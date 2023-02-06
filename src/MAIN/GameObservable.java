package MAIN;

import MAIN.DataTypes.GameState;
import MAIN.Interfaces.GameObserver;

import java.util.*;

public class GameObservable {
    private final List<GameObserver> gameObservers;
    private final Map<String, GameObserver> playerList;

    public GameObservable(){
        this.playerList = new HashMap<>();
        this.gameObservers = new ArrayList<>();
    }

    public void add(GameObserver gameObserver){
        if(!this.gameObservers.contains(gameObserver))
            this.gameObservers.add(gameObserver);
    }

    public void addPlayer(String playerName, GameObserver gameObserver){
        if(!this.playerList.containsKey(playerName) && this.playerList.size()<5) {
            this.playerList.put(playerName, gameObserver);
            gameObserver.notify("Added player " + playerName);
        }
    }

    public void remove(GameObserver gameObserver){
        this.gameObservers.remove(gameObserver);
    }

    public Set<String> getPlayerList() {
        return playerList.keySet();
    }


    public String notify(String message) {
        return message;
    }

    public void notifyAll(GameState message){
        for(GameObserver x : gameObservers){
            x.notify(message.toString());
        }
        //in game we add indexies to players by position in keySet
        int i = 0;
        for(String name : playerList.keySet()){
            playerList.get(name).notify(message.toString(i));
            i++;
        }
    }

    //only for tests in GameObservableTest
    /*public List<GameObserver> getGameObservers() {
        return gameObservers;
    }*/
}
