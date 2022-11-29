package DataTypes;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class GameState {

    private int                                     numberOfPlayers;
    private int                                     onTurn;                     //index of player (maybe)
    private Set<SleepingQueenPosition>              sleepingQueens;
    private Map<HandPosition, Optional<Card>>       cards;                      //cards to draw
    private Map<AwokenQueenPosition, Queen>         awokenQueens;               //where are all awoken queens and their values
    private List<Card>                              cardsDiscartedLastTurn;     //cards discarted in last turn (maybe)
}
