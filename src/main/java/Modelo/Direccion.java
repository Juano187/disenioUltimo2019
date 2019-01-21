package Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "DIRECCION")
public class Direccion implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DIRECCION")
	private Integer id_direccion;
	
	
	@Column(name = "CALLE", length = 150, nullable= false)
	private String calle;
	
	@Column(name = "NUMERO", nullable= false)
	private Integer numero;
	
	@ManyToOne
	@JoinColumn(name = "legajo")
	private Empleado empleado;
	
	public Direccion() {
		
	}
	
	public Direccion(Integer id_direccion, String calle, Integer numero, Empleado empleado) {
		
		this.id_direccion = id_direccion;
		this.calle = calle;
		this.numero = numero;
		this.empleado = empleado;
	}

	public Integer getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(Integer id_direccion) {
		this.id_direccion = id_direccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Direccion [id_direccion=" + id_direccion + ", calle=" + calle + ", numero=" + numero + ", empleado="
				+ empleado + "]";
	}
	
	
}

