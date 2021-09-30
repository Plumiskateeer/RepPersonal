
package prDatos;

import java.util.Arrays;

public class Datos {
	private double[] datos;
	private String[] errores;
	private double min;
	private double max;
	
	public Datos(String[] d, double min, double max) {
		procesarDatos(d);
		this.min = min;
		this.max = max;
	}
	public double calcMedia() {
		double suma = 0;
		int n = 0;
		for (int i = 0; i < datos.length; ++i) {
			if (min <= datos[i] && datos[i] <= max) {
				suma += datos[i];
				++n;
			}
		}
		if (n == 0) {
			throw new DatosException("Datos Vacíos");
		}
		return suma / n;
	}
	public double calcDesvTipica() {
		double media = this.calcMedia();
		double suma = 0;
		int n = 0;
		for (int i = 0; i < datos.length; ++i) {
			if (min <= datos[i] && datos[i] <= max) {
				suma += Math.pow(datos[i] - media, 2);
				++n;
			}
		}
		return Math.sqrt(suma / n);
	}
	public void setRango(String minmax) {
		try {
			int idx = minmax.indexOf(';');
			min = Double.parseDouble(minmax.substring(0, idx));
			max = Double.parseDouble(minmax.substring(idx+1));
		} catch (IndexOutOfBoundsException e) {
			throw new DatosException("Error, no hay valores suficientes ("+minmax+")");
		} catch (NumberFormatException e) {
			throw new DatosException("Error, al convertir un valor a número real ("+e.getMessage()+")");
		} catch (Exception e) {
			throw new DatosException(e.getMessage());
		}
	}
	public double[] getDatos() {
		return datos;
	}
	public String[] getErrores() {
		return errores;
	}
	@Override
	public String toString() {
		String str = "Min: " + min + ", Max: " + max + ",\n";
		str += Arrays.toString(datos);
		str += ",\n";
		str += Arrays.toString(errores);
		str += ",\n";
		try {
			str += "Media: " + calcMedia();
		} catch (Exception e) {
			str += "Media: ERROR";
		}
		str += ", ";
		try {
			str += "DesvTipica: " + calcDesvTipica();
		} catch (Exception e) {
			str += "DesvTipica: ERROR";
		}
		return str;
	}
	private void procesarDatos(String[] dat) {
		int nd = 0;
		int ne = 0;
		datos = new double[dat.length];
		errores = new String[dat.length];
		for (String d : dat) {
			try {
				datos[nd] = Double.parseDouble(d);
				++nd;
			} catch (Exception e) {
				errores[ne] = d;
				++ne;
			}
		}
		datos = Arrays.copyOf(datos, nd);
		errores = Arrays.copyOf(errores, ne);
	}
}
