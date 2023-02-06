package MAIN;

import MAIN.DataTypes.*;
import MAIN.Factory.HandFactory;
import MAIN.Factory.PileFactory;
import MAIN.Factory.PlayerFactory;
import MAIN.Interfaces.*;

import java.util.*;

public class Game {
    private final List<PlayerInterface> playerList;
    private final GameState gameState;
    private final DrawingAndTrashPileInterface drawingAndTrashPile;
    private final SleepingQueens sleepingQueens;
    private final GameFinished gameFinished;

    public Game(int playerSize){
        HandFactory handFactory = new HandFactory();
        PlayerFactory playerFactory = new PlayerFactory();
        PileFactory pileFactory = new PileFactory();

        this.sleepingQueens = new SleepingQueens();
        this.drawingAndTrashPile = pileFactory.createPile();

        playerList = new ArrayList<>();
        for(int i = 0; i < playerSize; i++){
            HandInterface hand = handFactory.createHand(i, drawingAndTrashPile);
            playerList.add(playerFactory.createPlayer(hand, i, sleepingQueens));
        }

        MoveQueenInterface moveQueen = new MoveQueen(sleepingQueens, playerList);
        EvaluateAttack evaluateAttack = new EvaluateAttack(playerList, moveQueen);

        for(PlayerInterface player : playerList){
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

        for(PlayerInterface player : playerList){
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

    public DrawingAndTrashPileInterface getDrawingAndTrashPile() {
        return drawingAndTrashPile;
    }

    public List<PlayerInterface> getPlayerList() {
        return playerList;
    }

    public SleepingQueens getSleepingQueens() {
        return sleepingQueens;
    }

    public GameState getGameState() {
        return gameState;
    }

}
