import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Segmento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        Segmento segmento = new Segmento();
        frame.setLocationRelativeTo(null);
        frame.add(segmento);
        frame.setVisible(true);
        Thread t = new Thread(segmento);
        t.start();
    }
}
