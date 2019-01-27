package Modelo;

import java.util.Date;

public class HistorialClasificacion extends HistorialABS{
	
	private int codigoClas;
	

	public HistorialClasificacion(String u, Date f,int c) {
		super (u,f);
		this.codigoClas= c;
	}
	

	public int getCodClasif() {
		return this.codigoClas;
	}
}
