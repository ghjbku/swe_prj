package Game.control_objects;

import Game.game_objects.Player;
import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Class for the xml saving and loading methods
 */
public class XmlMethods {

    /**
     * default constructor for the class
     */
    public XmlMethods(){}
    /**
     * method to save the player's data into an xml file
     *
     * @param player the player object to save into the xml
     * @throws JAXBException if there is an error with the xml file
     * @throws FileNotFoundException if the file does not exist
     */
    public void save(Player player) throws FileNotFoundException, JAXBException, URISyntaxException {
        File file = new File(String.valueOf(getClass().getResourceAsStream("/Game/control_objects/player_data.xml")));
        JAXBHelper.toXML(player, System.out);
        JAXBHelper.toXML(player, new FileOutputStream(file));
    }

    /**
     *  function that loads the player data from an external xml file
     *
     * @return the xml file's data as an object
     * @throws JAXBException if there is an error with the xml file
     */
    public Player load() throws JAXBException {
       return JAXBHelper.fromXML(Player.class, getClass().getResourceAsStream("/Game/control_objects/player_data.xml"));
    }
}
