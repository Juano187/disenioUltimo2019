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
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario user;
	
	public HistorialTicket (EstadoTicket estado, Date f, Ticket t) {
		super();
		this.estado= estado;
		this.ticket= t;
	
	}
	public HistorialTicket() {
	
	}

	public HistorialTicket(Usuario usuario ) {
		
		
		this.user=usuario;
	}
	
	public HistorialTicket( Date f) {
		super (f);
	}
	
	public void setUser(Usuario u) {
		this.setUser(u, true);
	}
	public void setUser(Usuario u, boolean a) {
		this.user=u;
		if(u!=null && a){
			u.addHT(this, false);
			}
		}
	
	/*public void setTicket(Ticket t){
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
