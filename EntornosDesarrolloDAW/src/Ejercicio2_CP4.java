import java.util.Scanner;

public class Ejercicio2_CP4 {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer numero: ");
        int num1 = sc.nextInt();

        System.out.println("Introduce el segundo numero: ");
        int num2 = sc.nextInt();

        if(num1 < num2) System.out.println("El mayor es: " + num1);
            else if (num1 == num2) System.out.println("Son iguales");
                else System.out.println("El mayor es: " + num2);
    }
}