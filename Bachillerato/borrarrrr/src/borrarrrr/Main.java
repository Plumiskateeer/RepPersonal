package borrarrrr;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
       Scanner sc= new Scanner(System.in);
        Punto p1;
        Circulo c1;
        int sizex,sizey,x,y,r;
        
       p1 = new Punto();
       
 /*
       System.out.print("Cuanto quieres mover en horizontal el punto??: ");
       sizex=sc.nextInt();

       System.out.print("Cuanto quieres mover en vertical el punto??: ");
       sizey=sc.nextInt();

       p1.moverH(sizex);
       p1.moverV(sizey);

       System.out.println("Posicion: ("+p1.posX()+","+p1.posY()+")");
     */
       System.out.print("Fijar x del centro: ");
       x=sc.nextInt();
       System.out.print("Fijar y del centro: ");
       y=sc.nextInt();
       System.out.print("Fijar radio: ");
       r=sc.nextInt();
       
       c1= new Circulo(x,y,r);

       System.out.println("Centro:"+"("+x+","+y+")");
      
       
    }




}
