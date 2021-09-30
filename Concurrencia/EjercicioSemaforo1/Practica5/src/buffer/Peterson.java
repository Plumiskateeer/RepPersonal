package buffer;

public class Peterson{
    private static volatile boolean f0,f1;
    private static volatile int turno;

    //productor
    public void pre0(){
        f0 = true;
        turno = 1;
        while(f1 && turno == 1){
            Thread.yield();
        }
    }
    public void post0(){
        f0 = false;
    }

    //consumidor
    public void pre1(){
        f1 = true;
        turno = 0;
        while(f0 && turno == 0){
            Thread.yield();
        }
    }
    public void post1(){ f1 = false; }
}
