import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Segmento extends JPanel implements Runnable, KeyListener {
    private static final long serialVersionUID = 1L;
    private int largura = 400; // Largura do retângulo
    private int altura = 20; // Altura do retângulo
    private int x = 280; // Coordenada x do canto superior esquerdo do retângulo
    private int y = 750; // Coordenada y do canto superior esquerdo do retângulo
    private int diminuirTamanho = 18;
    private int k = 0;
    private int direcao = 0;
    private int m=0;
    private int ç=0;
    private int curva=0;
    private String image = "./carro.png";
    ImageIcon imagemCarro = new ImageIcon(image);
    Percurso percurso = new Percurso();

    public Segmento() {
        setBackground(Color.WHITE);
        addKeyListener(this); // Adiciona o KeyListener ao painel
        setFocusable(true); // Permite que o painel tenha o foco para detectar eventos de teclado
    }

    @Override //pinta o componente retangulo na tela
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharRetangulo(g);
        g.drawImage(imagemCarro.getImage(), 310, 660, 180, 100, null);

    }

    public void direcionamentoCarro(){
       
    }
    

    private void desenharRetangulo(Graphics g) {

        for (int i = 1; i <= 30; i++) {

            if(m%2==0){
                g.setColor(Color.BLACK);
            }else{
                g.setColor(Color.GRAY);
            }
            if(i==30){
                largura=2000;
                x=0;
            }
            g.fillRect(x, y, largura, altura);
            this.y -= this.altura;   // defino a altura do quadrado pra sempre ser um acima do outro quadrante
            this.altura-=i/17;
            this.largura -= diminuirTamanho; //diminuo a largura em 30 para cada novo quadrante
            this.x += (diminuirTamanho / 2);
            this.x -= (i * this.k) / 100;
            m++;
        }
        m++;
    }
    
    @Override//runnable que roda o codigo
    public void run() {
        repaint();
        ///////// criação da thread do percurso que faz a pista mudar de forma constante de acordo com o percurso criado
        percurso = new Percurso();
        Thread tpercurso = new Thread(percurso);
        tpercurso.start();
        /////////
        while (true) {
            revalidate();//checa se houve alguma mudança
            repaint();//refaz a tela
            try {
                Thread.sleep(3); // Temporizador entre os frames, 1000=1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            moverQuadrantes();//move os quadrante  de acordo com o 0
            reset();
            percurso();
        }
    }
    
    
    private void reset() {
        this.y = 750;
        this.x = ((800-650)/2)+curva;
        this.largura = 650;
        this.altura = 15;
    }
    
 
    //faz com que a pista curve e com que o carro seja jogado para a esqueda e direita
    public void percurso() {
        
        if (percurso.getDirecao()==1) {
            curvaEsquerda();
            this.curva-=1;
        }
        if (percurso.getDirecao()==2) {
            curvaDireita();
            this.curva+=1;
        }
        if (percurso.getDirecao()==0) {
            reta();
        }
    }

    
    
    
    public void moverQuadrantes() {
        if (ç != 0) {
            if (k > 0 && k != 0) {
                this.k -= 1;
            } else if (k < 0 && k != 0) {
                this.k += 1;
            }
        } else {
            if ((k < 190 && k > -190)) {
                this.k += direcao;
            } else {
                if (k < 0) {
                    k = -189;
                } else {
                    k = 189;
                }
            }
        }
        
    }

    
    
    public void curvaEsquerda(){
        this.direcao = 1;
        ç = 0;
    }
    public void curvaDireita(){
        this.direcao = -1;
        ç = 0;
    }
    public void reta(){
        ç = 1;
    }
    
    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        
        if (codigo == KeyEvent.VK_LEFT) {
            this.curva+=20;
            this.image="./carroesquerda.png";
            this.imagemCarro = new ImageIcon(image);
            repaint();
        }
        if (codigo == KeyEvent.VK_RIGHT) {
            this.curva-=20;
            this.image="./carrodireita.png";
            this.imagemCarro = new ImageIcon(image);
            repaint();
        }
        
    }
    
        // Métodos necessários da interface KeyListener
        @Override
        public void keyTyped(KeyEvent e) {
            
        }
        
        @Override
        public void keyReleased(KeyEvent tecla) {
            int codigo = tecla.getKeyCode();
            if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_RIGHT) {
                this.image = "./carro.png"; // Volta para a imagem padrão do carro
                this.imagemCarro = new ImageIcon(image); // Atualiza a imagem do carro
            }
        }

    
    
}
