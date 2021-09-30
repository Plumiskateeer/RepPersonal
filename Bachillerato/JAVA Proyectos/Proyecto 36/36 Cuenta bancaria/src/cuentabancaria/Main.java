
package cuentabancaria;
import java.util.*;

public class Main {
public static int menucc(){
    Scanner sc= new Scanner(System.in);
   System.out.println("1: Cambiar titular");
   System.out.println("2: Ingresar saldo");
   System.out.println("3: Retirar saldo");
   System.out.println("4: Mostrar detalles de la cuenta");
   System.out.println("5: Salir");
   System.out.print("------------> ");
   return sc.nextInt();

}
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int opc=0;
        String titular;
        double saldo;
        CuentaCorriente cc;

       System.out.print("Nombre de la cuenta: ");
       titular=sc.next();
       System.out.print("Saldo inicial de la cuenta: ");
       saldo=sc.nextInt();
       cc= new CuentaCorriente(titular,saldo);
  do{
       opc=menucc();
      
       switch(opc){
     case 1:{
     System.out.print("Nuevo nombre de la cuenta: ");
       titular=sc.next();
         cc.cambiarTitular(titular);}
     break;
     case 2: {
         System.out.print("Saldo a ingresar en la cuenta: ");
         saldo=sc.nextDouble();
         cc.ingresar(saldo);
     } break;
     case 3: if(!cc.enRojo()){
         System.out.print("Saldo a retirar en la cuenta: ");
         saldo=sc.nextDouble();
         cc.retirar(saldo);
     }
         else System.out.println("ESTAS EN NUMEROS ROJOS");
             break;
     case 4:{

         System.out.println("Cuenta: "+cc.verTitular());
         System.out.println("Saldo: "+cc.saldo());
          }break;
     case 5: finalizar();break;
       }

        } while (opc != 5);
}
    
public static void finalizar(){
    System.out.println("-----------------------------");
    System.out.println("Fin del programa");
    System.out.println("Programa realizado por Angel Joaquin");
    System.out.println("-----------------------------");
    
}    
    
    
}
