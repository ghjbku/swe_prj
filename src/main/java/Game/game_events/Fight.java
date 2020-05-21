package Game.game_events;

import Game.game_objects.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Fight {
    private int round_counter = 0;
    public boolean run = false;
    private static Logger logger = LoggerFactory.getLogger(Fight.class);

    public Fight() {
    }

    public int Fight_crossroad(Player player) {

        if (round_counter == 0 && !(player.getFought())) {
            if (player.getItems().isEmpty()) {
                logger.info("no item");
                return -1;
            } else if (player.getItems().size() == 1) {
                if (player.getItems().get(0).getName().equals("dagger")){
                    logger.info("size 1,returns 0");
                    return 0;
                }
                else if (!(player.getItems().get(0).getName().equals("dagger"))) {
                    logger.info("size 1, item not dagger");
                    return -1;
                }

            } else if (player.getItems().size() == 2) {
                if (player.getItems().get(0).getName().equals("dagger")||player.getItems().get(1).getName().equals("dagger")){
                    logger.info("size 2,returns 0");
                    return 0;
                }
                else if (
                        !(player.getItems().get(1).getName().equals("dagger")) || !(player.getItems().get(0).getName().equals("dagger"))
                ) {
                    logger.info("size 2, no dagger");
                    return -1;
                }
            }
            else if (player.getItems().size() == 3) {
                if (player.getItems().get(0).getName().equals("dagger")||player.getItems().get(1).getName().equals("dagger")
                        ||player.getItems().get(2).getName().equals("dagger")){
                    logger.info("size 3,returns 0");
                    return 0;
                }
                else {logger.info("size 3,returns -1");
                return -1;}
            }
        } else if (round_counter == 10 || player.getFought()) {
            logger.info("already fought");
            return 1;
        }
        logger.error("returns -2");
        return -2;
    }

    public int getcounter() {
        return round_counter;
    }

    public void setcounter(int count) {
        round_counter = count;
    }

}
