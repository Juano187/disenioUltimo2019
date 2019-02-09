package Modelo;

import java.util.Date;

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
	
	@ManyToOne
	private Usuario usuario;
	
	public HistorialClasificacion(Date f, Usuario u) {
		super (f);
	
	}
	
	
	public HistorialClasificacion() {
		
	}
	
	
	
	public void setUser(Usuario u) {
		this.setUser(u, true);
	}
	public void setUser(Usuario u, boolean a) {
		this.usuario=u;
		if(u!=null && a){
			u.addHC(this, false);
			}
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
