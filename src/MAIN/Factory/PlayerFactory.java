package MAIN.Factory;

import MAIN.Interfaces.HandInterface;
import MAIN.Interfaces.PlayerInterface;
import MAIN.Player;
import MAIN.SleepingQueens;

public class PlayerFactory {
    public PlayerInterface createPlayer(HandInterface hand, int playerId, SleepingQueens queens){
        return new Player(hand, playerId, queens);
    }
}
