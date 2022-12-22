package MAIN.Interfaces;

import MAIN.DataTypes.Queen;

import java.util.Map;
import java.util.Optional;


public interface QueenCollection {
    void addQueen(Queen queen);
    Optional<Queen> removeQueen(Position position);
    Map<Position, Queen> getQueens();
}
