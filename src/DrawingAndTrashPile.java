import DataTypes.Card;
import Enumerations.CardType;

import java.util.*;

public class DrawingAndTrashPile {
    private List<Card> trashPile;
    private List<Card> drawingPile;

    public DrawingAndTrashPile(){
        trashPile = new ArrayList<>();
        drawingPile = new ArrayList<>();

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

    public Map<Integer, Card> getDrawingCards(){
        for(int i = 0; i < 5; i++){

        }
    }
}
