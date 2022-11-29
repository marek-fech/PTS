package DataTypes;

public class HandPosition {

    private int cardIndex;
    private int playerIndex;

    public HandPosition(int cardIndex, int playerIndex){
        this.cardIndex = cardIndex;
        this.playerIndex = playerIndex;

    }

    public int getCardIndex() {
        return cardIndex;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }
}
