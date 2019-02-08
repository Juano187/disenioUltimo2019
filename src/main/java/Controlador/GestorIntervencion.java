package Controlador;

import java.util.Date;

import Modelo.EstadoIntervencion;
import Modelo.GrupoResolucion;
import Modelo.Intervencion;
import Modelo.Usuario;


public class GestorIntervencion {
	GestorBDD gestorBDD;

	public Intervencion crearIntervencion( GrupoResolucion gr, Date f, Date a, EstadoIntervencion t ,  
			Usuario user) {
		
	
		
		Intervencion in = new Intervencion ( gr, f, a, EstadoIntervencion.TRABAJANDO);
		
		//Intervencion i = gestorBDD.guardarIntervencion(in);
	

		// TODO Auto-generated method stub
		return in;
	}
	
	
	
	
	

}
