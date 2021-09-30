package ejerciciocreadopormi;
import java.util.Scanner;
public class Main {
//**----------------------------------------------------------------------------
 public static void finalizar(){

          System.out.println("--------------------------------------------");
          System.out.println("Programa finalizado");
          System.out.println("Realizado por Angel Joaquin");
          System.out.println("--------------------------------------------");
}
//**----------------------------------------------------------------------------
    public static int menu()
{       Scanner sc= new Scanner(System.in);
         int n;
          System.out.println("\n1-->Construir piramide: ");
          System.out.println("2-->Grada de estadio de beisbol)(con asientos de repuesto): ");
          System.out.println("3-->EXIT :");
          do{
          System.out.println("--------------------------------------------");
          System.out.print("OPCION: ");
            n=sc.nextInt();
          System.out.println("--------------------------------------------");
          return n;
          }while(n!=3);

    }
//**----------------------------------------------------------------------------
    public static int Contarfilas(int x)
    {
        int i,ct=1;
        for(i=1;i<=x;i++){
            ct=ct+i;
            if(ct>x)return ct;
                         }
         return ct;
    }
//**----------------------------------------------------------------------------
    public static void grada()
     {
        Scanner sc= new Scanner(System.in);
        String t;
        int a,i,j,k=0,b;

        System.out.print("FRASE/PALABRA/NUMEROS/SIGNOS DE PUNTUACION : ");
        t=sc.next();
        b=(t.length());
        a=Contarfilas(b);

         for (i=1;i<=a;i++){
              for (j=(b);j>=i;j--){
                System.out.print(" ");
                              }
            if(k<t.length()){
                    if(t.charAt(k)!='\n')
                        System.out.print(t.charAt(k));
                        k++;
                             }
              for (j=1;j<=(2*b)+1;j++){

                  System.out.print("/./");
             }

              if(k<t.length()){
                    if(t.charAt(k)!='\n')
                        System.out.print(t.charAt(k));
                        k++;
                        }
           if(k<t.length())System.out.println();
        }

}
//**----------------------------------------------------------------------------
    public static void piramide()
{
        Scanner sc= new Scanner(System.in);
        String t;
        int a,i,j,k=0,b;

        System.out.print("FRASE|||PALABRA|||NUMEROS|||SIGNOS DE PUNTUACION : ");
        t=sc.next();
        b=(t.length());
        a=Contarfilas(b);

        for (i=1;i<=a;i++){
              for (j=(b);j>=i;j--){
                System.out.print(" ");
                              }
                for (j=i;j<=(2*i)-1;j++){
                if(k<t.length()){
                    if(t.charAt(k)!='\n')
               System.out.print(t.charAt(k)+" ");
                k++;}
            }
           if(k<t.length())System.out.println();
        }

}
//**----------------------------------------------------------------------------
    public static void main(String[] args)
                                         throws InterruptedException{
        int a,i;
        System.out.println("PROGRAMA QUE TRABAJA CON NUMEROS Y LETRAS (EN EL IDE FUNCIONA MUCHO MEJOR JOSEDIEGO)");
        do{
         a=menu();
         switch(a){
        case 1:piramide();break;
        case 2:grada();break;
       }
      }while(a!=3);
        System.out.print("FINALIZANDO");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        for(i=1;i<=10;i++){
        System.out.print(".");
        }
        System.out.print(".\n");
        finalizar();
 }
}

//**----------------------------------------------------------------------------
