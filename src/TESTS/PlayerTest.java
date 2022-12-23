package TESTS;
import MAIN.*;
import MAIN.DataTypes.HandPosition;
import MAIN.DataTypes.SleepingQueenPosition;
import MAIN.Enumerations.CardType;
import MAIN.Interfaces.Position;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;
    private Hand hand;
    private List<Position> positions;

    private void init(){
        SleepingQueens queens = new SleepingQueens();
        hand = new Hand(0, new DrawingAndTrashPile());
        positions = new ArrayList<>();

        player = new Player(hand, 0, queens);
        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        player.setMoveQueen(new MoveQueen(queens, playerList));
    }

    @Test
    public void playTest1(){
        init();
        assertFalse(player.play(new ArrayList<>()));

        positions.add(new SleepingQueenPosition(5));
        assertFalse(player.play(positions));

        positions.clear();
        positions.add(new HandPosition(2,1));
        assertFalse(player.play(positions));
    }

    @Test
    public void playTest2(){
        init();
        if(hand.hasCardOfType(CardType.Number) != null){
            positions.add(hand.hasCardOfType(CardType.Number));

            assertTrue(player.play(positions));
        }
    }

    @Test
    public void playTest3(){
        init();
        if(hand.hasCardOfType(CardType.King) != null){
            positions.add(hand.hasCardOfType(CardType.King));
            positions.add(new SleepingQueenPosition(11));

            assertTrue(player.play(positions));
            assertEquals(1, player.getAwokenQueens().getQueens().size());
        }
    }

    @Test
    public void playTest4(){
        init();
        HandPosition handPosition1 = hand.hasCardOfType(CardType.Number);
        if(handPosition1 != null){
            positions.add(hand.hasCardOfType(CardType.Number));
            HandPosition handPosition2 = hand.hasCardOfType(CardType.Number);
            if(handPosition2 != null) {
                positions.add(hand.hasCardOfType(CardType.Number));
                player.play(positions);

                //playTest3 only to make another play
                if(hand.hasCardOfType(CardType.King) != null){
                    positions.add(hand.hasCardOfType(CardType.King));
                    positions.add(new SleepingQueenPosition(11));

                    assertTrue(player.play(positions));
                    assertEquals(1, player.getAwokenQueens().getQueens().size());
                }

                assertEquals(5, hand.getCards().size());
            }
        }
    }
}
