package Game.game_events;

import Game.game_objects.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignEventTest {
    private Player player = new Player();
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
        assertEquals(1, undertest.Sign_crossroad(player));
        undertest.setcounter(5);
        assertEquals(0, undertest.Sign_crossroad(player));
    }





}
