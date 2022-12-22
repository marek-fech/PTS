package TESTS;


import MAIN.AwokenQueens;
import MAIN.DataTypes.AwokenQueenPosition;
import MAIN.DataTypes.Queen;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class AwokenQueensTest {
    private AwokenQueens awokenQueens;

    private void init(){
        awokenQueens = new AwokenQueens(0);
    }

    @Test
    public void addQueenTest(){
        init();
        awokenQueens.addQueen(new Queen(5));
        assertEquals(1, awokenQueens.getQueens().size());
    }

    @Test
    public void removeTest1(){
        init();
        assertFalse(awokenQueens.removeQueen(new AwokenQueenPosition(0,1)).isPresent());
    }

    @Test
    public void removeTest2(){
        init();

        awokenQueens.addQueen(new Queen(5));
        awokenQueens.addQueen(new Queen(15));
        awokenQueens.addQueen(new Queen(20));

        Optional<Queen> queen = awokenQueens.removeQueen(new AwokenQueenPosition(3,0));
        if(queen.isPresent())
            assertEquals(20, queen.get().getPoints());
    }

    @Test
    public void getTest(){
        init();
        assertEquals(0, awokenQueens.getQueens().size());
    }
}
