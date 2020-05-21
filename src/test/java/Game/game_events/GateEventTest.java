package Game.game_events;

import Game.game_objects.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class GateEventTest {
    private Player player = new Player();
    private GateEvent undertest;
    public GateEventTest(){}

    @BeforeEach
    public void setUp() {
        undertest = new GateEvent();

        System.out.println("im working");

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGateEvent(){
        player.setFought(false);

        System.out.println("fought?: "+player.getFought());
        assertEquals(0, undertest.Gate_crossroad(player));

        undertest.setcounter(5);
        assertEquals(-1, undertest.Gate_crossroad(player));

        undertest.setcounter(0);
        assertEquals(0, undertest.Gate_crossroad(player));
        player.setFought(true);
        System.out.println("fought?: "+player.getFought());
        assertEquals(1, undertest.Gate_crossroad(player));
    }

    @Test
    public void testPlayer_fought_ret_1(){
        player.setFought(true);
        undertest.setcounter(5);
        assertEquals(5,undertest.getcounter());
        assertEquals(1,undertest.Gate_crossroad(player));
    }





}
