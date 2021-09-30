
package nota;

import java.util.Scanner;

public class Main {

   
    public static void main(String[] args) {

     Scanner sc= new Scanner(System.in);

    System.out.println("PROGRAMA PARA AVERIGUAR TU NOTA");
    System.out.println("-------------------------------");

     System.out.print("\nIntroduzca su nota: ");
             int nota = sc.nextInt();

            String sb = "Sobresaliente";
            String nt = "Notable";
            String bn = "Bien";
            String su = "Suficiente";
            String in = "Insuficiente";

    
     if (nota < 0){

        System.out.println("\nNota no valida, introduce una nota de 0 a 10");      
        }
    else if(nota < 5){

        System.out.print(in);
        System.out.println("\nMUY MAL");
    }
    else if (nota < 7 ){
        System.out.print(bn);
        System.out.println("\nRegularcillo");

    }
    else if (nota == 5 ){
        System.out.print(su);
        System.out.println("\nMehhhhh");
    }
    else if (nota < 9 ){
        System.out.print(nt);
        System.out.println("\nVa mejorando la cosa");

    }
    else if (nota <=10){

        System.out.print(sb);
        System.out.println("\nLike a boss");


    }
   else if (nota >10){

        System.out.println("\nNota no valida, introduce una nota de 0 a 10");      

    }


     System.out.println("\nFIN DEL PROGRAMA");
     System.out.println("Programa realizado por Angel Manuel Joaquin");


    }}


    

