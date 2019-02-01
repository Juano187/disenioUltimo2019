package Modelo;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import Controlador.GestorBDD;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Enumerated;

@Entity
@Table(name = "Historial2")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO")

abstract class HistorialABS {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_historial;
	
	@Column(name = "FECHA_HORA_APERTURA", nullable= false)
	private Date hora_fecha_ini;
	
	@Column(name = "FECHA_HORA__FIN", nullable= true)
	private Date hora_fecha_fin;
	


	public HistorialABS() {
		
	}
	public HistorialABS( Date fecha) {
	
	
		
		this.hora_fecha_ini= fecha;
		this.hora_fecha_fin = null;
	}
	public static void main(String[] args) {
		
	}
	
	public boolean ultimaFechaVacia() {
		if(this.hora_fecha_fin == null) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public int getIdHistorial() {
		return this.id_historial;
	}
	
	public void setfinal(Date a) {
		this.hora_fecha_fin = a;
	}
}
