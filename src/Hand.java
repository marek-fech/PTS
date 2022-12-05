import DataTypes.Card;
import DataTypes.HandPosition;

import java.util.List;
import java.util.Optional;

public class Hand {

    public int playerIdx;

    public Hand(int playerIdx){
        this.playerIdx = playerIdx;
    }

    public Optional<List<Card>> pickCards(List<HandPosition> positions){
        return null;
    }
}
