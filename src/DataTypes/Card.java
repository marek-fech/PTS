package DataTypes;

import Enumerations.CardType;

public class Card {
    private CardType type;
    private int value;

    public Card(CardType type, int value){
        this.type = type;
        this.value = value;
    }

    public CardType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
