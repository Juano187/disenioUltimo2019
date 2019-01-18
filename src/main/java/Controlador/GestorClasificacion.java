package Controlador;

import java.util.ArrayList;

import Modelo.Clasificacion;
import Modelo.ClasificacionDTO;

public class GestorClasificacion {

	
	
	

public GestorBDD gestorBDD= new GestorBDD();


public GestorClasificacion() {
	
}


public ArrayList<ClasificacionDTO> getClasificaciones() {
	
	ArrayList<Clasificacion> gd = gestorBDD.getClasificacion();
	
	ArrayList<ClasificacionDTO> a = new ArrayList<ClasificacionDTO>();
	for (int i=0; i<gd.size(); i++) {
			String nom = gd.get(i).getNom_clasificacion();
			ClasificacionDTO c = new ClasificacionDTO();
			c.setNombre(nom);
			
				a.add(c);
			
		}
	return a;
}
}