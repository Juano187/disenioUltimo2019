package Modelo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@DiscriminatorValue(value = "Intervencion")
public class Historial_Intervencion extends HistorialABS {
	
	@ManyToOne
	@JoinColumn(name = "id_intervencion")
	private Intervencion intervencion;
	
	@JoinColumn(name = "id_estadointerv")
	@Enumerated(value = EnumType.STRING) 
	private EstadoIntervencion estado;
	
	
	public Historial_Intervencion(Usuario u, Date f,Intervencion i) {
		super (u,f);
		this.intervencion= i;
		i.addHistorial(this);
	
	}
	
	public EstadoIntervencion getEstadoI() {
		return this.estado;
	}
	public void setEstadoI(EstadoIntervencion a) {
		this.estado =a;		
	}
	public Intervencion getIntervencion() {
		return this.intervencion;
	}
	
	public static void main(String[] args) {

	}

}
