import Interfaces.GameObserver;
import Interfaces.GamePlayerInterface;

import java.util.ArrayList;
import java.util.Map;

public class GameAdaptor implements GamePlayerInterface {
    Game game;
    GameObservable gameObservable;
    ArrayList<String> playersMap;

    public GameAdaptor(Game game, GameObservable gameObservable){
        this.game = game;
        this.gameObservable = gameObservable;
    }

    @Override
    public String play(String player, String cards) {
        if(!playersMap.contains(player)){
            return "Incorrect input. Player " + player + " does not exists.";
        }


    }
}
