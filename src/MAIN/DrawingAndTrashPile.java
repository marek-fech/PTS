package MAIN;

import MAIN.DataTypes.Card;
import MAIN.Enumerations.CardType;
import MAIN.Strategies.EmptyDeckHandle;
import MAIN.Strategies.StrategyOne;

import java.util.*;

public class DrawingAndTrashPile {
    private List<Card> trashPile;
    private List<Card> drawingPile;
    private List<Card> discardedThisTurn;
    private EmptyDeckHandle strategy;


    public DrawingAndTrashPile(){
        trashPile = new ArrayList<>();
        drawingPile = new ArrayList<>();
        discardedThisTurn = new ArrayList<>();
        strategy = new StrategyOne();

        for(int i = 0; i < 8; i++) drawingPile.add(new Card(CardType.King, 0));
        for(int i = 0; i < 5; i++) drawingPile.add(new Card(CardType.Knight, 0));
        for(int i = 0; i < 4; i++) drawingPile.add(new Card(CardType.SleepingPotion, 0));
        for(int i = 0; i < 3; i++) drawingPile.add(new Card(CardType.MagicWand, 0));
        for(int i = 0; i < 3; i++) drawingPile.add(new Card(CardType.Dragon, 0));
        for(int i = 0; i < 4; i++) {
            for (int j = 1; j < 11; j++) {
                drawingPile.add(new Card(CardType.Number, j));
            }
        }

        Collections.shuffle(drawingPile, new Random());


    }

    public List<Card> discardAndDraw(List<Card> discard){
        List<Card> drawing = new ArrayList<>();
        discardedThisTurn.addAll(discard);

        if(drawingPile.size() < discard.size()){
            drawing = strategy.draw(discard, drawingPile, trashPile);
            drawingPile = strategy.getDrawingCards();
            trashPile = strategy.getTrashCards();
        }
        else{
            trashPile.addAll(discard);
            for(int i = 0; i < discard.size(); i++){
                drawing.add(drawingPile.get(0));
                drawingPile.remove(0);
            }
        }

        return drawing;
    }

    public void newTurn(){
        discardedThisTurn.clear();
    }

    public List<Card> getDiscardedThisTurn(){
        return discardedThisTurn;
    }

    public List<Card> getInitialCards(){
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            cards.add(drawingPile.get(0));
            drawingPile.remove(0);
        }
        return cards;
    }

    public List<Card> getDrawingCards(){
        return drawingPile;
    }

    public void setStrategy(EmptyDeckHandle strategy){
        this.strategy = strategy;
    }
}
