package TESTS;

import MAIN.DataTypes.Card;
import MAIN.DataTypes.HandPosition;
import MAIN.DrawingAndTrashPile;
import MAIN.Enumerations.CardType;
import MAIN.Hand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class HandTest {
    private Hand hand;
    private List<HandPosition> positions;

    private void init(){
        hand = new Hand(0, new DrawingAndTrashPile());
        positions = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            positions.add(new HandPosition(i, 0));
        }
    }

    @Test
    public void pickTest1(){
        init();
        Optional<List<Card>> cards = hand.pickCards(positions);
        if(cards.isPresent()) {
            assertEquals(Optional.of(4), cards.map(List::size));
        }
    }

    @Test
    public void pickTest2(){
        init();
        Optional<List<Card>> cards = hand.pickCards(new ArrayList<>());
        if(cards.isPresent()) {
            assertEquals(Optional.empty(), cards.map(List::size));
        }
    }

    @Test
    public void removeTest1(){
        init();
        hand.pickCards(positions);

        Map<HandPosition, Card> map = hand.removePickedCardsAndRedraw();

        int i = 5 - positions.size();
        for(HandPosition position : map.keySet()){
            assertEquals(i++, position.getCardIndex());
        }
        assertEquals(4, map.size());
    }

    @Test
    public void removeTest2(){
        init();
        hand.pickCards(new ArrayList<>());

        Map<HandPosition, Card> map = hand.removePickedCardsAndRedraw();

        assertEquals(0, map.size());
    }

    @Test
    public void hasTypeTest(){
        init();

        HandPosition handPosition = hand.hasCardOfType(CardType.King);
        if(handPosition != null){
            assertEquals(0, handPosition.getPlayerIndex());
            assertTrue(handPosition.getCardIndex() >= 0 && handPosition.getCardIndex() <= 4);
        }
        else assertNull(handPosition);

    }

    @Test
    public void getCardsTest(){
        init();
        assertEquals(5, hand.getCards().size());
    }

}
