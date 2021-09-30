package borrarobjetos;
public class Rectangulo {
private Punto pto1,pto2;

   void fijarpto1(int i,int j){
       pto1.fijar(i, j);
   }
   void fijarpto2(int i,int j){
       pto2.fijar(i, j);
   }
   void mostrar(){
      System.out.println("Punto A del rectangulo :("+pto1.posX()+","+pto1.posY()+")");
      System.out.println("Punto C del rectangulo :("+pto2.posX()+","+pto2.posY()+")");
   }
   void moverpto1(int i, int j){
        pto1.moverH(i);
        pto1.moverV(j);
    }
    void mostraraltura(){
        if(pto1.posY()>pto2.posY())
            System.out.println("El lado b del rectangulo mide: "+(pto1.posY()-pto2.posY())+" cm");
        else
            System.out.println("El lado b del rectangulo mide: "+(pto2.posY()-pto1.posY())+" cm");
    }
    void mostrarlargo(){
        if(pto1.posX()>pto2.posX())
            System.out.println("El lado a del rectangulo mide: "+(pto1.posX()-pto2.posX())+" cm");
        else
            System.out.println("El lado a del rectangulo mide: "+(pto2.posX()-pto1.posX())+" cm");
    }
    void arearectangulo(){
        double a = Math.pow((pto1.posX()-pto2.posX()),2);
        double b = Math.pow((pto1.posY()-pto2.posY()),2);
        System.out.println("El area del rectangulo es:  "+Math.pow((Math.pow(a,2)+Math.pow(b,2)),0.5));
    }
    Rectangulo(Punto p1,Punto p2){
        p1=new Punto();
        p2=new Punto();
        pto1.fijar(p1.posX(), p1.posY());
        pto2.fijar(p2.posX(), p2.posY());
        arearectangulo();

    }

}
