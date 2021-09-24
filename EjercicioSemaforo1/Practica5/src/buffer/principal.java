package buffer;

public class principal {
    public static void main(String[]args) throws InterruptedException {
        Buffer b = new Buffer(10);
        Consumidor c = new Consumidor(b);
        Productor p = new Productor(b);

        p.start();
        c.start();

        p.join();
        c.join();
    }

}
