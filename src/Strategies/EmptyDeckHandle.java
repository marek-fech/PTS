package Strategies;

import DataTypes.Card;

import java.util.List;

public interface EmptyDeckHandle {
    List<Card> draw(List<Card> discard, List<Card> drawingPile, List<Card> trashPile);
    List<Card> getDrawingCards();
    List<Card> getTrashCards();
}
