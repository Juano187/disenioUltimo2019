package Controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Modelo.Clasificacion;
import Modelo.ClasificacionDTO;
import Modelo.GrupoResolucion;
import Modelo.GrupoResolucionDTO;
import Modelo.Ticket;
import Modelo.TicketDTO;

public class GestorTicket {

	public GestorBDD gestorBDD= new GestorBDD();
	
	public GestorTicket() {
		
	}
	
	
	//todos metodos creados para interfazConsultarticket
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
	//(legajo,id_clasificacion,descripcion, u,fechaHoraString);
	public Ticket registrarTicket(int legajo,int id_cla, String descripcion,String user,Date f) {
		Ticket t = new Ticket();
		//codigo
		return t;
		
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
	/*public ArrayList<TicketDTO> getTickets ( ){
		ArrayList<TicketDTO> gd = gestorBDD.getTicket();
		
		ArrayList<TicketDTO> a = new ArrayList<TicketDTO>();
		TicketDTO t = new TicketDTO();
		
		for (int i=0; i<gd.size(); i++) {
		a.add();
		}
		return a;
	}*/
	
	//terminar cuando se termina la funcion en GestorBDD 	
	
	/*public List<TicketDTO> consultarTicket(Long numTic, Integer legajo, Date fechaABien, Date fechaUBien, String estado, ClasificacionDTO cla,  GrupoResolucionDTO ugrupo){

	List<TicketDTO> gd = gestorBDD.getTickets();
	
	ArrayList<TicketDTO> resultado = new ArrayList<TicketDTO>();
	
	for (int i=0; i<gd.size(); i++) {
		
		
		String nom = gd.get(i).getNum_ticket();
		TicketDTO tic = new TicketDTO(gd.ge);
			
		resultado.add(clas);
			
		}
	return resultado;
}*/
	public ArrayList<TicketDTO> consultarTicket(Long numTic, Integer legajo, Date fechaABien /*Date fechaUBien*/ , String estado,  ClasificacionDTO cla/*, GrupoResolucionDTO ugrupo*/){

		
		
		List<Ticket> gd = gestorBDD.getTickets(numTic, legajo , fechaABien, /*fechaUBien, */ estado ,cla /*ugrupo*/);
		
		ArrayList<TicketDTO> resultado = new ArrayList<TicketDTO>();
		
		for (int i=0; i<gd.size(); i++) {
			Ticket t = gd.get(i);
			//GrupoResolucionDTO ug = new GrupoResolucionDTO(t.ultimaI().getGruporesolucion().getNom_grupo());
			ClasificacionDTO cla1 = new ClasificacionDTO(t.getClasificacion().getNom_clasificacion());
			TicketDTO tic = new TicketDTO();
			tic.setNumeroTicket(t.getNum_ticket());
			tic.setNumlegajo(t.getEmpleado().getLegajo());
			tic.setFechaA(t.getFecha_apertura());
			tic.setEstado2(t.getEstadoticket());
			tic.setCla(cla1);
			//tic.setGru(ug);
			
				
			resultado.add(tic);
			}
		
		return resultado;
	}
	
	
	
	
	
	
	
	
	}

