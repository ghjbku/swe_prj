package Game.game_events;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignEventTest {

    private SignEvent undertest;
    public SignEventTest(){}

    @BeforeEach
    public void setUp() {
        undertest = new SignEvent();
        System.out.println("im working");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSignEvent(){
        assertEquals(1, undertest.Sign_crossroad());
        undertest.setcounter(5);
        assertEquals(0, undertest.Sign_crossroad());
    }





}
