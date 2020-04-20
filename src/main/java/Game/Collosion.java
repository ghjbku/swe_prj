package Game;

import Game.game_objects.Entity;
import Game.game_objects.Player;
import Game.game_objects.Tree_object;

public class Collosion {
    private static int dist = 8;
    public Collosion(){}
    public static void Collosion_detection(Player plr, Entity obj){

        if ( ( (Math.abs(obj.getx()-plr.getPosx())<dist) || (Math.abs(plr.getPosx()-obj.getx())<dist) ) && ( (Math.abs(obj.gety()-plr.getPosy())<dist) || (Math.abs(plr.getPosy()-obj.gety())<dist) ) ){

            plr.setPosx(Controller.getLastx());
            plr.setPosy(Controller.getLasty());
        }

    }
}
