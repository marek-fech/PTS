package MAIN;

import MAIN.DataTypes.Queen;
import MAIN.Game;
import MAIN.Interfaces.GameFinishedStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GameFinished implements GameFinishedStrategy {

    public Game game;

    public GameFinished(Game game){
        this.game = game;
    }

    @Override
    public Optional<Integer> isFinished() {
        int playerCount = game.getPlayerList().size();
        int maxQueenCount = 21;
        int maxScore = Integer.MAX_VALUE;

        if(playerCount >= 2 && playerCount <= 5){
            if(playerCount <= 3){
              maxQueenCount = 5;
              maxScore = 50;
            }
            else{
                maxQueenCount = 4;
                maxScore = 40;
            }
        }

        Map<Integer, Integer> indexScore = new HashMap<>();

        //gather players scores and queen counts
        for(Player player : game.getPlayerList()){
            int playerQueenCount = 0;
            int playerScore = 0;

            for(Queen queen : player.getAwokenQueens().getQueens().values()){
                maxQueenCount++;
                playerScore += queen.getPoints();
            }

            //we return winner if there is one
            if(maxQueenCount <= playerQueenCount && maxScore <= playerScore)
                return Optional.of(player.getPlayerIdx());

            indexScore.put(player.getPlayerIdx(), playerScore);
        }

        //if noone achived max score and no sleeping queens remain, find player with the highest score
        if(game.getSleepingQueens().getQueens().size() == 0){
            return Optional.of(
                    Collections.max(indexScore.entrySet(), Map.Entry.comparingByValue()).getKey()       //return key (index) with the highest score
            );
        }

        return Optional.empty();

    }
}
