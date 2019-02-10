package Controlador;

import java.util.Date;

import Modelo.EstadoIntervencion;
import Modelo.GrupoResolucion;
import Modelo.Intervencion;
import Modelo.Ticket;
import Modelo.Usuario;


public class GestorIntervencion {
	GestorBDD gestorBDD;

	public Intervencion crearIntervencion(String descrip, Date f, Date a, EstadoIntervencion t ) {
		
		Intervencion i = new Intervencion(descrip,f,EstadoIntervencion.TRABAJANDO);
		
		
		
		System.out.println(i.getId_intervencion());
	
		return i;
	}
	
	
	
	
	

}
