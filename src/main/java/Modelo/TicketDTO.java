package Modelo;

import java.time.LocalDate;
import java.util.Date;

public class TicketDTO {
	/* dto agragado cami para consultarticket hay q ver para consultar, en el gestor BD si se puede llamar estas funciones
	 ya q pide como return de tipo TicketDTO y todos los get aca son tipo string etc*/
	 

	private Integer numeroTicket;
	private Integer numlegajo;
	private Date fechaA;
	
	private ClasificacionDTO cla;
	private GrupoResolucionDTO gru;
	private EstadoTicket estado;
	private String descrip_problema; 
	
	public TicketDTO() {
		
	}
	
	public TicketDTO(Integer numeroTicket, Integer numlegajo, Date fechaA, ClasificacionDTO cla,
			GrupoResolucionDTO gru, EstadoTicket estado) {
		
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
	public EstadoTicket getEstado() {
		return estado;
	}
	public void setEstado(Integer i) {
		if ( i == 1) {
		this.estado = EstadoTicket.ABIERTODERIVADO ;}
		else {
			if( i == 2) {
				this.estado = EstadoTicket.ABIERTOSINDERIVAR;
				}
			else {
				if( i == 3) {
					this.estado = EstadoTicket.CERRADO;
				}
				else {
					if(i== 4) {
						this.estado= EstadoTicket.SOLUCIONADOALAESPERAOK;
					}
				}
			}
		}
		
	}

	public void setEstado2(EstadoTicket estado) {
		this.estado = estado;
	}
	

	public String getDescripcion() {
		return descrip_problema;
	}

	public void setDescripcion(String descrip_problema) {
		this.descrip_problema = descrip_problema;
	}

	
	
	
	
}
