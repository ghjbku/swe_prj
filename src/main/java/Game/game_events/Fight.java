package Game.game_events;

import Game.game_objects.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * class that contains the "model" of the Fight event.
 */
public class Fight {
    private int round_counter = 0;
    /**
     * a boolean value that tells if the player ran away from the fight.
     */
    public boolean run = false;
    /**
     * an implementation of the logger log4j.
     */
    private static Logger logger = LoggerFactory.getLogger(Fight.class);

    /**
     * default constructor.
     */
    public Fight() {
    }

    /**
     * the crossroad of the Fight event, returns different values based on the player's inventory.
     *
     * @param player the player object that is used to open it's inventory.
     * @return -1 if the player has no dagger in the inventory,0 if there is,1 if already fought and -2 for errors.
     */
    public int Fight_crossroad(Player player) {

        if (round_counter == 0 && !(player.getFought())) {
            if (player.getItems().isEmpty()) {
                logger.info("no item");
                return -1;
            } else if (player.getItems().size() == 1) {
                if (player.getItems().get(0).getName().equals("dagger")) {
                    logger.info("size 1,returns 0");
                    return 0;
                } else if (!(player.getItems().get(0).getName().equals("dagger"))) {
                    logger.info("size 1, item not dagger");
                    return -1;
                }

            } else if (player.getItems().size() == 2) {
                if (player.getItems().get(0).getName().equals("dagger") || player.getItems().get(1).getName().equals("dagger")) {
                    logger.info("size 2,returns 0");
                    return 0;
                } else if (
                        !(player.getItems().get(1).getName().equals("dagger")) || !(player.getItems().get(0).getName().equals("dagger"))
                ) {
                    logger.info("size 2, no dagger");
                    return -1;
                }
            } else if (player.getItems().size() == 3) {
                if (player.getItems().get(0).getName().equals("dagger") || player.getItems().get(1).getName().equals("dagger")
                        || player.getItems().get(2).getName().equals("dagger")) {
                    logger.info("size 3,returns 0");
                    return 0;
                } else {
                    logger.info("size 3,returns -1");
                    return -1;
                }
            }
        } else if (round_counter == 10 || player.getFought()) {
            logger.info("already fought");
            return 1;
        }
        logger.error("returns -2");
        return -2;
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
