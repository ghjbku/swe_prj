package Game.game_objects;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BearTest {
    Bear undertest;

    public BearTest(){}

    @BeforeEach
    public void setUp() {
        ImageView bear_image = new ImageView();
        AnchorPane bear_pane = new AnchorPane();
        //int x,int y, ImageView bear_image, AnchorPane bear_pane
        undertest = new Bear(0,0,bear_image,bear_pane);
        System.out.println("im working");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testBearstuff(){
       undertest.sethp(12);
        assertEquals(12,undertest.gethp());
        undertest.setx(5);
        undertest.sety(10);
        assertEquals(5,undertest.getx());
        assertEquals(10,undertest.gety());
    }

}
