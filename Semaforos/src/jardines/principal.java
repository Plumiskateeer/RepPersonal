package jardines;

public class principal {
    public static void main(String[]args) throws InterruptedException {
        Contador c = new Contador();
        Puerta p0 = new Puerta(c);
        Puerta p1 = new Puerta(c);

        p0.start();
        p1.start();

        p0.join();
        p1.join();

        System.out.println(c.getContador());
    }



}
