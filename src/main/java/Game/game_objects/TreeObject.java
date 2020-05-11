package Game.game_objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class TreeObject implements Entity {
    private int x,y;
    private AnchorPane pane;

    public TreeObject(int x, int y, ImageView tree_fig, AnchorPane tree_pane){
        this.pane=tree_pane;
        this.x=x;
        this.y=y;

        tree_fig.setLayoutX(x);
        tree_fig.setLayoutY(y);
        System.out.println(tree_fig.getLayoutX()+"= "+x+", "+y+"= "+tree_fig.getLayoutY());
    }

    public int getx(){ return x; }
    public int gety(){ return y; }
}
