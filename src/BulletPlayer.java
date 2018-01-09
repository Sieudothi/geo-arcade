import java.util.Vector;

public class BulletPlayer extends GameObject {
    public Vector2D velocity;

    public Vector vectorBulletPlayer = new Vector<>();

    public BulletPlayer() {
        this.image = Utils.loadImage("resources/player/player_bullet.png");

        this.velocity = new Vector2D(1,1);

    }

    @Override
    public void run() {

        super.run();

        this.position.subtractBy(this.velocity);

    }



}