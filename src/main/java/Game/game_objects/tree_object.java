package Game.game_objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tree_object {
    private int x,y;

    public Tree_object(int x, int y,Image img){
        this.x=x;
        this.y=y;

        ImageView tree_fig=new ImageView();
        tree_fig.setFitHeight(32);
        tree_fig.setFitWidth(32);
        tree_fig.setImage(img);
        tree_fig.setX(x);
        tree_fig.setY(y);
    }

    public int getx(){ return x; }
    public int gety(){ return y; }
}
