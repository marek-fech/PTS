package MAIN.Factory;

import MAIN.Hand;
import MAIN.Interfaces.DrawingAndTrashPileInterface;
import MAIN.Interfaces.HandInterface;

public class HandFactory {
    public HandInterface createHand(int playerId, DrawingAndTrashPileInterface datp){
        return new Hand(playerId, datp);
    }
}
