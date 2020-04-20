package Game;

import Game.game_objects.Entity;
import Game.game_objects.Item;
import Game.game_objects.Player;
import Game.game_objects.Tree_object;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Collosion {
    private static int dist = 8;
    public Collosion(){}
    public static void Collosion_detection(Player plr, Entity obj){

        if ( ( (Math.abs(obj.getx()-plr.getPosx())<dist) || (Math.abs(plr.getPosx()-obj.getx())<dist) ) && ( (Math.abs(obj.gety()-plr.getPosy())<dist) || (Math.abs(plr.getPosy()-obj.gety())<dist) ) ){

            plr.setPosx(Controller.getLastx());
            plr.setPosy(Controller.getLasty());
        }

    }
    public static void Collosion_detection(Player plr) {
        if (((Math.abs(65 - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - 65) < dist)) && ((Math.abs(216 - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - 216) < dist))) {
            Controller.getfound().setVisible(true);

            ArrayList<Item> item = Game.getItem();
            if (item.size()==0 || (item.size()==1 && item.get(0).getName()=="Note")){
                System.out.println("item added");
            item.add(new Item("dagger", 0, 65, 216));
            plr.setItems(item);}
            else{}
        } else if (((Math.abs(475 - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - 475) < dist)) && ((Math.abs(16 - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - 16) < dist))) {

            ArrayList<Item> item = Game.getItem();
            if (item.size()==0 || (item.size()==1 && item.get(0).getName()=="dagger")) {
                System.out.println("item added");
                item.add(new Item("Note", 1, 475, 16));
                plr.setItems(item);
            }
            else { }

        }

    }

}
