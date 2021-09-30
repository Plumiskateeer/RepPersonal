public class Peterson {
    private static volatile boolean f0 = false;
    private static volatile boolean f1 = false;
    private static volatile int turno = 0;
    private static int cont = 0;

    static class Puerta0 extends Thread{
        public void run(){
            for(int i = 0; i<1000; i++){
                //SNC0

                //PRE0
                f0 = true;
                turno = 1;
                while(turno == 1 && f1){
                    Thread.yield();
                }
                //SC0
                cont++;
                //POST0
                f0 = false;
            }
        }
    }
    static class Puerta1 extends Thread{
        public void run(){
            for(int i = 0; i<1000; i++){
                //SNC1

                //PRE1
                f1 = true;
                turno = 0;
                while(turno == 0 && f0){
                    Thread.yield();
                }
                //SC1
                cont++;
                //POST1
                f1 = false;
            }
        }
    }
    public static void main(String []args) throws InterruptedException {
        Puerta1 h1 = new Puerta1();
        Puerta0 h0 = new Puerta0();

        h0.start();
        h1.start();

        h0.join();
        h1.join();

        System.out.print("Han entrado: " + cont);
    }
}
