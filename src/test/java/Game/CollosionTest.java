package Game;

import Game.control_objects.Collosion;
import Game.game_objects.Player;
import Game.game_objects.Tree_object;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Game.control_objects.Collosion_Exception;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollosionTest {
private Collosion undertest;
private Player player=new Player();
private Tree_object obj;


    public CollosionTest() throws IOException {
    }


    @BeforeEach
    public void setUp() {
        undertest = new Collosion();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test //Controller controller, Player plr, Entity obj
    public void testCollosion_detection_Should_Throw_collosion_exception_if_playerpos_and_objpos_is_equal() {
        // Given
        Player plr = player;
        ImageView test_image=new ImageView();
        AnchorPane anch = new AnchorPane();
        plr.setPosx(5);
        plr.setPosy(5);
        obj = new Tree_object(plr.getPosx(),plr.getPosy(),test_image,anch);
        // When
        Collosion_Exception exception = assertThrows(Collosion_Exception.class, () -> {
            undertest.Collosion_detection(plr,obj);
        });
        assertEquals("the player is inside the object", exception.getMessage());
    }

}
