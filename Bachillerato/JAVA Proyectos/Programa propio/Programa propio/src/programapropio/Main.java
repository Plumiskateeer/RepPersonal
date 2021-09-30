package programapropio;
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
//------------------------------------------------------------------------------
   public static int menu()
{
   Scanner sc= new Scanner(System.in);
   System.out.print
  ("--------------------------------------------   "+"\n"+
   "                PROGRAM                        "+"\n"+
   "--------------------------------------------   "+"\n"+
   "            1: Añadir evento                   "+"\n"+
   "            2: Borrar evento                   "+"\n"+
   "            3: Mostrar eventos                 "+"\n"+
   "            4: Editar evento                   "+"\n"+
   "--------------------------------------------   "+"\n"+
   "                 FILE                          "+"\n"+
   "--------------------------------------------   "+"\n"+
   "      5: Guardar en fichero                    "+"\n"+
   "      6: Mostrar lo guardado en el fichero     "+"\n"+
   "--------------------------------------------   "+"\n"+
   "       0: Salir                                "+"\n"+
   "--------------------------------------------   "+"\n"+
   "----->");
   return sc.nextInt();
}
//------------------------------------------------------------------------------
   public static void main(String[] args)throws FileNotFoundException, IOException
{
     int opc;
     ArrayList<Evento>m= new ArrayList<Evento>();

     do{
         opc= menu();
         switch(opc) {
             case 1: añadirevento(m);break;
             case 2: borrarevento(m);break;
             case 3: mostrartodo(m);break;
             case 4: editarevento(m);break;
             case 5: guardarfichero(m);break;
             case 6: leerfichero(m);break;
                    }
       }while(opc!=0);
     finalizar();
}
//------------------------------------------------------------------------------
   public static void mostrartodo(ArrayList <Evento> m)
    {
        int i=0;

        Iterator it = m.iterator();
        if (!it.hasNext())
            System.out.println("No hay ningun evento en su agenda"+"\n");
        else
         while (it.hasNext())
         {
            it.next();
            System.out.println("--------------------------------------------");
            System.out.println
                    ("Evento Nº: " +(i)+"\n"+
                     "Nombre: " +m.get(i).mostrarnombre()+"\n"+
                     "Precio: " +m.get(i).mostrarprecio() +"\n"+
                     "Fecha: "+m.get(i).mostrardiafecha()
                     +"/"+m.get(i).mostrarmesfecha()
                     +"/"+m.get(i).mostrarañofecha());
            System.out.println("--------------------------------------------");
            i++;
         }
    }
//------------------------------------------------------------------------------
   public static void mostrar(ArrayList <Evento> m,int c)
    {       System.out.println("--------------------------------------------");
            System.out.println
                    ("Evento Nº: " +(c)+"\n"+
                     "Nombre: " +m.get(c).mostrarnombre()+"\n"+
                     "Precio: " +m.get(c).mostrarprecio() +"\n"+
                     "Fecha: "+m.get(c).mostrardiafecha()
                     +"/"+m.get(c).mostrarmesfecha()
                     +"/"+m.get(c).mostrarañofecha());
            System.out.println("--------------------------------------------");
  }
//------------------------------------------------------------------------------
   public static void añadirevento(ArrayList <Evento> m)
{       Scanner sc= new Scanner(System.in);
        Evento Datos;
        Datos=new Evento();
        int dia,año,mes,precio;
        String nombre;

        System.out.println("-------------------");
        System.out.print("Ingrese el nombre del evento: ");
        nombre=sc.nextLine();
        Datos.fijarnombre(nombre);
        System.out.print("Ingrese el precio: ");
        precio=sc.nextInt();
        Datos.fijarprecio(precio);

        System.out.print("Introduzca el dia del evento: ");
        dia= sc.nextInt();

        System.out.print("Introduzca el mes del evento: ");
        mes= sc.nextInt();

        System.out.print("Introduzca el año del evento: ");
        año= sc.nextInt();

        Datos.fijarfecha(dia, año, mes);
        Datos.añadirevento(m,Datos);
    }
//------------------------------------------------------------------------------
   public static void editarevento(ArrayList<Evento>m)
{      Scanner sc= new Scanner(System.in);
       int c,k,p,precio;
       String i;
       Iterator it = m.iterator();
       
       if (!it.hasNext())
            System.out.println("No hay ningun evento en su agenda"+"\n");
       else{
       do{
       System.out.print("Evento que quieres editar:||-1 para salir|| ");
       c= sc.nextInt();
       if(c!=-1){
       mostrar(m,c);
       System.out.print("¿Es este el evento que desea editar?||1 si||2 no||: ");
       k= sc.nextInt();
       if(k==1)
         {
          do{
            System.out.print
            ("Propiedad que desea cambiar: ||1 Nombre ||2 Precio||3 Fecha||-1 Salir||: ");
             p=sc.nextInt();
        switch(p){
            case 1:{
                System.out.print("Introducir nuevo nombre del evento: ");
                i=sc.next();
                m.get(c).fijarnombre(i);
         }break;
            case 2:{
               System.out.print("Introducir nuevo precio del evento: ");
               precio=sc.nextInt();
               m.get(c).fijarprecio(precio);
        }break;
            case 3: cambiarfecha(m,c); break;
                }

            }while(p!=-1);
         }}
         }while(c!=-1);
}}
//------------------------------------------------------------------------------
   public static void borrarevento(ArrayList<Evento>m)
{
        Scanner sc= new Scanner(System.in);

        int c,k;
        Iterator it = m.iterator();

        if (!it.hasNext())
            System.out.println("No hay ningun evento en su agenda"+"\n");
       else{
        do{
        System.out.print("Evento que quieres borrar:||-1 para salir||: ");
        c= sc.nextInt();
        if(c!=-1){
        mostrar(m,c);
        System.out.print("¿Es este el evento que desea borrar?||1 si||2 no||: ");
        k= sc.nextInt();
        if(k==1)m.remove(c);
        }
         }while(c!=-1);
}}
//------------------------------------------------------------------------------
   public static void cambiarfecha(ArrayList <Evento> m,int c)
{       Scanner sc= new Scanner(System.in);
        int dia,año,mes;

        System.out.print("Introduzca el dia del evento: ");
        dia= sc.nextInt();

        System.out.print("Introduzca el mes del evento: ");
        mes= sc.nextInt();

        System.out.print("Introduzca el año del evento: ");
        año= sc.nextInt();

        m.get(c).cambiarfecha(c,dia,mes,año);

}
//------------------------------------------------------------------------------
   public static void leerfichero(ArrayList<Evento>m)
{
       int i=0;
       try
        {
            // Se crea un ObjectInputStream
            File miDir = new File (".");
            String fichero = miDir.getCanonicalPath() + "\\agenda.dat";
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));

            // Se lee el primer objeto
            Object aux = ois.readObject();

            // Mientras haya objetos
            while (aux!=null)
            {
                if (aux instanceof Evento)
                    m.add((Evento)aux);

            System.out.println("--------------------------------------------");
            System.out.println("Evento Nº: " +(i)+"\n"+
                     "Nombre: " +m.get(i).mostrarnombre()+"\n"+
                     "Precio: " +m.get(i).mostrarprecio() +"\n"+
                     "Fecha: "+m.get(i).mostrardiafecha()
                     +"/"+m.get(i).mostrarmesfecha()
                     +"/"+m.get(i).mostrarañofecha());
            System.out.println("--------------------------------------------");

         i++;
                
                aux = ois.readObject();
            }
            ois.close();
        }
        catch (EOFException e1)
        {
            System.out.println ("Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
	}
//------------------------------------------------------------------------------
    public static void guardarfichero(ArrayList<Evento>m){
       {int ct;

     File miDir = new File (".");

     try {
            String fichero = miDir.getCanonicalPath() + "\\agenda.dat";
            System.out.println ("Fichero actual: " + fichero);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));

            for (ct=0; ct<m.size(); ct++)
            {
                oos.writeUnshared(m.get(ct));
            }
            oos.close();
       }
     catch(Exception e) {
           e.printStackTrace();
     }}}
//------------------------------------------------------------------------------
    
    public static void finalizar()
{
    System.out.println("-----------------------------");
    System.out.println("Fin del programa");
    System.out.println("Programa realizado por Angel Joaquin");
    System.out.println("-----------------------------");
}

//------------------------------------------------------------------------------

}

