public class Ejercicio3 {

    static class VariableCompartida {
        private int v;

        public VariableCompartida() {
            this.v = 0;
        }

        public int get() {
            return this.v;
        }

        public void set(int v) {
            this.v = v;
        }
    }

    static class Hebra extends Thread {
        private VariableCompartida vc;

        public Hebra(VariableCompartida vc) {
            this.vc = vc;
        }

        public void run() {
            for(int i = 0; i <= 99; i++){
                System.out.println(vc.get());
            }
        }
    }

    static class Hebra2 extends Thread {
        private VariableCompartida vc;

        public Hebra2(VariableCompartida vc) {
            this.vc = vc;
        }

        public void run() {
            for(int i = 0; i <= 99; i++) {
                vc.set(i);


            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        VariableCompartida vc = new VariableCompartida();
        Hebra h1 = new Hebra(vc);
        Hebra2 h2 = new Hebra2(vc);

            h1.start();
            h2.start();
            h1.join();
            h2.join();
    }
}
