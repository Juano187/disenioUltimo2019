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
	public Ticket crearTicket() {
		Ticket ticket = new Ticket();
		Ticket nuevoTicket = gestorBDD.cargarTicket(ticket);
		return nuevoTicket;
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
	

	public void derivarTicket(Integer numTicket, String observ, GrupoResolucion grup) {
		Ticket ticket = this.getTicket(numTicket);
		Date fecha = new Date();
		System.out.println("hola2");
		ticket.setEstadoticket(1);
		
		Intervencion newI = gestorI.actualizarI(numTicket, observ , grup);
		
		if(newI != null) {
			newI.setTicket(ticket);
			ticket.add(newI);
			ticket.setFecha_cierre(fecha);
			
		}
		
		System.out.println("hola2");
		gestorBDD.actualizarTicket(ticket);
		System.out.println("hola2");
	}
	

	
	

	
	public void registrarTicket(int legajo,String clasific, String descripcion,Usuario user,Date f, Date fecha, Date hora) {
		
		try{
		Clasificacion c = gc.getClasificacion(clasific);
		Empleado e = ge.validarLegajo(legajo);
		Usuario u = user;
		GrupoResolucion gr = ggr.getGrupo(u.getGruporesolucion().getNom_grupo());
		
		Ticket t = new Ticket( fecha,descripcion,EstadoTicket.ABIERTODERIVADO,hora);
			e.addTicket(t);
			c.addTicket(t);
		HistorialTicket ht=(new HistorialTicket(f));	
			t.add(ht);
			gestorBDD.cargarHistorialT(ht);
		
		Intervencion i = new Intervencion(descripcion,f,EstadoIntervencion.TRABAJANDO);
			i.setGr(gr);
		
		HistorialClasificacion hc = new HistorialClasificacion (f);
			gestorBDD.cargarHistorialC(hc);
		
		Historial_Intervencion hi = new Historial_Intervencion(f,EstadoIntervencion.TRABAJANDO);
			gestorBDD.cargarHistorialI(hi);
			
		System.out.println("id historial_I: "+ hi.getIdHistorial()+ " id historial_C" + hc.getIdHistorial()+ " id historial_T"+ ht.getIdHistorial());
		
			c.addHistorial(hc);
			u.addHI(hi);
			u.addHT(ht);
			u.addHC(hc);
			i.add(hi);
			t.add(i);
		
			gestorBDD.cargarTicket(t);
		System.out.println("ticket guardado " + getTicket(t.getNum_ticket()));
	
		
		}catch(Exception ex) {
        	System.out.println(ex.getMessage());
    		EjemploError error = new EjemploError(ex.getMessage());
    		error.setVisible(true); 
    	}
				
		
		
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
	
	public static boolean validarDatosRegistro (int legajo, String descripcion, String clasificacion) {
	
	//if()
		
		
		return true;
		
	}
	

	public ArrayList<TicketDTO> consultarTicket(Long numTic, Integer legajo, Date fechaABien /*Date fechaUBien*/ , String estado,  ClasificacionDTO cla/*, GrupoResolucionDTO ugrupo*/){

		
		
		List<Ticket> gd = gestorBDD.getTickets(numTic, legajo , fechaABien, /*fechaUBien, */ estado ,cla /*ugrupo*/);
		
		ArrayList<TicketDTO> resultado = new ArrayList<TicketDTO>();
		
		for (int i=0; i<gd.size(); i++) {
			Ticket t = gd.get(i);
		//	GrupoResolucionDTO ug = new GrupoResolucionDTO(t.ultimaI().getGruporesolucion().getNom_grupo());
			ClasificacionDTO cla1 = new ClasificacionDTO(t.getClasificacion().getNom_clasificacion());
			TicketDTO tic = new TicketDTO();
			tic.setNumeroTicket(t.getNum_ticket());
			tic.setNumlegajo(t.getEmpleado().getLegajo());
			tic.setFechaA(t.getFecha_apertura());
			tic.setEstado2(t.getEstadoticket());
			tic.setCla(cla1);
			tic.setDescripcion(t.getDescrip_problema());
			//tic.setGru(ug);
			
				
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

	
	
	
	
	
	}

