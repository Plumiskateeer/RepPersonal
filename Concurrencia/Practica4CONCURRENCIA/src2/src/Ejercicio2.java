public class Ejercicio2 {
    static class VariableCompartida {
        private int v;

        public VariableCompartida(){
            this.v = 0;
        }

        public int get(){
            return this.v;
        }

        public void set(int v){
            this.v = v;
        }

        public void inc(){
            this.v = this.v + 1;
        }
    }
    static class Hebra extends Thread{
        int nInc;
        VariableCompartida vc;

        public Hebra(VariableCompartida vc, int i){
            this.nInc = i;
            this.vc = vc;
        }

        public void run(){
            for(int i = 0; i < nInc; i++){
                vc.inc();
            }
        }
    }
    public static void main(String[]args) throws InterruptedException {
        VariableCompartida vc = new VariableCompartida();
        // A veces se obtiene el valor correcto y otras no, puede ser porque se este accediendo
        // de manera incorrecta a la hora de incrementar
        Hebra h1 = new Hebra(vc,650);
        Hebra h2 = new Hebra(vc,151);

        h1.start();
        h2.start();

        h1.join();
        h2.join();

        System.out.print(vc.get());
    }
}