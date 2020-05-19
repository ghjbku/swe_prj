package Game.game_events;

import Game.game_objects.Player;

public class WellEvent {
    private int round_counter = 0;

    public WellEvent(){}

    public int Well_crossroad(Player player) {

        if (round_counter == 0 && !player.getWellevent_done()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int getcounter() {
        return round_counter;
    }

    public void setcounter(int count) {
        round_counter = count;
    }
}


