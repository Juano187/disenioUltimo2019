package Modelo;

import java.util.Date;
import Modelo.EstadoTicket;

public class HistorialTicket extends HistorialABS {
	private int num_ticket;
	private EstadoTicket estado;
	
	
	public HistorialTicket(String u, Date f,int id) {
		super (u,f);
		this.num_ticket= id;
	}
	
	public void setEstadoT(EstadoTicket a) {
		this.estado =a;		
	}
	public int getNum_ticket() {
		return this.num_ticket;
	}

	public static void main(String[] args) {

	}

}
