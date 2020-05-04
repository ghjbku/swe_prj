package Game.game_events;

import Game.control_objects.Controller;
import javafx.scene.control.Label;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static java.lang.Thread.sleep;

public class Fight {
    Controller ctr;
    private int round_counter=0;

    public Fight(Controller controller){ ctr=controller; }

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

    public void option1() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException {
        ctr.setText_pane_text(ctr.getOption1().getText()+" clicked");
        fight(round_counter,1);
        fight_done(round_counter);
        round_counter++;

    };
    public void option2() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException {
        ctr.setText_pane_text(ctr.getOption2().getText()+" clicked");
        fight(round_counter,2);
        fight_done(round_counter);
        round_counter++;
    };
    public void option3() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException {
        ctr.setText_pane_text(ctr.getOption3().getText()+" clicked");
        fight(round_counter,3);
        fight_done(round_counter);
        round_counter++;
    };
    public void option4() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException {
        ctr.setText_pane_text(ctr.getOption4().getText()+" clicked");
        fight(round_counter,4);
        fight_done(round_counter);
        round_counter++;
    };
//42113421
    private void fight(int round_counter,int option) throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException {
        switch (round_counter) {
            case 0:
                ctr.setText_pane_text("");
                if (option==1){fight_lost();}
                else if (option==2){fight_lost();}
                else if(option==3){fight_lost();}
                else if(option==4){ctr.raiseScore();}
                break;
            case 1:
                ctr.setText_pane_text("");
                if (option==1){fight_lost();}
                else if (option==2){ctr.raiseScore();}
                else if(option==3){fight_lost();}
                else if(option==4){fight_lost();}
                break;
            case 2:
                ctr.setText_pane_text("");
                if (option==1){ctr.raiseScore();}
                else if (option==2){fight_lost();}
                else if(option==3){fight_lost();}
                else if(option==4){fight_lost();}
                break;
            case 3:
                ctr.setText_pane_text("");
                if (option==1){ctr.raiseScore();}
                else if (option==2){fight_lost();}
                else if(option==3){fight_lost();}
                else if(option==4){fight_lost();}
                break;
            case 4:
                ctr.setText_pane_text("");
                if (option==1){fight_lost();}
                else if (option==2){fight_lost();}
                else if(option==3){ctr.raiseScore();}
                else if(option==4){fight_lost();}
                break;
            case 5:
                ctr.setText_pane_text("");
                if (option==1){fight_lost();}
                else if (option==2){fight_lost();}
                else if(option==3){fight_lost();}
                else if(option==4){ctr.raiseScore();}
                break;
            case 6:
                ctr.setText_pane_text("");
                if (option==1){fight_lost();}
                else if (option==2){ctr.raiseScore();}
                else if(option==3){fight_lost();}
                else if(option==4){fight_lost();}
                break;
            case 7:
                ctr.setText_pane_text("");
                if (option==1){ctr.raiseScore();}
                else if (option==2){fight_lost();}
                else if(option==3){fight_lost();}
                else if(option==4){fight_lost();}
                break;
        }
    }

    private void end_stuff(String str) throws InterruptedException {
        ctr.setText_pane_text(str);
        ctr.get_text_pane().setDisable(false);
        ctr.getOption1().setVisible(false);
        ctr.getOption2().setVisible(false);
        ctr.getOption3().setVisible(false);
        ctr.getOption4().setVisible(false);
        ctr.can_move = true;

    }

     private void fight_done(int counter) throws InterruptedException {
        if (counter==8)
        {
         end_stuff("You won! Go take a look at the city gate just a few yars away of the bear corpse!");
            round_counter=10;
        }
     }

     private void fight_lost() throws InterruptedException {
        if (round_counter>1)
        {
         end_stuff("You fought hard, but sadly you lost this fight... but you can do it again! Good Luck!");
            round_counter=10;
        }
        else
        {
         end_stuff("It wasn't a tough fight i suppose... well... sadly you lost this fight... but you can do it again! Good Luck!");
            round_counter=10;
        }
     }

     public int getcounter(){return round_counter;}

}
