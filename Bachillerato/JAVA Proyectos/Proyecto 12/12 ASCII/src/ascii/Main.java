package ascii;

import java.util.Scanner;
public class Main {

 
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     char car= 0;

        System.out.print("Escribe una palabra: ");

     do {
         
        try{ 
        car = (char) System.in.read();
            
            if ((int)car!= 32 )
            {
                if ((int)car != 10)
                {
                System.out.println("El codigo ASCII de " + car + " es " + (int)car);
                
                }
           }
         }
        catch (Exception e){}

     }while(car != 10);


        System.out.println("\nFin del Programa");
        System.out.println("Programa realizado por Angel Joaquin");





    }

}
