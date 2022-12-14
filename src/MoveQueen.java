import DataTypes.AwokenQueenPosition;
import DataTypes.Queen;
import DataTypes.SleepingQueenPosition;
import Interfaces.Position;
import Interfaces.QueenCollection;

import java.util.List;
import java.util.Optional;

public class MoveQueen {
    private List<Player> playerList;
    private SleepingQueens sleepingQueens;
    private QueenCollection queenCollection;

    public MoveQueen(SleepingQueens sleepingQueens, List<Player> playerList){
        this.playerList = playerList;
        this.sleepingQueens = sleepingQueens;
    }

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
}
