public class Percurso implements Runnable{
    private int[] percurso1 = {0,0,0,1,1,0,0,2,2,1};
    private int direcao=0;

    @Override
    public void run() {
        int i=0;
        while(i<percurso1.length){
            direcao = percurso1[i];
            try {
                Thread.sleep(1000); // Temporizador entre os frames, 1000=1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if(i==percurso1.length-1){
                i=0;
            }
        }
    }


    public int getDirecao(){
        return direcao;
    }
    
}
