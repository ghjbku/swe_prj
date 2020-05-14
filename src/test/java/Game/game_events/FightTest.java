package Game.game_events;

import Game.game_objects.Item;
import Game.game_objects.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FightTest {
    private Player player=new Player();
    Fight undertest;
    public FightTest(){}


    @BeforeEach
    public void setUp() {
            undertest = new Fight();
            System.out.println("im working");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testFight()
    {
        Player plr = player;
        Fight test_fight=undertest;

       plr.setscore(10);
       plr.setgender("male");
       plr.setName("windsake");
        assertEquals("windsake",plr.getName());
        assertEquals("male",plr.getgender());
        assertEquals(10,plr.getscore());

        //leaps into the first if
        assertFalse(plr.getFought());
        assertEquals(0, test_fight.getcounter());

        //no_weapon end
       assertTrue(plr.getItems().isEmpty());
       assertEquals(-1, test_fight.Fight_crossroad(plr));

       //thefight end
        ArrayList<Item> item = plr.getItems();
        item.add(new Item("dagger", 0, 65, 216));
        plr.setItems(item);
        assertTrue(plr.getitem(0).getid()==0);
        assertTrue(plr.getitem(0).getName().equals("dagger"));
        assertEquals(0, test_fight.Fight_crossroad(plr));

        //fought end
        test_fight.setcounter(10);
        assertEquals(1, test_fight.Fight_crossroad(plr));

        test_fight.setcounter(9);
        plr.setFought(false);
        assertEquals(-2, test_fight.Fight_crossroad(plr));

    }

}
