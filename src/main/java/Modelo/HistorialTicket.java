package Modelo;

import java.util.Date;
import Modelo.EstadoTicket;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Entity
@DiscriminatorValue(value = "Ticket")

public class HistorialTicket extends HistorialABS {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "num_ticket")
	private Ticket ticket;
	
	@JoinColumn(name = "estadoticket")
	@Enumerated(value = EnumType.STRING) 
	private EstadoTicket estado;
	
	public HistorialTicket() {
		
	}
	public void setTicket(Ticket t){
		this.ticket =t;
	}
	public HistorialTicket(Usuario u, Date f,Ticket t) {
		super (u,f);
		this.ticket= t;
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
