package TESTS;

import MAIN.DataTypes.Card;
import MAIN.DrawingAndTrashPile;
import MAIN.Enumerations.CardType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class DrawingPileTest {
    private DrawingAndTrashPile pile;
    private List<Card> discard;

    private void init(){
        pile = new DrawingAndTrashPile();
        discard = new ArrayList<>();
        discard.add(new Card(CardType.Number, 5));
        discard.add(new Card(CardType.Number, 5));
    }

    @Test
    public void discardDrawTest(){
        init();
        List<Card> cards = pile.discardAndDraw(discard);
        assertEquals(2, cards.size());
    }

    @Test
    public void newTurnTest(){
        init();
        pile.newTurn();
        assertTrue(pile.getDiscardedThisTurn().isEmpty());
    }

    @Test
    public void getInitCardsTest(){
        init();
        List<Card> initialCards = pile.getInitialCards();
        assertEquals(5, initialCards.size());
    }
}
