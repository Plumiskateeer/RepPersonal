import javax.swing.plaf.synth.SynthTextAreaUI;

public class Principal {
    public static void main (String[]args) throws InterruptedException {

        Lago l = new Lago();
        Rio r0 = new Rio(l,0);
        Rio r1 = new Rio(l,1);
        Presa p0 = new Presa(l, 0);
        Presa p1 = new Presa(l, 1);

        r0.start();
        r1.start();
        p0.start();
        p1.start();

        r0.join();
        r1.join();
        p0.join();
        p1.join();

        System.out.println("El nivel del lago es de " + l.getNivel() + " unidades.");
    }
}
