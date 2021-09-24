package jardines;

import java.util.concurrent.Semaphore;

public class Contador {
    private int contador;
    Semaphore mutex = new Semaphore(1);

    public void inc() throws InterruptedException {
        mutex.acquire();
        contador++;
        mutex.release();
    }

    public int getContador(){
        return contador;

    }
}
