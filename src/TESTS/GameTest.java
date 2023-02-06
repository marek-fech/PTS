package TESTS;

import MAIN.DataTypes.GameState;
import MAIN.DrawingAndTrashPile;
import MAIN.Game;
import MAIN.Interfaces.DrawingAndTrashPileInterface;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;

    private void init(){
        game = new Game(3);
    }

    @Test
    public void playTest(){
        init();
        Optional<GameState> gameState = game.play(0, new ArrayList<>());
        assertTrue(gameState.isEmpty());
    }

    @Test
    public void getPileTest() {
        init();
        DrawingAndTrashPileInterface drawingAndTrashPile = game.getDrawingAndTrashPile();
        assertNotNull(drawingAndTrashPile);
    }

    @Test
    public void getPlayerListTest(){
        init();
        assertEquals(3, game.getPlayerList().size());
    }

    @Test
    public void getSleepQueensTest(){
        init();
        assertEquals(12, game.getSleepingQueens().getQueens().size());
    }

    @Test
    public void getGameStateTest(){
        init();
        assertEquals(0, game.getGameState().getOnTurn());
    }
}
