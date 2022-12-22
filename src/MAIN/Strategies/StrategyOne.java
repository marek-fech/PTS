package MAIN.Strategies;

import MAIN.DataTypes.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StrategyOne implements EmptyDeckHandle{
    private List<Card> drawingPileS;
    private List<Card> trashPileS;

    @Override
    public List<Card> draw(List<Card> discard, List<Card> drawingPile, List<Card> trashPile) {
        //throw away all cards to discard
        trashPile.addAll(discard);
        //draw all cards left
        List<Card> drawing = new ArrayList<>(drawingPile);

        //shuffle trash pile
        Collections.shuffle(trashPile, new Random());

        //draw from trash pile
        while(drawing.size() < discard.size()){
            drawing.add(trashPile.get(0));
            trashPile.remove(0);
        }

        //new piles to be returned
        drawingPileS = new ArrayList<>(trashPile);
        trashPileS = new ArrayList<>();

        return drawing;
    }

    @Override
    public List<Card> getDrawingCards() {
        return drawingPileS;
    }

    @Override
    public List<Card> getTrashCards() {
        return trashPileS;
    }
}
