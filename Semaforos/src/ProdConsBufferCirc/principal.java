package ProdConsBufferCirc;

public class principal {
    public static void main(String[]args) throws InterruptedException {
        Buffer b = new Buffer(10);
        Productor p = new Productor(b);
        Consumidor c = new Consumidor(b);

        p.start();
        c.start();

        p.join();
        c.join();


    }
}
