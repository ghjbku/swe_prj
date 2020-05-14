package Game.game_events;

import Game.control_objects.ForestController;
import Game.control_objects.XmlMethods;
import Game.game_objects.Player;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static java.lang.Thread.sleep;

public class Fight {
    ForestController ctr;
    private int round_counter=0;
    private boolean run =false;


    public Fight(){}
    public Fight(ForestController forestController){ ctr= forestController; }

    public int open_text_pane(Player player) {

        if (round_counter==0 && !(player.getFought()) )
        {
            ctr.get_text_pane().setDisable(false);
            ctr.get_text_pane().setVisible(true);
            ctr.can_move = false;

            if (player.getItems().isEmpty() || !(player.getItems().get(0).getid()==0)){ no_weapon(); return -1; }
            else { start_fight(); return 0;}
        }
        else if(round_counter==10 || player.getFought()==true){
            return 1;
        }
    return 0;
    }

    private void start_fight(){
        ctr.setText_pane_text("You see a Bear in front of you sleeping in the grass.\nAs you lurk closer it suddenly snaps its" +
                " eyes open and looks at you.\nYou remember that you found a weapon along the way here... maybe it was " +
                "for this moment.\nThe bear suddenly lets out a horrendous roar and starts running towards you,full of killing intent!");
        ctr.setOption1("run away");
        ctr.setOption2("try to play dead");
        ctr.setOption3("try to talk it out with him");
        ctr.setOption4("dodge the rush to the right");
    };

    public void option1() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException, MalformedURLException {
        ctr.setText_pane_text("sadly the bear is faster!");
        fight(round_counter,1);
        fight_done(round_counter);
        round_counter++;

        if (run){
            ctr.can_move = true;
            end_stuff("you tried to run away, but... running away from a bear is pretty much impossible... you died");
            round_counter=55;
        }

    };
    public void option2() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException, MalformedURLException {
        ctr.setText_pane_text("sadly the bear is faster!");
        fight(round_counter,2);
        fight_done(round_counter);
        round_counter++;
    };
    public void option3() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException, MalformedURLException {
        ctr.setText_pane_text("sadly the bear is faster!");
        fight(round_counter,3);
        fight_done(round_counter);
        round_counter++;
    };
    public void option4() throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException, MalformedURLException {
        ctr.setText_pane_text("sadly the bear is faster!");
        fight(round_counter,4);
        fight_done(round_counter);
        round_counter++;
    };
//42113421
    private void fight(int round_counter,int option) throws FileNotFoundException, JAXBException, InterruptedException, URISyntaxException, MalformedURLException {
        switch (round_counter) {
            case 0:
                ctr.setText_pane_text("You dodged to the side, and just barely survive the rush...\nOn the other hand, the bear" +
                        " seems to be surprised about this.\nit might be your chance to deal some damage to it!");
                ctr.setOption1("maybe it is playing, lets wait");
                ctr.setOption2("time to stab it in the eye");
                ctr.setOption3("try to talk it out with him");
                ctr.setOption4("laugh and run away");
                if (option==1){fight_lost();}
                else if (option==2){fight_lost();}
                else if(option==3){fight_lost();}
                else if(option==4){ctr.raiseScore();}
                break;
            case 1:
                ctr.setText_pane_text("You decided to grab your chances and thrust your blade into its eyes.\nThe bear probably didn't like " +
                        "it,\nas you succeed in wounding it, he roars and once again rushes towards you!");
                ctr.setOption1("lets dodge to the left now!");
                ctr.setOption2("what about now...? lets play dead?");
                ctr.setOption3("try to talk it out with him");
                ctr.setOption4("hmm, dodge to the right again!");
                if (option==1){fight_lost();}
                else if (option==2){ctr.raiseScore();}
                else if(option==3){fight_lost();}
                else if(option==4){fight_lost();}
                break;
            case 2:
                ctr.setText_pane_text("You dodge to the left, the bear half expecting your move, lunges to the right\nsadly for him" +
                        " you have chosen the other side... time for another punishment?");
                ctr.setOption1("lets play it safe for now...");
                ctr.setOption2("Alright!!! lets cut it down!");
                ctr.setOption3("maybe i can run away now?");
                ctr.setOption4("attack its rear!");
                if (option==1){ctr.raiseScore();}
                else if (option==2){fight_lost();}
                else if(option==3){fight_lost();}
                else if(option==4){fight_lost();}
                break;
            case 3:
                ctr.setText_pane_text("You decide to wait, and you have chosen the right option...\n" +
                        "The bear who seemed like an easy prey a moment ago\nsuddenly turns back towards you and slashes with its pawns.");
                ctr.setOption1("try to dodge to the left!");
                ctr.setOption2("cut down its pawns!");
                ctr.setOption3("stand still...");
                ctr.setOption4("dodge backwards!");
                if (option==1){ctr.raiseScore();}
                else if (option==2){fight_lost();}
                else if(option==3){fight_lost();}
                else if(option==4){fight_lost();}
                break;
            case 4:
                ctr.setText_pane_text("You play the bear into a fool..\nThe bear, expecting you to dodge, turns its body to the left, slashing the air\n" +
                        "maybe now you can get some damage?");
                ctr.setOption1("stab your dagger into its head");
                ctr.setOption2("try to slash its fore legs!");
                ctr.setOption3("grab the chance to run away!");
                ctr.setOption4("stab its hind legs.");
                if (option==1){fight_lost();}
                else if (option==2){fight_lost();}
                else if(option==3){ctr.raiseScore();}
                else if(option==4){fight_lost();}
                break;
            case 5:
                ctr.setText_pane_text("You stab the beast on its hind legs!\nIt seemingly is a little exhausted now" +
                        " and the wound on its left hindleg is bleeding constantly.\nWhat will you do now?");
                ctr.setOption1("Time to give him more wounds!");
                ctr.setOption2("Wait for another chance at punishment!");
                ctr.setOption3("guess an exhausted bear might not catch me? lets run!");
                ctr.setOption4("This time i'll be the one rushing in!");
                if (option==1){fight_lost();}
                else if (option==2){fight_lost();}
                else if(option==3){fight_lost();}
                else if(option==4){ctr.raiseScore();}
                break;
            case 6:
                ctr.setText_pane_text("You once again stay patient, just standing still waiting for the bear to make its move.\n" +
                        "It isn't a patient type on the other hand,but only slowly comes towards you...\nThe difficulty just risen!");
                ctr.setOption1("Lets wait for any attack!");
                ctr.setOption2("He is clearly exhausted, lets go! KILL!!!");
                ctr.setOption3("lets slash its other leg as well!");
                ctr.setOption4("maybe i can run away now?");
                if (option==1){fight_lost();}
                else if (option==2){ctr.raiseScore();}
                else if(option==3){fight_lost();}
                else if(option==4){fight_lost();}
                break;
            case 7:
                if (option==1){ctr.raiseScore();
                fight_done(round_counter);}
                else if (option==2){fight_lost();}
                else if(option==3){fight_lost();}
                else if(option==4){fight_lost();}
                break;
        }
    }

    private void end_stuff(String str) {
        ctr.setText_pane_text(str);
        ctr.get_text_pane().setDisable(false);
        ctr.getOption1().setVisible(false);
        ctr.getOption2().setVisible(false);
        ctr.getOption3().setVisible(false);
        ctr.getOption4().setVisible(false);
        ctr.can_move = true;

    }

     private void fight_done(int counter) throws FileNotFoundException, JAXBException {
        if (counter>=7 && counter<10)
        {
         end_stuff("You decide to wait for the bear...It slowly walks towards you, seemingly really weakened...\n" +
                 "As it reaches you, it lifts up its paws to strike...You prepare for the last strike!\nAnd the bear just falls to the ground, lifeless! You won, go through the city gate now!");
            round_counter=10;
            ctr.getplayer().setFought(true);
            XmlMethods xmlMethods = new XmlMethods();
            xmlMethods.save(ctr.getplayer());
        }
     }

     private void fight_lost() {
        if (round_counter>1)
        {
         end_stuff("You fought hard, but sadly you lost this fight... but you can do it again! Good Luck!");
            round_counter=55;
        }
        else
        {
         end_stuff("It wasn't a tough fight i suppose... well... sadly you lost this fight... but you can do it again! Good Luck!");
            round_counter=55;
        }
     }

     public int getcounter(){return round_counter;}
     public void setcounter(int count){round_counter=count;}
     public void no_weapon(){
         ctr.getOption2().setVisible(false);
         ctr.getOption3().setVisible(false);
         ctr.getOption4().setVisible(false);
         ctr.gettext_pane_text().setText("You found a bear laying in the grass.\n" +
                 "When you come closer it suddenly gets up and starts running towards you!\n" +
                 "Sadly you have no weapon with you, the best you can do now is run!");
         ctr.getOption1().setText("run");
         run=true;
     }

}
