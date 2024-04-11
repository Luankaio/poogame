import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Carro implements KeyListener, Runnable {
    private int xCarro;
    private int yCarro;


    @Override
    public void run() {
        
    }

    public void setXCarro(int xCarro){
        this.xCarro=xCarro;
    }

    public void setYCarro(int yCarro){
        this.yCarro=yCarro;
    }

    public int getXCarro(){
        return xCarro;
    }
    public int getYCarro(){
        return yCarro;
    }

    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_LEFT) {

        }
        if (codigo == KeyEvent.VK_RIGHT) {

        }
        if (codigo == KeyEvent.VK_DOWN) {

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
