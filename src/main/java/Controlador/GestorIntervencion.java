package Controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Modelo.ClasificacionDTO;
import Modelo.EstadoIntervencion;
import Modelo.EstadoTicket;
import Modelo.GrupoResolucion;
import Modelo.HistorialTicket;
import Modelo.Historial_Intervencion;
import Modelo.Intervencion;
import Modelo.IntervencionDTO;
import Modelo.Ticket;
import Modelo.Usuario;
import ventanas.EjemploError;


public class GestorIntervencion {
	GestorBDD gestorBDD = new GestorBDD();
	GestorEmpleado gestorE = new GestorEmpleado(); 


public Intervencion crearIntervencion(String descrip, LocalDate f, LocalDate a, EstadoIntervencion e ,  
			Usuario user) {
		
	
		
		Intervencion in = new Intervencion(descrip, f, e);
		System.out.println(in.getId_intervencion());
		//Intervencion i = gestorBDD.guardarIntervencion(in);
	

		// TODO Auto-generated method stub
		return in;
	}



public Intervencion cambioInterv(Integer numTicket, String observ, GrupoResolucion grup ) {
	
	System.out.println("gestor interv, con grupo, num y nombre grupo");
	System.out.println(numTicket);

	System.out.println(observ);
	System.out.println(grup.getNom_grupo());
	
	LocalDate fecha = LocalDate.now();
	

	Intervencion i2;
	
	Intervencion newi = gestorBDD.ultimaInt(numTicket, grup);
	System.out.println("se obtuvo ultima interv ");
	System.out.println("verifica si es nulo o no");
			
	
	//newi.setObservaciones(observ);
	if(newi == null || (newi.getEstadointervencion() == EstadoIntervencion.TERMINADA)) {
		System.out.println("es nulo asique se crear inter o ter minado");
		
		Intervencion intervg = new Intervencion();
		Historial_Intervencion hi = new Historial_Intervencion(fecha,EstadoIntervencion.ASIGNADO);
		intervg.addHi(hi);
		
		intervg.setFecha_inicio(fecha);
		intervg.setGruporesolucion(grup);
		intervg.setEstadointervencion(EstadoIntervencion.ASIGNADO);
		i2 = intervg;
				
		
	}
	else {
		System.out.println("no es nulo asiq se actualiza");
	
		LocalDate fechafin = LocalDate.now();
		Historial_Intervencion nuevo = new Historial_Intervencion(fecha,EstadoIntervencion.ASIGNADO);
		Historial_Intervencion hi = newi.getUltimoHistorial();
		hi.setfinal(fechafin);
		 if(newi.getListahistorial().contains(hi)) {
             newi.getListahistorial().set(newi.getListahistorial().indexOf(hi), hi);
         }
         else {
             newi.getListahistorial().add(hi);
         }
		 
		 newi.getListahistorial().add(nuevo);
	
		/*newi.setFecha_fin(fechafin);
		newi.setEstadointervencion(EstadoIntervencion.ASIGNADO);*/
		gestorBDD.actualizarIntervencion(newi);
		i2 = null;
	}
	

	
	return i2;
}




public ArrayList<IntervencionDTO> consultarIntervAsigna(Long numTicket, Integer numLeg, String estado, LocalDate desde,
		LocalDate hasta) {
	System.out.println("ñega");
	System.out.println(numLeg);
	
	Integer idg = gestorE.getGrupo(numLeg);
	
	ArrayList<Intervencion> busI = gestorBDD.consultarItervencion(numTicket, numLeg, estado, desde, hasta, idg);
	ArrayList<IntervencionDTO> intervenciones= new ArrayList<IntervencionDTO>();
	
	for(Intervencion a : busI) {
		Ticket t = a.getTicket();
		
	
		IntervencionDTO i= new IntervencionDTO();
		ClasificacionDTO clasif = new ClasificacionDTO(t.getClasificacion().getNom_clasificacion(), t.getClasificacion().getCodigo());
		GrupoResolucion grup = new GrupoResolucion(t.getIntervencionidI(a.getId_intervencion()).getGruporesolucion().getNom_grupo(), t.getIntervencionidI(a.getId_intervencion()).getGruporesolucion().getId_grupo());
		
		
		i.setIdI(a.getId_intervencion());
		i.setIdTicket(t.getNum_ticket());
		i.setEstadoT(t.getEstadoticket());
		i.setEstadoI(a.getEstadointervencion());
		i.setLegajo(t.getEmpleado().getLegajo());
		i.setFechap(t.getFecha_apertura());
		i.setFechaAs(a.getFecha_inicio());
		i.setObserv(a.getObservaciones());
		i.setClas(clasif);
		i.setGrup(grup);
		
		intervenciones.add(i);
	}
	// TODO Auto-generated method stub
	return intervenciones;
}
	
public IntervencionDTO consultarI(Integer numISeleccionado, ArrayList<IntervencionDTO> listaIencontrados) {
	IntervencionDTO intv = new IntervencionDTO();
	Integer e= listaIencontrados.size();
	System.out.println(e);
	for(IntervencionDTO i : listaIencontrados) {
		
		if(i.getIdTicket() == numISeleccionado) {
			intv = i;
			
			
		}
	}
	return intv;
}
//TODO agregar

public Ticket actualizarI(IntervencionDTO i, String nuevestado, String observ, Ticket ticket) {
	Ticket tr = new Ticket();
	
	Intervencion inter= gestorBDD.getIntervencion(i.getIdI());
	System.out.println("interv q se consigio");
	Date fechaAhora = new Date();  
	System.out.println(inter.getId_intervencion());
	 
	
	if((((inter.getEstadointervencion() == EstadoIntervencion.TRABAJANDO) && nuevestado == EstadoIntervencion.EN_ESPERA.toString()) || 
	((inter.getEstadointervencion()== EstadoIntervencion.TRABAJANDO) && nuevestado == EstadoIntervencion.TERMINADA.toString()))|| 
((inter.getEstadointervencion()== EstadoIntervencion.ASIGNADO) && nuevestado == EstadoIntervencion.TRABAJANDO.toString())){
		
		//TODO va el cambio del historial de Intervencion,  se pone como fecha fin interv fechaAhora
		
		if((inter.getEstadointervencion()== EstadoIntervencion.ASIGNADO) && nuevestado == EstadoIntervencion.TRABAJANDO.toString()) {
			//inter.setEstadointervencion(EstadoIntervencion.TRABAJANDO);
			System.out.println("entro a asig a trab");
			cambiarEstadoI(inter, EstadoIntervencion.TRABAJANDO);
		}
		else {
			// TODO se le setea ahora la fecha al historial del cambio de estado ticket con fecha actual ya q se pasa a otro grupo
			
			if((inter.getEstadointervencion() == EstadoIntervencion.TRABAJANDO) && nuevestado == EstadoIntervencion.EN_ESPERA.toString()) {
				System.out.println("entro a trab a en esepera");
				cambiarEstadoI(inter, EstadoIntervencion.EN_ESPERA);
				//inter.setEstadointervencion(EstadoIntervencion.EN_ESPERA);
			}
			if((inter.getEstadointervencion() == EstadoIntervencion.TRABAJANDO) && nuevestado == EstadoIntervencion.TERMINADA.toString()) {
				//inter.setEstadointervencion(EstadoIntervencion.TERMINADA);
				System.out.println("entro a trab a termianda");
				cambiarEstadoI(inter, EstadoIntervencion.TERMINADA);
			}
			
			
		}
		System.out.println("salio de las comparaciones, tiene q setearweeeee");
		System.out.println(inter.getEstadointervencion());
		System.out.println(inter.getId_intervencion());
		System.out.println(ticket.getNum_ticket());
		inter.setTicket(ticket);

		gestorBDD.actualizarIntervencion(inter);
		tr = ticket;
		
		
	}
	else {
		String e= "No es valido el nuevo estado de ticket";
		EjemploError ia = new EjemploError(e);
		ia.setVisible(true);
	}
	
	
	
	
	return tr;
}	
	
public void cambiarEstadoI ( Intervencion i, EstadoIntervencion estado ) {
	//System.out.println("entro para cambiar histo y estado");
	Historial_Intervencion ht = i.getUltimoHistorial();
	//System.out.println(ht.getIntervencion().getId_intervencion());
	LocalDate f = LocalDate.now();
	ht.setfinal(f);
	i.setEstadointervencion(estado);
	Historial_Intervencion nuevo = new Historial_Intervencion(f, estado, i);
	
	 if(i.getListahistorial().contains(ht)) {
         i.getListahistorial().set(i.getListahistorial().indexOf(ht), ht);
     }
     else {
         i.getListahistorial().add(ht);
     }
	 
	 i.getListahistorial().add(nuevo);
}

}
