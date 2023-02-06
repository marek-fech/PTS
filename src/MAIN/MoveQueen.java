package MAIN;

import MAIN.DataTypes.AwokenQueenPosition;
import MAIN.DataTypes.Queen;
import MAIN.DataTypes.SleepingQueenPosition;
import MAIN.Interfaces.MoveQueenInterface;
import MAIN.Interfaces.PlayerInterface;
import MAIN.Interfaces.Position;
import MAIN.Interfaces.QueenCollection;

import java.util.List;
import java.util.Optional;

public class MoveQueen implements MoveQueenInterface {
    private final List<PlayerInterface> playerList;
    private final SleepingQueens sleepingQueens;
    private QueenCollection queenCollection;

    public MoveQueen(SleepingQueens sleepingQueens, List<PlayerInterface> playerList){
        this.playerList = playerList;
        this.sleepingQueens = sleepingQueens;
    }

    @Override
    public boolean play(Position targetQueen){
        if(targetQueen instanceof SleepingQueenPosition || targetQueen instanceof AwokenQueenPosition) {
            Optional<Queen> queen;

            if (targetQueen instanceof SleepingQueenPosition)
                queen = sleepingQueens.removeQueen(targetQueen);

            else {
                int targetPlayer = targetQueen.getPlayerIndex();
                queen = playerList.get(targetPlayer).getAwokenQueens().removeQueen(targetQueen);
            }

            if (queen.isPresent()) {
                queenCollection.addQueen(queen.get());
                return true;
            }
        }
        return false;
    }

    @Override
    public void setQueenCollection(QueenCollection queenCollection){
        this.queenCollection = queenCollection;
    }
}
