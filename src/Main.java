public class Main {

    static public class Car {
        String color;
        int number;
        double speed;

        void run () {
            System.out.println("run.....");
        }
    }

    public static void main(String[] args) {
	    Gamewindow gamewindow = new Gamewindow();
	    gamewindow.gameLoop();
        Car Cammry = new Car();
        Cammry.color = "Red";
        Cammry.number = 4;
        Cammry.speed = 500.0;

        Cammry.run();
    }
}
