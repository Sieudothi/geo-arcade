
import java.awt.image.BufferedImage;

import java.util.Random;

public class MediumSquare extends GameObject{


    public Vector2D velocity;


//
    private float a;

    private float b ;




    public static float randFloat(float min, float max) {


        Random rand = new Random();

        float result = rand.nextFloat() * (max - min) + min;

        return result;

    }

    public MediumSquare () {

        this.velocity = new Vector2D();


        this.position.x = 380;

//        this.position.x = 380;

        this.position.y = 560;

        this.velocity = new Vector2D();

        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
    }

    @Override
    public void run() {

        super.run();


        if (this.position.x == 380) {

            a = -3;


        } else if ( this.position.x == 200) {

            a = 3;



        } else if ( this.position.y == 560) {

            b = -3;


        } else if ( this.position.y == 300) {

            b = 3;

        }

        this.velocity.set(a, b);

        this.position.addUp(this.velocity);


    }



}
