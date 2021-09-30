public class VariableCompartida { //recurso
    private int var;
    private boolean hayDato = false; //hay un nuevo dato en la variable compartida

    public void escribir(int v){
        // utilizado por el productor
        while(hayDato){
            Thread.yield();
        }; //espera activa. PreProtocolo

        var = v;
        System.out.println("Productor ha escrito " + v);
        hayDato = true; //Postprotocolo
    }
    public int leer(){
        // utilizado por el consumidor
        while(!hayDato){
            Thread.yield();
        }; //espera activa. Preprotocolo

        System.out.println("Consumidor ha leido " + var);
        hayDato = false; //Postprotocolo
        return var;
    }
}
//CondSincr-Prod: No puedo producir hasta que se haya leido el anterior dato
//CondSincr-Cons: No puedo leer hasta que se haya escrito un dato nuevo