package cuentabancaria;
public class CuentaCorriente {
private String titular;
private double saldo;
//--------------------------------------------------------

public String verTitular (){ return titular; }
public double saldo () { return saldo; }
public void ingresar (double cantidad){ saldo+=cantidad; }
public void retirar (double cantidad) { if(saldo>0) saldo-=cantidad; }
public boolean enRojo() { return saldo<0; }
public void cambiarTitular (String nombre){ titular=nombre;}

//--------------------------------------------------------
 CuentaCorriente(String n){
     
    titular= n;
    saldo=0;
}
 CuentaCorriente(String n,double s){
     
    titular= n;
    saldo= s;
    
}
}
