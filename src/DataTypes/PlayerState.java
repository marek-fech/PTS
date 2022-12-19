package DataTypes;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class PlayerState {

    private Map<Integer, Optional<Card>> cards;
    private Map<Integer, Queen> awokenQueens;

    public PlayerState(){
        this.cards = new LinkedHashMap<>();
        this.awokenQueens = new LinkedHashMap<>();
    }

    public void setAwokenQueens(Map<Integer, Queen> awokenQueens) {
        this.awokenQueens = awokenQueens;
    }

    public void setCards(Map<Integer, Optional<Card>> cards) {
        this.cards = cards;
    }

    public Map<Integer, Queen> getAwokenQueens() {
        return awokenQueens;
    }

    public Map<Integer, Optional<Card>> getCards() {
        return cards;
    }
}
