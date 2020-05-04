package Game.game_objects;

import Game.Controller;

public class Fight {
    Controller ctr;
    public Fight(Controller controller){ ctr=controller;}

    public void open_text_pane(){
        System.out.println(ctr.get_text_pane().isDisable());
        ctr.get_text_pane().setDisable(false);
        System.out.println(ctr.get_text_pane().isDisable());
        ctr.get_text_pane().setVisible(true);
        ctr.can_move = false;
    }
}
