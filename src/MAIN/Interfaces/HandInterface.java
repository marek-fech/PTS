package MAIN.Interfaces;

import MAIN.DataTypes.Card;
import MAIN.DataTypes.HandPosition;
import MAIN.Enumerations.CardType;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface HandInterface {
    Optional<List<Card>> pickCards(List<HandPosition> positions);
    Map<HandPosition, Card> removePickedCardsAndRedraw();
    void returnPickedCards();
    HandPosition hasCardOfType(CardType type);
    List<Card> getCards();
}
