package Controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Modelo.Clasificacion;
import Modelo.ClasificacionDTO;
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
	
	public int registrarTicket(int legajo,String clasific, String descripcion,Usuario user,Date f, Date fecha, Date hora) {
		
		
		try {
			
		Clasificacion c = gc.getClasificacion(clasific);
		Empleado e = ge.validarLegajo(legajo);
		Date a = new Date();
		Usuario u = user;

		int id_t = (gestorBDD.getTickets().size() +1);
		
		System.out.println("hasta aca todo bien");
		Ticket t = new Ticket(id_t,fecha,descripcion,EstadoTicket.ABIERTODERIVADO,hora);
		t.setEmp(e);
		t.setClasificacion(c);
		t.setEmp(e);
		
		HistorialTicket ht=new HistorialTicket(f);	
		t.addH(ht);
		
		GrupoResolucion gr = ggr.getGrupo(u.getGruporesolucion().getNom_grupo());
		
		int id_intervencion = (gestorBDD.getIntervenciones().size()+1);
		Intervencion i = new Intervencion(id_intervencion,f,a,descripcion,EstadoIntervencion.TRABAJANDO);
		i.setGr(gr);
		HistorialClasificacion hc = new HistorialClasificacion (f);
		hc.setUser(u);
		
		Historial_Intervencion hi = new Historial_Intervencion(f);
		hi.setUser(u);
		i.addHi(hi);
		t.addH(ht);
		
	//	System.out.println("MOSTRAME LA INTERVENCION GATO "  +id_intervencion+ "  " + (gestorBDD.getTickets().size() +1));

		
	

		gestorBDD.cargarTicket(t);
		//gestorBDD.cargarHistorialI(hi);
		//gestorBDD.cargarHistorialC(hc);
	
		}catch(Exception ex) {
        	System.out.println(ex.getMessage());
    		EjemploError error = new EjemploError(ex.getMessage());
    		error.setVisible(true); 
    	}
		
		
		
		return 1;
		
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

