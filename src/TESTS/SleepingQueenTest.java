package TESTS;

import MAIN.DataTypes.Queen;
import MAIN.DataTypes.SleepingQueenPosition;
import MAIN.SleepingQueens;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class SleepingQueenTest {
    private SleepingQueens sleepingQueens;

    private void init(){
        sleepingQueens = new SleepingQueens();
    }

    @Test
    public void addQueenTest1(){
        init();
        assertEquals(12, sleepingQueens.getQueens().size());

        sleepingQueens.addQueen(new Queen(15));
        assertEquals(12, sleepingQueens.getQueens().size());
    }

    @Test
    public void addQueenTest2(){
        init();

        Optional<Queen> removed1 = sleepingQueens.removeQueen(new SleepingQueenPosition(1));
        Optional<Queen> removed2 = sleepingQueens.removeQueen(new SleepingQueenPosition(2));
        Optional<Queen> removed3 = sleepingQueens.removeQueen(new SleepingQueenPosition(3));

        sleepingQueens.addQueen(removed1.get());
        assertEquals(10, sleepingQueens.getQueens().size());
    }

    @Test
    public void removeTest1(){
        init();
        Optional<Queen> queen = sleepingQueens.removeQueen(new SleepingQueenPosition(12));
        assertTrue(queen.isEmpty());
    }

    @Test
    public void removeTest2(){
        init();
        Optional<Queen> queen = sleepingQueens.removeQueen(new SleepingQueenPosition(8));
        assertTrue(queen.isPresent());
        assertEquals(11, sleepingQueens.getQueens().size());
    }

    @Test
    public void getTest(){
        init();
        assertEquals(12, sleepingQueens.getQueens().size());
    }



}
