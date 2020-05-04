package Game.control_objects;

import Game.Game;

public class CollosionException extends Exception {
    public CollosionException(){}
    public CollosionException(String message){
        super(message);
    }
}
