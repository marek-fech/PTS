import DataTypes.AwokenQueenPosition;
import DataTypes.Queen;
import DataTypes.SleepingQueenPosition;
import Interfaces.Position;
import Interfaces.QueenCollection;

import java.util.*;

public class AwokenQueens implements QueenCollection {
    private Map<Position, Queen> queens;
    private List<Integer> empty;
    private int playerIdx;

    public AwokenQueens(int playerIdx){
        queens = new HashMap<>();
        empty = new ArrayList<>();
        this.playerIdx = playerIdx;
    }

    @Override
    public void addQueen(Queen queen) {
        if(empty.isEmpty()){
            queens.put(new AwokenQueenPosition(queens.size(),playerIdx),queen);
        }
        else {
            queens.put(new AwokenQueenPosition(empty.get(0),playerIdx),queen);
            empty.remove(0);
        }
    }

    @Override
    public Optional<Queen> removeQueen(Position position) {
        if(!(position instanceof AwokenQueenPosition))
            return Optional.empty();

        if(position.getPlayerIndex() != playerIdx)
            return Optional.empty();


        Optional<Queen> queen = Optional.empty();

        for(Position awokenPosition : queens.keySet()){
            if(awokenPosition.getCardIndex() == position.getCardIndex()){
               empty.add(awokenPosition.getCardIndex());
               return Optional.of(queens.remove(awokenPosition));
            }
        }

        return queen;
    }

    @Override
    public Map<Position, Queen> getQueens() {
        return queens;
    }
}
