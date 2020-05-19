package Game.game_events;

import Game.game_objects.Item;
import Game.game_objects.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WellEventTest {
    private Player player = new Player();
    private SignEvent undertest;
    public WellEventTest(){}

    @BeforeEach
    public void setUp() {
        undertest = new SignEvent();
        System.out.println("im working");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testWellEvent(){
        //player.getItems().get(0).getName().equals("Rope")
            ArrayList<Item> item = player.getItems();
            item.add(new Item("Rope", 2, 0, 0));
            player.setItems(item);

        assertEquals(1, undertest.Sign_crossroad(player));
        undertest.setcounter(5);
        assertEquals(0, undertest.Sign_crossroad(player));
    }





}
