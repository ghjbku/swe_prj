package Game.game_window;

import Game.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * the class that contains the city "level" of the game
 */
public class CityScene {
    private static Scene game_scene;

    static {
        try {
            game_scene = new Scene(loadFXML("city_window"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public CityScene() {
    }

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
