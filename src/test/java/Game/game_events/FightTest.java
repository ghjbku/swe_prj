package Game.game_events;

import Game.Game;
import Game.control_objects.Collosion;
import Game.game_events.Fight;
import Game.game_objects.Item;
import Game.game_objects.Player;
import Game.game_window.ForestScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
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
    public void testNoWeapon()
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
       assertEquals(-1, test_fight.open_text_pane(plr));


       //thefight end
        ArrayList<Item> item = plr.getItems();
        item.add(new Item("dagger", 0, 65, 216));
        plr.setItems(item);
        assertEquals(0, test_fight.open_text_pane(plr));

       //fought end
       test_fight.setcounter(10);
       assertEquals(1, test_fight.open_text_pane(plr));

    }

}
