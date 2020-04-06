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


public class Game extends Application implements EventHandler<ActionEvent> {
    Button btnSubmit = new Button("Submit");
    Button btnClear = new Button("Clear");
    Button btnExit = new Button("Exit");

    @Override
    public void start(Stage primarystage) {
        primarystage.setTitle("SWE_game_project");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10.0);
        btnSubmit.setStyle("-fx-font-size: 15pt;");
        btnExit.setOnAction(this);
        Label lblName = new Label("User name:");
        TextField tfName = new TextField();


        hbButtons.getChildren().addAll(btnSubmit, btnClear, btnExit);
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
    }
}