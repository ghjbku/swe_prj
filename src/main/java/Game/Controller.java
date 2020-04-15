package Game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static Player player;
    private boolean isset=false;
    private static boolean isok=false;
    private String path_start="/demo/swe_prj/target/classes/Game/";

    @FXML
    private static String playername ="playername";
    @FXML
    private Label playername_label=new Label(playername);
    @FXML
    private Label score_label;
    @FXML
    private ImageView imageView;

    @FXML
    private void setname() {
        if(isset==false){
        playername_label.setText(playername);
        isset=true;
        }
        else{}
    }
    public static void setPlayer(Player player2) throws IOException {
        player = player2;
        playername=player.getName();
        isok=true;
    }
    @FXML
    public void setpic(){
       /* File file = new File(path_start+"background.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);*/
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}





