

package entrada;
import java.util.Scanner;

public class Main {

 
    public static void main(String[] args) {

                    Scanner sc= new Scanner(System.in);


      System.out.print("Introduzca dato 1: ");

 int dato1 = sc.nextInt();

      System.out.print("Introduzca dato 2: ");
      
      
 int dato2 = sc.nextInt();

      System.out.print("\n"+"dato nº1 ="+dato1+"\n");

      System.out.print("dato nº2 ="+dato2+"\n");
    

  int sol1=dato1 + dato2;
  int sol2=dato1 - dato2;
  int sol3=dato1 * dato2;
  int sol4=dato1 / dato2;


     System.out.println(dato1 + " + " + dato2+ " = "+ sol1);

     System.out.println(dato1 + " - " + dato2+ " = "+ sol2);

     System.out.println(dato1 + " * " + dato2+ " = "+ sol3);

     System.out.println(dato1 + " / " + dato2+ " = "+ sol4+"\n");
     
     System.out.println("Programa realizado por Angel Manuel Joaquin");

    }

}
