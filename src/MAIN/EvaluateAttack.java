package MAIN;

import MAIN.DataTypes.HandPosition;
import MAIN.Enumerations.CardType;
import MAIN.Interfaces.MoveQueenInterface;
import MAIN.Interfaces.PlayerInterface;
import MAIN.Interfaces.Position;
import MAIN.Interfaces.QueenCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EvaluateAttack {
    private CardType defenseCardType;
    private final List<PlayerInterface> playerList;
    private final MoveQueenInterface moveQueen;
    private QueenCollection queenCollection;

    public EvaluateAttack(List<PlayerInterface> playerList, MoveQueenInterface moveQueen){
        this.playerList = playerList;
        this.moveQueen = moveQueen;
    }

    public boolean play(Position targetQueen, int targetPlayerIdx){
        //if player does exist in the game
        if(playerList.size() > targetPlayerIdx && targetPlayerIdx >= 0) {

            PlayerInterface targetPlayer = playerList.get(targetPlayerIdx);
            Set<Position> playersQueeens = targetPlayer.getAwokenQueens().getQueens().keySet();

            for (Position position : playersQueeens) {
                if (position.getCardIndex() == targetQueen.getCardIndex()) {

                    HandPosition autoDefense = targetPlayer.getHand().hasCardOfType(defenseCardType);

                    //if there are ways to defend
                    if (autoDefense != null) {
                        List<HandPosition> toPick = new ArrayList<>();
                        toPick.add(autoDefense);

                        targetPlayer.getHand().pickCards(toPick);
                        targetPlayer.getHand().removePickedCardsAndRedraw();

                    }
                    //if there are no ways to defend
                    else {
                        moveQueen.setQueenCollection(queenCollection);
                        moveQueen.play(targetQueen);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void setDefenseCardType(CardType defenseCardType) {
        this.defenseCardType = defenseCardType;
    }

    public void setQueenCollection(QueenCollection queenCollection) {
        this.queenCollection = queenCollection;
    }
}
