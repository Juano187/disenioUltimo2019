package Controlador;

import java.util.Date;

import Modelo.EstadoIntervencion;
import Modelo.GrupoResolucion;
import Modelo.Intervencion;
import Modelo.Ticket;
import Modelo.Usuario;


public class GestorIntervencion {
	GestorBDD gestorBDD;


public Intervencion crearIntervencion(String descrip, Date f, Date a, EstadoIntervencion e ,  
			Usuario user) {
		
	
		
		Intervencion in = new Intervencion(descrip, f, e);
		System.out.println(in.getId_intervencion());
		//Intervencion i = gestorBDD.guardarIntervencion(in);
	

		// TODO Auto-generated method stub
		return in;
	}

	public Intervencion actualizarI(Integer numTicket, String observ, GrupoResolucion grup) {
	
		Date fecha = new Date();
		
		
		System.out.println("hola3");
		Intervencion i = gestorBDD.getIntervMESA(numTicket);
		
		i.setFecha_fin(fecha);
		i.setEstadointervencion(EstadoIntervencion.EN_ESPERA);
		gestorBDD.guardarIntervencion(i);
		System.out.println("hola3");
		Intervencion i2;
		
			
		Intervencion newi = gestorBDD.ultimaInt(numTicket, grup);
				
		System.out.println("hola3");
		
		newi.setObservaciones(observ);
		if(newi == null || (newi.getEstadointervencion() == EstadoIntervencion.TERMINADA)) {
			Intervencion intervg = new Intervencion();
			intervg.setFecha_inicio(fecha);
			intervg.setGruporesolucion(grup);
			intervg.setEstadointervencion(EstadoIntervencion.ASIGNADO);
			i2 = intervg;
					
			
		}
		else {
			Date fechafin = new Date();
			newi.setFecha_fin(fechafin);
			newi.setEstadointervencion(EstadoIntervencion.ASIGNADO);
			gestorBDD.actualizarIntervencion(newi);
			i2 = null;
		}
		
		
				 
		
		
		
		
		
		return i2;
	}

	
	



	
	
	
	

}
