
import java.awt.*;
import java.awt.image.BufferedImage;


public class Background {
    public BufferedImage image;

//    public void Background(String url) {
//
//        this. image = Utils.loadImage("resources/background/background.png");
//
//    }

    public void render(Graphics graphics) {

        this. image = Utils.loadImage("resources/background/background.png");

        if (this.image !=null) {
            graphics.drawImage(this.image, 0, 0, null);
        }
    }

}
