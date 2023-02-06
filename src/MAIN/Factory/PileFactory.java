package MAIN.Factory;

import MAIN.DrawingAndTrashPile;
import MAIN.Interfaces.DrawingAndTrashPileInterface;

public class PileFactory {
    public DrawingAndTrashPileInterface createPile(){
        return new DrawingAndTrashPile();
    }
}
