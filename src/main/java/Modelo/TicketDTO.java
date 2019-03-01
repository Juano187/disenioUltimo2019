package Modelo;

import java.time.LocalDate;
import java.util.Date;



public class TicketDTO {
	/* dto agragado cami para consultarticket hay q ver para consultar, en el gestor BD si se puede llamar estas funciones
	 ya q pide como return de tipo TicketDTO y todos los get aca son tipo string etc*/
	 

	private Integer numeroTicket;
	private Integer numlegajo;
	private LocalDate fechaA;
	private LocalDate fechaU;
	private Empleado empleado;
	private Clasificacion cla;
	private GrupoResolucion gru;
	private EstadoTicket estado;
	private String descrip_problema;
	private String usuario;
	
	public TicketDTO() {
		
	}
	
	// TODO clasificacionDTO a clasificacion, y GrupoResolucionDTO a grupoResolucion 
	
	public TicketDTO(Integer numeroTicket, 
			Integer numlegajo, LocalDate fechaA, 	
			LocalDate fechaU , Clasificacion cla,
			GrupoResolucion gru, 
			EstadoTicket estado, String usuario) {
		
		this.numeroTicket = numeroTicket;
		this.numlegajo = numlegajo;
		this.fechaA = fechaA;
		this.fechaU = fechaU;
		this.cla = cla;
		this.gru = gru;
		this.estado = estado;
		this.usuario= usuario;
	}
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String string) {
		this.usuario = string;
	}

	public LocalDate getFechaU() {
		
		return fechaU;
	}

	public void setFechaU(LocalDate fechaU) {
		this.fechaU = fechaU;
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
	public LocalDate getFechaA() {
		return fechaA;
	}
	public void setFechaA(LocalDate fechaA) {
		this.fechaA = fechaA;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Clasificacion getCla() {
		return cla;
	}
	public void setCla(Clasificacion cla) {
		this.cla = cla;
	}
	public GrupoResolucion getGru() {
		return gru;
	}
	public void setGru(GrupoResolucion gru) {
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
	public Integer getLegajo () {
		return this.numlegajo;
	}

	public String getDescripcion() {
		return descrip_problema;
	}

	public void setDescripcion(String descrip_problema) {
		this.descrip_problema = descrip_problema;
	}

	
	
	
	
	
}
