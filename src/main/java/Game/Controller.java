package Game;

import Game.game_objects.Images;
import Game.game_objects.Item;
import Game.game_objects.Player;
import Game.game_objects.Tree_object;
import com.sun.source.tree.Tree;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    private static boolean isok=false,collided=false,ready=false;
    private static int lastx=0,lasty=0;

    //declaring the tree objects
    private Tree_object tree,tree1,tree2,tree3,tree4,tree5,tree6,tree7,tree8,tree9,tree10,tree11,tree12,tree13,tree14,tree15,tree16;
    private Tree_object tree17,tree18,tree19,tree20,tree21,tree22,tree23,tree24,tree25,tree26,tree27,tree28,tree29,tree30,tree31,tree32,tree33;
    private Tree_object tree34,tree35,tree36,tree37,tree38,tree39,tree40,tree41,tree42,tree43,tree44,tree45,tree46,tree47,tree48,tree49,tree50,tree51,tree52,tree53;





    //fxml variables
    @FXML
    private static String playername ="playername";
    @FXML
    private Label playername_label=new Label(playername);
    @FXML
    private Label score_label = new Label();
    @FXML
    Pane root = new Pane();
    @FXML
    private static AnchorPane tree_pane= new AnchorPane();
    @FXML
    private AnchorPane inventory;


        //fxml_figs
        @FXML
        private ImageView player_fig;
        @FXML
        private ImageView tree_fig;
        @FXML
        private ImageView dagger_fig;
        @FXML
        private ImageView dagger_fig_inv;
        @FXML
        private ImageView note_fig;
        @FXML
        private ImageView note_fig_inv;
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
        isThere();

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

    @FXML
    private void open_inv(){
        inventory.setVisible(true);

        if (player.getItems().size()==0) {}
        else if (player.getItems().size()>1){
                if ((player.getitem(0).getid() == 0 && player.getitem(1).getid() == 1) ||
                    (player.getitem(0).getid() == 1 && player.getitem(1).getid() == 0)) {
                    dagger_fig_inv.setVisible(true);
                    note_fig_inv.setVisible(true);
                    dagger_fig.setImage(null);
                    note_fig.setImage(null);}
                }

        else if(player.getItems().size()==1){
                if (player.getitem(0).getid() == 1) {
                    note_fig.setImage(null);
                    note_fig_inv.setVisible(true);
                }
                else if (player.getitem(0).getid() == 0) {
                    dagger_fig.setImage(null);
                    dagger_fig_inv.setVisible(true);
                }
        }

        System.out.println("clicked!");
    }

    @FXML
    private void close_inv(){
    inventory.setVisible(false);
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



    private void raiseScore(int score){
        if(collided){
            score=score+10;
            score_label.setText(((String.valueOf(score))));
            player.setscore(score);
        }
        else{ System.out.println(score_label.getText());}
    }

    public void setcollided(){
        collided=true;
        raiseScore(player.getscore());
        isThere();
    }

    private void isThere(){

        if (player.getItems().isEmpty()){return;}
        if(player.getItems().size()==1) {
            if (player.getitem(0).getid() == 0) {
                dagger_fig.setImage(null);
                dagger_fig.setDisable(true);
            } else if (player.getitem(0).getid() == 1 ) {
                note_fig.setImage(null);
                note_fig.setDisable(true);
            }
        }
        else if(
                (player.getitem(0).getid()==0 && player.getitem(1).getid()==1) ||
                (player.getitem(0).getid()==1 && player.getitem(1).getid()==0)
                ){
            note_fig.setImage(null);
            note_fig.setDisable(true);
            dagger_fig.setImage(null);
            dagger_fig.setDisable(true);
        }
    }

    private void collosionDetect(){
        Collosion.Collosion_detection(this,player);
        Collosion.Collosion_detection(this,player, getTree(tree));
        Collosion.Collosion_detection(this,player, getTree(tree1));
        Collosion.Collosion_detection(this,player, getTree(tree2));
        Collosion.Collosion_detection(this,player, getTree(tree3));
        Collosion.Collosion_detection(this,player, getTree(tree4));
        Collosion.Collosion_detection(this,player, getTree(tree5));
        Collosion.Collosion_detection(this,player, getTree(tree6));
        Collosion.Collosion_detection(this,player, getTree(tree7));
        Collosion.Collosion_detection(this,player, getTree(tree8));
        Collosion.Collosion_detection(this,player, getTree(tree9));
        Collosion.Collosion_detection(this,player, getTree(tree10));
        Collosion.Collosion_detection(this,player, getTree(tree11));
        Collosion.Collosion_detection(this,player, getTree(tree12));
        Collosion.Collosion_detection(this,player, getTree(tree13));
        Collosion.Collosion_detection(this,player, getTree(tree14));
        Collosion.Collosion_detection(this,player, getTree(tree15));
        Collosion.Collosion_detection(this,player, getTree(tree16));
        Collosion.Collosion_detection(this,player, getTree(tree17));
        Collosion.Collosion_detection(this,player, getTree(tree18));
        Collosion.Collosion_detection(this,player, getTree(tree19));
        Collosion.Collosion_detection(this,player, getTree(tree20));
        Collosion.Collosion_detection(this,player, getTree(tree21));
        Collosion.Collosion_detection(this,player, getTree(tree22));
        Collosion.Collosion_detection(this,player, getTree(tree23));
        Collosion.Collosion_detection(this,player, getTree(tree24));
        Collosion.Collosion_detection(this,player, getTree(tree25));
        Collosion.Collosion_detection(this,player, getTree(tree26));
        Collosion.Collosion_detection(this,player, getTree(tree27));
        Collosion.Collosion_detection(this,player, getTree(tree28));
        Collosion.Collosion_detection(this,player, getTree(tree29));
        Collosion.Collosion_detection(this,player, getTree(tree30));

    }

    public void inittrees() {
         tree = settrees((int) tree_fig.getLayoutX(), (int) tree_fig.getLayoutY(),tree_fig);
        System.out.println("tree: "+tree.getx()+","+tree.gety());
        tree1 = settrees((int) tree_fig1.getLayoutX(), (int) tree_fig1.getLayoutY(),tree_fig1);
        tree2 = settrees((int) tree_fig2.getLayoutX(), (int) tree_fig2.getLayoutY(),tree_fig2);
         tree3= settrees((int) tree_fig3.getLayoutX(), (int) tree_fig3.getLayoutY(),tree_fig3);
         tree4 = settrees((int) tree_fig4.getLayoutX(), (int) tree_fig4.getLayoutY(),tree_fig4);
         tree5= settrees((int) tree_fig5.getLayoutX(), (int) tree_fig5.getLayoutY(),tree_fig5);
         tree6 = settrees((int) tree_fig6.getLayoutX(), (int) tree_fig6.getLayoutY(),tree_fig6);
         tree7= settrees((int) tree_fig7.getLayoutX(), (int) tree_fig7.getLayoutY(),tree_fig7);
         tree8 = settrees((int) tree_fig8.getLayoutX(), (int) tree_fig8.getLayoutY(),tree_fig8);
         tree9= settrees((int) tree_fig9.getLayoutX(), (int) tree_fig9.getLayoutY(),tree_fig9);
         tree10 = settrees((int) tree_fig10.getLayoutX(), (int) tree_fig10.getLayoutY(),tree_fig10);
         tree11= settrees((int) tree_fig11.getLayoutX(), (int) tree_fig11.getLayoutY(),tree_fig11);
         tree12 = settrees((int) tree_fig12.getLayoutX(), (int) tree_fig12.getLayoutY(),tree_fig12);
         tree13= settrees((int) tree_fig13.getLayoutX(), (int) tree_fig13.getLayoutY(),tree_fig13);
         tree14 = settrees((int) tree_fig14.getLayoutX(), (int) tree_fig14.getLayoutY(),tree_fig14);
         tree15= settrees((int) tree_fig15.getLayoutX(), (int) tree_fig15.getLayoutY(),tree_fig15);
         tree16 = settrees((int) tree_fig16.getLayoutX(), (int) tree_fig16.getLayoutY(),tree_fig16);
         tree17= settrees((int) tree_fig17.getLayoutX(), (int) tree_fig17.getLayoutY(),tree_fig17);
         tree18 = settrees((int) tree_fig18.getLayoutX(), (int) tree_fig18.getLayoutY(),tree_fig18);
         tree19= settrees((int) tree_fig19.getLayoutX(), (int) tree_fig19.getLayoutY(),tree_fig19);
         tree20 = settrees((int) tree_fig20.getLayoutX(), (int) tree_fig20.getLayoutY(),tree_fig20);
         tree21= settrees((int) tree_fig21.getLayoutX(), (int) tree_fig21.getLayoutY(),tree_fig21);
         tree22= settrees((int) tree_fig22.getLayoutX(), (int) tree_fig22.getLayoutY(),tree_fig22);
         tree23= settrees((int) tree_fig23.getLayoutX(), (int) tree_fig23.getLayoutY(),tree_fig23);
         tree24= settrees((int) tree_fig24.getLayoutX(), (int) tree_fig24.getLayoutY(),tree_fig24);
         tree25= settrees((int) tree_fig25.getLayoutX(), (int) tree_fig25.getLayoutY(),tree_fig25);
         tree26= settrees((int) tree_fig26.getLayoutX(), (int) tree_fig26.getLayoutY(),tree_fig26);
         tree27= settrees((int) tree_fig27.getLayoutX(), (int) tree_fig27.getLayoutY(),tree_fig27);
         tree28= settrees((int) tree_fig28.getLayoutX(), (int) tree_fig28.getLayoutY(),tree_fig28);
         tree29= settrees((int) tree_fig29.getLayoutX(), (int) tree_fig29.getLayoutY(),tree_fig29);
        tree30= settrees((int) tree_fig30.getLayoutX(), (int) tree_fig30.getLayoutY(),tree_fig30);


    }
    public Tree_object getTree(Tree_object tree) {
        return tree;
    }


    private void movement(){
        root.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                lastx=player.getPosx();
                lasty=player.getPosy();
                player.setPosx(player.getPosx()-incr);
                player_fig.setLayoutX(player.getPosx());

                //collosion detection
                //for items
               collosionDetect();

            }
            else if(e.getCode() == KeyCode.D){
                lastx=player.getPosx();
                lasty=player.getPosy();
                player.setPosx(player.getPosx()+incr);
                player_fig.setLayoutX(player.getPosx());

                //collosion detection
                //for items
               collosionDetect();
            }
            if(e.getCode() == KeyCode.W){
                lastx=player.getPosx();
                lasty=player.getPosy();
                player.setPosy(player.getPosy()-incr);
                player_fig.setLayoutY(player.getPosy());

                //collosion detection
                //for items
                collosionDetect();
            }
            else if (e.getCode() == KeyCode.S){
                lastx=player.getPosx();
                lasty=player.getPosy();
                player.setPosy(player.getPosy()+incr);
                player_fig.setLayoutY(player.getPosy());

                //collosion detection
                //for items
                collosionDetect();
            }
        });

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initializing trees
       inittrees();
        //player movement
        movement();



















    }



    public static int getLastx(){ return lastx; }
    public static int getLasty(){return lasty;}

}





