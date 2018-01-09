import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class SquareSqwaner extends GameObject {
    private int count = 0;
    private Random random;

    public SquareSqwaner() {
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        if (this.count >= 20) {
            Square square = new Square();
            square.position.set(random.nextInt(400), 0.0f);
            square.velocity.set(0.0f, random.nextInt(6) + 3);
            GameObject.add(square);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}