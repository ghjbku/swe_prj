package Game.control_objects;

import Game.Game;

/**
 * custom Exception for the Collosion Class
 */
public class CollosionException extends Exception {
    public CollosionException() {
    }

    public CollosionException(String message) {
        super(message);
    }
}
