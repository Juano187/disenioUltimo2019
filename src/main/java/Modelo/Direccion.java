package Modelo;

import java.io.Serializable;
import java.util.List;

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
	
	
	@Column(name = "CALLE", length = 150, nullable= true)
	private String calle;
	
	@Column(name = "NUMERO", nullable= true)
	private Integer numero;
	
	@ManyToOne
	@JoinColumn(name = "LEGAJO")
	private Empleado empleado;
	
	public Direccion() { 
		
	}
	
	public Direccion( String calle, Integer numero) {

		this.calle = calle;
		this.numero = numero;
		
	}
	
	public void setEmp(Empleado e){
		setEmp(e,true);
	}
	
	public void setEmp(Empleado e, boolean a) {
		this.empleado=e;
		if(e!=null && a) {
			e.addDir(this,false);
		}
	}

	public Direccion(Direccion direccion) {
		
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



	
}

