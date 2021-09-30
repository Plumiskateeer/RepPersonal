
package tareadecasa01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.print ("Introduzca cantidad de material comprado: ");
        int c = sc.nextInt();

        if (c >= 100) System.out.println("Tu descuento es del 40%");
        else if  (c >= 25 ) System.out.println("Tu descuento es del 20%");
        else if  (c >= 10 ) System.out.println("Tu descuento es del 10%");
        else if  (c <= 10 ) System.out.println("No tienes ningun descuento");



}}
