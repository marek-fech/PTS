import DataTypes.*;
import Interfaces.GameObserver;
import Interfaces.GamePlayerInterface;
import Interfaces.Position;

import java.util.*;

public class GameAdaptor implements GamePlayerInterface {
    public Game game;
    public GameObservable gameObservable;
    public Map<String, Integer> playerMap;

    public GameAdaptor(GameObservable gameObservable){

        this.gameObservable = gameObservable;

        playerMap = new HashMap<>();
        int index = 0;
        for(String name : gameObservable.getPlayerList()){
            playerMap.put(name, index++);
        }

        this.game = new Game(playerMap.size());
    }

    @Override
    public String play(String player, String cards) {
        if(!playerMap.containsKey(player)){
            return "Incorrect input. Player " + player + " does not exists.";
        }
        if(playerMap.keySet().size() < 2){
            return "Not enough players!";
        }

        List<Position> cardsList = new ArrayList<>();

        //Expects format hx hy hz, for equation where x,y,z are numbers 1-5
        String[] split = cards.split(" ");

        //we add Postion as 'xy' where x is h,a,s for differnet position and y is index of card from 'hx'
        for (String s : split) {
            char ca = s.charAt(0);

            if (ca == 'h') {
                cardsList.add(
                        new HandPosition(
                                s.charAt(1), playerMap.get(player)));
            } else if (ca == 's') {
                String index = s.replace("s", "");
                cardsList.add(
                        new SleepingQueenPosition(Integer.parseInt(index)));
            } else if (ca == 'a') {
                cardsList.add(
                        new AwokenQueenPosition(//card                                      playes
                                Integer.valueOf(s.charAt(2)), Integer.valueOf(s.charAt(1))));
            } else {
                return "Incorrect format used!";
            }
        }

        Optional<GameState> gameState = game.play(playerMap.get(player), cardsList);
        if(gameState.isEmpty()){
            return "Move not successful!";
        }
        gameObservable.notifyAll(gameState.get());
        return gameState.get().toString();

    }
}
