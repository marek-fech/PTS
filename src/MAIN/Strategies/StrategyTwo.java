package MAIN.Strategies;

import MAIN.DataTypes.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StrategyTwo implements EmptyDeckHandle{
    private List<Card> drawingPileS;
    private List<Card> trashPileS;

    @Override
    public List<Card> draw(List<Card> discard, List<Card> drawingPile, List<Card> trashPile) {
        List<Card> drawing = new ArrayList<>();

        //shuffle trash
        Collections.shuffle(trashPile, new Random());

        //add trash pile under drawing
        drawingPile.addAll(trashPile);

        //new trash pile are discarted cards
        trashPileS = new ArrayList<>(discard);

        //draw cards from drawing pile and set new drawing pile as what remains
        for(int i = 0; i < discard.size(); i++){
            drawing.add(drawingPile.get(0));
            drawingPile.remove(0);
        }
        drawingPileS = new ArrayList<>(drawingPile);

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
