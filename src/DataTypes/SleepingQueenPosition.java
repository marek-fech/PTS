package DataTypes;

import Interfaces.Position;

public class SleepingQueenPosition implements Position {

    private int cardIndex;

    public SleepingQueenPosition(int cardIndex){
        this.cardIndex = cardIndex;
    }

    public int getCardIndex() {
        return cardIndex;
    }

    @Override
    public int getPlayerIndex() {
        return 0;
    }

}
