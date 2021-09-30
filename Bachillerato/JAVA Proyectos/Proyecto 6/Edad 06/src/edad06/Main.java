
package edad06;

import java.util.Scanner;

public class Main {

 
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);

        System.out.println("PROGRAMA PARA IDENTIFICAR MENORES DE EDAD");
        System.out.println("-----------------------------------------");

        System.out.print("Introduzca su edad: ");
        int edad = sc.nextInt();

    if (edad < 18){

        System.out.println("\nTodavia eres menor de edad");

        System.out.println("Te quedan "+ (18 - edad ) + " años para tener los 18");
    }
        else System.out.println("Felicidades, puedes pasar a las discotecas sin tus padres");



        System.out.println("\nFIN DEL PROGRAMA");
        System.out.println("Programa realizado por Angel Manuel Joaquin");
    

}}
