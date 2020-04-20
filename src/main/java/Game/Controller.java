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
    private int incr=2;
    private boolean isset=false;
    private static boolean isok=false;
    private static int lastx=0,lasty=0;


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
    private static AnchorPane tree_pane= new AnchorPane();


        //fxml_figs
        @FXML
        private ImageView player_fig;
        @FXML
        private ImageView tree_fig;
        @FXML
        private ImageView tree_fig1;
        @FXML
        private ImageView tree_fig2;
        @FXML
        private ImageView tree_fig3;
        @FXML
        private ImageView tree_fig4;
        @FXML
        private ImageView tree_fig5;
        @FXML
        private ImageView tree_fig6;
        @FXML
        private ImageView tree_fig7;
        @FXML
        private ImageView tree_fig8;
        @FXML
        private ImageView tree_fig9;
        @FXML
        private ImageView tree_fig10;
        @FXML
        private ImageView tree_fig11;
        @FXML
        private ImageView tree_fig12;
        @FXML
        private ImageView tree_fig13;
        @FXML
        private ImageView tree_fig14;
        @FXML
        private ImageView tree_fig15;
        @FXML
        private ImageView tree_fig16;
        @FXML
        private ImageView tree_fig17;
        @FXML
        private ImageView tree_fig18;
        @FXML
        private ImageView tree_fig19;
        @FXML
        private ImageView tree_fig20;
        @FXML
        private ImageView tree_fig21;
        @FXML
        private ImageView tree_fig22;
        @FXML
        private ImageView tree_fig23;
        @FXML
        private ImageView tree_fig24;
        @FXML
        private ImageView tree_fig25;
        @FXML
        private ImageView tree_fig26;
        @FXML
        private ImageView tree_fig27;
        @FXML
        private ImageView tree_fig28;
        @FXML
        private ImageView tree_fig29;
        @FXML
        private ImageView tree_fig30;
        @FXML
        private ImageView tree_fig31;
        @FXML
        private ImageView tree_fig32;
        @FXML
        private ImageView tree_fig33;
        @FXML
        private ImageView tree_fig34;
        @FXML
        private ImageView tree_fig35;
        @FXML
        private ImageView tree_fig36;
        @FXML
        private ImageView tree_fig37;
        @FXML
        private ImageView tree_fig38;
        @FXML
        private ImageView tree_fig39;
        @FXML
        private ImageView tree_fig40;
        @FXML
        private ImageView tree_fig41;
        @FXML
        private ImageView tree_fig42;
        @FXML
        private ImageView tree_fig43;
        @FXML
        private ImageView tree_fig44;
        @FXML
        private ImageView tree_fig45;
        @FXML
        private ImageView tree_fig46;
        @FXML
        private ImageView tree_fig47;
        @FXML
        private ImageView tree_fig48;
        @FXML
        private ImageView tree_fig49;
        @FXML
        private ImageView tree_fig50;
        @FXML
        private ImageView tree_fig51;
        @FXML
        private ImageView tree_fig52;
        @FXML
        private ImageView tree_fig53;
        @FXML
        private ImageView tree_fig54;
        @FXML
        private ImageView tree_fig55;
        @FXML
        private ImageView tree_fig56;
        @FXML
        private ImageView tree_fig57;
        @FXML
        private ImageView tree_fig58;
        @FXML
        private ImageView tree_fig59;
        @FXML
        private ImageView tree_fig60;
        @FXML
        private ImageView tree_fig61;
        @FXML
        private ImageView tree_fig62;
        @FXML
        private ImageView tree_fig63;
        @FXML
        private ImageView tree_fig64;
        @FXML
        private ImageView tree_fig65;
        @FXML
        private ImageView tree_fig66;
        @FXML
        private ImageView tree_fig67;
        @FXML
        private ImageView dagger_fig;
        @FXML
        private ImageView note_fig;

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


    public Tree_object settrees(int x, int y, ImageView tree){
        Tree_object temp_tree = new Tree_object(x,y,tree,tree_pane);
        return getTree(temp_tree);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initializing trees
       Tree_object tree = settrees((int) tree_fig.getLayoutX(), (int) tree_fig.getLayoutY(),tree_fig);
        System.out.println("tree: "+tree.getx()+","+tree.gety());
       Tree_object tree1= settrees((int) tree_fig1.getLayoutX(), (int) tree_fig1.getLayoutY(),tree_fig1);
        Tree_object tree2 = settrees((int) tree_fig2.getLayoutX(), (int) tree_fig2.getLayoutY(),tree_fig2);
        Tree_object tree3= settrees((int) tree_fig3.getLayoutX(), (int) tree_fig3.getLayoutY(),tree_fig3);
        Tree_object tree4 = settrees((int) tree_fig4.getLayoutX(), (int) tree_fig4.getLayoutY(),tree_fig4);
        Tree_object tree5= settrees((int) tree_fig5.getLayoutX(), (int) tree_fig5.getLayoutY(),tree_fig5);
        Tree_object tree6 = settrees((int) tree_fig6.getLayoutX(), (int) tree_fig6.getLayoutY(),tree_fig6);
        Tree_object tree7= settrees((int) tree_fig7.getLayoutX(), (int) tree_fig7.getLayoutY(),tree_fig7);
        Tree_object tree8 = settrees((int) tree_fig8.getLayoutX(), (int) tree_fig8.getLayoutY(),tree_fig8);
        Tree_object tree9= settrees((int) tree_fig9.getLayoutX(), (int) tree_fig9.getLayoutY(),tree_fig9);
        Tree_object tree10 = settrees((int) tree_fig10.getLayoutX(), (int) tree_fig10.getLayoutY(),tree_fig10);
        Tree_object tree11= settrees((int) tree_fig11.getLayoutX(), (int) tree_fig11.getLayoutY(),tree_fig11);
        Tree_object tree12 = settrees((int) tree_fig12.getLayoutX(), (int) tree_fig12.getLayoutY(),tree_fig12);
        Tree_object tree13= settrees((int) tree_fig13.getLayoutX(), (int) tree_fig13.getLayoutY(),tree_fig13);
        Tree_object tree14 = settrees((int) tree_fig14.getLayoutX(), (int) tree_fig14.getLayoutY(),tree_fig14);
        Tree_object tree15= settrees((int) tree_fig15.getLayoutX(), (int) tree_fig15.getLayoutY(),tree_fig15);
        Tree_object tree16 = settrees((int) tree_fig16.getLayoutX(), (int) tree_fig16.getLayoutY(),tree_fig16);
        Tree_object tree17= settrees((int) tree_fig17.getLayoutX(), (int) tree_fig17.getLayoutY(),tree_fig17);
        Tree_object tree18 = settrees((int) tree_fig18.getLayoutX(), (int) tree_fig18.getLayoutY(),tree_fig18);
        Tree_object tree19= settrees((int) tree_fig19.getLayoutX(), (int) tree_fig19.getLayoutY(),tree_fig19);
        Tree_object tree20 = settrees((int) tree_fig20.getLayoutX(), (int) tree_fig20.getLayoutY(),tree_fig20);
        Tree_object tree21= settrees((int) tree_fig21.getLayoutX(), (int) tree_fig21.getLayoutY(),tree_fig21);






















        //player movement
        root.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                lastx=player.getPosx();
                lasty=player.getPosy();
                player.setPosx(player.getPosx()-incr);
                player_fig.setLayoutX(player.getPosx());





                //collosion detection
                Collosion.Collosion_detection(player, getTree(tree));
                Collosion.Collosion_detection(player, getTree(tree1));
                Collosion.Collosion_detection(player, getTree(tree2));
                Collosion.Collosion_detection(player, getTree(tree3));
                Collosion.Collosion_detection(player, getTree(tree4));
                Collosion.Collosion_detection(player, getTree(tree5));
                Collosion.Collosion_detection(player, getTree(tree6));
                Collosion.Collosion_detection(player, getTree(tree7));
                Collosion.Collosion_detection(player, getTree(tree8));
                Collosion.Collosion_detection(player, getTree(tree9));
                Collosion.Collosion_detection(player, getTree(tree10));
                Collosion.Collosion_detection(player, getTree(tree11));
                Collosion.Collosion_detection(player, getTree(tree12));
                Collosion.Collosion_detection(player, getTree(tree13));
                Collosion.Collosion_detection(player, getTree(tree14));
                Collosion.Collosion_detection(player, getTree(tree15));
                Collosion.Collosion_detection(player, getTree(tree16));
                Collosion.Collosion_detection(player, getTree(tree17));
                Collosion.Collosion_detection(player, getTree(tree18));
                Collosion.Collosion_detection(player, getTree(tree19));
                Collosion.Collosion_detection(player, getTree(tree20));
                Collosion.Collosion_detection(player, getTree(tree21));


            }
            else if(e.getCode() == KeyCode.D){
                lastx=player.getPosx();
                lasty=player.getPosy();
                player.setPosx(player.getPosx()+incr);
                player_fig.setLayoutX(player.getPosx());

                //collosion detection
                Collosion.Collosion_detection(player, getTree(tree));
                Collosion.Collosion_detection(player, getTree(tree1));
                Collosion.Collosion_detection(player, getTree(tree2));
                Collosion.Collosion_detection(player, getTree(tree3));
                Collosion.Collosion_detection(player, getTree(tree4));
                Collosion.Collosion_detection(player, getTree(tree5));
                Collosion.Collosion_detection(player, getTree(tree6));
                Collosion.Collosion_detection(player, getTree(tree7));
                Collosion.Collosion_detection(player, getTree(tree8));
                Collosion.Collosion_detection(player, getTree(tree9));
                Collosion.Collosion_detection(player, getTree(tree10));
                Collosion.Collosion_detection(player, getTree(tree11));
                Collosion.Collosion_detection(player, getTree(tree12));
                Collosion.Collosion_detection(player, getTree(tree13));
                Collosion.Collosion_detection(player, getTree(tree14));
                Collosion.Collosion_detection(player, getTree(tree15));
                Collosion.Collosion_detection(player, getTree(tree16));
                Collosion.Collosion_detection(player, getTree(tree17));
                Collosion.Collosion_detection(player, getTree(tree18));
                Collosion.Collosion_detection(player, getTree(tree19));
                Collosion.Collosion_detection(player, getTree(tree20));
                Collosion.Collosion_detection(player, getTree(tree21));
            }
            else if(e.getCode() == KeyCode.W){
                lastx=player.getPosx();
                lasty=player.getPosy();
                player.setPosy(player.getPosy()-incr);
                player_fig.setLayoutY(player.getPosy());

                //collosion detection
                Collosion.Collosion_detection(player, getTree(tree));
                Collosion.Collosion_detection(player, getTree(tree1));
                Collosion.Collosion_detection(player, getTree(tree2));
                Collosion.Collosion_detection(player, getTree(tree3));
                Collosion.Collosion_detection(player, getTree(tree4));
                Collosion.Collosion_detection(player, getTree(tree5));
                Collosion.Collosion_detection(player, getTree(tree6));
                Collosion.Collosion_detection(player, getTree(tree7));
                Collosion.Collosion_detection(player, getTree(tree8));
                Collosion.Collosion_detection(player, getTree(tree9));
                Collosion.Collosion_detection(player, getTree(tree10));
                Collosion.Collosion_detection(player, getTree(tree11));
                Collosion.Collosion_detection(player, getTree(tree12));
                Collosion.Collosion_detection(player, getTree(tree13));
                Collosion.Collosion_detection(player, getTree(tree14));
                Collosion.Collosion_detection(player, getTree(tree15));
                Collosion.Collosion_detection(player, getTree(tree16));
                Collosion.Collosion_detection(player, getTree(tree17));
                Collosion.Collosion_detection(player, getTree(tree18));
                Collosion.Collosion_detection(player, getTree(tree19));
                Collosion.Collosion_detection(player, getTree(tree20));
                Collosion.Collosion_detection(player, getTree(tree21));
            }
            else if (e.getCode() == KeyCode.S){
                lastx=player.getPosx();
                lasty=player.getPosy();
                player.setPosy(player.getPosy()+incr);
                player_fig.setLayoutY(player.getPosy());

                //collosion detection
                Collosion.Collosion_detection(player, getTree(tree));
                Collosion.Collosion_detection(player, getTree(tree1));
                Collosion.Collosion_detection(player, getTree(tree2));
                Collosion.Collosion_detection(player, getTree(tree3));
                Collosion.Collosion_detection(player, getTree(tree4));
                Collosion.Collosion_detection(player, getTree(tree5));
                Collosion.Collosion_detection(player, getTree(tree6));
                Collosion.Collosion_detection(player, getTree(tree7));
                Collosion.Collosion_detection(player, getTree(tree8));
                Collosion.Collosion_detection(player, getTree(tree9));
                Collosion.Collosion_detection(player, getTree(tree10));
                Collosion.Collosion_detection(player, getTree(tree11));
                Collosion.Collosion_detection(player, getTree(tree12));
                Collosion.Collosion_detection(player, getTree(tree13));
                Collosion.Collosion_detection(player, getTree(tree14));
                Collosion.Collosion_detection(player, getTree(tree15));
                Collosion.Collosion_detection(player, getTree(tree16));
                Collosion.Collosion_detection(player, getTree(tree17));
                Collosion.Collosion_detection(player, getTree(tree18));
                Collosion.Collosion_detection(player, getTree(tree19));
                Collosion.Collosion_detection(player, getTree(tree20));
                Collosion.Collosion_detection(player, getTree(tree21));
            }
        });
    }

    private Tree_object getTree(Tree_object tree) {
        return tree;
    }

    public static int getLastx(){
        return lastx;
    }
    public static int getLasty(){return lasty;}


}





