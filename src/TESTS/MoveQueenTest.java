package TESTS;

import MAIN.*;
import MAIN.DataTypes.AwokenQueenPosition;
import MAIN.DataTypes.SleepingQueenPosition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MoveQueenTest {
    private MoveQueen moveQueen;
    private List<Player> playerList;
    private SleepingQueens queens;
    private DrawingAndTrashPile pile;

    private void init(){
        pile = new DrawingAndTrashPile();
        queens = new SleepingQueens();
        playerList = new ArrayList<>();

        playerList.add(new Player(new Hand(0, pile), 0, queens));
        playerList.add(new Player(new Hand(1, pile), 1, queens));

        moveQueen = new MoveQueen(queens, playerList);
    }

    @Test
    public void test1(){
        init();
        moveQueen.setQueenCollection(queens);
        assertFalse(moveQueen.play(new AwokenQueenPosition(0,0)));
    }

    @Test
    public void test2(){
        init();
        moveQueen.setQueenCollection(playerList.get(1).getAwokenQueens());
        assertTrue(moveQueen.play(new SleepingQueenPosition(5)));
        assertEquals(1, playerList.get(1).getAwokenQueens().getQueens().size());
    }

}
