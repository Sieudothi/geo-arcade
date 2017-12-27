import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel{

    BufferedImage background;
    BufferedImage player;
    BufferedImage enemy;
    BufferedImage backBuffered;
    Graphics graphics;
    public int positionPlayerX = 200;
    public int getPositionPlayerY = 300;
    public int positionEnemyX = 200;
    public int positionEnemyY = 30;

    public GameCanvas() {

        this.setSize(400, 600);

        this.setVisible(true);

        this.setupbackBuffered();

        this.setupBackground();

        this.setupPlayer();

        try {
            this.enemy = ImageIO.read(new File( "resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setupbackBuffered () {

        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();

    }

    private void setupBackground () {
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setupPlayer() {
        try {
            this.player = ImageIO.read(new File("resources/player/straight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);



    }



    public void renderAll() {

        this. graphics.drawImage(this.background, 0,0,null);
        this.graphics.drawImage(this.player, positionPlayerX -20 , getPositionPlayerY - 30 , null);
        this.repaint();
    }
}
