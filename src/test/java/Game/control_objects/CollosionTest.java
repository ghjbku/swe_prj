package Game.control_objects;

import Game.game_objects.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CollosionTest {
    private Collosion undertest;
    private Player player = new Player();
    private TreeObject obj;


    public CollosionTest() throws IOException {
    }


    @BeforeEach
    public void setUp() {
        try {
            undertest = new Collosion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Test //Player plr, Entity obj
    public void testCollosion_detection_Should_Throw_collosion_exception_if_playerpos_and_objpos_is_equal() {
        // Given
        Player plr = player;
        ImageView test_image = new ImageView();
        AnchorPane anch = new AnchorPane();
        plr.setPosx(5);
        plr.setPosy(5);
        obj = new TreeObject(plr.getPosx(), plr.getPosy(), test_image, anch);
        // When
        CollosionException exception = assertThrows(CollosionException.class, () -> {
            undertest.Collosion_detection(plr, obj);
        });
        assertEquals("the player is inside the object", exception.getMessage());
    }

    @Test
    public void testCollosion_with_dagger(){
        final int d_x = 65, d_y = 216;
        Player plr = player;
        ArrayList<Item> itemek=plr.getItems();

        plr.setPosx(64);
        plr.setPosy(215);
        //itemsize 0, player "collides" with the dagger
        assertTrue(undertest.Collosion_detection_item(plr));
        System.out.println("size:"+plr.getItems().size());

        itemek.remove(0);
        Item random_item = new Item();
        random_item.setname("stuff");
        random_item.setid(1);
        random_item.setx(0);
        random_item.sety(0);
        itemek.add(random_item);
        plr.setItems(itemek);
        //itemsize 1, not dagger
        assertTrue(undertest.Collosion_detection_item(plr));
        System.out.println("size:"+plr.getItems().size());

        //itemsize 1, is dagger, doesnt return anything
        itemek.remove(0);
        itemek.remove(0);
        itemek.add(new Item("dagger",0,0,0));
        plr.setItems(itemek);
        System.out.println("size:"+plr.getItems().size());

        //itemsize 2, has dagger in it... doesnt return anything
        itemek.add(random_item);
        plr.setItems(itemek);
        System.out.println("size:"+plr.getItems().size());

        itemek.remove(0);
        itemek.add(new Item("Note",2,0,0));
        plr.setItems(itemek);
        //itemsize 2, no dagger
        assertTrue(undertest.Collosion_detection_item(plr));

    }

    @Test
    public void testCollosion_with_note(){
        final int n_x = 475, n_y = 16;

        Player plr = player;
        ArrayList<Item> itemek=plr.getItems();

        plr.setPosx(n_x-1);
        plr.setPosy(n_y-1);
        System.out.println("size:"+plr.getItems().size());
        //collosion with note, 0 itemsize
        assertTrue(undertest.Collosion_detection_item(plr));
        //now the itemsize is 1 and it is the note, it returns nothing
        System.out.println("size:"+plr.getItems().size());

        itemek.remove(0);
        itemek.add(new Item("asd",0,0,0));
        plr.setItems(itemek);
        System.out.println("size:"+plr.getItems().size());
        //itemsize 1, its not the note
        assertTrue(undertest.Collosion_detection_item(plr));
        //now the itemsize is 2, one of them is the note

        itemek.remove(1);
        itemek.add(new Item("asd2",2,0,0));
        plr.setItems(itemek);
        //itemsize 2, not the note
        assertTrue(undertest.Collosion_detection_item(plr));
        System.out.println("size:"+plr.getItems().size());
        //itemsize3
        assertFalse(undertest.Collosion_detection_item(plr));
    }

    @Test
    public void testCollosion_with_obj_a_bear() throws CollosionException {
        Player plr = player;
        ImageView bear_fig = new ImageView();
        AnchorPane entity_pane = new AnchorPane();
        Bear bear = new Bear(730, 314, bear_fig, entity_pane);
        plr.setPosx(0);
        plr.setPosy(0);
        plr.setLastx(5);
        plr.setLasty(5);
        bear.setx(1);
        bear.sety(1);
        assertFalse( undertest.Collosion_detection(plr, bear));
        assertEquals(5,plr.getPosx());
        assertEquals(5,plr.getPosy());
    }

    // public static boolean Collosion_tp(Player plr)
    @Test
    public void testCollosion_tp() {
        final int tp_x = 768, tp_y = 23;
        Player plr = player;
        assertFalse(undertest.Collosion_tp(plr));

        plr.setPosx(768);
        plr.setPosy(23);

        assertTrue(undertest.Collosion_tp(plr));
    }

    @Test
    //public static boolean Collosion_sign(Player plr)
    public void testCollosion_sign() {
        final int sign_x = 59, sign_y = 409;
        Player plr = player;
        assertFalse(undertest.Collosion_sign(plr));

        plr.setPosx(59);
        plr.setPosy(409);

        assertTrue(undertest.Collosion_sign(plr));
    }

    @Test
    //public static boolean Collosion_well(Player plr)
    public void testCollosion_well() {
        final int well_x = 725, well_y = 533;
        Player plr = player;
        assertFalse(undertest.Collosion_well(plr));

        plr.setPosx(725);
        plr.setPosy(533);

        assertTrue(undertest.Collosion_well(plr));
    }

}
