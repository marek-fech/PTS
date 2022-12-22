package MAIN;

import MAIN.DataTypes.*;
import MAIN.Interfaces.Position;

import java.util.*;

public class Game {
    private List<Player> playerList;
    private GameState gameState;
    private DrawingAndTrashPile drawingAndTrashPile;
    private SleepingQueens sleepingQueens;
    private GameFinished gameFinished;

    public Game(int playerSize){
        sleepingQueens = new SleepingQueens();
        drawingAndTrashPile = new DrawingAndTrashPile();

        playerList = new ArrayList<>();
        for(int i = 0; i < playerSize; i++){
            Hand hand = new Hand(i, drawingAndTrashPile);
            playerList.add(new Player(hand, i, sleepingQueens));
        }

        MoveQueen moveQueen = new MoveQueen(sleepingQueens, playerList);
        EvaluateAttack evaluateAttack = new EvaluateAttack(playerList, moveQueen);

        for(Player player : playerList){
            player.setMoveQueen(moveQueen);
            player.setEvaluateAttack(evaluateAttack);
        }

        gameState = new GameState(playerSize, 0, new ArrayList<>());

        updateGameState();

        gameFinished = new GameFinished(this);
    }

    public void updateGameState(){
        //update Sleeping Queens
        Set<SleepingQueenPosition> sleepingQueenPositions = new LinkedHashSet<>();
        for(Position position : sleepingQueens.getQueens().keySet()){
            sleepingQueenPositions.add((SleepingQueenPosition) position);
        }
        gameState.setSleepingQueens(sleepingQueenPositions);


        Map<AwokenQueenPosition, Queen> awokenQueenPositions = new LinkedHashMap();
        Map<HandPosition, Optional<Card>> cards = new LinkedHashMap<>();

        for(Player player : playerList){
            int i = 0;
            //update Awoken Queens
            for(Queen queen : player.getAwokenQueens().getQueens().values()){
                awokenQueenPositions.put(new AwokenQueenPosition(i, player.getPlayerIdx()), queen);
                i++;
            }
            i = 0;
            //update cards
            for(Card card : player.getHand().getCards()){
                cards.put(new HandPosition(i, player.getPlayerIdx()), Optional.ofNullable(card));
                i++;
            }
        }
        gameState.setAwokenQueens(awokenQueenPositions);
        gameState.setCards(cards);

    }

    public Optional<GameState> play(int playerIdx, List<Position> card){
        if(playerIdx == gameState.getOnTurn() && playerList.get(playerIdx).play(card)){
            updateGameState();
            gameState.setOnTurn((gameState.getOnTurn() + 1) % gameState.getNumberOfPlayers());
            gameState.setCardsDiscartedLastTurn(drawingAndTrashPile.getDiscardedThisTurn());

            drawingAndTrashPile.newTurn();

            Optional<Integer> winner = gameFinished.isFinished();
            if(winner.isPresent()){
                gameState.setOnTurn(-1);
                System.out.println("The winner is Player number " + (winner) + "! Congratulations");
            }
            return Optional.of(gameState);
        }
        return Optional.empty();
    }

    public DrawingAndTrashPile getDrawingAndTrashPile() {
        return drawingAndTrashPile;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public SleepingQueens getSleepingQueens() {
        return sleepingQueens;
    }

    public GameState getGameState() {
        return gameState;
    }

}
