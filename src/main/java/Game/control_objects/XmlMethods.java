package Game.control_objects;

import Game.Game;
import Game.game_objects.Player;
import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;
import java.io.*;


/**
 * Class for the xml saving and loading methods
 */
public class XmlMethods {
    File file = new File(Game.class.getProtectionDomain().getCodeSource().getLocation().getPath());

    /**
     * default constructor for the class
     */
    public XmlMethods() {
    }

    /**
     * method to save the player's data into an xml file, outside of the jar
     *
     * @param plr the player object to save into the xml
     * @throws JAXBException         if there is an error with the xml file
     * @throws FileNotFoundException if the file does not exist
     */
    public void save(Player plr) throws FileNotFoundException, JAXBException {
        JAXBHelper.toXML(plr, System.out);
        JAXBHelper.toXML(plr, new FileOutputStream(file.getParent() + "/player_data.xml"));
    }

    /**
     * function that loads the player data from an external xml file, outside of the jar
     *
     * @return the xml file's data as an object
     * @throws JAXBException if there is an error with the xml file
     */
    public Player load() throws JAXBException, FileNotFoundException {
        return JAXBHelper.fromXML(Player.class, new FileInputStream(file.getParent() + "/player_data.xml"));
    }

}
