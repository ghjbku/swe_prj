package Game.control_objects;

import Game.Game;

/**
 * custom Exception for the Collosion Class.
 */
public class CollosionException extends Exception {
    /**
     * default constructor.
     */
    public CollosionException() {
    }

    /**
     * constructor with parameter.
     * @param message the message to throw as error.
     */
    public CollosionException(String message) {
        super(message);
    }
}
