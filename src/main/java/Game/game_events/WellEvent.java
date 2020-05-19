package Game.game_events;

import Game.game_objects.Player;

public class WellEvent {
    private int round_counter = 0;

    public WellEvent(){}

    public int Well_crossroad(Player player) {

        if (round_counter == 0 && !player.getWellevent_done()) {
            if (player.getItems().size()==0){
                return 0;
            }
            else if (player.getItems().size()==1){
                if (player.getItems().get(0).getName().equals("Rope")){
                    return 1;
                }
            }
            else if (player.getItems().size()==2){
                if (player.getItems().get(0).getName().equals("Rope")||
                    player.getItems().get(1).getName().equals("Rope")){
                    return 1;
                }
            }
            else if (player.getItems().size()==3){
                if (player.getItems().get(0).getName().equals("Rope")||
                    player.getItems().get(1).getName().equals("Rope")||
                    player.getItems().get(2).getName().equals("Rope")){
                    return 1;
                }
            }
            return 0;
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


