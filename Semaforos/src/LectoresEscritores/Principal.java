package LectoresEscritores;

public class Principal {
    public static void main(String[]args) throws InterruptedException {
        BaseDeDatos b = new BaseDeDatos();
        Escritor [] e = new Escritor[4];
        Lector [] l = new Lector[20];

        for(int i = 0; i<e.length; i++){
            e[i] = new Escritor(i,b);
        }
        for(int i = 0; i<l.length; i++){
            l[i] = new Lector(i,b);
        }
        for(Escritor x : e){
            x.start();
        }
        for(Lector x : l){
            x.start();
        }
        for(Escritor x : e){
            x.join();
        }
        for(Lector x : l){
            x.join();
        }
    }
}
