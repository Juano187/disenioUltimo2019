package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "TICKET2")
public class Ticket2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUM_TICKET")
	private Integer num_ticket;
	
	@Column(name = "HORA_APERTURA")
	private Date hora_apertura;

	@Column(name = "FECHA_APERTURA")
	private Date fecha_apertura;
	
	@Column(name = "FECHA_CIERRE")
	private Date fecha_cierre;
	
	@Column(name = "HORA_CIERRE")
	private Date hora_cierre;
	
	@Column(name = "DESCRIP_PROBLEMA",length = 5000)
	private String descrip_problema;

	
	@Enumerated(value = EnumType.STRING)
	@JoinColumn(name = "estadoticket")
	private EstadoTicket estadoticket;
	
	
	@ManyToOne
	@JoinColumn(name = "LEGAJO")
	private Empleado empleado;
	
	/*@OneToMany(cascade={CascadeType.ALL}, mappedBy = "ticket2")
	//@JoinColumn(name = "numero")
	private List<Intervencion> listaintervenciones = new ArrayList<>();;
	*/
	
	public Ticket2() {
		
		//listaintervenciones = new ArrayList<>();	
	}
	public Ticket2(Integer num_ticket, Date fecha_apertura, String descrip_problema,
			EstadoTicket estadoticket,
	 Date hora_apertura) {
		
		this.num_ticket = num_ticket;
		this.fecha_apertura = fecha_apertura;
		this.hora_apertura = hora_apertura;
		this.descrip_problema = descrip_problema;
		this.estadoticket = estadoticket;

	}
	public void setEmp(Empleado e) {
		this.setEmp(e, true);
	}
	public void setEmp(Empleado e, boolean a) {
		this.empleado=e;
		if(e!=null && a) {
			e.addTicket2(this, false);
		}
		
	}
	/*public void addInt(Intervencion i) {
		this.addInt(i,true);
	}
	public void addInt(Intervencion i, boolean a) {
		if(i != null) {
			if(this.getListainterveniones().contains(i)) {
				this.getListainterveniones().set(this.getListainterveniones().indexOf(i), i);
				
			}
			else {
				this.getListainterveniones().add(i);
			}
			if(a) {
				i.setTicket2(this, false);
			}
		}
	}
	public List<Intervencion> getListainterveniones (){
		return this.listaintervenciones;
	}*/
	
	
	
	
}
