package Controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

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
import Modelo.IntervencionDTO;
import Modelo.Ticket;

import Modelo.TicketDTO;
import Modelo.Usuario;
import ventanas.EjemploAdvertencia;
import ventanas.EjemploError;
import ventanas.Noincumbe;

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
	
	public void cambiarEstadoH ( Ticket t, EstadoTicket estado ) {
		HistorialTicket ht = t.getUltimoHistorial();
		Date f = new Date();
		ht.setfinal(f);
		t.setEstadoticket(1);
		HistorialTicket nuevo = new HistorialTicket(estado, f);
		
		 if(t.getListahistorial().contains(ht)) {
             t.getListahistorial().set(t.getListahistorial().indexOf(ht), ht);
         }
         else {
             t.getListahistorial().add(ht);
         }
		 
		 t.getListahistorial().add(nuevo);
	}
	


	public void derivarTicket(Integer numTicket, String observ, String grup , Usuario u , Integer idCla, Boolean a) {
		System.out.println("entro a gestorti, nombre grup = ");
		System.out.println(grup);
		
		Ticket ticket = gestorBDD.buscarTicket(numTicket);
		System.out.println("se obtuvo ticket con num y estado : ");
		System.out.println(ticket.getNum_ticket());
		System.out.println(ticket.getEstadoticket());
		
		//aca se cambia el estado
		cambiarEstadoH(ticket,EstadoTicket.ABIERTODERIVADO);
		
		Date fecha = new Date();
		System.out.println("nuevo estado del ticket es : ");
		System.out.println(ticket.getEstadoticket());
		
		GrupoResolucion g= gestorBDD.getgrupo(grup) ;
		System.out.println("se obtuvo grupo entero");	
		
		Intervencion intervencionU = gestorI.cambioInterv(numTicket, observ, g );		
		
		System.out.println("salio del gestor interv, volvio a gestor ticket, estado interv :");
		
		
		
		//System.out.println(intervencionU.getEstadointervencion());
		
		Intervencion i = ticket.getIntervencion(1);

		
		if(intervencionU != null) {
			intervencionU.setTicket(ticket);
			ticket.add(intervencionU);
			ticket.setFecha_cierre(fecha);
			
		}
		
		System.out.println("sale si hay interv en mesa de ayuda nombre y estado : ");
		System.out.println(i.getGruporesolucion().getNom_grupo());
		System.out.println(i.getEstadointervencion());
		
		i.setEstadointervencion(EstadoIntervencion.EN_ESPERA);
		i.setFecha_fin(fecha);
		System.out.println("la interv de mesa de ayuda se pone en espera: ");
		System.out.println(i.getEstadointervencion());
		
		//el problema esta aca
		
		if(a) {
			Clasificacion cls = gc.getClasificacion(ticket.getClasificacion().getNom_clasificacion());
			gc.cambiarEstadoHC(cls);
			ticket.setClasif(cls);
			}
		
		
	gestorBDD.actualizarTicket(ticket);
	System.out.println(ticket.getNum_ticket());
		
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
	

	
	public Ticket registrarTicket(int legajo,String clasific, String descripcion,Usuario user,Date f) {
		Ticket t2= new Ticket();
		try{
			System.out.print("fecha: " + f);
		Clasificacion c = gc.getClasificacion(clasific);
		Empleado e = ge.validarLegajo(legajo);
		
		if(e != null) {
		Usuario u = user;
		GrupoResolucion gr = ggr.getGrupo(u.getGruporesolucion().getNom_grupo());
		Ticket t = new Ticket(f,descripcion,EstadoTicket.ABIERTOSINDERIVAR);
			e.addTicket(t);
			c.addTicket(t);
		Intervencion i = new Intervencion(descripcion,f,EstadoIntervencion.TRABAJANDO);	
		HistorialTicket ht=(new HistorialTicket(f));
			ht.setClasificacion(c.getNom_clasificacion());
			ht.setEstadoT(EstadoTicket.ABIERTOSINDERIVAR);
			ht.setDescripcion(descripcion);
			
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
		}
		else {
			EjemploError cartel = new EjemploError("legajo invalido");	
			cartel.setVisible(true);
			
		}
			System.out.println("ticket guardado " + getTicket(t2.getNum_ticket()));
	
		
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
			tic.setFechaU(t.ultimaIGrupo().getFecha_inicio());
			tic.setEstado2(t.getEstadoticket());
			tic.setUsuario(t.getUsuOperador().getUsuario());
			tic.setCla(cla1);
			tic.setDescripcion(t.getDescrip_problema());
			tic.setGru(ug);
			tic.setEmpleado(t.getEmpleado());
					
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
		 ticket.setEstadoticket(3);
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
	
public void actualizarEstadoI(IntervencionDTO interv, String nuevestado, String observ, Clasificacion cla) {
		
		Ticket ticket = gestorBDD.buscarTicket(interv.getIdTicket());
		ticket = gestorI.actualizarI(interv, nuevestado, observ, ticket );
		
		
		if(ticket!=null && !((interv.getEstadoI() == EstadoIntervencion.ASIGNADO) && (nuevestado == EstadoIntervencion.TRABAJANDO.toString()))) {
			
			// TODO como la funcion actulizarI solo se actualiza ticket cuando va a espera o terminada, si pasa a trabajando se sube el histoarial
			
			if(nuevestado == EstadoIntervencion.EN_ESPERA.toString()) {
				ticket.setEstadoticket(1); 
			}
			if(nuevestado == EstadoIntervencion.TERMINADA.toString()) {
				//hacer la ventana para ver si es por asignacion incorrecta o no
				Boolean a;
				
				JOptionPane pane = new JOptionPane();
				pane.setBackground(new java.awt.Color(255, 150, 255));	
				int da=JOptionPane.YES_NO_OPTION;
						

                
				int dr = JOptionPane.showConfirmDialog (null, "¿Esta terminando la intervencion por una asignacion incorrecta?","Warning",da);
				
				if(dr == JOptionPane.YES_OPTION){
					a=true;
				}
				else {
					a=false;
				}
				
				
			

				System.out.println("interv abierttas____");
				System.out.println(ticket.getIntervencionesAbiertas().SIZE);
		
				    	
				   
				if(a || ticket.getIntervencionesAbiertas()> 1) {
					ticket.setEstadoticket(2);
				}
				else {
					ticket.setEstadoticket(4);
				}
			
				
				
			}
			
			ticket.getListaintervenciones().get(ticket.getListaintervenciones().size()-1).setTicket(ticket);
			
			if(!cla.getNom_clasificacion().equalsIgnoreCase(ticket.getClasificacion().getNom_clasificacion())) {
				// TODO aca va historial cla
				Clasificacion cls = gc.getClasificacion(cla.getNom_clasificacion());
				gc.cambiarEstadoHC(cls);
				ticket.setClasif(cla);
				
			}
			
			gestorBDD.actualizarTicket(ticket);
		}
		}

	
	

	
}
