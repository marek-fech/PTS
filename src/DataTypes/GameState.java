package DataTypes;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class GameState {

    private int                                     numberOfPlayers;
    private int                                     onTurn;                     //index of player (maybe)
    private Set<SleepingQueenPosition>              sleepingQueens;
    private Map<HandPosition, Optional<Card>>       cards;                      //cards that are held
    private Map<AwokenQueenPosition, Queen>         awokenQueens;               //where are all awoken queens and their values
    private List<Card>                              cardsDiscartedLastTurn;     //cards discarted in last turn (maybe)

    public GameState(int numberOfPlayers, int onTurn,
                     Set<SleepingQueenPosition> sleepingQueens,
                     Map<HandPosition, Optional<Card>> cards,
                     Map<AwokenQueenPosition, Queen> awokenQueens,
                     List<Card> cardsDiscartedLastTurn){
        this.numberOfPlayers = numberOfPlayers;
        this.onTurn = onTurn;
        this.sleepingQueens = sleepingQueens;
        this.cards = cards;
        this.awokenQueens = awokenQueens;
        this.cardsDiscartedLastTurn = cardsDiscartedLastTurn;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getOnTurn() {
        return onTurn;
    }

    public List<Card> getCardsDiscartedLastTurn() {
        return cardsDiscartedLastTurn;
    }

    public Map<AwokenQueenPosition, Queen> getAwokenQueens() {
        return awokenQueens;
    }

    public Map<HandPosition, Optional<Card>> getCards() {
        return cards;
    }

    public Set<SleepingQueenPosition> getSleepingQueens() {
        return sleepingQueens;
    }

}
