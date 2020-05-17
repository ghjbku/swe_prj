package Game.control_objects;

import Game.Game;
import Game.game_objects.Player;
import Game.game_window.CityScene;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller class for the city_window fxml
 */
public class CityController implements Initializable {
    private static Logger logger = LoggerFactory.getLogger(CityController.class);

    private Player player;
    private String playername;
    private XmlMethods xmlMethods = new XmlMethods();

    public CityController() throws MalformedURLException {
    }

    public void setPlayer(Player player2) {
        player = player2;
        playername = player.getName();
    }

    /**
     * a method that loads the CityScene after the player uses the city gates in the ForestScene
     *
     * @param primarystage the Game class's stage
     * @throws FileNotFoundException
     * @throws JAXBException
     * @throws URISyntaxException
     */
    public void load_city(Stage primarystage) throws FileNotFoundException, JAXBException, URISyntaxException {
        logger.info("Loading the city scene!");
        primarystage.setScene(CityScene.getGame_scene());
        primarystage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
