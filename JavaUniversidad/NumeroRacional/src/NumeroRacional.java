
import java.lang.Object;

public class NumeroRacional {

private int numerador, denominador;

public NumeroRacional() {
numerador= 0 ;
denominador = 0;
}

public NumeroRacional(int numerador,int denominador) {

if(denominador == 0) {

throw new RuntimeException("El denominador no puede ser 0");

}else if(denominador < 0) {

this.numerador = denominador;
this.denominador = numerador;

}else {

this.numerador = numerador;
this.denominador = denominador;

}
}

public int getNumerador(){
return numerador;
}

public int getDenominador(){
return denominador;
}

public static NumeroRacional sumar(NumeroRacional a, NumeroRacional b){
NumeroRacional c = new NumeroRacional();
c.numerador=a.numerador*b.denominador+b.numerador*a.denominador;
c.denominador=a.denominador*b.denominador;
return c;
}

public NumeroRacional restar(NumeroRacional a, NumeroRacional b){
NumeroRacional c=new NumeroRacional();
c.numerador=a.numerador*b.denominador-b.numerador*a.denominador;
c.denominador=a.denominador*b.denominador;
return c;
}

public NumeroRacional multiplica(NumeroRacional a, NumeroRacional b) {
NumeroRacional c = new NumeroRacional();
c.numerador=a.numerador*b.numerador;
c.denominador=a.denominador*a.denominador;
return c;
}

public NumeroRacional inversa(NumeroRacional a){
return new NumeroRacional(a.denominador, a.numerador);
}

public NumeroRacional dividir(NumeroRacional a, NumeroRacional b){
return new NumeroRacional(a.numerador*b.denominador, a.denominador*b.numerador);
}

public int mcd(){
int dividendo = Math.abs(numerador);
int divisor = Math.abs(denominador);
int resto = 1;

while(resto!=0) {
resto=dividendo%divisor;
dividendo=divisor;
divisor=resto;
}

return divisor;
}

public NumeroRacional simplificar(){
int dividir=mcd();
numerador/=dividir;
denominador/=dividir;
return this;
}
}