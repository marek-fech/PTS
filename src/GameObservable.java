import DataTypes.GameState;
import Interfaces.GameObserver;

import java.util.ArrayList;
import java.util.List;

public class GameObservable implements GameObserver {
    private List<GameObserver> gameObserver;
    private List<String> playerList;
    private GameAdaptor gameAdaptor;

    public GameObservable(){
        this.playerList = new ArrayList<>();
        this.gameObserver = new ArrayList<>();
    }

    public void add(GameObserver observer){
        this.gameObserver.add(observer);
    }

    public void addPlayer(Integer playerIdx, String playerName, GameObserver gameObserver){
        if(playerList.size()<5) {
            playerList.add(playerIdx, playerName);
            gameObserver.notify("Added player " + playerName);
        }
    }


    public List<String> getPlayerList() {
        return playerList;
    }

    @Override
    public String notify(String message) {
        return message;
    }

    public void notifyAll(GameState message){
        for(GameObserver x : gameObserver){
            x.notify(message.toString());
        }
    }
}
