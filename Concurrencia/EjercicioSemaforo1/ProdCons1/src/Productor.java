public class Productor extends Thread{
    private VariableCompartida v;

    public Productor(VariableCompartida v){
        this.v = v;
    }
    public void run(){
        for(int i = 0; i<10; i++){

            v.escribir(i);
        }
    }
}
