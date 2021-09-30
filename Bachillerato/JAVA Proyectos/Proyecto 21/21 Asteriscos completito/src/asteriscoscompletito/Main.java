

package asteriscoscompletito;
import java.util.Scanner;
public class Main {
//* --------------------------------------------------------------------
             //* -----------------MENU------------------
    public static void menu()
    {
        System.out.println("\n-----------------------------");
        System.out.println("1: Fila de asteriscos");
        System.out.println("2: Cuadrado de asteriscos");
        System.out.println("3: Triangulo 1 de asteriscos");
        System.out.println("4: Triangulo 2 de asteriscos");
        System.out.println("5: Piramide de asteriscos");
        System.out.println("6: Piramide de numeros");
        System.out.println("7: Piramide de numeros 2");
        System.out.println("8: Salir");
        System.out.println("-----------------------------");
 }

    //* -----------------------------------------
    public static void primero()
    {
        Scanner sc= new Scanner(System.in);
        int i,n;
        System.out.print("Definir numero de asteriscos: ");
        n=sc.nextInt();
        for (i=1;i<=n;i++){

            System.out.print("* ");
        }

    }

    //* ------------------------------------------
    public static void segundo()
    {
        Scanner sc= new Scanner(System.in);
        int i,n,j;
        System.out.print("Definir lado del cuadrado de asteriscos: ");
        n=sc.nextInt();

        for (i=1;i<=n;i++){
            System.out.println();
            for (j=1;j<=n;j++)
                System.out.print("* ");
        }
    }

    //* ------------------------------------------
    public static void tercero()
    {
        Scanner sc= new Scanner(System.in);
        int i,n,j;
        System.out.print("Definir triangulo de asteriscos 1: ");
        n=sc.nextInt();

        for (i=1;i<=n;i++){
            System.out.println();
            for (j=1;j<=i;j++)
                System.out.print("* ");

        }
    }

    //* ------------------------------------------
    public static void cuarto()
    {
        Scanner sc= new Scanner(System.in);
        int i,n,j;
        System.out.print("Definir triangulo de asteriscos 2: ");
        n=sc.nextInt();

        for (i=1;i<=n;i++){
            System.out.println();
            for (j=n;j>=i;j--){
                System.out.print("* ");
            }
        }

    }

    //* ------------------------------------------
    public static void quinto()
    {
        Scanner sc= new Scanner(System.in);
        int i,n,j;
        System.out.print("Definir piramide de asteriscos : ");
        n=sc.nextInt();

       for (i=1;i<=n;i++){
            for (j=n;j>=i;j--){
                System.out.print(" ");
                              }
            for (j=i;j<=(2*i)-1;j++){System.out.print("* ");}

           System.out.println();
        }

    }

     //* ------------------------------------------
    public static void sexto()
    {
        Scanner sc= new Scanner(System.in);
        int i,n,j;
        System.out.print("Definir piramide de numeros: ");
        n=sc.nextInt();

        for (i=1;i<=n;i++){
            System.out.println();
            for (j=n;j>=i;j--){
                System.out.print(" ");

           }
           for (j=i;j<=(2*i)-1;j++){
               System.out.print((j%10)+" ");
           }
        }
    }

    //* ------------------------------------------
    public static void septimo()
    {
        Scanner sc= new Scanner(System.in);
        int i,n,j;
        System.out.print("Definir piramide de numeros 2: ");
        n=sc.nextInt();

        for (i=1;i<=n;i++){
            System.out.println();
            for (j=n;j>=i;j--){
                System.out.print("  ");

           }
           for (j=i;j<=(2*i)-1;j++){
               System.out.print((j%10)+" ");
           }
           for (j=(2*i)-2;j>=i;j--){
               System.out.print((j%10)+" ");
           }
        }

    }

    //* ---------------FINALIZAR------------------
    public static void octavo()
    {
        System.out.println("------------------------------------");
        System.out.println("Fin del programa");
        System.out.println("Realizado por Angel Joaquin");
        System.out.println("------------------------------------");
    }

    //* ---------------PRINCIPAL------------------
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int opc;
        System.out.println("PROGRAMA GENERADOR DE PIRAMIDES Y TRIANGULOS");
        System.out.println("--------------------------------------------");

        do {
            menu();
            System.out.print("Introduce un comando a ejecutar: ");
            opc = sc.nextInt();

        switch(opc){
            case 1: primero();
            break;
            case 2: segundo();
            break;
            case 3: tercero();
            break;
            case 4: cuarto();
            break;
            case 5: quinto();
            break;
            case 6: sexto();
            break;
            case 7: septimo();
        }

        }while(opc!=8);

        octavo();
 }

}


//* ----------------------------------------------------------------------------