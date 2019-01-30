package Modelo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@DiscriminatorValue(value = "Clasificacion")
public class HistorialClasificacion extends HistorialABS{
	
	@ManyToOne
	@JoinColumn(name = "codigo")
	private Clasificacion clasificacion ;
	

	public HistorialClasificacion(Usuario u, Date f,Clasificacion c) {
		super (u,f);
		this.clasificacion= c;
	}
	

	public Clasificacion getCodClasif() {
		return this.clasificacion;
	}
}
