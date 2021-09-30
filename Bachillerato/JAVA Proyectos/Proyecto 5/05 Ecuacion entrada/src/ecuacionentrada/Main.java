
package ecuacionentrada;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("PROGRAMA SOLVENTOR DE ECUACIONES DE SEGUNDO GRADO");

        System.out.println("-------------------------------------------------\n");

        System.out.print("a= ");
    double a = sc.nextInt();

        System.out.print("b= ");
    double b = sc.nextInt();


        System.out.print("c= ");
    double c = sc.nextInt();

        System.out.println("SOLUCIONES: ");

        System.out.println((-b)+(Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a));

        System.out.println((-b)-(Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a)+"\n");

        System.out.println("Programa realizado por Angel Manuel Joaquin");













    }

}
