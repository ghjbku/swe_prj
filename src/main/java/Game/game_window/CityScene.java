package Game.game_window;

import Game.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * the class that contains the city "level" of the game
 */
public class CityScene {
    private static Logger logger = LoggerFactory.getLogger(CityScene.class);
    private static Scene game_scene;

    static {
        try {
            game_scene = new Scene(loadFXML("city_window"));
        } catch (IOException e) {
            logger.error("error occured: ", e);
        }
    }

    /**
     * default constructor.
     */
    public CityScene() {
    }

    /**
     * getter that returns the game_scene.
     *
     * @return game_scene.
     */
    public static Scene getGame_scene() {
        return game_scene;
    }

    /**
     * a function that loads the fxml file it gets as param.
     *
     * @param fxml the fxml file.
     * @return the loaded fxml data.
     * @throws IOException throws when the fxml file cant be loaded.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/Game/fxmls/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
