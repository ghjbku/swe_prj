package Game;

import Game.control_objects.CityController;
import Game.control_objects.ForestController;
import Game.control_objects.XmlMethods;
import Game.game_objects.Item;
import Game.game_objects.Player;
import Game.game_window.ForestScene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Class for the main screen with player creation
 */
public class Game extends Application implements EventHandler<ActionEvent> {
    private static Stage primarystage;
    private XmlMethods xml_methods=new XmlMethods();
    ForestController forestController = new ForestController();
    CityController cityController = new CityController();


    private Scene game_scene = ForestScene.getGame_scene();
    private Button btnSubmit = new Button("Submit name"),btn_loaddata = new Button("Continue");
    private Button btnDone = new Button("Start");
    private Button btnExit = new Button("Exit");
    private Player player;
    private Label lbl_gender;
    static ArrayList<Item> item = new ArrayList<Item>();


    private TextField tfName;
    private RadioButton male=new RadioButton("Male?");
    private boolean isset=false;

    /**
     * default constructor for the game class
     * @throws IOException
     */
    public Game() throws IOException {
    }

    /**
     * method that uses the <code>XmlMethods</code> class as its base to save the playerdata into the xml file
     * @throws FileNotFoundException
     * @throws JAXBException
     * @throws MalformedURLException
     */
    public void savetoxml() throws FileNotFoundException, JAXBException, MalformedURLException {
        xml_methods.save(player);
    }

    /**
     *  method that uses the <code>XmlMethods</code> class as its base to load the playerdata from the xml file
     * @throws JAXBException
     */
    public void readxml() throws JAXBException, FileNotFoundException {
        Player loadplayer = xml_methods.load();
        System.out.println(loadplayer.getName());
        if (!item.isEmpty())
        System.out.println(loadplayer.getitem(0).getName());
        tfName.setText(loadplayer.getName());
        isset=true;
        player= loadplayer;

    }

    /**
     * method to start the game and change the stage's scene from the main screen into the first level: ForestScene
     * @throws IOException
     * @throws JAXBException
     * @throws URISyntaxException
     */
    public void start_game() throws IOException, JAXBException, URISyntaxException {
        savetoxml();
        System.out.println("starting the game now...");
        forestController.setPlayer(player);
        primarystage.setResizable(false);
        primarystage.setScene(game_scene);
        primarystage.show();

    }


    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primarystage) {
        player = new Player();
        Game.primarystage =primarystage;

        primarystage.setTitle("SWE_game_project");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10.0);
        btnSubmit.setStyle("-fx-font-size: 15pt;");
        male.setOnAction(this);
        btnSubmit.setOnAction(this);
        btnExit.setOnAction(this);
        btnDone.setOnAction(this);
        btn_loaddata.setOnAction(this);
        Label lblName = new Label("Player name:");
        lbl_gender =new Label("GENDER: "+player.getgender());
        tfName = new TextField();


        hbButtons.getChildren().addAll(btnSubmit, btnDone, btnExit,btn_loaddata,male);
        grid.add(lblName, 0, 0);
        grid.add(tfName, 1, 0);
        grid.add(lbl_gender,2,0);
        grid.add(hbButtons, 0, 1, 2, 1);



        Scene scene = new Scene(grid,640,480);
        primarystage.setScene(scene);
        primarystage.show();


    }

    /**
     * a function that is used to get the class's stage
     * @return primarystage, which is the Start method's parameter
     */
    public static Stage getPrimarystage(){return primarystage;}


    @Override
    public void handle(ActionEvent actionEvent) {

        if(actionEvent.getSource()==btnExit){
            System.out.println("button clicked");
            System.exit(0);
        }
        else if (actionEvent.getSource()==male){
            System.out.println("male clicked!");
            if (player.getgender()=="female"){
                player.setgender("male");
                lbl_gender.setText("GENDER: " +player.getgender());}

            else if (player.getgender()=="male")
            {
                player.setgender("female");
                lbl_gender.setText("GENDER: " +player.getgender());
            }
        }
        else if(actionEvent.getSource()==btnSubmit){
            System.out.println("Name submitted!");
            if (tfName.getText().isEmpty()){
                tfName.setPromptText("The name Can't be left empty!");
            }
            player.setName(tfName.getText());

            System.out.println(player.getName());
            isset=true;
        }
        else if(actionEvent.getSource()==btnDone){
            System.out.println("done button clicked!!!");

            if(isset){
                System.out.println("ISSET IS TRUE!");
                try {
                    savetoxml();
                } catch (FileNotFoundException | JAXBException | MalformedURLException e) {
                    e.printStackTrace();
                }
                isset=false;
                try {
                    start_game();
                } catch (URISyntaxException | JAXBException | IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("isset false!");
            }
        }
        else if(actionEvent.getSource()==btn_loaddata){
            try {
                readxml();
                start_game();
            } catch (URISyntaxException | JAXBException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}