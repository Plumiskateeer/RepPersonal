import java.util.Scanner;

public class Ejercicio4_CP4 {
    public static void main(String[]args){
        int num1,num2;

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Introduce el numero: ");
            num1 = sc.nextInt();
            System.out.println("Introduce el numero: ");
            num2 = sc.nextInt();
        }while(num1!=num2);

        System.out.println("Los numeros son iguales");
    }
}
