import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static java.lang.Math.abs;


public class DangerousEnemy {

    public int velocityX = 2;

    public int velocityY = 2;

    public int randomEnemyX;

    public int randomEnemyY;

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

    public DangerousEnemy(String url) {


        this.randomEnemyX = rand(0, 400);

        this.randomEnemyY = 0;

        try {

            this.image = ImageIO.read(new File(url));

        } catch (IOException e) {

            e.printStackTrace();
        }


    }

    public void run () {

        if (randomEnemyX == 380) {

            velocityX = -2;

        } else if ( randomEnemyX == 0) {

            velocityX = 2;

        } else if ( randomEnemyY == 560) {

            velocityY = -2;

        } else if ( randomEnemyY == 0) {

            velocityY = 2;
        }

        randomEnemyX += velocityX;

        randomEnemyY += velocityY;

    }

    public void render (Graphics graphics) {

        graphics.drawImage(this.image, this.randomEnemyX, this.randomEnemyY, null);

    }

}
