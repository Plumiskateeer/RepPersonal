import java.awt.datatransfer.SystemFlavorMap;

public class Jardin {
    private static int cont = 0; //visitantes del jardin

    static class Puerta extends Thread{
        public void run(){
            for(int i = 0; i<1000; i++){
                cont++; //cada vez que se itera entra un nuevo visitante
            }
        }
    }
    public static void main(String[]args) throws InterruptedException {
        Puerta p1 = new Puerta();
        Puerta p2 = new Puerta();
        p1.start();
        p2.start();

        p1.join();
        p2.join();

        System.out.println("Han entrado " + cont);
    }
}
