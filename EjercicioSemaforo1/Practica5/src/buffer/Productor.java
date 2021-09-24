package buffer;

import java.util.Random;

public class Productor extends Thread{
    private Buffer b;
    private Random rnd;

    public Productor(Buffer b){
        this.b = b;
        rnd = new Random();
    }
    public void run(){
        for(int i = 0; i<1000; i++){
            if(b.getNumElem() < b.getTamElem()){
                b.insertar(rnd.nextInt(100));
            }
        }
    }
}
