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
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario user;
	
	
	public Historial_Intervencion( Date f) {
		super (f);

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
		this.user=u;
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
		return this.intervencion;
	}
	
	public static void main(String[] args) {

	}

}
