import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gamewindow extends JFrame {
    GameCanvas gameCanvas;
    private long lastTime;

    public Gamewindow() {
        this.setSize(400, 600);

        this.gameCanvas = new GameCanvas();

        this.add(this.gameCanvas);

        this.setVisible(true);

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                gameCanvas.positionPlayerX = e.getX();

                gameCanvas.getPositionPlayerY = e.getY();


            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });


    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
