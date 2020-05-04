package Game.game_events;

import Game.control_objects.Controller;
import javafx.scene.control.Label;

public class Fight {
    Controller ctr;
    //private vars
    private Label textbox=ctr.getText_pane_text();
    private Label option1_label=ctr.getOption1();
    private Label option2_label=ctr.getOption2();
    private Label option3_label=ctr.getOption3();
    private Label option4_label=ctr.getOption4();

    public Fight(Controller controller){ ctr=controller;}

    public void open_text_pane(){
        ctr.get_text_pane().setDisable(false);
        ctr.get_text_pane().setVisible(true);
        ctr.can_move = false;
        start_fight();
    }

    private void start_fight(){};

    private void option1(){};
    private void option2(){};
    private void option3(){};
    private void option4(){};
}
