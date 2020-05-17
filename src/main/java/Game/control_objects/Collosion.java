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
        if
        (
                ((Math.abs(65 - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - 65) < dist))
                        && ((Math.abs(216 - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - 216) < dist))
        ) {

            ArrayList<Item> item = plr.getItems();
            if (item.size() == 0 || ((item.get(0).getName() == "Note") && item.size() == 1)) {
                logger.trace("item added");
                item.add(new Item("dagger", 0, 65, 216));
                plr.setItems(item);
                forestController.setcollided();
            } else if (item.size() > 1) {
            }

        } else if (
                ((Math.abs(475 - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - 475) < dist)) &&
                        ((Math.abs(16 - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - 16) < dist))
        ) {

            ArrayList<Item> item = plr.getItems();
            if (item.size() == 0 || ((item.get(0).getid() == 0) && item.size() == 1)) {
                logger.trace("item added");
                item.add(new Item("Note", 1, 475, 16));
                plr.setItems(item);
                forestController.setcollided();
            } else if (item.size() > 1) {
            }
        }


    }

    /**
     * checks the collosion between the player and the city gate teleporter
     *
     * @param forestController uses the controller's setter method
     * @param plr              the player
     */
    public static void Collosion_tp(ForestController forestController, Player plr) {
        if (
                ((Math.abs(768 - plr.getPosx()) < dist) || (Math.abs(plr.getPosx() - 768) < dist)) &&
                        ((Math.abs(23 - plr.getPosy()) < dist) || (Math.abs(plr.getPosy() - 23) < dist))
        ) {
            logger.trace("collided with the teleporter!");
            forestController.setTpReady(true);
        }
    }


}
