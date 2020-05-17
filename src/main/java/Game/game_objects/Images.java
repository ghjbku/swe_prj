package Game.game_objects;

import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Images {
    public Images() throws MalformedURLException {
    }

    URL playerm_img = new URL(getClass().getResource("/Game/pics/Player_m.png").toExternalForm());
    private Image playerm_image = new Image(playerm_img.toExternalForm());
    URL bear_img = new URL(getClass().getResource("/Game/pics/Bear.png").toExternalForm());
    private Image bear_image = new Image(bear_img.toExternalForm());
    URL waterh_img = new URL(getClass().getResource("/Game/pics/waterhag.png").toExternalForm());
    private Image waterh_image = new Image(waterh_img.toExternalForm());

    public Image getimage(String str) {
        if (str.equals("p")) {
            return playerm_image;
        }
        else if (str.equals("b")){
            return bear_image;
        }
        else if (str.equals("wh")){
            return waterh_image;
        }
        return null;
    }
}
