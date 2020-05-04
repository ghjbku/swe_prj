package Game.game_objects;

import Game.Controller;

public class Fight {
    Controller controller;
    public void open_text_pane(){
        System.out.println(controller.text_pane.isDisable());
        controller.text_pane.setDisable(false);
        System.out.println(controller.text_pane.isDisable());
        controller.text_pane.setVisible(true);
        controller.can_move = false;
    }
}
