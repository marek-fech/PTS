import DataTypes.GameState;
import DataTypes.PlayerState;
import DataTypes.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Game {
    private List<Player> playerList;
    private DrawingAndTrashPile drawingAndTrashPile;

    public Game(int playerSize){
        for(int i = 0; i < playerSize; i++){
            playerList.add(new Player(new PlayerState( /*TODO*/, new HashMap<>()), i));
        }
    }

    public Optional<GameState> play(int playerIdx, List<Position> card){
        //To DO according to rules
        return null;
    }

}
