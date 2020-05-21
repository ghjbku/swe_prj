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
    private WellEvent undertest;
    public WellEventTest(){}

    @BeforeEach
    public void setUp() {
        undertest = new WellEvent();
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
        System.out.println("size: "+player.getItems().size()+","+player.getitem(0).getName());

        assertEquals(1, undertest.Well_crossroad(player));
        item.remove(0);
        assertEquals(-1, undertest.Well_crossroad(player));
        player.setWellevent_done(true);
        undertest.setcounter(5);
        assertEquals(5,undertest.getcounter());;
        assertEquals(0, undertest.Well_crossroad(player));
    }

    @Test
    public void testWellEvent_false_branch(){
        Item random_item = new Item();
        random_item.setname("dogthing");
        random_item.setid(11);
        random_item.setx(0);
        random_item.sety(0);

        ArrayList<Item> item = player.getItems();
        item.add(new Item("dagger", 0, 0, 0));
        player.setItems(item);
        //items size 1, not Rope
        assertEquals(-1,undertest.Well_crossroad(player));

        item.add(new Item("Note",1,0,0));
        player.setItems(item);
        //items size 2, none is Rope
        assertEquals(-1,undertest.Well_crossroad(player));

        item.remove(1);
        item.add(new Item("Rope",2,0,0));
        player.setItems(item);
        //items size 2, one of them is rope
        assertEquals(1,undertest.Well_crossroad(player));

        item.add(new Item("Note",1,0,0));
        player.setItems(item);
        //items size 3, one of them is rope
        assertEquals(1,undertest.Well_crossroad(player));

        item.remove(1);
        item.add(random_item);
        player.setItems(item);
        //item size is 3, but none is rope
        assertEquals(-1,undertest.Well_crossroad(player));
    }





}
