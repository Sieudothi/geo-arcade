import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;



public class GameCanvas extends JPanel{

    BufferedImage background;

    BufferedImage backBuffered;

//    BufferedImage player;

    Graphics graphics;

    Vector<BulletPlayer> vectorBulletPlayer;

    Vector<Enemy> vectorEnemy;

    Vector<BulletXEnemy> vectorBulletXEnemy;

    public int positionPlayerX = 200;

    public int positionPlayerY = 300;

    public int countBulletPlayer = 0;

    public int countBulletSuperEnemy = 0;

    public int countEnemy;


    Player player;

    DangerousEnemy dangerousEnemy;

    XEnemy xEnemy;


    public GameCanvas() {

        this.setSize(400, 600);

        this.setVisible(true);

        this.setupbackBuffered();

        this.setupBackground();

        this.setupPlayer();

        this.setupEnemy();

        this.setupDangerousEnemy();

        this.setupSuperEnemy();

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

        player = new Player(positionPlayerX, positionPlayerY,"resources/player/straight.png");

//        player1 = new Player("resources/player/straight.png");

//        try {
//            this.player = ImageIO.read(new File("resources/player/straight.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        this.vectorBulletPlayer = new Vector<>();
    }



    public void setupEnemy () {

        this.vectorEnemy = new Vector<>();

    }

    public void setupDangerousEnemy () {

        dangerousEnemy = new DangerousEnemy("resources/square/enemy_square_small.png");


    }

    public void setupSuperEnemy() {

        xEnemy = new XEnemy("resources/square/enemy_square_medium.png");

        this.vectorBulletXEnemy = new Vector<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);
    }



    public void renderAll( ) {



        this.graphics.drawImage(this.background, 0,0,null);

//        this.graphics.drawImage(this.player, positionPlayerX, positionPlayerY, null);

        player = new Player(positionPlayerX, positionPlayerY,"resources/player/straight.png");

        player.render(graphics);

        //render DangerousEnemy

        dangerousEnemy.render(graphics);

        //render XEnemy

        xEnemy.render(graphics);

        //render Enemy

        for (Enemy enemy: this.vectorEnemy) {

            enemy.render(graphics);
        }

        //render BullerPlayer

        for (BulletPlayer bulletPlayer: this.vectorBulletPlayer) {

            bulletPlayer.render(graphics);
        }

        //render BullerSuperEnemy

        for (BulletXEnemy bulletXEnemy : this.vectorBulletXEnemy) {

            bulletXEnemy.render(graphics);
        }

        this.repaint();
    }

    public void runAll() {

//        player1 = new Player(positionPlayerX, positionPlayerY,"resources/player/straight.png");

        // run DangerousEnemy

        dangerousEnemy.run();

        //run XEnemy

        xEnemy.run();

        //run BulletPlayer

        if (this.countBulletPlayer >= 10) {

            BulletPlayer bulletPlayer = new BulletPlayer(positionPlayerX, positionPlayerY,"resources/player/player_bullet.png", 3);

            this.vectorBulletPlayer.add(bulletPlayer);

            this.countBulletPlayer = 0;

        } else {

            this.countBulletPlayer +=1;

        }

        for (BulletPlayer bulletPlayer: this.vectorBulletPlayer) {

            bulletPlayer.run();

        }

        //run BulletXEnemy

        if (this.countBulletSuperEnemy >= 30) {

            BulletXEnemy bulletXEnemy = new BulletXEnemy(xEnemy.superEnemyX, xEnemy.superEnemyY, "resources/square/enemy_square_bullet.png");

            this.vectorBulletXEnemy.add(bulletXEnemy);

            this.countBulletSuperEnemy = 0;

        } else {

            this.countBulletSuperEnemy += 1;
        }

        for (BulletXEnemy bulletXEnemy : this.vectorBulletXEnemy) {

            bulletXEnemy.run();

        }

        //run Enemy

        if (this.countEnemy >= 50) {

            Enemy enemy = new Enemy("resources/square/enemy_square_small.png");

            this.vectorEnemy.add(enemy);

            this.countEnemy = 0;

        } else {

            this.countEnemy +=1;

        }


        for (Enemy enemy: this.vectorEnemy) {

            enemy.run();

        }
    }


}

