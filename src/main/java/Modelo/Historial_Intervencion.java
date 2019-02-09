package Modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@DiscriminatorValue(value = "Intervencion")
public class Historial_Intervencion extends HistorialABS {
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_intervencion")
	private Intervencion intervencion;
	
	@JoinColumn(name = "id_estadointerv")
	@Enumerated(value = EnumType.STRING) 
	private EstadoIntervencion estado;
	
	@ManyToOne
	private Usuario usuario;
	
	public Historial_Intervencion () {
		
	}
	public Historial_Intervencion(Date f, EstadoIntervencion estadoIntervencion, Integer integer, Usuario u ) {
		super(f);

	}

	public Historial_Intervencion( Date f ,EstadoIntervencion est) {
			super(f);
			this.estado=est;

	}
	
	public void setIntervencion(Intervencion i) {
		setIntervencion(i,true);
	}
	
	public void setIntervencion (Intervencion i, boolean a) {
		this.intervencion=i;
		if(i!=null && a) {
			i.addHi(this,false);
		}
	}
	
	public void setUser(Usuario u) {
		this.setUser(u, true);
	}
	
	public void setUser(Usuario u, boolean a) {
		this.usuario=u;
		if(u!=null && a){
			u.addHI(this, false);
			}
		}
	
	public EstadoIntervencion getEstadoI() {
		return this.estado;
	}
	public void setEstadoI(EstadoIntervencion a) {
		this.estado =a;		
	}
	public Intervencion getIntervencion() {
		return intervencion;
	}

	public static void main(String[] args) {

	}

}
