package Game.game_events;

import Game.game_objects.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * class that contains the "model" of the GateEvent.
 */
public class GateEvent {
    private int round_counter = 0;
    private static Logger logger = LoggerFactory.getLogger(GateEvent.class);

    /**
     * default constructor
     */
    public GateEvent() {
    }

    /**
     * the crossroad that returns a different value based on the player's status.
     *
     * @param player player object so we can check if they fought yet or not.
     * @return 0 if did not fight yet, 1 if they did, -1 if there is an error.
     */
    public int Gate_crossroad(Player player) {
        if (round_counter == 0 && player.getFought() == false) {
            logger.info("player did not fight yet,return 0");
            return 0;
        } else if (round_counter == 0 && player.getFought()) {
            logger.info("player fought,return 1");
            return 1;
        } else if (round_counter > 0 && player.getFought()) {
            logger.info("player fought,return 1");
            return 1;
        }
        logger.info("round is not 0,player did not fight yet. return -1");
        return -1;
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

