package Game.game_objects;

/**
 * class of the Invetory's model.
 */
public class Inventory {
    private int[] slot = new int[3];
    private Player player;

    /**
     * constructor that gets a player as param and sets it as the class's own player.
     *
     * @param plr player object.
     */
    public Inventory(Player plr) {
        player = plr;
    }

    /**
     * function that returns the inventory slot corresponding to the index given.
     *
     * @param i index of the slot to return.
     * @return the slot.
     */
    public int getslot(int i) {
        return slot[i];
    }

    /**
     * sets the inventory's slot with the val value that corresponds to the index.
     *
     * @param i   index of the slot.
     * @param val value to set to the slot.
     */
    public void setslot(int i, int val) {
        slot[i] = val;
    }
}
