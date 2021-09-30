public class Rio extends Thread{
    private Lago l;
    private int idRio;
    private volatile boolean r0, r1;
    private volatile int turno;

    public Rio(Lago lago, int id){
        this.l = lago;
        this.idRio = id;
    }


    public void run(){
        for(int i=0; i < 1000; i++) {
            if(idRio == 0) {
                incrementarR0();
            } else {
                incrementarR1();
            }
        }
    }

    private void pre0() {
        r0 = true;
        turno = 1;
        while(turno == 1 && r1) {
            Thread.yield();
        }
    }

    private void pre1() {
        r1 = true;
        turno = 0;
        while(turno == 0 && r0) {
            Thread.yield();
        }
    }

    private void post0() {
        r0= false;
    }

    private void post1() {
        r1= false;
    }

    private void incrementarR0() {
        pre0();
        //Seccion critica
        l.llenar();
        post0();
    }

    private void incrementarR1() {
        pre1();
        //Seccion critica
        l.llenar();
        post1();
    }
}
