package Game.game_objects;

public class Inventory {
    private int[] slot = new int[3];
    private Player player;

    public Inventory(Player plr) {
        player = plr;
    }

    public int getslot(int i) {
        return slot[i];
    }

    public void setslot(int i, int val) {
        slot[i] = val;
    }
}
