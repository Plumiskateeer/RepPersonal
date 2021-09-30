public class Presa extends Thread{
    private Lago l;
    private int idPresa;
    private volatile boolean p0, p1;
    private volatile int turno;

    public Presa(Lago lago, int id){
        this.l = lago;
        this.idPresa = id;
    }


    public void run(){
        for(int i=0; i < 1000; i++) {
            if(idPresa == 0) {
                incrementarR0();
            } else {
                incrementarR1();
            }
        }
    }

    private void pre0() {
        p0 = true;
        turno = 1;
        while(turno == 1 && p1) {
            Thread.yield();
        }
    }

    private void pre1() {
        p1 = true;
        turno = 0;
        while(turno == 0 && p0) {
            Thread.yield();
        }
    }

    private void post0() {
        p0= false;
    }

    private void post1() {
        p1= false;
    }

    private void incrementarR0() {
        pre0();
        //Seccion critica
        l.vaciar();
        post0();
    }

    private void incrementarR1() {
        pre1();
        //Seccion critica
        l.vaciar();
        post1();
    }
}
