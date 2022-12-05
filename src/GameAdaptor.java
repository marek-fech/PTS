import DataTypes.*;
import Interfaces.GameObserver;
import Interfaces.GamePlayerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GameAdaptor implements GamePlayerInterface {
    public Game game;
    public GameObservable gameObservable;
    public Map<String, Integer> playerMap;

    public GameAdaptor(GameObservable gameObservable){
        if(gameObservable.getPlayerList().size() > 2){
            this.gameObservable = gameObservable;
            this.game = new Game(gameObservable.getPlayerList().size());
        }
        int counter = 1;
        for(String x : gameObservable.getPlayerList()){
            playerMap.put(x, counter++);
        }

    }

    @Override
    public String play(String player, String cards) {
        if(!playerMap.containsKey(player)){
            return "Incorrect input. Player " + player + " does not exists.";
        }

        List<Position> cardsList = new ArrayList<>();

        //Expects format hx hy hz, for equation where x,y,z are numbers 1-5
        String[] split = cards.split(" ");

        //we add Postion as 'xy' where x is h,a,s for differnet position and y is index of card from 'hx'
        for(int i = 0; i < split.length; i++){
            Character ca = split[i].charAt(0);

            if(ca == 'h'){
                cardsList.add(
                        new Position(
                                new HandPosition(
                                        (int) split[i].charAt(1), playerMap.get(player))));
            }

            else if(ca == 's'){
                String index = split[i].replace("s", "");
                cardsList.add(
                        new Position(
                                new SleepingQueenPosition(Integer.parseInt(index))));
            }

            else if(ca == 'a'){
                cardsList.add(
                        new Position(
                                new AwokenQueenPosition(//card                                      playes
                                        Integer.valueOf(split[i].charAt(2)), Integer.valueOf(split[i].charAt(1)))));
            }

            else{
                return "Incorrect format!";
            }
        }

        Optional<GameState> gameState = game.play(playerMap.get(player), cardsList);
        if(gameState.isEmpty()){
            return "Move not successful!";
        }
        return "Move successful";

    }
}
