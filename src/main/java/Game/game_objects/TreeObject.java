package Game.game_objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * model class of the Tree objects.
 */
public class TreeObject implements Entity {
    private int x, y;
    private AnchorPane pane;

    /**
     * constructor for the tree object.
     *
     * @param x         the x coord of the tree.
     * @param y         the y coord of the tree.
     * @param tree_fig  the ImageView for the tree.
     * @param tree_pane the pane the tree's image is on.
     */
    public TreeObject(int x, int y, ImageView tree_fig, AnchorPane tree_pane) {
        this.pane = tree_pane;
        this.x = x;
        this.y = y;

        tree_fig.setLayoutX(x);
        tree_fig.setLayoutY(y);
    }

    /**
     * getter for the x coord.
     *
     * @return x coord.
     */
    public int getx() {
        return x;
    }

    /**
     * getter for the y coord.
     *
     * @return y coord.
     */
    public int gety() {
        return y;
    }
}
