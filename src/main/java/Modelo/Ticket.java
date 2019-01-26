package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "TICKET")
public class Ticket implements  Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUM_TICKET")
	private Integer num_ticket;
	
	@Column(name = "HORA_APERTURA")
	private LocalTime hora_apertura;

	@Column(name = "FECHA_APERTURA")
	private Date fecha_apertura;
	
	@Column(name = "FECHA_CIERRE")
	private Date fecha_cierre;
	
	@Column(name = "HORA_CIERRE")
	private LocalTime hora_cierre;
	
	@Column(name = "DESCRIP_PROBLEMA",length = 5000)
	private String descrip_problema;
	
	@ManyToOne
	@JoinColumn(name = "CODIGO")
	private Clasificacion clasificacion;
	
	@Enumerated(value = EnumType.STRING)
	@JoinColumn(name = "id_estadoticket")
	private EstadoTicket estadoticket;
	
	
	@ManyToOne
	@JoinColumn(name = "LEGAJO")
	private Empleado empleado;
	
	@OneToMany(mappedBy = "ticket")
	//@JoinColumn(name = "numero")
	private List<Intervencion> listaintervenciones = new ArrayList<>();;
	
	@OneToMany(mappedBy = "ticket")
	private List<Historial> listahistorial = new ArrayList<>();;
	
	public Ticket() {
		
		listaintervenciones = new ArrayList<>();
		listahistorial = new ArrayList<>();
		
	}
	

	public Ticket(Integer num_ticket, Date fecha_apertura,Date fecha_cierre, String descrip_problema,
			Clasificacion clasificacion, EstadoTicket estadoticket, Empleado empleado,
			List<Intervencion> listaintervenciones, List<Historial> listahistorial, LocalTime hora_apertura, LocalTime hora_cierre) {
		
		this.num_ticket = num_ticket;
		this.fecha_apertura = fecha_apertura;
		this.fecha_cierre = fecha_cierre;
		this.hora_apertura = hora_apertura;
		this.hora_cierre = hora_cierre;
		this.descrip_problema = descrip_problema;
		this.clasificacion = clasificacion;
		this.estadoticket = estadoticket;
		this.empleado = empleado;
		this.listaintervenciones = listaintervenciones;
		this.listahistorial = listahistorial;
	}
	
	public void setListainterveniones(List<Intervencion> listainterveniones) {
		this.listaintervenciones = listainterveniones;
	}



	public int getNum_ticket() {
		return num_ticket;
	}


	public void setNum_ticket(Integer num_ticket) {
		this.num_ticket = num_ticket;
	}





	public String getDescrip_problema() {
		return descrip_problema;
	}


	public void setDescrip_problema(String descrip_problema) {
		this.descrip_problema = descrip_problema;
	}


	public Clasificacion getClasificacion() {
		return clasificacion;
	}


	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}


	public EstadoTicket getEstadoticket() {
		return estadoticket;
	}


	public void setEstadoticket(Integer i) {
		if ( i == 1) {
		this.estadoticket = EstadoTicket.ABIERTODERIVADO ;}
		else {
			if( i == 2) {
				this.estadoticket = EstadoTicket.ABIERTOSINDERIVAR;
				}
			else {
				if( i == 3) {
					this.estadoticket = EstadoTicket.CERRADO;
				}
				else {
					if(i== 4) {
						this.estadoticket= EstadoTicket.SOLUCIONADOALAESPERAOK;
					}
				}
			}
		}
		
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public List<Intervencion> getListainterveniones() {
		return listaintervenciones;
	}
	
	/*public Intervencion ultimaI() {
		Intervencion u = listaintervenciones.get(0);
		for(Intervencion i: listaintervenciones) {
			if(i.getFecha_inicio().compareTo(u.getFecha_inicio())>0) {
				if(i.getEstadointervencion()!= EstadoIntervencion.TERMINADA) {
					u=i;
				}   
					}
				}
			
		
	return u;	
	}	*/
			
	

	public LocalTime getHora_apertura() {
		return hora_apertura;
	}


	public void setHora_apertura(LocalTime hora_apertura) {
		this.hora_apertura = hora_apertura;
	}


	public Date getFecha_apertura() {
		return fecha_apertura;
	}


	public void setFecha_apertura(Date fecha_apertura) {
		this.fecha_apertura = fecha_apertura;
	}


	public Date getFecha_cierre() {
		return fecha_cierre;
	}


	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}


	public LocalTime getHora_cierre() {
		return hora_cierre;
	}


	public void setHora_cierre(LocalTime hora_cierre) {
		this.hora_cierre = hora_cierre;
	}
	




	

	public List<Historial> getListahistorial() {
		return listahistorial;
	}


	public void setListahistorial(List<Historial> listahistorial) {
		this.listahistorial = listahistorial;
	}


	/*@Override
	public String toString() {
		return "Ticket [num_ticket=" + num_ticket + ", fecha_apertura=" + fecha_apertura + "hora_apertura" + hora_apertura +", fecha_cierre=" + fecha_cierre +
				", descrip_problema=" + descrip_problema + ", clasificacion=" + clasificacion
				+ ", estadoticket=" + estadoticket + ", empleado=" + empleado + ", listainterveniones="
				+ listaintervenciones + ", listahistorial=" + listahistorial + "]";
	}

*/
	
	
}
