package Game.game_events;

import Game.control_objects.Controller;
import javafx.scene.control.Label;

public class Fight {
    Controller ctr;
    //private vars
    private Label textbox;
    private Label option1_label;
    private Label option2_label;
    private Label option3_label;
    private Label option4_label;

    public Fight(Controller controller){ ctr=controller;
       textbox=ctr.gettext_pane_text();
       option1_label=ctr.getOption1();
       option2_label=ctr.getOption2();
       option3_label=ctr.getOption3();
       option4_label=ctr.getOption4();
    }

    public void open_text_pane(){
        ctr.get_text_pane().setDisable(false);
        ctr.get_text_pane().setVisible(true);
        ctr.can_move = false;
        start_fight();
    }

    private void start_fight(){
        ctr.setText_pane_text("Lets fight!");
        ctr.setOption1("option");
        ctr.setOption2("option");
        ctr.setOption3("option");
        ctr.setOption4("option");
    };

    private void option1(){};
    private void option2(){};
    private void option3(){};
    private void option4(){};
}
