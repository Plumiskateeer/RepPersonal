package jardines;

public class Puerta extends Thread{
    private Contador c;

    public Puerta(Contador c){
        this.c = c;
    }

    public void run(){
       for(int i = 0; i < 10000; i++){
           try {
               c.inc();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
