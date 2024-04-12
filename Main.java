import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Main {
    // public static void main(String[] args) {
    //     JFrame frame = new JFrame("Segmento");
        
    //     Segmento segmento = new Segmento();

    //     Dimension dimension = new Dimension();
    //     dimension.setSize(800, 600);

    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(800, 600);
    //     frame.setMinimumSize(dimension);
    //     frame.setLocationRelativeTo(null);
    //     frame.add(segmento);
    //     frame.setResizable(false);
    //     frame.setVisible(true);
        
    //     Thread t = new Thread(segmento);
    //     t.start();
    // }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Segmento");

        Segmento segmento = new Segmento();
        Dimension dimension = new Dimension(800, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setMinimumSize(dimension);
        frame.setLocationRelativeTo(null);
        frame.add(segmento);
        frame.setResizable(true);
        frame.setVisible(true);

        // Adiciona um KeyListener para alternar entre o modo de tela cheia e o modo normal
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F11) {
                    toggleFullscreen(frame);
                }
            }
        });

        Thread t = new Thread(segmento);
        t.start();
    }

    private static void toggleFullscreen(JFrame frame) {
        GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (!frame.isUndecorated()) {
            // Entra no modo de tela cheia
            frame.dispose();
            frame.setUndecorated(true); // Remove as bordas da janela
            frame.setResizable(false); // Impede redimensionamento ao entrar em tela cheia
            graphicsDevice.setFullScreenWindow(frame); // Define a janela como tela cheia
        } else {
            // Sai do modo de tela cheia
            frame.dispose();
            graphicsDevice.setFullScreenWindow(null); // Remove a janela do modo de tela cheia
            frame.setUndecorated(false); // Restaura as bordas da janela
            frame.setSize(800, 600); // Define o tamanho padrão da janela
            frame.setLocationRelativeTo(null); // Centraliza a janela na tela
            frame.setResizable(true); // Permite redimensionamento ao voltar ao modo normal
            frame.setVisible(true); // Mostra a janela com a configuração atualizada
        }
    }
}
