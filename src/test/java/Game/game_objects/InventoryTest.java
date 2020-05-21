package Game.game_objects;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InventoryTest {
    private Inventory undertest;
    private Player player=new Player();

    public InventoryTest(){}

    @BeforeEach
    public void setUp() {
        undertest=new Inventory(player);
        System.out.println("im working");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testInventory(){
        undertest.setslot(0,1);
        assertEquals(1,undertest.getslot(0));
    }

}
