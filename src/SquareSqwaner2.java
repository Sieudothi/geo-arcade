import java.util.Random;

public class SquareSqwaner2 extends GameObject {
    private int count = 0;
    private Random random;

    public SquareSqwaner2() {
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();

        if (this.count == 40) {
            MediumSquare mediumSquare = new MediumSquare();
            mediumSquare.position.set(random.nextInt(400), 0.0f);
            mediumSquare.velocity.set(0.0f, random.nextInt(6) + 3);
            GameObject.add(mediumSquare);
            this.count = 0;
        } else {
            this.count += 1;
        }

    }
}