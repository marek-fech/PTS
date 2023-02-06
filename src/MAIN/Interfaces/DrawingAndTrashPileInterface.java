package MAIN.Interfaces;

import MAIN.DataTypes.Card;

import java.util.List;

public interface DrawingAndTrashPileInterface {
    List<Card> discardAndDraw(List<Card> discard);
    void newTurn();
    List<Card> getDiscardedThisTurn();
    List<Card> getInitialCards();
}
