package Game.control_objects;

import Game.game_objects.Player;
import Game.game_window.CityScene;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class CityController implements Initializable {
    private Player player;
    private String playername;
    private XmlMethods xmlMethods = new XmlMethods();

    public void setPlayer(Player player2) {
         player = player2;
         playername = player.getName();
    }

    public void load_city(Stage primarystage) throws FileNotFoundException, JAXBException, URISyntaxException {
        System.out.println("Loading the city scene!");
        primarystage.setScene(CityScene.getGame_scene());
        primarystage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
