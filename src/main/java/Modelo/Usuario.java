package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	@OneToMany(mappedBy = "usuario")
	private List<Historial> listahistorial = new ArrayList<>();
	
	public Usuario() {
			
		
	}

	public Usuario(Integer id_usuario, String usuario, String contraseña, List<Clasificacion> listaclasificacion,
			GrupoResolucion gruporesolucion, Empleado empleado, List<Historial> listahistorial) {
		
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		Contraseña = contraseña;
		this.listaclasificacion = listaclasificacion;
		this.gruporesolucion = gruporesolucion;
		this.empleado = empleado;
		this.listahistorial = listahistorial;
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

	public List<Historial> getListahistorial() {
		return listahistorial;
	}

	public void setListahistorial(List<Historial> listahistorial) {
		this.listahistorial = listahistorial;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", Contraseña=" + Contraseña
				+ ", listaclasificacion=" + listaclasificacion + ", gruporesolucion=" + gruporesolucion + ", empleado="
				+ empleado + ", listahistorial=" + listahistorial + "]";
	}
	
	

	
}
