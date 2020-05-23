package Game.game_window;

import Game.Game;
import Game.control_objects.ForestController;
import Game.game_objects.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * the class that contains the forest "level" of the game
 */
public class ForestScene {
    private static Logger logger = LoggerFactory.getLogger(ForestScene.class);
    private static Scene game_scene;
    private Game game = new Game();

    static {
        try {
            game_scene = new Scene(loadFXML("forest_window"));
        } catch (IOException e) {
            logger.error("error occured: ", e);
        }
    }

    /**
     * default constructor for the class
     */
    public ForestScene() throws IOException {
    }

    /**
     * getter function for the class's game_scene for the Game class to use
     *
     * @return the game_scene Scene
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


