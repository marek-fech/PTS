import DataTypes.Queen;
import DataTypes.SleepingQueenPosition;
import Interfaces.Position;
import Interfaces.QueenCollection;

import java.util.*;

public class SleepingQueens implements QueenCollection {
    private Map<Position, Queen> queens;
    private List<Integer> empty;

    public SleepingQueens() {
        empty = new ArrayList<>();
        queens = new HashMap<>();

        List<Queen> queensCards= new ArrayList<>();
        queensCards.add(new Queen(20));
        for(int i = 0; i < 3; i++){
            queensCards.add(new Queen(15));
        }
        for(int i = 0; i < 4; i++){
            queensCards.add(new Queen(10));
            queensCards.add(new Queen(5));
        }

        Collections.shuffle(queensCards, new Random());
        for(int i = 0; i < queensCards.size(); i++){
            queens.put(new SleepingQueenPosition(i), queensCards.get(i));
        }

    }

    @Override
    public void addQueen(Queen queen) {
        if(queens.size() < 12) {
            if (empty.isEmpty()) {
                queens.put(new SleepingQueenPosition(queens.size()), queen);
            } else {
                queens.put(new SleepingQueenPosition(empty.get(0)), queen);
                empty.remove(0);
            }
        }
    }

    @Override
    public Optional<Queen> removeQueen(Position position) {
        Optional<Queen> queen = Optional.empty();

        for(Position sleepingPosition : queens.keySet()){
            if(sleepingPosition.getCardIndex() == position.getCardIndex()){
                empty.add(sleepingPosition.getCardIndex());
                return Optional.of(queens.remove(sleepingPosition));
            }
        }

        return queen;

    }

    @Override
    public Map<Position, Queen> getQueens() {
        return queens;
    }
}