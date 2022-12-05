import DataTypes.AwokenQueenPosition;
import DataTypes.HandPosition;
import DataTypes.PlayerState;
import DataTypes.Position;

import java.util.List;

public class Player {
    private PlayerState playerState;
    private Hand hand;
    private int playerIdx;
    private AwokenQueens awokenQueens;

    public Player(PlayerState playerState, int playerIdx){
        this.playerIdx = playerIdx;
        this.hand = new Hand(this.playerIdx);
        this.playerState = playerState;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void play(List<Position> cards){
        //TO DO
    }
}
