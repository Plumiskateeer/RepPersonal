package ProdConsBufferCirc;

import java.util.concurrent.Semaphore;

public class Buffer {
    private int []buffer;
    private int p,c;
    private Semaphore mutex = new Semaphore(3);
    private Semaphore hayDatos = new Semaphore(0);
    private Semaphore hayHuecos;

    public Buffer(int tam){
        buffer = new int[tam];
        p = 0;
        c = 0;
        hayHuecos = new Semaphore(tam);
    }

    public void insertar(int i) throws InterruptedException {
        hayHuecos.acquire();
        mutex.acquire();
        //SC
        buffer[p] = i;
        p = (p+1)%buffer.length;
        System.out.println("Insertado: " + i);
        mutex.release();
        hayDatos.release();
    }

    public int extraer() throws InterruptedException {
        hayDatos.acquire();
        mutex.acquire();
        //SC
        int i = buffer[c];
        c= (c+1)%buffer.length;
        mutex.release();
        hayHuecos.release();
        return i;
    }

}
