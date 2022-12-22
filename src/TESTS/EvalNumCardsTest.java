package TESTS;

import MAIN.DataTypes.Card;
import MAIN.Enumerations.CardType;
import MAIN.EvaluateNumberedCards;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EvalNumCardsTest {
    private EvaluateNumberedCards eval;
    private List<Card> cardList;

    private void init(){
        eval = new EvaluateNumberedCards();
        cardList = new ArrayList<>();
    }

    @Test
    public void test1(){
        init();
        cardList.add(new Card(CardType.Number, 2));
        assertTrue(eval.play(cardList));
    }

    @Test
    public void test2(){
        init();
        cardList.add(new Card(CardType.Number, 2));
        cardList.add(new Card(CardType.Number, 2));
        assertTrue(eval.play(cardList));
    }

    @Test
    public void test3(){
        init();
        cardList.add(new Card(CardType.Number, 1));
        cardList.add(new Card(CardType.Number, 2));
        assertFalse(eval.play(cardList));
    }

    @Test
    public void test4(){
        init();
        cardList.add(new Card(CardType.Number, 1));
        cardList.add(new Card(CardType.Number, 2));
        cardList.add(new Card(CardType.Number, 2));
        assertFalse(eval.play(cardList));
    }

    @Test
    public void test5(){
        init();
        cardList.add(new Card(CardType.Number, 1));
        cardList.add(new Card(CardType.Number, 3));
        cardList.add(new Card(CardType.Number, 2));
        assertTrue(eval.play(cardList));
    }
}
