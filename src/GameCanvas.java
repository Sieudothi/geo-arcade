import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel{

    BufferedImage background;
    BufferedImage player;
    BufferedImage enemy;
    BufferedImage backBuffered;
    Graphics graphics;
    BufferedImage DangerousEnemy;
    public int positionPlayerX = 200;
    public int positionPlayerY = 300;
    public int positionEnemyX ;
    public int positionEnemyY = 30;
    public int randomEnemyX = rand(0, 400);
    public int randomEnemyY = 0;
    public int xVelocity = 1;
    public int yVelocity = 1;

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






    public GameCanvas() {

        this.setSize(400, 600);

        this.setVisible(true);

        this.setupbackBuffered();

        this.setupBackground();

        this.setupPlayer();

        this.setupEnemy();

        this.setupDangerousEnemy();

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



    public void setupEnemy () {

            try {
                this.enemy = ImageIO.read(new File( "resources/square/enemy_square_small.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    public void setupDangerousEnemy () {
        try {
            this.DangerousEnemy = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);
    }



    public void renderAll() {


        randomEnemyY += yVelocity;
        randomEnemyX += xVelocity;

        if (randomEnemyX == 380) {
             xVelocity = -2;
        } else if ( randomEnemyX == 0) {
            xVelocity = 2;
        } else if ( randomEnemyY == 560) {
            yVelocity = -2;
        } else if ( randomEnemyY == 0) {
            yVelocity = 2;
        }

        this.graphics.drawImage(this.background, 0,0,null);
        this.graphics.drawImage(this.player, positionPlayerX -20 , positionPlayerY - 30 , null);
        for (int i = 0; i < 10; i ++) {
            positionEnemyX = rand(0,400);
            positionEnemyY += 2;
            this.graphics.drawImage(this.enemy, randomEnemyX, positionEnemyY, null);

        }
        this.graphics.drawImage(this.DangerousEnemy, randomEnemyX, randomEnemyY, null);
        this.repaint();
    }


}
