package Modelo;

import java.io.Serializable;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORIAL")
public class Historial implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_historial;



	@Column(name = "FECHAHORA_APERTURA", nullable= false)
	private LocalDateTime fechahora_apertura; 
	

	@Column(name = "FECHAHORA__FIN", nullable= false)
	private LocalDateTime fechahora_fin;
	
	@ManyToOne
	@JoinColumn(name = "codigo")
	private Clasificacion clasificacion;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "num_ticket")
	private Ticket ticket;
	
	
	@JoinColumn(name = "id_estadointerv")
	@Enumerated(value = EnumType.STRING) 
	private EstadoIntervencion estadointervencion;
	
	
	@JoinColumn(name = "id_estadoticket")
	@Enumerated(value = EnumType.STRING) 
	private EstadoTicket estadoticket; 

	public Historial() {

	}
	
	public Historial(Integer id_historial, LocalDateTime fechahora_apertura, LocalDateTime fechahora_fin,
			Clasificacion clasificacion, Usuario usuario, Ticket ticket, EstadoIntervencion estadointervencion,
			EstadoTicket estadoticket) {
		
		this.id_historial = id_historial;
		this.fechahora_apertura = fechahora_apertura;
		this.fechahora_fin = fechahora_fin;
		this.clasificacion = clasificacion;
		this.usuario = usuario;
		this.ticket = ticket;
		this.estadointervencion = estadointervencion;
		this.estadoticket = estadoticket;
	}

	public Integer getId_historial() {
		return id_historial;
	}

	public void setId_historial(Integer id_historial) {
		this.id_historial = id_historial;
	}

	public LocalDateTime getFechahora_apertura() {
		return fechahora_apertura;
	}

	public void setFechahora_apertura(LocalDateTime fechahora_apertura) {
		this.fechahora_apertura = fechahora_apertura;
	}

	public LocalDateTime getFechahora_fin() {
		return fechahora_fin;
	}

	public void setFechahora_fin(LocalDateTime fechahora_fin) {
		this.fechahora_fin = fechahora_fin;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public EstadoIntervencion getEstadointervencion() {
		return estadointervencion;
	}

	public void setEstadointervencion(EstadoIntervencion estadointervencion) {
		this.estadointervencion = estadointervencion;
	}

	public EstadoTicket getEstadoticket() {
		return estadoticket;
	}

	public void setEstadoticket(EstadoTicket estadoticket) {
		this.estadoticket = estadoticket;
	}

	@Override
	public String toString() {
		return "Historial [id_historial=" + id_historial + ", fechahora_apertura=" + fechahora_apertura
				+ ", fechahora_fin=" + fechahora_fin + ", clasificacion=" + clasificacion + ", usuario=" + usuario
				+ ", ticket=" + ticket + ", estadointervencion=" + estadointervencion + ", estadoticket=" + estadoticket
				+ "]";
	}

	
}
