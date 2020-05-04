package Game.game_events;

import Game.control_objects.Controller;
import javafx.scene.control.Label;

public class Fight {
    Controller ctr;
    private int round_counter=0;

    public Fight(Controller controller){ ctr=controller;
        //private vars
        Label textbox = ctr.gettext_pane_text();
        Label option1_label = ctr.getOption1();
        Label option2_label = ctr.getOption2();
        Label option3_label = ctr.getOption3();
        Label option4_label = ctr.getOption4();
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

    public void option1(){
        ctr.setText_pane_text(ctr.getOption1().getText()+" clicked");
        fight(round_counter,1);
    };
    public void option2(){
        ctr.setText_pane_text(ctr.getOption2().getText()+" clicked");
        fight(round_counter,2);
    };
    public void option3(){
        ctr.setText_pane_text(ctr.getOption3().getText()+" clicked");
        fight(round_counter,3);
    };
    public void option4(){
        ctr.setText_pane_text(ctr.getOption4().getText()+" clicked");
        fight(round_counter,4);
    };

    private void fight(int round_counter,int option) {
        switch (round_counter) {
            case 0:
                if (option==1){}
                else if (option==2){}
                else if(option==3){}
                else if(option==4){}
                break;
            case 1:
                if (option==1){}
                else if (option==2){}
                else if(option==3){}
                else if(option==4){}
                break;
            case 2:
                if (option==1){}
                else if (option==2){}
                else if(option==3){}
                else if(option==4){}
                break;
            case 3:
                if (option==1){}
                else if (option==2){}
                else if(option==3){}
                else if(option==4){}
                break;
            case 4:
                if (option==1){}
                else if (option==2){}
                else if(option==3){}
                else if(option==4){}
                break;
            case 5:
                if (option==1){}
                else if (option==2){}
                else if(option==3){}
                else if(option==4){}
                break;
            case 6:
                if (option==1){}
                else if (option==2){}
                else if(option==3){}
                else if(option==4){}
                break;
            case 7:
                if (option==1){}
                else if (option==2){}
                else if(option==3){}
                else if(option==4){}
                break;
            case 8:
                if (option==1){}
                else if (option==2){}
                else if(option==3){}
                else if(option==4){}
                break;

        }
    }
}
