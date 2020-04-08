package Game;

import Game.window.Game_scene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jaxb.JAXBHelper;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Game extends Application implements EventHandler<ActionEvent> {
    private Stage primarystage;
    private GridPane game_window = Game_scene.getGame_window();
    private Scene game_scene = Game_scene.getGame_scene();
    private Button btnSubmit = new Button("Submit"),btn_loaddata = new Button("Load data");
    private Button btnDone = new Button("Done");
    private Button btnExit = new Button("Exit");
    private Player player;

    private TextField tfName;
    private boolean isset=false;

    private void savetoxml() throws FileNotFoundException, JAXBException {
        JAXBHelper.toXML(player, System.out);
        JAXBHelper.toXML(player, new FileOutputStream("player_data.xml"));
    }
    private void readxml() throws FileNotFoundException, JAXBException {
        Player loadplayer;
        loadplayer = JAXBHelper.fromXML(Player.class, new FileInputStream("player_data.xml"));
        System.out.println(loadplayer.getName());
        System.out.println(loadplayer.getitem(0).getName());
        tfName.setText(loadplayer.getName());
        isset=true;


    }

    public void start_game()
    {
        Game_scene.set_game();
        System.out.println("starting the game now...");
        primarystage.setScene(game_scene);
        primarystage.show();
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
        btnSubmit.setOnAction(this);
        btnExit.setOnAction(this);
        btnDone.setOnAction(this);
        btn_loaddata.setOnAction(this);
        Label lblName = new Label("Player name:");
        tfName = new TextField();


        hbButtons.getChildren().addAll(btnSubmit, btnDone, btnExit,btn_loaddata);
        grid.add(lblName, 0, 0);
        grid.add(tfName, 1, 0);
        grid.add(hbButtons, 0, 1, 2, 1);



        Scene scene = new Scene(grid,640,480);
        primarystage.setScene(scene);
        primarystage.show();




    }

    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void handle(ActionEvent actionEvent) {

        if(actionEvent.getSource()==btnExit){
            System.out.println("button clicked");
            System.exit(0);
        }
        else if(actionEvent.getSource()==btnSubmit){
            System.out.println("Name submitted!");
            player.setName(tfName.getText());
            ArrayList<Item> item = new ArrayList<Item>();
            item.add(new Item("dagger",1));
            player.setItems(item);
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
               start_game();
            }
            else{
                System.out.println("isset false!");
            }
        }
        else if(actionEvent.getSource()==btn_loaddata){
            try {
                readxml();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
}