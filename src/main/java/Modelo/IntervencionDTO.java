package Modelo;

import java.util.Date;

public class IntervencionDTO {
	
	
	private Integer idI;
	private Integer idTicket;
	private Integer legajo;
	private Date fechaAs;
	private Date fechap;
	private ClasificacionDTO clas;
	private EstadoTicket estadoT;
	private EstadoIntervencion estadoI;
	private GrupoResolucion grup;
	private String observ;
	
   public IntervencionDTO() {
	   
   }

   

	public IntervencionDTO(Integer idI, Integer idTicket, Integer legajo, Date fechaAs, Date fechap, ClasificacionDTO clas,
		EstadoTicket estadoT, EstadoIntervencion estadoI, GrupoResolucion grup, String observ) {
	
	this.idI = idI;
	this.idTicket = idTicket;
	this.legajo = legajo;
	this.fechaAs = fechaAs;
	this.fechap = fechap;
	this.clas = clas;
	this.estadoT = estadoT;
	this.estadoI = estadoI;
	this.grup = grup;
	this.observ = observ;
}



	public Integer getIdI() {
		return idI;
	}


	public void setIdI(Integer idI) {
		this.idI = idI;
	}


	public Integer getIdTicket() {
		return idTicket;
	}


	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}


	public Integer getLegajo() {
		return legajo;
	}


	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}


	public Date getFechaAs() {
		return fechaAs;
	}


	public void setFechaAs(Date fechaAs) {
		this.fechaAs = fechaAs;
	}


	public Date getFechap() {
		return fechap;
	}


	public void setFechap(Date fechap) {
		this.fechap = fechap;
	}


	public ClasificacionDTO getClas() {
		return clas;
	}


	public void setClas(ClasificacionDTO clas) {
		this.clas = clas;
	}


	public EstadoTicket getEstadoT() {
		return estadoT;
	}


	public void setEstadoT(EstadoTicket estadoT) {
		this.estadoT = estadoT;
	}


	public EstadoIntervencion getEstadoI() {
		return estadoI;
	}


	public void setEstadoI(EstadoIntervencion estadoI) {
		this.estadoI = estadoI;
	}


	public GrupoResolucion getGrup() {
		return grup;
	}


	public void setGrup(GrupoResolucion grup) {
		this.grup = grup;
	}


	public String getObserv() {
		return observ;
	}


	public void setObserv(String observ) {
		this.observ = observ;
	}


	

}