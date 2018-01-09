import java.util.Vector;

public class BulletSquare extends GameObject {
    public Vector2D velocity;

//    public Vector vectorBulletSquare= new Vector<>();

    public BulletSquare() {
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");

        this.velocity = new Vector2D(1,1);

    }

    @Override
    public void run() {

        super.run();

        this.position.addUp(this.velocity);

    }



}
