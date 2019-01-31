package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 
@Entity
@Table(name = "CLASIFICACION")
public class Clasificacion implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private int codigo;
	
	@Column(name = "FECHA_CREACION", nullable= false)
	private Date fecha_Creacion;
	
	@Column(name = "DESCRIPCION", length = 5000)
    private String descripcion;
	
	@Column(name = "NOMBRE", length = 150, nullable= false)
	private String nom_clasificacion;
	
	@OneToMany(mappedBy = "clasificacion")
	private List<Ticket> listaTickets = new ArrayList<>();;
	
	@OneToMany(mappedBy = "clasificacion")
	private List<HistorialClasificacion> listahistorial = new ArrayList<>();;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@ManyToMany(cascade = {CascadeType.ALL},mappedBy="listaclasificacion")
	private List<GrupoResolucion> gruporesolucion = new ArrayList<>();

	
	public Clasificacion() {
		listaTickets = new ArrayList<>();
		listahistorial = new ArrayList<>();
		gruporesolucion = new ArrayList<>();
		
	}

	public Clasificacion(int codigo, Date fecha_Creacion, String descripcion, String nom_clasificacion,
			List<Ticket> listaTickets, List<HistorialClasificacion> listahistorial, Usuario usuario) {
		
		this.codigo = codigo;
		this.fecha_Creacion = fecha_Creacion;
		this.descripcion = descripcion;
		this.nom_clasificacion = nom_clasificacion;
		this.listaTickets = listaTickets;
		this.listahistorial = listahistorial;
		this.usuario = usuario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha_Creacion() {
		return fecha_Creacion;
	}

	public void setFecha_Creacion(Date fecha_Creacion) {
		this.fecha_Creacion = fecha_Creacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNom_clasificacion() {
		return nom_clasificacion;
	}

	public void setNom_clasificacion(String nom_clasificacion) {
		this.nom_clasificacion = nom_clasificacion;
	}

	public List<Ticket> getListaTickets() {
		return listaTickets;
	}

	public void setListaTickets(List<Ticket> listaTickets) {
		this.listaTickets = listaTickets;
	}

	public List<HistorialClasificacion> getListahistorial() {
		return listahistorial;
	}

	public void setListahistorial(List<HistorialClasificacion> listahistorial) {
		this.listahistorial = listahistorial;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Clasificacion [codigo=" + codigo + ", fecha_Creacion=" + fecha_Creacion + ", descripcion=" + descripcion
				+ ", nom_clasificacion=" + nom_clasificacion + ", listaTickets=" + listaTickets + ", listahistorial="
				+ listahistorial + ", usuario=" + usuario + "]";
	}
	
	
}
