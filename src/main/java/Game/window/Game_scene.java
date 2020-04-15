package Game.window;

import Game.Game;
import Game.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class Game_scene {
    private static Scene game_scene;

    static {
        try {
            game_scene = new Scene(loadFXML("game_window"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Label somelabel = new Label();

    public Game_scene() throws IOException {
    }

    public static Scene getGame_scene(){
        return game_scene;
    }



    static void setRoot(String fxml) throws IOException {
        game_scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}


