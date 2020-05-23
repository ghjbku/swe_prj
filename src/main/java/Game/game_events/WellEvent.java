package Game.game_events;

import Game.game_objects.Player;

/**
 * class that contains the "model" of the WellEvent.
 */
public class WellEvent {
    private int round_counter = 0;

    /**
     * default constructor.
     */
    public WellEvent() {
    }

    /**
     * the crossroad of the Well event, returns different values based on the player's inventory.
     *
     * @param player the player object that is used to open it's inventory.
     * @return -1 if the player has no rope in the inventory,1 if there is,0 if there is an error.
     */
    public int Well_crossroad(Player player) {

        if (round_counter == 0 && !player.getWellevent_done()) {
            if (player.getItems().size() == 0) {
                return -1;
            } else if (player.getItems().size() == 1) {
                if (player.getItems().get(0).getName().equals("Rope")) {
                    return 1;
                } else return -1;
            } else if (player.getItems().size() == 2) {
                if (player.getItems().get(0).getName().equals("Rope") ||
                        player.getItems().get(1).getName().equals("Rope")) {
                    return 1;
                } else return -1;
            } else if (player.getItems().size() == 3) {
                if (player.getItems().get(0).getName().equals("Rope") ||
                        player.getItems().get(1).getName().equals("Rope") ||
                        player.getItems().get(2).getName().equals("Rope")) {
                    return 1;
                } else return -1;
            }
            return 0;
        } else {
            return 0;
        }
    }

    /**
     * getter method for the round counter.
     *
     * @return round counter.
     */
    public int getcounter() {
        return round_counter;
    }

    /**
     * setter method for the round counter.
     *
     * @param count an integer to set the round_counter to.
     */
    public void setcounter(int count) {
        round_counter = count;
    }

}


