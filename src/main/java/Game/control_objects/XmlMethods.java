package Game.control_objects;

import Game.game_objects.Player;
import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.net.URL;

public class XmlMethods {

    public XmlMethods(){}

    public void save(Player player) throws FileNotFoundException, JAXBException, URISyntaxException {
        URL path = getClass().getResource("/Game/control_objects/player_data.xml");
        File file = new File(path.toURI());
        JAXBHelper.toXML(player, System.out);
        JAXBHelper.toXML(player, new FileOutputStream(file));
    }
    public Player load() throws JAXBException {
       return JAXBHelper.fromXML(Player.class, getClass().getResourceAsStream("/Game/control_objects/player_data.xml"));
    }
}
