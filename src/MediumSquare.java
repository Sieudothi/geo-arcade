
public class MediumSquare extends GameObject {

    public Vector2D velocity;
    public int count = 0;

    public MediumSquare() {
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {

        super.run();

        this.position.addUp(this.velocity);

        if (this.count == 20) {
            BulletSquare bulletSquare = new BulletSquare();
            bulletSquare.position.set(this.position);
            bulletSquare.velocity.set(1.0f, 1.0f);
            GameObject.add(bulletSquare);
            this.count = 0;
        } else {
            this.count += 1;
        }

    }
}