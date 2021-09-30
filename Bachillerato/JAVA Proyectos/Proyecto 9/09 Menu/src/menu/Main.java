
package menu;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("Menu de opciones");
        System.out.println("-----------------------------------");
        System.out.println("1 -> Calcular área del rectángulo:");
        System.out.println("2 -> Calcular área del triángulo:");
        System.out.println("3 -> Calcular área del círculo:");
        System.out.println("4 -> Finalizar:");
        System.out.println("-----------------------------------");

        System.out.print("Introduzca comando: ");
        int n = sc.nextInt();
        System.out.println("-----------------------------------");

            switch (n)

        {
                case 1:
                    System.out.print("Introduce base del rectángulo: ");
                    double b1 = sc.nextInt();
                    System.out.print("Introduce altura del rectángulo: ");
                    double h1 = sc.nextInt();
                    System.out.println("-----------------------------------");
                    System.out.println("El área del rectángulo es: "+(b1*h1));
                break;

                case 2:
                    System.out.print("Introduce base del triángulo: ");
                    double b2 = sc.nextInt();

                    System.out.print("Introduce altura del triángulo: ");
                    double h2 = sc.nextInt();

                    System.out.println("-----------------------------------");
                    System.out.println("El área del triángulo es: "+(b2*h2)/2);
                 break;

                 case 3:
                    System.out.print("Introduce radio del círculo: ");
                    double r = sc.nextInt();
                    System.out.println("-----------------------------------");
                    System.out.println("El área del círculo es: "+ (Math.PI)*(Math.sqrt(r)));
                    break;
                    
                 case 4:
                    System.out.println("Finalizando programa......");
                    break;


        }

                    System.out.println("-----------------------------------");
                    System.out.println("FIN DEL PROGRAMA");
                    System.out.println("\nPrograma realizado por Ángel M Joaquín");

    
    
    
    }


}
