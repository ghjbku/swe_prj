package Game;

import Game.game_objects.Images;
import Game.game_objects.Player;
import Game.game_objects.Tree_object;
import com.sun.source.tree.Tree;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    //variables
    private static Player player;
    private int incr=3;
    private boolean isset=false;
    private static boolean isok=false;


    //fxml variables
    @FXML
    private static String playername ="playername";
    @FXML
    private Label playername_label=new Label(playername);
    @FXML
    private Label score_label;
    @FXML
    Pane root = new Pane();
    @FXML
    private static AnchorPane image_pane = new AnchorPane();
    @FXML
    private ImageView player_fig;
    @FXML
    private ImageView tree_fig;

    //fxml methods

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

    @FXML
    public void setpic(){
        player_fig.setImage(Images.playerm_image);

    }

    public static void setPlayer(Player player2) throws IOException {
        player = player2;
        playername=player.getName();
        isok=true;
    }


    public Tree_object settrees(int x, int y, Image tree){
        Tree_object temp_tree = new Tree_object(x,y,tree,image_pane);
        return temp_tree;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       Tree_object tree = settrees(44,71,Images.tree1_image);
        Tree_object tree2= settrees(32,71,Images.tree1_image);



        //player movement
        root.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                player.setPosx(player.getPosx()-incr);
                player_fig.setLayoutX(player.getPosx());
                Collosion.Collosion_detection(player,tree);
                Collosion.Collosion_detection(player,tree2);

            }
            else if(e.getCode() == KeyCode.D){
                player.setPosx(player.getPosx()+incr);
                player_fig.setLayoutX(player.getPosx());
                Collosion.Collosion_detection(player,tree);
                Collosion.Collosion_detection(player,tree2);
            }
            else if(e.getCode() == KeyCode.W){
                player.setPosy(player.getPosy()-incr);
                player_fig.setLayoutY(player.getPosy());
                Collosion.Collosion_detection(player,tree);
                Collosion.Collosion_detection(player,tree2);
            }
            else if (e.getCode() == KeyCode.S){
                player.setPosy(player.getPosy()+incr);
                player_fig.setLayoutY(player.getPosy());
                Collosion.Collosion_detection(player,tree);
                Collosion.Collosion_detection(player,tree2);
            }
        });
    }


}





