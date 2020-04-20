package Game.game_objects;

import javafx.scene.image.Image;

import java.io.File;

public class Images {
    public static String picture_path_start ="/Game/pics/";
    static File tree1_img = new File(String.valueOf(Images.class.getResource(picture_path_start +"Tree1.png")));
    static File tree2_img = new File(String.valueOf(Images.class.getResource(picture_path_start +"Tree2.png")));
    static File playerm_img = new File(String.valueOf(Images.class.getResource(picture_path_start +"Player_m.png")));

    public static Image tree1_image=new Image(tree1_img.toString());
    public static Image tree2_image=new Image(tree2_img.toString());
    public static Image playerm_image=new Image(playerm_img.toString());


}
