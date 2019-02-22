package Modelo;

import java.util.Date;
import Modelo.EstadoTicket;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
@DiscriminatorValue(value = "Ticket")

public class HistorialTicket extends HistorialABS {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "num_ticket")
	private Ticket ticket;
	
	@JoinColumn(name = "estadoticket")
	@Enumerated(value = EnumType.STRING) 
	
	private EstadoTicket estado;

	private Clasificacion clasificacion;
	
	public HistorialTicket (EstadoTicket estado, Date f) {
		super(f);
		this.estado= estado;

	
	}
	public HistorialTicket() {
	
	}
	
	public void setUser(Usuario u) {
		super.setUser(u);
		u.addHT(this);
	}
	public HistorialTicket( Date f) {
		super (f);
	}
	
	public void setTicket(Ticket t){
		this.ticket = t;
	}

	public EstadoTicket getEstado () {
		return this.estado;
	}
	public void setClasificacion (Clasificacion c) {
		this.clasificacion = c;
	}
	public Clasificacion getClasif () {
		return	this.clasificacion;
	}
	
	/*
	public void setTicket(Ticket t){
		setTicket(t,true);
	}
	public void setTicket(Ticket t, boolean a) {
		this.ticket=t;
		if(t!= null && a) {
			t.addH(this, false);
		}
	}
	*/
	public void setEstadoT(EstadoTicket a) {
		this.estado =a;		
	}
	public Ticket getNum_ticket() {
		return this.ticket;
	}

	public static void main(String[] args) {

	}

}
