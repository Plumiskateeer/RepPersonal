public class Consumidor extends Thread{
    private VariableCompartida v;

    public Consumidor(VariableCompartida v){
        this.v = v;
    }
    public void run(){
        for(int i = 0; i<10; i++){
            int valor = v.leer();

        }
    }
}
