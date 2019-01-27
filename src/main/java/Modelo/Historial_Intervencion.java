package Modelo;

import java.util.Date;

public class Historial_Intervencion extends HistorialABS {

	private int id_intervencion;
	private EstadoIntervencion estado;
	
	
	public Historial_Intervencion(String u, Date f,int id) {
		super (u,f);
		this.id_intervencion= id;
	}
	
	public EstadoIntervencion getEstadoI() {
		return this.estado;
	}
	public void setEstadoI(EstadoIntervencion a) {
		this.estado =a;		
	}
	public int getid_Int() {
		return this.id_intervencion;
	}
	
	public static void main(String[] args) {

	}

}
