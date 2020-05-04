package Game.game_objects;

import Game.control_objects.Controller;

public class Inventory {
    Controller ctr;
    public Inventory(Controller controller){ ctr=controller;}

    public void open_inventory() {
        ctr.getInventory().setVisible(true);

        if (ctr.getplayer().getItems().size() == 0) {}
        else if (ctr.getplayer().getItems().size() > 1)
        {
            if ((ctr.getplayer().getitem(0).getid() == 0 && ctr.getplayer().getitem(1).getid() == 1) ||
                (ctr.getplayer().getitem(0).getid() == 1 && ctr.getplayer().getitem(1).getid() == 0))
            {
                ctr.getDagger_fig_inv().setVisible(true);
                ctr.getNote_fig_inv().setVisible(true);
                ctr.getDagger_fig().setImage(null);
                ctr.getNote_fig().setImage(null);
            }
        }
        else if (ctr.getplayer().getItems().size() == 1)
        {
            if (ctr.getplayer().getitem(0).getid() == 1)
            {
                ctr.getNote_fig().setImage(null);
                ctr.getNote_fig_inv().setVisible(true);
            }
            else if (ctr.getplayer().getitem(0).getid() == 0)
            {
                ctr.getDagger_fig().setImage(null);
                ctr.getDagger_fig_inv().setVisible(true);
            }
        }
    }

    public void close_inventory(){
        ctr.getInventory().setVisible(false);
        ctr.getNote_desc().setVisible(false);
        ctr.getDagger_desc().setVisible(false);
    }

    public void open_dagger_desc(){
        ctr.getDagger_desc().setVisible(true);
    }
    public void open_note_desc(){
        ctr.getNote_desc().setVisible(true);
    }

}
