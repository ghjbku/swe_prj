package Game.game_objects;

import Game.Controller;

public class Inventory {
    Controller ctr;
    public Inventory(Controller controller){ ctr=controller;}

    public void open_inventory() {
        ctr.inventory.setVisible(true);

        if (ctr.getplayer().getItems().size() == 0) {
        } else if (ctr.getplayer().getItems().size() > 1) {
            if ((ctr.getplayer().getitem(0).getid() == 0 && ctr.getplayer().getitem(1).getid() == 1) ||
                    (ctr.getplayer().getitem(0).getid() == 1 && ctr.getplayer().getitem(1).getid() == 0)) {
                ctr.dagger_fig_inv.setVisible(true);
                ctr.note_fig_inv.setVisible(true);
                ctr.dagger_fig.setImage(null);
                ctr.note_fig.setImage(null);
            }
        } else if (ctr.getplayer().getItems().size() == 1) {
            if (ctr.getplayer().getitem(0).getid() == 1) {
                ctr.note_fig.setImage(null);
                ctr.note_fig_inv.setVisible(true);
            } else if (ctr.getplayer().getitem(0).getid() == 0) {
                ctr.dagger_fig.setImage(null);
                ctr.dagger_fig_inv.setVisible(true);
            }
        }
    }

    public void close_inventory(){
        ctr.inventory.setVisible(false);
        ctr.note_desc.setVisible(false);
        ctr.dagger_desc.setVisible(false);
    }

}
