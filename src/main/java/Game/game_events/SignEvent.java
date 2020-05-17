package Game.game_events;

import Game.game_objects.Player;

public class SignEvent {
    private int round_counter = 0;

    public SignEvent(){}

    public int Sign_crossroad() {

        if (round_counter == 0 ) {
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
