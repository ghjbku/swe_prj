package Game;

import Game.game_objects.Entity;
import Game.game_objects.Player;
import Game.game_objects.Tree_object;

public class Collosion {
    public Collosion(){}
    public static void Collosion_detection(Player plr, Entity obj){

        if (plr.getPosx()==obj.getx() && plr.getPosy()==obj.gety()){
            System.out.println("COLLIDED!!!");
        }

    }
}
