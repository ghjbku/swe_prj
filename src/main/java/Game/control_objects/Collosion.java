package Game.control_objects;

import Game.Game;
import Game.game_objects.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * class that checks the collosion between objects and the player(later obj + obj as well)
 */
public class Collosion {
    private static Logger logger = LoggerFactory.getLogger(Collosion.class);

    private static int dist = 10;
    private CityController cityController = new CityController();

    /**
     * default constructor for the class
     */
    public Collosion() throws MalformedURLException {
    }

    /**
     * function that detects if the player collides with an object
     *
     * @param plr the player
     * @param obj the object
     * @return returns true if the collosion happens with inanimate objects(trees),false if with mobs(bear)
     * @throws CollosionException happens when the player is inside the object
     */
    public static boolean Collosion_detection(Player plr, Entity obj) throws CollosionException {

        if (obj.getx() == plr.getPosx() && obj.gety() == plr.getPosy()) {
            throw new CollosionException("the player is inside the object");
        }
        if (((Math.abs(obj.getx() - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - obj.getx()) < dist)) && ((Math.abs(obj.gety() - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - obj.gety()) < dist))) {

            plr.setPosx(plr.getLastx());
            plr.setPosy(plr.getLasty());

            if (obj.getClass().equals(Bear.class)) {
                return false;
            }
            return true;
        }

        return true;
    }

    /**
     * method that checks if the player collides with an item, adds them into the player's item data
     * and calls the setcollided method of the ForestController class
     *
     * @param forestController
     * @param plr              the player
     * @throws FileNotFoundException the xml file is not found
     * @throws JAXBException         problem with the xml save/load
     * @throws MalformedURLException url wrong
     */
    public static void Collosion_detection_item(ForestController forestController, Player plr) throws FileNotFoundException, JAXBException, MalformedURLException {
        final int d_x=65,d_y=216;
        final int n_x=475,n_y=16;
        if
        (
                ((Math.abs(d_x - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - d_x) < dist))
                        && ((Math.abs(d_y - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - d_y) < dist))
        ) {

            ArrayList<Item> item = plr.getItems();
            if (item.size() == 0 || ((item.get(0).getName() == "Note") && item.size() == 1)) {
                logger.trace("item added");
                item.add(new Item("dagger", 0, d_x, d_y));
                plr.setItems(item);
                forestController.setcollided();
            } else if (item.size() > 1) {
            }

        } else if (
                ((Math.abs(n_x - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - n_x) < dist)) &&
                        ((Math.abs(n_y - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - n_y) < dist))
        ) {

            ArrayList<Item> item = plr.getItems();
            if (item.size() == 0 || ((item.get(0).getid() == 0) && item.size() == 1)) {
                logger.trace("item added");
                item.add(new Item("Note", 1, n_x, n_y));
                plr.setItems(item);
                forestController.setcollided();
            } else if (item.size() > 1) {
            }
        }


    }

    /**
     * checks the collosion between the player and the city gate teleporter
     *
     * @param plr              the player
     */
    public static boolean Collosion_tp(Player plr) {
        final int tp_x=768,tp_y=23;
        if (
                ((Math.abs(tp_x - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - tp_x) < dist)) &&
                        ((Math.abs(tp_y - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - tp_y) < dist))
        ) {
            logger.trace("collided with the teleporter!");
            return true;
        }
        return false;
    }

    public static boolean Collosion_sign(Player plr) {
        final int sign_x=59,sign_y=409;
        if (
                ((Math.abs(sign_x - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - sign_x) < dist)) &&
                ((Math.abs(sign_y - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - sign_y) < dist))
        ) {
            logger.trace("collided with the sign!");
            return true;
        }
        return false;
    }
    public static boolean Collosion_well(Player plr){
        final int well_x=725,well_y=533;
        if (
                ((Math.abs(well_x - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - well_x) < dist)) &&
                        ((Math.abs(well_y - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - well_y) < dist))
        ) {
            logger.trace("collided with the well!");
            return true;
        }
        return false;

    }


}
