package MAIN.Interfaces;

import MAIN.AwokenQueens;
import MAIN.DataTypes.PlayerState;
import MAIN.EvaluateAttack;

import java.util.List;

public interface PlayerInterface {
    boolean play(List<Position> cards);

    PlayerState getPlayerState();

    AwokenQueens getAwokenQueens();

    HandInterface getHand();

    int getPlayerIdx();

    void setMoveQueen(MoveQueenInterface moveQueen);

    void setEvaluateAttack(EvaluateAttack evaluateAttack);
}
