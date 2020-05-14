package Game.game_events;
import Game.game_objects.Player;


public class Fight {
    private int round_counter=0;
    public boolean run =false;

    public Fight(){}

    public int Fight_crossroad(Player player) {

        if (round_counter==0 && !(player.getFought()) )
        {
            if (player.getItems().isEmpty() || !(player.getItems().get(0).getid()==0)){return -1; }
            else {return 0;}
        }
        else if(round_counter==10 || player.getFought()==true){
            return 1;
        }
    return -2;
    }

     public int getcounter(){return round_counter;}
     public void setcounter(int count){round_counter=count;}

}
