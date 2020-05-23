package Game.game_events;

import Game.game_objects.Player;

/**
 * class that contains the "model" of the SignEvent.
 */
public class SignEvent {
    private int round_counter = 0;

    /**
     * default constructor.
     */
    public SignEvent() {
    }

    /**
     * the crossroad that returns different values based on the player's status.
     *
     * @param player player object so we can check if they did the event yet.
     * @return 1 if they did not trigger the event yet, 0 if they did.
     */
    public int Sign_crossroad(Player player) {

        if (round_counter == 0 && !player.getSignevent_done()) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * getter for the round_counter.
     *
     * @return round_counter.
     */
    public int getcounter() {
        return round_counter;
    }

    /**
     * getter for the round_counter.
     *
     * @param count the number to set the counter to.
     */
    public void setcounter(int count) {
        round_counter = count;
    }
}
