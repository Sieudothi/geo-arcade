import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class BulletPlayer {

    public int xRight;
    public int xLeft;
    public  int y;
    public BufferedImage image;
    public int speedX;
    public int speedY;

    public BulletPlayer(int a, int b, int c, String url) {

        this.xRight = a;
        this.xLeft = b;
        this.y = c;
        try {
            this.image = ImageIO.read (new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.speedX = 1;
        this.speedY = 3;
    }

    public void run () {

        if (this.xRight == 0) {

            this.xLeft -= this.speedX;

            this.y -= this.speedY;

        } else {

            this.xRight += this.speedX;

            this.y -= this.speedY;

        }





    }

    public void render (Graphics graphics) {

        if( this.xRight== 0) {

            graphics.drawImage(this.image, this.xLeft, this.y, null);

        } else {

            graphics.drawImage(this.image, this.xRight, this.y, null);

        }



    }
}
