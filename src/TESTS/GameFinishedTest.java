package TESTS;

import MAIN.DataTypes.Queen;
import MAIN.DataTypes.SleepingQueenPosition;
import MAIN.Game;
import MAIN.GameFinished;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class GameFinishedTest {
    private GameFinished gameFinished;
    private Game game;

    private void init(){
        game = new Game(5);
        gameFinished = new GameFinished(game);
    }

    @Test
    public void isFinished1(){
        init();
        assertTrue(gameFinished.isFinished().isEmpty());

        game.getSleepingQueens().getQueens().clear();
        assertTrue(gameFinished.isFinished().isPresent());
    }

    @Test
    public void isFinished2(){
        init();
        for(int i = 0; i < 4; i++){
            Optional<Queen> queen = game.getSleepingQueens().removeQueen(new SleepingQueenPosition(i));
            if(queen.isPresent())
                game.getPlayerList().get(3).getAwokenQueens().addQueen(queen.get());
        }

        assertEquals(3, (int) gameFinished.isFinished().get());
    }

}
