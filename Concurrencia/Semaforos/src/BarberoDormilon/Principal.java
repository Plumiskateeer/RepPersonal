package BarberoDormilon;

public class Principal {
    public static void main(String[]args) throws InterruptedException {
        Barberia b = new Barberia();
        Barbero bar = new Barbero(b);
        Entorno ent = new Entorno(b);

        ent.start();
        bar.start();

        ent.join();
        bar.join();

    }
}
