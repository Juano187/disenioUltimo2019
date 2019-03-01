package Modelo;
import java.time.LocalDate;

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
@Table(name = "Historial")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO")

abstract class HistorialABS {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_historial;
	
	@Column(name = "FECHA_HORA_APERTURA", nullable= true)
	private LocalDate hora_fecha_ini;
	
	@Column(name = "FECHA_HORA_FIN", nullable= true)
	private LocalDate hora_fecha_fin;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public HistorialABS() {
		
	}
	
	public HistorialABS( LocalDate fecha) {
	
		this.hora_fecha_ini= fecha;
		this.hora_fecha_fin = null;
	}
	
	public static void main(String[] args) {
		
	}
	
	public void setUser(Usuario u) {
		this.usuario=u;
	}
	public Usuario getUser () {
		return this.usuario;
	}

	public LocalDate getFechaFin() {
		return this.hora_fecha_fin;
	}
	public LocalDate getFechaIni() {
		return this.hora_fecha_ini;
	}
	public int getIdHistorial() {
		return this.id_historial;
	}
	
	public void setfinal(LocalDate a) {
		this.hora_fecha_fin = a;
	}
}
