package Game;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private static Player player;
    private int incr=3;
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
    Pane root = new Pane();
    @FXML
    private ImageView player_fig;
    @FXML
    private Button save_button;



    @FXML
    private void save() throws FileNotFoundException, JAXBException {
            JAXBHelper.toXML(player, System.out);
            JAXBHelper.toXML(player, new FileOutputStream("player_data.xml"));

    }

    @FXML
    public void load() throws FileNotFoundException, JAXBException {
        Player loadplayer = JAXBHelper.fromXML(Player.class, new FileInputStream("player_data.xml"));
        System.out.println(loadplayer.getName());
        setname();
        isset=true;
        if (loadplayer.getgender().equals("male")){setpic();}
        else{ }
        player=loadplayer;
        player_fig.setLayoutX(player.getPosx());
        player_fig.setLayoutY(player.getPosy());

    }

    @FXML
    private void setname() {
        if(isset==false){
        playername_label.setText(playername+", "+player.getgender());
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
        File file = new File(path_start+"Tree1.png");
        Image image = new Image(file.toURI().toString());
        player_fig.setImage(image);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(player_fig.getLayoutX()+" ," + player_fig.getLayoutY());
        root.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                player.setPosx(player.getPosx()-incr);
                player_fig.setLayoutX(player.getPosx());

            }
            else if(e.getCode() == KeyCode.D){
                player.setPosx(player.getPosx()+incr);
                player_fig.setLayoutX(player.getPosx());}
            else if(e.getCode() == KeyCode.W){
                player.setPosy(player.getPosy()-incr);
                player_fig.setLayoutY(player.getPosy());
            }
            else if (e.getCode() == KeyCode.S){
                player.setPosy(player.getPosy()+incr);
                player_fig.setLayoutY(player.getPosy());}
        });
    }


}





