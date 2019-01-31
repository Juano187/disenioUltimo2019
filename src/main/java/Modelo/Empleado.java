package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable{
	


	private static final long serialVersionUID = 1L;
	
	@Id
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	@Column(name = "LEGAJO", length = 5)
	private Integer legajo;
	
	@Column(name = "NOMBRE", length = 150, nullable= false)
	private String nombre;
	
	@Column(name = "APELLIDO", length = 150, nullable= false)
	private String apellido;
	
	@Column(name = "CUIL", length = 40, nullable= false)
	private Long cuil;
	
	@Column(name = "DOCUMENTO", length = 40, nullable= false)
	private Integer documento;
	
	@Column(name = "TELEFONO",nullable= false)
	private Long telefono;
	
	@Column(name = "TELEFONO_INTERNO",nullable= true)
	private Long telefonoint;
	
	@Column(name = "DESCRIPCION_DEL_CARGO",nullable= false)
	private String descripcioncargo;
	
	@Column(name = "EMAIL", length = 150)
	private String email;
	
	@OneToMany(mappedBy = "empleado")
	private List<Direccion> listadireccion = new ArrayList<>();
	
	@OneToOne(mappedBy = "empleado")        /*ver si poner cascade.all*/
	private Usuario usuario;
	
	@OneToMany(mappedBy = "empleado")
	private List<Ticket> listaTickets = new ArrayList<>();;
	
	public Empleado(){
	
	 }
	 
	

	public Empleado(Integer legajo, Integer documento, String nombre, String apellido, Long cuil, Long telefono, Long telefonoint, String descripcioncargo, String email,
			List<Direccion> listadireccion, Usuario usuario, List<Ticket> listaTickets) {
		this.legajo = legajo;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.telefono = telefono;
		this.telefonoint = telefonoint;
		this.descripcioncargo = descripcioncargo;
		this.email = email;
		this.listadireccion = listadireccion;
		this.usuario = usuario;
		this.listaTickets = listaTickets;
	}


	public Integer getDocumento() {
		return documento;
	}



	public void setDocumento(Integer documento) {
		this.documento = documento;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public Long getCuil() {
		return cuil;
	}



	public void setCuil(Long cuil) {
		this.cuil = cuil;
	}

	public void setLegajo ( Integer legajo) {
		this.legajo= legajo;
		
	}
	
	public Integer getLegajo() {
		return legajo;
	}

	public Long getTelefono() {
		return telefono;
	}



	public void setTelefono(Long telefonoint) {
		this.telefono = telefono;
	}
	
	public Long getTelefonoint() {
		return telefonoint;
	}



	public void setTelefonoint(Long telefonoint) {
		this.telefonoint = telefonoint;
	}

	public String getDescripcioncargo() {
		return descripcioncargo;
	}



	public void setDescricioncargo(String descripcioncargo) {
		this.descripcioncargo = descripcioncargo;
	}


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Direccion> getListadireccion() {
		return listadireccion;
	}



	public void setListadireccion(List<Direccion> listadireccion) {
		this.listadireccion = listadireccion;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public List<Ticket> getListaTickets() {
		return listaTickets;
	}



	public void setListaTickets(List<Ticket> listaTickets) {
		this.listaTickets = listaTickets;
	}



	@Override
	public String toString() {
		return "Empleado [legajo= " + legajo + ", documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", cuil=" + cuil
				+ ", telefono=" + telefono + ", telefonount=" + telefonoint + ", descripcioncargo=" + descripcioncargo + ", email=" + email + ", listadireccion=" + listadireccion + ", usuario="
				+ usuario + ", listaTickets=" + listaTickets + "]";
	}
	
	
	
}
