package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable{
	


	private static final long serialVersionUID = 1L;
	
	@Id
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
	//@Fetch(value = FetchMode.SUBSELECT)
	private List<Direccion> listadireccion = new ArrayList<>();
	
	@OneToOne(mappedBy = "empleado")   
	private Usuario usuario;

	@OneToMany(	cascade = CascadeType.ALL, mappedBy = "empleado" )
	//@Fetch(value = FetchMode.SUBSELECT)
	private List<Ticket> listaTickets = new ArrayList<>();;
	
	
	public Empleado(){
		listaTickets = new ArrayList<>();
		listadireccion = new ArrayList<>();
		
	 }
	 
	

	public Empleado(Integer legajo, Integer documento, String nombre, String apellido,
			Long cuil, Long telefono, Long telefonoint, String descripcioncargo, String email) {
		listaTickets = new ArrayList<>();
		listadireccion = new ArrayList<>();
		
		this.legajo = legajo;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.telefono = telefono;
		this.telefonoint = telefonoint;
		this.descripcioncargo = descripcioncargo;
		this.email = email;
		
	}
	
	
	public List<Direccion> getDireccion(){
		return listadireccion;
	}
	
	
	
	
	public void addDir(Direccion d) {
		this.addDir(d,true);
	}
	public void addDir(Direccion d,boolean a) {
		if(d!=null) {
			if(this.getListaDir().contains(d)) {
				this.getListaDir().set(this.getListaDir().indexOf(d), d);
			}
			else {
				this.getListaDir().add(d);
			}
			if(a) {
			d.setEmp(this, false);
			}
		}
	}

	public void addTicket(Ticket t) {
		this.addTicket(t, true);
	}
	public void addTicket(Ticket t, boolean a) {
		if(t!=null ) {
			if(this.getListaTickets().contains(t)) {
				this.getListaTickets().set(this.getListaTickets().indexOf(t), t);
			}
			else {
				this.getListaTickets().add(t);
			}
			if(a) {
				t.setEmp(this,false);
			}
				
		}
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
		this.telefono = telefonoint;
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



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Direccion> getListaDir(){
		return listadireccion;
	}

	public List<Ticket> getListaTickets() {
		return listaTickets;
	}



	public void setListaTickets(List<Ticket> listaTickets) {
		this.listaTickets = listaTickets;
	}


	@Override
	public String toString() {
		return this.nombre;
	}
	
	
}
