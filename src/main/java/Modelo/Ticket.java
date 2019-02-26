package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;




@Entity
@Table(name = "TICKET")
public class Ticket implements  Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUM_TICKET")
	private Integer num_ticket;
	


	@Column(name = "FECHA_APERTURA",nullable= true)
	private Date fecha_apertura;
	
	@Column(name = "FECHA_CIERRE",nullable= true)
	private Date fecha_cierre;
	
	
	@Column(name = "DESCRIP_PROBLEMA",length = 5000)
	private String descrip_problema;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO")
	private Clasificacion clasificacion;
	
	@Enumerated(value = EnumType.STRING)
	@JoinColumn(name = "estadoticket")
	private EstadoTicket estadoticket;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "LEGAJO")
	private Empleado empleado;
	
	@OneToMany(	cascade = CascadeType.ALL, mappedBy = "ticket")
	
	//@Fetch(value = FetchMode.SUBSELECT)
	//@JoinColumn(name = "numero")
	
	private List<Intervencion> listaintervenciones = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
	//	@Fetch(value = FetchMode.SUBSELECT)
	private List<HistorialTicket> listahistorial = new ArrayList<>();
	
	public Ticket() {
		
		listaintervenciones = new ArrayList<>();
		listahistorial = new ArrayList<>();
		
	}


	public Ticket(Date fecha_apertura, String descrip_problema,
			EstadoTicket estadoticket) {
		
		listaintervenciones = new ArrayList<>();
		listahistorial = new ArrayList<>();
		
		this.fecha_apertura = fecha_apertura;
		
		this.descrip_problema = descrip_problema;
		this.estadoticket = estadoticket;
	}
	
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado e) {
		
		this.empleado = e;
	}
	
	public void addInt(Intervencion i) {
		this.addInt(i,true);
	}
	public void addInt(Intervencion i, boolean a) {
		if(i != null) {
			if(this.getListaintervenciones().contains(i)) {
				this.getListaintervenciones().set(this.getListaintervenciones().indexOf(i), i);
				
			}
			else {
				this.getListaintervenciones().add(i);
			}
			if(a) {
				i.setTicket(this, false);
			}
		}
	}
	
	public HistorialTicket getUltimoHistorial () {
		HistorialTicket result = new HistorialTicket ();
		for (HistorialTicket ht : this.listahistorial) {
			if(ht.getFechaFin() == null) {
				result= ht;
			}
			
		}
		return result;
	}
	
	public void addH( HistorialTicket ht) {
	 this.listahistorial.add(ht);
	 ht.setTicket(this);
	}

	public void setEmp(Empleado e) {
		setEmp(e,true);
	}
	
	public void setEmp(Empleado e, boolean a) {
		this.empleado = e;
		if(e!=null && a) {
			e.addTicket(this, false);
		}
	}

	public void setClasif(Clasificacion c) {
		setClasif(c,true);
	}
	public void setClasif ( Clasificacion c, boolean a) {
		this.clasificacion=c;
		if(c!=null && a) {
			c.addTicket(this, false);
		}
	}
	
	public Clasificacion getClasificacion() {
		return clasificacion ;
			
	}
	
	public void setListainterveniones(List<Intervencion> listainterveniones) {
		this.listaintervenciones = listainterveniones;
	}


	public Integer getNum_ticket() {
		return num_ticket;
	}
	
	public Usuario getUsuOperador() {
		System.out.println("pelotuda");
		
		return listahistorial.get(0).getUser();
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





	public List<Intervencion> getListaintervenciones() {
		return listaintervenciones;
	}

	
	public void add(Intervencion interv) {
		listaintervenciones.add(interv);
	}
	
	

	
	public Intervencion ultimaIGrupo() {
		Intervencion u = listaintervenciones.get(0);
		for(Intervencion i: listaintervenciones) {
			System.out.println("fecha");
			System.out.println(i.getFecha_inicio());
			System.out.println(i.getEstadointervencion());
			System.out.println("fecha2");
			System.out.println(u.getFecha_inicio());
			System.out.println(u.getEstadointervencion());
			
			if(i.getFecha_inicio().compareTo(u.getFecha_inicio())>0) {
				if(i.getEstadointervencion()!= EstadoIntervencion.TERMINADA) {
					u=i;
					System.out.println("estado no terminada");
				}   else {	 
					for(Intervencion a: listaintervenciones) {
						if(a.getEstadointervencion() != EstadoIntervencion.EN_ESPERA) {
							u=i;
							System.out.println("estado no en espera");
							}
						}					
					}
				}
			}
				
	return u;	
	}




			
	
	/*

	public Date getHora_apertura() {
		return hora_apertura;
	}


	public void setHora_apertura(Date hora_apertura) {
		this.hora_apertura = hora_apertura;
	}*/


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
/*
	public Date getHora_cierre() {
		return hora_cierre;
	}


	public void setHora_cierre(Date hora_cierre) {
		this.hora_cierre = hora_cierre;
	}*/
	

	public Intervencion getIntervencion(int idgrupo) {
		for (int i=0;i<listaintervenciones.size(); i++) {
			if(listaintervenciones.get(i).getGruporesolucion().getId_grupo()==idgrupo) {
				return listaintervenciones.get(i);
			}
			
		}
		
		return null;
	}


	

	public List<HistorialTicket> getListahistorial() {
		return listahistorial;
	}


	@Override
	public String toString() {
		return this.descrip_problema;
	}

	

	
	
}
