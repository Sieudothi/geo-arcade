

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Enemy {

    public int EnemyX;

    public int EnemyY;

    public int yVelocity;

    public BufferedImage image;

    public static int rand(int min, int max) {

        try {
            Random rn = new Random();

            int range = max - min + 1;

            int randomNum = min + rn.nextInt(range);

            return randomNum;

        } catch (Exception e) {

            e.printStackTrace();

            return -1;
        }
    }

    public Enemy(String url) {

        this.EnemyX = rand(0,400);

        this.EnemyY = 0;

        this.yVelocity = 1;

        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run () {

        yVelocity = rand(1,3);

        EnemyY += yVelocity;

    }

    public void render(Graphics graphics) {

        graphics.drawImage(this.image, EnemyX, EnemyY, null);

    }

}
