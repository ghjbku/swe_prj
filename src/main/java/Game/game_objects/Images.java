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

    public Image getimage() {
        return playerm_image;
    }
}
