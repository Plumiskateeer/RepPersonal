package ProdConsBufferCirc;

public class Productor extends Thread{
    private Buffer b;

    public Productor(Buffer b){
        this.b = b;
    }

    public void run(){
        for(int i = 0; i<100; i++){
            try {
                b.insertar(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
