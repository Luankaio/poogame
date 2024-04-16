import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Segmento");

        Segmento segmento = new Segmento();
        Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screen_size);
        frame.setLocationRelativeTo(null);
        frame.add(segmento);
        frame.setResizable(false);
        frame.setVisible(true);

        Thread t = new Thread(segmento);
        t.start();
    }
}
