import DataTypes.GameState;
import Interfaces.GameObserver;

import java.util.*;

public class GameObservable implements GameObserver {
    private List<GameObserver> gameObservers;
    private Map<String, GameObserver> playerList;

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

    @Override
    public String notify(String message) {
        return message;
    }

    public void notifyAll(GameState message){
        for(GameObserver x : gameObservers){
            x.notify(message.toString());
        }
        for(String name : playerList.keySet()){
            playerList.get(name).notify(message.getCards().toString()); //TODO players cards
        }
    }
}
