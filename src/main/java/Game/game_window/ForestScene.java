package Game.game_window;

import Game.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * the class that contains the forest "level" of the game
 */
public class ForestScene {
    private static Scene game_scene;

    static {
        try {
            game_scene = new Scene(loadFXML("forest_window"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * default constructor for the class
     */
    public ForestScene() {
    }

    /**
     * getter function for the class's game_scene for the Game class to use
     * @return the game_scene Scene
     */
    public static Scene getGame_scene(){
        return game_scene;
    }



    static void setRoot(String fxml) throws IOException {
        game_scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("/Game/fxmls/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }
}


