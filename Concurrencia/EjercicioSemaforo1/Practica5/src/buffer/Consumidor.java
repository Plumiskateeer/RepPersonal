package buffer;

public class Consumidor extends Thread{
    private Buffer b;

    public Consumidor(Buffer b){
        this.b = b;
    }
    public void run(){
        for(int i = 0; i<1000; i++){
            if(b.getNumElem() > 0) {
                b.extraer();
            }
        }
    }
}
