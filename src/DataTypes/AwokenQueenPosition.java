package DataTypes;

import Interfaces.Position;

public class AwokenQueenPosition implements Position {

    private int cardIndex;
    private int playerIndex;

    public AwokenQueenPosition(int cardIndex, int playerIndex){
        this.cardIndex = cardIndex;
        this.playerIndex = playerIndex;

    }

    @Override
    public int getCardIndex() {
        return cardIndex;
    }

    @Override
    public int getPlayerIndex() {
        return playerIndex;
    }
}
