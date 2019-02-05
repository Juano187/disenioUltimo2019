package Controlador;

import java.util.Date;

import Modelo.EstadoIntervencion;
import Modelo.Intervencion;
import Modelo.Usuario;


public class GestorIntervencion {
	GestorBDD gestorBDD;

	public Intervencion crearIntervencion(int id_intervencion, Date f, Date a, EstadoIntervencion trabajando,
			Usuario user) {
		
		
		
		Intervencion in = new Intervencion (id_intervencion, f, a, trabajando);
		in.setGruporesolucion(gestorBDD.getgrupo(1));
		
		
		// TODO Auto-generated method stub
		return in;
	}
	
	
	
	
	

}
