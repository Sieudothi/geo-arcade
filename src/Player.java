import java.util.Vector;

public class Player extends GameObject {


    public int count = 0;

    public Player() {
        this.image = Utils.loadImage("resources/player/straight.png");

    }

    @Override
    public void run() {

        super.run();

        if (this.count == 30) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(this.position);
            bulletPlayer.velocity.set(0.0f, 5.0f);
            GameObject.add(bulletPlayer);
            this.count = 0;
        } else {
            this.count += 1;
        }

    }

}