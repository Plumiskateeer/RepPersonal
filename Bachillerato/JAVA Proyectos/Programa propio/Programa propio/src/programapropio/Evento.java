package programapropio;
import java.util.*;
public class Evento implements java.io.Serializable{
//------------------------------------------------------------------------------
private Calendar Fecha;
private int Precio;
private String Evento;
//------------------------------------------------------------------------------
  void añadirevento(ArrayList <Evento> m,Evento Datos){ m.add(Datos); }
//------------------------------------------------------------------------------
  void fijarfecha(int dia, int año, int mes){ Fecha.set(año,mes,dia); }
//------------------------------------------------------------------------------
  void cambiarfecha(int c,int dia, int año, int mes){ Fecha.set(año,mes,dia); }
//------------------------------------------------------------------------------
  void fijarnombre(String i){Evento=i;}
//------------------------------------------------------------------------------
  void fijarprecio(int i){
       Precio=i;
   }
//------------------------------------------------------------------------------
  String mostrarnombre(){  return Evento;  }
//------------------------------------------------------------------------------
  int mostrarprecio(){ return Precio; }
//------------------------------------------------------------------------------
  int mostrardiafecha(){ return Fecha.get(Fecha.DAY_OF_MONTH); }
//------------------------------------------------------------------------------
  int mostrarmesfecha(){ return Fecha.get(Fecha.MONTH); }
//------------------------------------------------------------------------------
  int mostrarañofecha(){ return Fecha.get(Fecha.YEAR); }
//------------------------------------------------------------------------------
                               Evento()
             {
                        Evento=" "; Precio=0;
                    Fecha= new GregorianCalendar();
                                                         }
}
//------------------------------------------------------------------------------