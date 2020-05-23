package Game.game_objects;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * class for the Bear object's model.
 */
public class Bear implements Entity {
    private int x, y, hp = 10;
    private ImageView bear;
    private AnchorPane pane;

    /**
     * constructor for the Bear.
     *
     * @param x          x coord of the object.
     * @param y          y coord of the object.
     * @param bear_image the image containing the bear.
     * @param bear_pane  the pane the bear_image is on.
     */
    public Bear(int x, int y, ImageView bear_image, AnchorPane bear_pane) {
        this.x = x;
        this.y = y;
        this.bear = bear_image;
        this.pane = bear_pane;

        bear_image.setLayoutX(x);
        bear_image.setLayoutY(y);
    }

    /**
     * method that sets the bear's hp.
     *
     * @param hp_to_set amount to set the hp to.
     */
    public void sethp(int hp_to_set) {
        this.hp = hp_to_set;
    }

    /**
     * method that returns the hp value.
     *
     * @return the hp value.
     */
    public int gethp() {
        return hp;
    }

    /**
     * method that returns the x coord.
     *
     * @return x coord.
     */
    @Override
    public int getx() {
        return x;
    }

    /**
     * method that sets the x coord.
     *
     * @param sx x coord.
     */
    public void setx(int sx) {
        x = sx;
    }

    /**
     * method that returns the y coord.
     *
     * @return y coord.
     */
    @Override
    public int gety() {
        return y;
    }

    /**
     * method that sets the y coord.
     *
     * @param sy y coord.
     */
    public void sety(int sy) {
        y = sy;
    }
}
