public class Principal {
    public static void main(String[]args) throws InterruptedException {
        VariableCompartida v = new VariableCompartida();
        Productor p = new Productor(v);
        Consumidor c = new Consumidor(v);
        p.start();
        c.start();
        p.join();
        c.join();
    }
}
