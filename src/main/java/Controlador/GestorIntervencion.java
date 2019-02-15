package Controlador;

import java.util.Date;

import Modelo.EstadoIntervencion;
import Modelo.GrupoResolucion;
import Modelo.Intervencion;
import Modelo.Ticket;
import Modelo.Usuario;


public class GestorIntervencion {
	GestorBDD gestorBDD = new GestorBDD();


public Intervencion crearIntervencion(String descrip, Date f, Date a, EstadoIntervencion e ,  
			Usuario user) {
		
	
		
		Intervencion in = new Intervencion(descrip, f, e);
		System.out.println(in.getId_intervencion());
		//Intervencion i = gestorBDD.guardarIntervencion(in);
	

		// TODO Auto-generated method stub
		return in;
	}

public Intervencion cambioInterv(Integer numTicket, String observ, GrupoResolucion grup /*, Usuario u*/) {
	
	System.out.println("cambio interv");
	System.out.println(numTicket);

	System.out.println(observ);
	System.out.println(grup.getNom_grupo());
	
	Date fecha = new Date();
	
	
	
	
	Intervencion i2;
	
	Intervencion newi = gestorBDD.ultimaInt(numTicket, grup);
	System.out.println("se obtuvo interv ");
	System.out.println(newi.getId_intervencion());		
	System.out.println(newi.getEstadointervencion());		
	
	//newi.setObservaciones(observ);
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
