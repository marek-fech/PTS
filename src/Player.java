import DataTypes.HandPosition;
import DataTypes.PlayerState;
import DataTypes.Position;

import java.util.List;

public class Player {
    public PlayerState playerState;
    public Hand hand;

    public Player(PlayerState playerState){
        this.playerState = playerState;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void play(List<Position> cards){
        //TO DO
    }
}
