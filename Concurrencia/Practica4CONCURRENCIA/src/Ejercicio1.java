public class Ejercicio1 {

    static class Hebra extends Thread{
        private char letra;
        private int times;

        public Hebra(char c, int i){
            letra = c;
            times = i;
        }

        public void run(){
            for(int i = 0; i<times; i++)
            System.out.print(this.letra);
        }
    }
    public static void main(String[]args){
        Hebra h1 = new Hebra('A',2);
        Hebra h2 = new Hebra('B',5);
        Hebra h3 = new Hebra('C',3);

        h1.start();
        h2.start();
        h3.start();
    }
}
