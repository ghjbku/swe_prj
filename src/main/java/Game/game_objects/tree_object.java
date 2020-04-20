package Game.game_objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class Tree_object implements Entity {
    private int x,y;
    private AnchorPane pane;

    public Tree_object(int x, int y, Image image, AnchorPane image_pane){
        ImageView tree_fig=new ImageView(image);
        this.pane=image_pane;
        this.x=x;
        this.y=y;

        tree_fig.setLayoutX(0);
        tree_fig.setLayoutY(0);
        tree_fig.setX(x);
        tree_fig.setY(y);
        pane.getChildren().add(tree_fig);
    }

    public int getx(){ return x; }
    public int gety(){ return y; }
}
