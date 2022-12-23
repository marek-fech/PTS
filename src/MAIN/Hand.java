package MAIN;

import MAIN.DataTypes.Card;
import MAIN.DataTypes.HandPosition;
import MAIN.Enumerations.CardType;
import MAIN.DrawingAndTrashPile;

import java.util.*;

public class Hand {
    private int playerIdx;
    private List<Card> cards;
    private DrawingAndTrashPile drawingAndTrashPile;
    private List<Card> pickedCards;
    private List<Integer> dontUse;

    public Hand(int playerIdx, DrawingAndTrashPile drawingAndTrashPile){
        this.playerIdx = playerIdx;
        this.drawingAndTrashPile = drawingAndTrashPile;
        this.dontUse = new ArrayList<>();
        cards = drawingAndTrashPile.getInitialCards();
    }

    public Optional<List<Card>> pickCards(List<HandPosition> positions){
        pickedCards = new ArrayList<>();

        if(positions.isEmpty())
            return Optional.empty();

        for(HandPosition handPosition : positions){
            pickedCards.add(cards.get(handPosition.getCardIndex()));
        }
        return Optional.ofNullable(pickedCards);
    }

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

    public void returnPickedCards() {
        pickedCards.clear();
    }

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

    public List<Card> getCards() {
        return cards;
    }
}
