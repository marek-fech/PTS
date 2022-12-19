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
                     List<Card> cardsDiscartedLastTurn){
        this.numberOfPlayers = numberOfPlayers;
        this.onTurn = onTurn;
        this.cardsDiscartedLastTurn = cardsDiscartedLastTurn;
    }

    //getters
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


    //setters
    public void setCards(Map<HandPosition, Optional<Card>> cards) {
        this.cards = cards;
    }

    public void setAwokenQueens(Map<AwokenQueenPosition, Queen> awokenQueens) {
        this.awokenQueens = awokenQueens;
    }

    public void setCardsDiscartedLastTurn(List<Card> cardsDiscartedLastTurn) {
        this.cardsDiscartedLastTurn = cardsDiscartedLastTurn;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void setOnTurn(int onTurn) {
        this.onTurn = onTurn;
    }

    public void setSleepingQueens(Set<SleepingQueenPosition> sleepingQueens) {
        this.sleepingQueens = sleepingQueens;
    }
}
