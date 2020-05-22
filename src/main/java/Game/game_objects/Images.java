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
    URL bear_img = new URL(getClass().getResource("/Game/pics/bear_image.png").toExternalForm());
    private Image bear_image = new Image(bear_img.toExternalForm());
    URL waterh_img = new URL(getClass().getResource("/Game/pics/waterhag.png").toExternalForm());
    private Image waterh_image = new Image(waterh_img.toExternalForm());
    URL sign_img = new URL(getClass().getResource("/Game/pics/wooden_sign.png").toExternalForm());
    private Image sign_image = new Image(sign_img.toExternalForm());
    URL well_img = new URL(getClass().getResource("/Game/pics/well.png").toExternalForm());
    private Image well_image = new Image(well_img.toExternalForm());
    URL city_img = new URL(getClass().getResource("/Game/pics/city.png").toExternalForm());
    private Image city_image = new Image(city_img.toExternalForm());

    public Image getimage(String str) {
        if (str.equals("p")) {
            return playerm_image;
        } else if (str.equals("b")) {
            return bear_image;
        } else if (str.equals("wh")) {
            return waterh_image;
        } else if (str.equals("ws")) {
            return sign_image;
        }
        else if (str.equals("well")) {
            return well_image;
        }
        else if (str.equals("city")) {
            return city_image;
        }
        return null;
    }
}
