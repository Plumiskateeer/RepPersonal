public class Lago {
    private volatile int nivel;
    //variable Peterson
    private volatile boolean f0, f1;
    private volatile int turno;
    // f0 Rio
    // f1 Presa

    public Lago() {
        nivel = 0;
    }

    public int getNivel() {
        return nivel;
    }

    private void pre0() {
        f0 = true;
        turno = 1;
        while(turno == 1 && f1) {
            Thread.yield();
        }
    }

    private void post0() {
        f0 = false;
    }

    public void llenar(){
        pre0();
        // No hay sincronizacion (se puede incrementar hasta el infinito)
        //Seccion crítica
        nivel++;
        System.out.println("Rio");
        //Post protocolo
        post0();
    }

    private void pre1() {
        f1= true;
        turno = 0;
        while(turno == 0 && f0) {
            Thread.yield();
        }
    }

    private void post1() {
        f1 = false;
    }

    public void vaciar(){
        pre1();

        //Sincronización
        while(nivel == 0) {
            System.out.println("Nivel cero");
            post1();
            Thread.yield();
            pre1();
        }
        //Sección critica
        nivel--;
        System.out.println("Presa");
        //Post protocolo
        post1();
    }
}
