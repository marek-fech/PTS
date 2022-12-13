import DataTypes.Card;
import Enumerations.CardType;

import java.util.*;

public class DrawingAndTrashPile {
    private List<Card> trashPile;
    private List<Card> drawingPile;
    private List<Card> discardedThisTurn;

    public DrawingAndTrashPile(){
        trashPile = new ArrayList<>();
        drawingPile = new ArrayList<>();
        discardedThisTurn = new ArrayList<>();

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

    }

    public void newTurn(){
        discardedThisTurn.clear();
    }

    public List<Card> getDiscardedThisTurn(){
        return discardedThisTurn;
    }

    public Map<Integer, Optional<Card>> getInitialCards(){
        Map<Integer, Optional<Card>> cards = new HashMap<>();
        for(int i = 0; i < 5; i++){
            cards.put(i, Optional.ofNullable(drawingPile.get(0)));
            drawingPile.remove(0);
        }
        return cards;
    }

    public List<Card> getDrawingCards(){
        return drawingPile;
    }
}
