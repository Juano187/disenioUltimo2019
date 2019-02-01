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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
	
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Integer id_usuario;
	
	@Column(name = "USUARIO", length = 150, nullable= false)
	private String usuario;
	
	@Column(name = "CONTRASEÑA", length = 150, nullable= false)
	private String Contraseña;
	
	@OneToMany(mappedBy = "usuario")
	private List<Clasificacion> listaclasificacion = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_grupo")
	private GrupoResolucion gruporesolucion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "legajo")
	private Empleado empleado;

	@OneToMany(cascade={CascadeType.ALL}, mappedBy = "user")
	private List<HistorialTicket> listaHistorialT = new ArrayList<>();;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy = "user")
	private List<HistorialClasificacion> listaHistorialC = new ArrayList<>();;
	@OneToMany(cascade={CascadeType.ALL}, mappedBy = "user")
	private List<Historial_Intervencion> listaHistorial_I = new ArrayList<>();;
	
	public Usuario() {
			
		
	}
	
	public void addHI(Historial_Intervencion hi ) {
		this.addHI(hi,true);
	}
	public void addHI(Historial_Intervencion hi, boolean a) {
		if(hi!=null) {
			if(this.getListaHi().contains(hi)) {
				this.getListaHi().set(this.getListaHi().indexOf(hi), hi);
			}
			else {
				this.getListaHi().add(hi);
			}
			if(a) {
				hi.setUser(this, false);
			}
		}
	}
	
	public void addHC(HistorialClasificacion hc ) {
		this.addHC(hc,true);
	}
	public void addHC(HistorialClasificacion hc, boolean a) {
		if(hc!=null) {
			if(this.getListaHc().contains(hc)) {
				this.getListaHc().set(this.getListaHc().indexOf(hc), hc);
			}
			else {
				this.getListaHc().add(hc);
			}
			if(a) {
				hc.setUser(this, false);
			}
		}
	}
	public void addHT(HistorialTicket ht ) {
		this.addHT(ht,true);
	}
	public void addHT(HistorialTicket ht, boolean a) {
		if(ht!=null) {
			if(this.getListaHt().contains(ht)) {
				this.getListaHt().set(this.getListaHt().indexOf(ht), ht);
			}
			else {
				this.getListaHt().add(ht);
			}
			if(a) {
				ht.setUser(this, false);
			}
		}
	}
		
	
	public void addClasif(Clasificacion c) {
		this.addClasif(c, true);
	}
	public void addClasif(Clasificacion c, boolean a) {
		if(c!= null) {
			if(this.getListaclasificacion().contains(c)) {
				this.getListaclasificacion().set(this.getListaclasificacion().indexOf(c), c);
			}
			else {
				this.getListaclasificacion().add(c);
			}
			if(a) {
				c.setUser(this, false);
			}
		}
	}
	public Usuario(Integer id_usuario, String usuario, String contraseña, List<Clasificacion> listaclasificacion,
			GrupoResolucion gruporesolucion, Empleado empleado) {
		
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		Contraseña = contraseña;
		this.listaclasificacion = listaclasificacion;
		this.gruporesolucion = gruporesolucion;
		this.empleado = empleado;

	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	public List<HistorialClasificacion> getListaHc(){
		return this.listaHistorialC;
	}
	public List<HistorialTicket> getListaHt(){
		return listaHistorialT;
	}
	public List<Historial_Intervencion> getListaHi(){
		return listaHistorial_I;
	}
	public List<Clasificacion> getListaclasificacion() {
		return listaclasificacion;
	}

	public void setListaclasificacion(List<Clasificacion> listaclasificacion) {
		this.listaclasificacion = listaclasificacion;
	}

	public GrupoResolucion getGruporesolucion() {
		return gruporesolucion;
	}

	public void setGruporesolucion(GrupoResolucion gruporesolucion) {
		this.gruporesolucion = gruporesolucion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}



	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", Contraseña=" + Contraseña
				+ ", listaclasificacion=" + listaclasificacion + ", gruporesolucion=" + gruporesolucion + ", empleado="
				+ empleado + ", listahistorial=" + "]";
	}
	
	

	
}
