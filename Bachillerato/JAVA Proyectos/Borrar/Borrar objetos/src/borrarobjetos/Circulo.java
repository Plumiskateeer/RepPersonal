package borrarobjetos;
public class Circulo {
private int radio;
private Punto c;

 void fijarCentro(int i,int j)
    {   c.fijar(i, j);    }

 void fijarRadio(int i)
    {   radio = i;
    }

 void moverCentro(int i,int j){ c.moverH(i); c.moverV(j); }

 void Radio(int i){ radio+=i; }

 double area()
    {
    double area;
    area = (radio*radio*Math.PI);
    return area;
    }

 double perimetrocircunferencia()
    {
    double longitud;
    longitud = (2*radio*Math.PI);
    return longitud;
    }

    Circulo(){
    c=new Punto();

    }
    Circulo(int x,int y,int r){
    c=new Punto();
    c.fijar(x, y);
    radio=r;
   }
}
