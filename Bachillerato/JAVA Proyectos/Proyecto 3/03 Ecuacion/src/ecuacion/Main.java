
package ecuacion;

public class Main {

    public static void main(String[] args) {
    double a=1.0;
    double b=0.0;
    double c=-4.0;
        System.out.println("PROGRAMA QUE RESUELVE ECUACION DE SEGUNDO GRADO");

        System.out.println("-----------------------------------------------\n");

        System.out.println("a ="+a);

        System.out.println("b ="+b);

        System.out.println("c ="+c+"\n");

        System.out.println("SOLUCIONES :");

        System.out.println((-b)+(Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a));

        System.out.println((-b)-(Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a)+"\n");

        System.out.println("Programa realizado por Angel Joaquin");
        



    }

}
