package Modelo;

import java.util.Date;

public class TicketDTO {
	/* dto agragado cami para consultarticket hay q ver para consultar, en el gestor BD si se puede llamar estas funciones
	 ya q pide como return de tipo TicketDTO y todos los get aca son tipo string etc*/
	 

	private Integer numeroTicket;
	private Integer numlegajo;
	private Date fechaA;
	
	private ClasificacionDTO cla;
	private GrupoResolucionDTO gru;
	private String estado;
	
	public TicketDTO() {
		
	}
	
	public TicketDTO(Integer numeroTicket, Integer numlegajo, Date fechaA, ClasificacionDTO cla,
			GrupoResolucionDTO gru, String estado) {
		
		this.numeroTicket = numeroTicket;
		this.numlegajo = numlegajo;
		this.fechaA = fechaA;

		this.cla = cla;
		this.gru = gru;
		this.estado = estado;
	}
	
	
	public Integer getNumeroTicket() {
		return numeroTicket;
	}
	public void setNumeroTicket(Integer numeroTicket) {
		this.numeroTicket = numeroTicket;
	}
	public Integer getNumlegajo() {
		return numlegajo;
	}
	public void setNumlegajo(Integer numlegajo) {
		this.numlegajo = numlegajo;
	}
	public Date getFechaA() {
		return fechaA;
	}
	public void setFechaA(Date fechaA) {
		this.fechaA = fechaA;
	}

	public ClasificacionDTO getCla() {
		return cla;
	}
	public void setCla(ClasificacionDTO cla) {
		this.cla = cla;
	}
	public GrupoResolucionDTO getGru() {
		return gru;
	}
	public void setGru(GrupoResolucionDTO gru) {
		this.gru = gru;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
