public class Vector2D {

    public float x;

    public float y;

    public Vector2D(float x, float y) {

        this.x = x;

        this.y = y;

    }

    public Vector2D() {

        this.x = 0.0f;

        this.y = 0.0f;

    }

    public Vector2D set(float x, float y) {

        this.x = x;

        this.y = y;

        return  this;

    }

    public Vector2D set(Vector2D vector2D) {

        return this.set(vector2D.x, vector2D.y);
    }

    public Vector2D addUp(float x, float y) {

        this.x += x;

        this.y += y;

        return this;
    }

    public Vector2D addUp(Vector2D vector2D) {

        return this.addUp(vector2D.x, vector2D.y);

    }

    public Vector2D add(float x, float y) {

        return new Vector2D(this.x + x, this.y + y);

    }

    public Vector2D add(Vector2D vector2D) {

        return this.add(vector2D.x, vector2D.y);

    }

    //subtractBy

    public Vector2D subtractBy(float x, float y) {

        this.x -= x;

        this.y -= y;

        return  this;

    }

    public Vector2D subtractBy(Vector2D vector2D) {

        return this.subtractBy(vector2D.x, vector2D.y);

    }

    //subtract

    public Vector2D subtract(float x, float y) {

        return new Vector2D(this.x - x, this.y - y);

    }

    public Vector2D subtract(Vector2D vector2D) {

        return this.add(vector2D.x, vector2D.y);

    }

    //multiply

    public Vector2D multiply(float k, Vector2D vector2D) {

        return new Vector2D(k*this.x, k* this.y);

    }


    //length

    public float length() {

        return (float) Math.sqrt(this.x*this.x + this.y*this.y);

    }

    //clone

    public Vector2D clone(){

        Vector2D vector2D = new Vector2D(this.x, this.y);

        return vector2D;

    }

    //rotate
    private Vector2D rotateZ(Vector2D vector2D,double angle) { // angle in radians

        //normalize(vector); // No  need to normalize, vector is already ok...

        float x1 = (float)(vector2D.x * Math.cos(angle) - vector2D.y * Math.sin(angle));

        float y1 = (float)(vector2D.x * Math.sin(angle) + vector2D.y * Math.cos(angle)) ;

        return new Vector2D(x1, y1);

    }


    //normalize



    public Vector2D normalize(Vector2D vector2D) {

        float length = (float) Math.sqrt( this.x*this.x + this.y*this.y);
        if (length != 0) {
            vector2D.x = this.x/length;
            vector2D.y = this.y/length;
        }
        return vector2D;
    }

}
