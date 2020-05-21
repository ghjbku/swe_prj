package Game.control_objects;

import Game.game_objects.Player;
import Game.game_objects.TreeObject;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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

    @Test //Controller controller, Player plr, Entity obj
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
