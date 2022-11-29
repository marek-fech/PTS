package DataTypes;

import java.util.Map;
import java.util.Optional;

public class PlayerState {

    private Map<Integer, Optional<Card>> cards;
    private Map<Integer, Queen> awokenQueens;

    public PlayerState(Map<Integer, Optional<Card>> cards, Map<Integer, Queen> awokenQueens){
        this.cards = cards;
        this.awokenQueens = awokenQueens;
    }

    public Map<Integer, Queen> getAwokenQueens() {
        return awokenQueens;
    }

    public Map<Integer, Optional<Card>> getCards() {
        return cards;
    }
}
