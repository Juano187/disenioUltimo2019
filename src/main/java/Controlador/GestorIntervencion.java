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

public Intervencion cambioInterv(Integer numTicket, String observ, String grup /*, Usuario u*/) {
	
	System.out.println("cambio");
	System.out.println(numTicket);

	System.out.println(observ);
	System.out.println(grup);
	
	Date fecha = new Date();
	GrupoResolucion g= gestorBDD.getgrupo(grup) ;
	
	
	
	Intervencion i2;
	System.out.println("shit");
	
	Intervencion newi = gestorBDD.ultimaInt(numTicket, g.getId_grupo());
	System.out.println(newi.getId_intervencion());		
	System.out.println(newi.getEstadointervencion());		
	
	//newi.setObservaciones(observ);
	if(newi == null || (newi.getEstadointervencion() == EstadoIntervencion.TERMINADA)) {
		Intervencion intervg = new Intervencion();
		intervg.setFecha_inicio(fecha);
		intervg.setGruporesolucion(g);
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
