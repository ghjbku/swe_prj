package Game.window;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Game_scene {
    private static GridPane game_window = new GridPane();
    private static Scene game_scene = new Scene(game_window,800,600);;
    private static Label somelabel = new Label();

    public static void set_game()
    {
        somelabel.setText("this is a random thing until the game itself can be seen");
        game_window.add(somelabel,10,1);
    }

    public static GridPane getGame_window(){
        return game_window;
    }
    public static Scene getGame_scene(){
        return game_scene;
    }
}
