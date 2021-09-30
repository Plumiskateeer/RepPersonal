package prLibreria; 
import java.util.*;
public class LibroOferta extends Libro {

	private double porcDescuento;
	
	public LibroOferta
	(String autor,String titulo,double preciobase,double porcentaje) {
		
	 super(autor,titulo,preciobase);
	 this.porcDescuento = porcentaje;
		
	}
	
	public double getDescuento() {
		return this.porcDescuento;
	}
	private double getPrecioBaseDescuento() {
		double PB = getPrecioBase();
		return PB - PB* getDescuento()/100;
		
	}
	@Override
	public double getPrecioFinal() {
		double px;
		px = this.getPrecioBase() - this.getPrecioBase()*this.getDescuento()/100;
		return ( px + px * this.getIVA()/100) ;
	}
	
	@Override
	public String toString() {
		return    getAutor() 
	    + " ; " + getTitulo() 
		+ " ; " + getPrecioBase() 
		+ " ; " + getDescuento() 
		+ " ; " + getPrecioBaseDescuento() 
		+ " ; " + getIVA() 
		+ " ; " + getPrecioFinal();
	}
	
}
