package Game;

import Game.game_objects.*;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Collosion {
    private static int dist = 8;
    public Collosion(){}
    public static boolean Collosion_detection(Controller controller,Player plr, Entity obj){

        if ( ( (Math.abs(obj.getx()-plr.getPosx())<dist) || (Math.abs(plr.getPosx()-obj.getx())<dist) ) && ( (Math.abs(obj.gety()-plr.getPosy())<dist) || (Math.abs(plr.getPosy()-obj.gety())<dist) ) ){

            plr.setPosx(Controller.getLastx());
            plr.setPosy(Controller.getLasty());

            if (obj.getClass().equals(Bear.class)){
                System.out.println("its a bear!!!");
                controller.open_text_pane();
            }

        }
        return true;
    }
    public static void Collosion_detection(Controller controller,Player plr) {
        if (((Math.abs(65 - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - 65) < dist)) && ((Math.abs(216 - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - 216) < dist))) {

            ArrayList<Item> item = plr.getItems();
            if (item.size()==0 || ((item.get(0).getName()=="Note") &&item.size()==1)){
                System.out.println("item added");
            item.add(new Item("dagger", 0, 65, 216));
            plr.setItems(item);
            controller.setcollided();
            }

            else if(item.size()>1){

            }

        } else if (((Math.abs(475 - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - 475) < dist)) &&
                ((Math.abs(16 - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - 16) < dist))) {

            ArrayList<Item> item = plr.getItems();
            if (item.size()==0 || ((item.get(0).getid()==0) &&item.size()==1)){
                System.out.println("item added");
                item.add(new Item("Note", 1, 475, 16));
                plr.setItems(item);
                controller.setcollided();
            }

            else if(item.size()>1){}

        }

    }

}
