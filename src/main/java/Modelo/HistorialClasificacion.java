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
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario user;

	public HistorialClasificacion( Date f) {
		super (f);
	}
	public void setUser(Usuario u) {
		this.setUser(u, true);
	}
	public void setUser(Usuario u, boolean a) {
		this.user=u;
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
}
