import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Player extends JFrame{

    GameCanvas gameCanvas;

    public int positionPlayerX;

    public int positionPlayerY;

    public BufferedImage image;



    public Player(int a, int b, String url) {

        this.positionPlayerX = a;

        this.positionPlayerY = b;


        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void render(Graphics graphics) {

        graphics.drawImage(this.image, this.positionPlayerX -20 , this.positionPlayerY - 30 , null);

    }
}
