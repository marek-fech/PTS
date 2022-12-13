import DataTypes.GameState;
import DataTypes.PlayerState;
import DataTypes.SleepingQueenPosition;
import Interfaces.Position;

import java.util.*;

public class Game {
    private List<Player> playerList;
    private GameState gameState;
    private DrawingAndTrashPile drawingAndTrashPile;
    private SleepingQueens sleepingQueens;

    public Game(int playerSize){
        sleepingQueens = new SleepingQueens();
        drawingAndTrashPile = new DrawingAndTrashPile();
        playerList = new ArrayList<>();
        for(int i = 0; i < playerSize; i++){
            playerList.add(new Player(new PlayerState(drawingAndTrashPile.getInitialCards(), new HashMap<>()), i));
        }

        Set<SleepingQueenPosition> sleepingQueenPositions = new HashSet<>();
        for(Position x : sleepingQueens.getQueens().keySet()){
            sleepingQueenPositions.add((SleepingQueenPosition) x);
        }

        gameState = new GameState(playerSize, 0, sleepingQueenPositions, null, new HashMap<>(), new ArrayList<>());
    }

    public Optional<GameState> play(int playerIdx, List<Position> card){
        //To DO according to rules
        return null;
    }

}
