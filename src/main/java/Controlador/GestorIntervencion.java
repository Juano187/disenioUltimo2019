package Controlador;

import java.util.Date;

import Modelo.EstadoIntervencion;
import Modelo.GrupoResolucion;
import Modelo.Intervencion;
import Modelo.Ticket;
import Modelo.Usuario;


public class GestorIntervencion {
	GestorBDD gestorBDD;

	public Intervencion crearIntervencion( Ticket tc, GrupoResolucion gr, Date f, Date a, EstadoIntervencion t ,  
			Usuario user) {
		
	
		
		Intervencion in = new Intervencion (tc, gr, f, a, EstadoIntervencion.TRABAJANDO);
		System.out.println(in.getId_intervencion());
		//Intervencion i = gestorBDD.guardarIntervencion(in);
	

		// TODO Auto-generated method stub
		return in;
	}
	
	
	
	
	

}
