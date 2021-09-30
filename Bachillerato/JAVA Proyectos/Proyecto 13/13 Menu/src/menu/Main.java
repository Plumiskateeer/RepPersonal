
package menu;

import java.util.Scanner;
public class Main {

   public static int menu(){
       int opc;
       Scanner sc= new Scanner(System.in);
        System.out.println("Menu de opciones");
        System.out.println("-----------------------------------");
        System.out.println("1 -> Calcular área del rectángulo:");
        System.out.println("2 -> Calcular área del triángulo:");
        System.out.println("3 -> Calcular área del círculo:");
        System.out.println("4 -> Finalizar:");
        System.out.println("-----------------------------------");
        System.out.print("Introduzca comando: ");
        opc=sc.nextInt();
        return opc;
        
   }
   public static void rectangulo(){
       Scanner sc= new Scanner(System.in);
     System.out.print("Introduce base del rectángulo: ");
                    double b1 = sc.nextInt();
     System.out.print("Introduce altura del rectángulo: ");
                    double h1 = sc.nextInt();
     System.out.println("-----------------------------------");
     System.out.println("El área del rectángulo es: "+(b1*h1)+"\n\n");

   }
   public static void triangulo(){
       Scanner sc= new Scanner(System.in);
       System.out.print("Introduce base del triángulo: ");
                    double b2 = sc.nextInt();

       System.out.print("Introduce altura del triángulo: ");
                    double h2 = sc.nextInt();

       System.out.println("-----------------------------------");
       System.out.println("El área del triángulo es: "+(b2*h2)/2+"\n\n");

   }
   public static void circulo (){
       Scanner sc =new Scanner(System.in);
       System.out.print("Introduce radio del círculo: ");
                    double r = sc.nextInt();
       System.out.println("-----------------------------------");
       System.out.println("El área del círculo es: "+ (Math.PI)*(Math.pow(2,r))+"\n\n");
   }
   public static void finalizar(){
        System.out.println("Finalizando programa......");

        System.out.println("-----------------------------------");
        System.out.println("FIN DEL PROGRAMA");
        System.out.println("\nPrograma realizado por Ángel M Joaquín");
   }
    public static void main(String[] args) throws InterruptedException {
       Scanner sc= new Scanner(System.in);

        int n,a;

    do{
        
        a = menu();

        Thread.sleep(1000);
        if (a==1) rectangulo();
        if (a==2) triangulo();
        if (a==3) circulo();

        Thread.sleep(1000);
             //hacer con un switch

    }while(a!=4);

        finalizar();
        
    }

}
