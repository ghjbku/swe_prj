package Game.game_objects;

/**
 * interface with the basic properties of all entities in the game.
 */
public interface Entity {
    /**
     * default coordinates for every entity.
     */
    int x = 0;
    /**
     * default coordinates for every entity.
     */
    int y = 0;

    /**
     * default coordinate getter for every entity.
     * @return x
     */
     int getx();

    /**
     * default coordinate getter for every entity.
     * @return y
     */
     int gety();
}
