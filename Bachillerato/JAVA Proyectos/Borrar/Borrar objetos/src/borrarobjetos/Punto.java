package borrarobjetos;
public class Punto {
private int x,y;

    void fijar(int i,int j)
    {
    x = i;
    y = j;
    }
    int posX(){  return x;  }
    int posY(){  return y;  }


    void moverV(int size){ y+=size; }
    void moverH(int size){ x+=size; }
}
