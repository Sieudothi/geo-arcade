import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletXEnemy {
    public int x;

    public int y;

    public BufferedImage image;

    public int speed;

    public BulletXEnemy(int a, int b, String url) {

        this.x = a;

        this.y = b;

        this.speed = 2;

        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {

        y += speed;

    }

    public void render(Graphics graphics) {

        graphics.drawImage(this.image, x, y, null);
    }
}
