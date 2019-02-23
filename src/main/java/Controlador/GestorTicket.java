package Controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Modelo.Clasificacion;
import Modelo.ClasificacionDTO;
import Modelo.Direccion;
import Modelo.Empleado;
import Modelo.EstadoIntervencion;
import Modelo.EstadoTicket;
import Modelo.GrupoResolucion;
import Modelo.GrupoResolucionDTO;
import Modelo.HistorialClasificacion;
import Modelo.HistorialTicket;
import Modelo.Historial_Intervencion;
import Modelo.Intervencion;
import Modelo.Ticket;

import Modelo.TicketDTO;
import Modelo.Usuario;
import ventanas.EjemploError;

public class GestorTicket {
	public GestorClasificacion gc = new GestorClasificacion();
	public GestorEmpleado ge = new GestorEmpleado();
	public GestorBDD gestorBDD= new GestorBDD();
	public GestorUsuario gu = new GestorUsuario();
	public GestorGrupoResolucion ggr = new GestorGrupoResolucion();
	public GestorIntervencion gestorI = new GestorIntervencion();
	public GestorHistorial gestorH = new GestorHistorial();
	public GestorTicket() {
		
	}
	
	
	//todos metodos creados para interfazConsultarticket
	public Ticket getTicket(int t) {
		Ticket a = new Ticket();
		List<Ticket> gd = gestorBDD.getTickets();
		for (int i =0 ; i< gd.size() ;i++) {
			if(gd.get(i).getNum_ticket() == t) {
				 a = gd.get(i);
			}	
		}
		return a;
	}

	
	public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	

	public void derivarTicket(Integer numTicket, String observ, String grup , Usuario u , Integer idCla) {
		System.out.println("entro gestor ti, nombre grup = ");
		System.out.println(grup);
		
		Ticket ticket = gestorBDD.buscarTicket(numTicket);
		
		System.out.println(ticket.getNum_ticket());
		
		
		ticket.setEstadoticket(1);
		Date fecha = new Date();
		System.out.println(ticket.getEstadoticket());
		
		GrupoResolucion g= gestorBDD.getgrupo(grup) ;
		System.out.println("se obtuvo grupo entero");	
		
		Intervencion intervencionU = gestorI.cambioInterv(numTicket, observ, g /*, u*/);		
		
	
		
		Intervencion i = ticket.getIntervencion(1);

		
		if(intervencionU != null) {
			intervencionU.setTicket(ticket);
			ticket.add(intervencionU);
			ticket.setFecha_cierre(fecha);
			
		}
		
		System.out.println(i.getGruporesolucion().getNom_grupo());
		
		
		i.setEstadointervencion(EstadoIntervencion.EN_ESPERA);
		i.setFecha_fin(fecha);
		
		
		gestorBDD.actualizarTicket(ticket);
		
	}


	
	

	
	public Ticket registrarTicket(int legajo,String clasific, String descripcion,Usuario user,Date f, Date fecha, Date hora) {
		Ticket t2= new Ticket();
		try{
			
		Clasificacion c = gc.getClasificacion(clasific);
		Empleado e = ge.validarLegajo(legajo);
		Usuario u = user;
		GrupoResolucion gr = ggr.getGrupo(u.getGruporesolucion().getNom_grupo());
		Ticket t = new Ticket( fecha,descripcion,EstadoTicket.ABIERTODERIVADO,hora);
			e.addTicket(t);
			c.addTicket(t);
			Intervencion i = new Intervencion(descripcion,f,EstadoIntervencion.TRABAJANDO);	
		HistorialTicket ht=(new HistorialTicket(f));

		HistorialClasificacion hc = new HistorialClasificacion (f);
		
		Historial_Intervencion hi = new Historial_Intervencion(f,EstadoIntervencion.TRABAJANDO);
			
			i.setGr(gr);
			t.addH(ht);
			c.addHistorial(hc);
			hi.setUser(u);
			ht.setUser(u);
			hc.setUser(u);
			i.addHi(hi);

			t.addInt(i);
		
			gestorBDD.cargarTicket(t);
			
			t2=t;
			
			System.out.println("ticket guardado " + getTicket(t.getNum_ticket()));
	
		
		}catch(Exception ex) {
        	System.out.println(ex.getMessage());
    		EjemploError error = new EjemploError(ex.getMessage());
    		error.setVisible(true); 
    	}
				
		
		return t2;
	}
	
	public Ticket getTicket(Integer id) {
	List<Ticket> gd = gestorBDD.getTickets();
		
		Ticket resultado = new Ticket();
		
		for (int i=0; i<gd.size(); i++) {
			if(gd.get(i).getNum_ticket() == id){
				resultado = gd.get(i);
			}
		}
		return resultado;
	}

	public static Date stringtodate(String fecha) {
		Date f=null;
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            formatoFecha.setLenient(false);
            f= formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return null;
        }
        return f;
    }
	
/*	
	public static boolean validarDatosRegistro (int legajo, String descripcion, String clasificacion) {
	
	//if()
		
		
		return true;
		
	}*/
	


public ArrayList<TicketDTO> consultarTicket(Long numTic, Integer legajo, Date fechaABien , Date fechaUBien , String estado,  ClasificacionDTO cla, GrupoResolucionDTO ugrupo){

	
		
		List<Ticket> gd = gestorBDD.getTickets(numTic, legajo , fechaABien, fechaUBien,  estado ,cla , ugrupo);
		
		ArrayList<TicketDTO> resultado = new ArrayList<TicketDTO>();
		
		
		for (int i=0; i<gd.size(); i++) {
			
			Ticket t = gd.get(i);
		
		    GrupoResolucion ug = new GrupoResolucion(t.ultimaIGrupo().getGruporesolucion().getNom_grupo() , t.ultimaIGrupo().getGruporesolucion().getId_grupo());
			Clasificacion cla1 = new Clasificacion(t.getClasificacion().getNom_clasificacion());
			TicketDTO tic = new TicketDTO();
			
			System.out.println("gestorticket consultar");
			System.out.println(ug.getNom_grupo());
			System.out.println(t.getUsuOperador().getUsuario());
			System.out.println(t.getEstadoticket());
			
			
			tic.setNumeroTicket(t.getNum_ticket());
			tic.setNumlegajo(t.getEmpleado().getLegajo());
			tic.setFechaA(t.getFecha_apertura());
			tic.setFechaU(t.getFecha_cierre());
			tic.setEstado2(t.getEstadoticket());
			tic.setUsuario(t.getUsuOperador().getUsuario());
			tic.setCla(cla1);
			tic.setDescripcion(t.getDescrip_problema());
			tic.setGru(ug);
				
					
			resultado.add(tic);
			}
		
		return resultado;

	}		

	
	
	public TicketDTO consultarTicket(Integer numTSeleccionado, ArrayList<TicketDTO> listaTencontrados){
		TicketDTO tic = new TicketDTO();
		for(TicketDTO t: listaTencontrados) {
			if(t.getNumeroTicket() == numTSeleccionado) {
				tic = t;
			}
		}
		return tic;
	}

	public void cerrarTicket(Integer numTicket, String obser) {
		
		 Ticket ticket = gestorBDD.buscarTicket(numTicket);
		 ticket.setEstadoticket(4);
		 ticket.setDescrip_problema(obser);
		 Date fecha = new Date();
		
		 System.out.println(ticket.getEstadoticket());
		
			
		Intervencion i = ticket.getIntervencion(1);
		i.setObservaciones(obser);
		i.setEstadointervencion(EstadoIntervencion.TERMINADA);
			
		ticket.setFecha_cierre(fecha);
		i.setFecha_fin(fecha);	
		 
		 
		gestorBDD.actualizarTicket(ticket);
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	}

