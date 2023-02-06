package TESTS;

import MAIN.GameAdaptor;
import MAIN.GameObservable;
import MAIN.Interfaces.GameObserver;
import org.junit.Test;

import static org.junit.Assert.*;
public class GameAdaptorTest {
    private GameAdaptor gameAdaptor;
    private GameObservable gameObservable;

    private void init1(){
        gameObservable = new GameObservable();
        //gameObservable.addPlayer("John", new GameObserver());
        gameAdaptor = new GameAdaptor(gameObservable);
    }

    private void init2(){
        gameObservable = new GameObservable();
        //gameObservable.addPlayer("John", new GameObservable());
        //gameObservable.addPlayer("Mary", new GameObservable());
        gameAdaptor = new GameAdaptor(gameObservable);
    }

    @Test
    public void playTest1(){
        init1();
        assertEquals("Not enough players!", gameAdaptor.play("John", "h0 s2"));
    }

    @Test
    public void playTest2(){
        init2();
        assertEquals("Incorrect input. Player Anna does not exists.", gameAdaptor.play("Anna", "h0 s2"));
    }

    @Test
    public void playTest3(){
        init2();
        assertEquals("Incorrect format used!", gameAdaptor.play("Mary", "play whatever"));
    }
}
