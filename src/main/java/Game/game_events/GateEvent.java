package Game.game_events;

import Game.game_objects.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GateEvent {
    private int round_counter = 0;
    private static Logger logger = LoggerFactory.getLogger(GateEvent.class);

    public GateEvent(){}

    public int Gate_crossroad(Player player) {
        if (round_counter == 0 && player.getFought()==false) {
            logger.info("player did not fight yet,return 0");
            return 0;
        }
        else if (round_counter == 0 && player.getFought()) {
            logger.info("player fought,return 1");
            return 1;
        }
        else if (round_counter>0 &&  player.getFought()){
            logger.info("player fought,return 1");
            return 1;
        }
        logger.info("round is not 0,player did not fight yet. return -1");
        return -1;
    }

    public int getcounter() {
        return round_counter;
    }

    public void setcounter(int count) {
        round_counter = count;
    }
}

