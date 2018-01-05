import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class XEnemy {

    public int superEnemyX;

    public int superEnemyY;

    public BufferedImage image;

    public int velocitySuperEnemyX = 1;

    public int velocitySuperEnemyY = 1;

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

    public XEnemy(String url) {

        this.superEnemyX = rand(0,400);

        this.superEnemyY = 0;

        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        if (superEnemyX == 380) {

            velocitySuperEnemyX = -1;

        } else if ( superEnemyX == 0) {

            velocitySuperEnemyX = 1;

        } else if ( superEnemyY == 560) {

            velocitySuperEnemyY = -1;

        } else if ( superEnemyY == 0) {

            velocitySuperEnemyY = 1;
        }


        superEnemyX += velocitySuperEnemyX;

        superEnemyY += velocitySuperEnemyY;

    }

    public  void render(Graphics graphics) {

        graphics.drawImage(this.image, superEnemyX, superEnemyY, null);
    }


}
