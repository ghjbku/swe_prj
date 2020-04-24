package Game;

import Game.game_objects.Item;
import Game.game_objects.Player;
import Game.game_window.Game_scene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;


public class Game extends Application implements EventHandler<ActionEvent> {
    private Stage primarystage;
    Controller controller = new Controller();


    private Scene game_scene = Game_scene.getGame_scene();
    private Button btnSubmit = new Button("Submit name"),btn_loaddata = new Button("Continue");
    private Button btnDone = new Button("Start");
    private Button btnExit = new Button("Exit");
    private Player player;
    private Label lbl_gender;
    static ArrayList<Item> item = new ArrayList<Item>();


    private TextField tfName;
    private RadioButton male=new RadioButton("Male?");
    private boolean isset=false;

    public Game() throws IOException {
    }

    public void savetoxml() throws FileNotFoundException, JAXBException {
        JAXBHelper.toXML(player, System.out);
        JAXBHelper.toXML(player, new FileOutputStream("player_data.xml"));
    }
    public void readxml() throws FileNotFoundException, JAXBException {
        Player loadplayer = JAXBHelper.fromXML(Player.class, new FileInputStream("player_data.xml"));
        System.out.println(loadplayer.getName());
        if (!item.isEmpty())
        System.out.println(loadplayer.getitem(0).getName());
        tfName.setText(loadplayer.getName());
        isset=true;
        player= loadplayer;

    }

    public void start_game() throws IOException, JAXBException {
        savetoxml();

        System.out.println("starting the game now...");
        Controller.setPlayer(player);
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
        this.primarystage=primarystage;

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
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                isset=false;
                try {
                    start_game();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (JAXBException e) {
                    e.printStackTrace();
                } catch (IOException e) {
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
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}