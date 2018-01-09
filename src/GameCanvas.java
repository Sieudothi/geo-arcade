
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class GameCanvas extends JPanel {


        Background background;
        Player player;
        BulletPlayer bulletPlayer;
        MediumSquare mediumSquare;
        BufferedImage backBuffered;
        Graphics graphics;

        public Vector2D positionPlayer = new Vector2D();



    public GameCanvas() {
            this.setSize(400, 600);
            this.setVisible(true);
            this.setupBackBuffered();
            this.setupBackground();
            this.setupPlayer();
            this.setupSquare();
            this.setupMediumSquare();
        }

        public static float randFloat(float min, float max) {

            Random rand = new Random();

            float result = rand.nextFloat() * (max - min) + min;

            return result;

        }

        private void setupBackBuffered() {
            this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
            this.graphics = this.backBuffered.getGraphics();
        }

        private void setupBackground() {
            this.background = new Background();
        }

        private void setupPlayer() {
            this.player = new Player();

            this.bulletPlayer = new BulletPlayer();

            GameObject.add(bulletPlayer);

            GameObject.add(player);
        }

        private void setupSquare() {
            GameObject.add(new SquareSqwaner());
        }

        private void setupMediumSquare (){

            GameObject.add(new SquareSqwaner2());

        }

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(this.backBuffered, 0, 0, null);
        }

        public void renderAll() {
            this.background.render(graphics);
            GameObject.renderAll(graphics);
            this.repaint();
        }

        public void runAll() {

            this.player.position.set(this.positionPlayer);

            GameObject.runAll();

        }
    }

