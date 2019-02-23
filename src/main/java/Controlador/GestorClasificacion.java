package Controlador;

import java.util.ArrayList;

import Modelo.Clasificacion;
import Modelo.ClasificacionDTO;

public class GestorClasificacion {

	
	
	

public GestorBDD gestorBDD= new GestorBDD();


public GestorClasificacion() {
	
}
public Clasificacion getClasificacion (String c) {
	ArrayList<Clasificacion> gd = gestorBDD.getClasificacion();
	
	Clasificacion  a = new Clasificacion();
	for (int i=0; i<gd.size(); i++) {
		if(gd.get(i).getNom_clasificacion() == c) {
			a = gd.get(i);
		}
			
		}
	return a;
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

public ArrayList<Clasificacion> getClasificaciones2() {
	
	ArrayList<Clasificacion> gd = gestorBDD.getClasificacion();
	
	ArrayList<Clasificacion> a = new ArrayList<Clasificacion>();
	for (int i=0; i<gd.size(); i++) {
			String nom = gd.get(i).getNom_clasificacion();
			Clasificacion c = new Clasificacion();
			c.setNom_clasificacion(nom);
			
				a.add(c);
			
		}
	return a;
}
}