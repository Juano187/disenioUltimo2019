package Modelo;

import java.time.LocalDate;
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
		
	private String descrip;
	
	private String clasificacion;
	
	public HistorialTicket (EstadoTicket estado, LocalDate f) {
		super(f);
		this.estado= estado;

	
	}
	public HistorialTicket() {
	
	}
	
	public void setUser(Usuario u) {
		super.setUser(u);
		u.addHT(this);
	}
	public HistorialTicket( LocalDate f) {
		super (f);
	}
	
	public void setTicket(Ticket t){
		this.ticket = t;
	}

	public EstadoTicket getEstado () {
		return this.estado;
	}
	public void setClasificacion (String c) {
		this.clasificacion = c;
	}
	public String getClasif () {
		return	this.clasificacion;
	}
	
	
	public void setDescripcion (String d) {
		this.descrip = d;
	}
	public String getDescripcion () {
		return this.descrip;
	}
	public void setEstadoT(EstadoTicket a) {
		this.estado =a;		
	}
	public Ticket getNum_ticket() {
		return this.ticket;
	}

	public static void main(String[] args) {

	}

}
