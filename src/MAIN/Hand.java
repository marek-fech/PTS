package MAIN;

import MAIN.DataTypes.Card;
import MAIN.DataTypes.HandPosition;
import MAIN.Enumerations.CardType;
import MAIN.Interfaces.DrawingAndTrashPileInterface;
import MAIN.Interfaces.HandInterface;

import java.util.*;

public class Hand implements HandInterface {
    private final int playerIdx;
    private final List<Card> cards;
    private final DrawingAndTrashPileInterface drawingAndTrashPile;
    private List<Card> pickedCards;
    private final List<Integer> dontUse;

    public Hand(int playerIdx, DrawingAndTrashPileInterface drawingAndTrashPile){
        this.playerIdx = playerIdx;
        this.drawingAndTrashPile = drawingAndTrashPile;
        this.dontUse = new ArrayList<>();
        cards = drawingAndTrashPile.getInitialCards();
    }

    @Override
    public Optional<List<Card>> pickCards(List<HandPosition> positions){
        pickedCards = new ArrayList<>();

        if(positions.isEmpty())
            return Optional.empty();

        for(HandPosition handPosition : positions){
            pickedCards.add(cards.get(handPosition.getCardIndex()));
        }
        return Optional.ofNullable(pickedCards);
    }

    @Override
    public Map<HandPosition, Card> removePickedCardsAndRedraw(){
        if(pickedCards == null)
            return new LinkedHashMap<>();

        cards.removeAll(pickedCards);
        Map<HandPosition, Card> redrawn = new LinkedHashMap<>();
        List<Card> drawing = drawingAndTrashPile.discardAndDraw(pickedCards);
        for(int i = 0; i < drawing.size(); i++){
            redrawn.put(
                    new HandPosition(cards.size() + i, playerIdx),
                    drawing.get(i));
        }
        cards.addAll(drawing);
        returnPickedCards();
        return redrawn;
    }

    @Override
    public void returnPickedCards() {
        pickedCards.clear();
    }

    @Override
    public HandPosition hasCardOfType(CardType type){
        int i = 0;
        for(Card card : cards){
            if(card.getType() == type && !dontUse.contains(i)){
                dontUse.add(i);
                //cards.remove(i);
                return new HandPosition(i, playerIdx);
            }
            i++;
        }
        return null;
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }
}
