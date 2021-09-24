package ProdConsBufferCirc;

public class Consumidor extends Thread{
    private Buffer b;

    public Consumidor(Buffer b){
        this.b = b;
    }

    public void run(){
        for(int i = 0; i<100; i++){
            try {
                System.out.println("Extraido: " + b.extraer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
