package Game.game_objects;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Bear implements Entity{
    private int x,y,hp=10;
    private ImageView bear;
    private AnchorPane pane;


    public Bear(int x,int y, ImageView bear_image, AnchorPane bear_pane){
        this.x=x;
        this.y=y;
        this.bear=bear_image;
        this.pane=bear_pane;

        bear_image.setLayoutX(x);
        bear_image.setLayoutY(y);
    }


    public void sethp(int hp_to_set){
        this.hp=hp_to_set;
    }

    @Override
    public int getx() {
        return x;
    }

    @Override
    public int gety() {
        return y;
    }
}
