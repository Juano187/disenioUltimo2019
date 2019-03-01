package Modelo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DiscriminatorOptions;
@Entity
@DiscriminatorOptions(force = true)
@DiscriminatorValue(value = "Clasificacion")
public class HistorialClasificacion extends HistorialABS{
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo")
	private Clasificacion clasificacion ;
	
	
	public HistorialClasificacion(LocalDate f) {
		super (f);
	}
	public HistorialClasificacion(LocalDate f, Clasificacion clasificacion) {
		super (f);
		this.clasificacion = clasificacion;
		
	}
	
	public HistorialClasificacion() {
		
	}
	
	public void setUser(Usuario u) {
		super.setUser(u);
		u.addHC(this);
	}
	
	public void setClasificacion (Clasificacion c) {
		setClasificacion(c,true);
	}
	
	public void setClasificacion (Clasificacion c,boolean a) {
		this.clasificacion=c;
		if(c!=null && a) {
			c.addHistorial(this,false);
		}
	}
	
	public Clasificacion getCodClasif() {
		return this.clasificacion;
	}
	
	public static void main(String[] args) {

	}
}
