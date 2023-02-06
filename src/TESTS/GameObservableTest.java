package TESTS;

import MAIN.GameObservable;
import org.junit.Test;

import static org.junit.Assert.*;
public class GameObservableTest {
    private GameObservable gameObservable;

    private void init(){
        gameObservable = new GameObservable();
    }

    @Test   //remove comment from GameObservable
    public void addTest(){
        init();
        //gameObservable.add(new GameObservable());
        //assertEquals(1, gameObservable.getGameObservers().size());
    }

    @Test
    public void addPlayerTest(){
        init();
        //gameObservable.addPlayer("John", new GameObservable());
        //gameObservable.addPlayer("John", new GameObservable());
        assertEquals(1, gameObservable.getPlayerList().size());
    }

    @Test   //remove comment from GameObservable
    public void removeTest(){
        init();
        //gameObservable.add(new GameObservable());
        //gameObservable.add(new GameObservable());
        //gameObservable.remove(gameObservable.getGameObservers().get(1));
        //assertEquals(1, gameObservable.getGameObservers().size());
    }

    @Test
    public void notifyTest(){
        init();
        assertEquals("Something", gameObservable.notify("Something"));
        assertNotEquals("something", gameObservable.notify("Something"));
    }
}
