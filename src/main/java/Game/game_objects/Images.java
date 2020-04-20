package Game.game_objects;

import javafx.scene.image.Image;

import java.io.File;

public class Images {
    public static String picture_path_start ="/Game/pics/";
    static File playerm_img = new File(String.valueOf(Images.class.getResource(picture_path_start +"Player_m.png")));

    public static Image playerm_image=new Image(playerm_img.toString());


}
