package Controlador;

import java.util.ArrayList;
import java.util.List;

import Modelo.Clasificacion;
import Modelo.ClasificacionDTO;
import Modelo.GrupoResolucion;

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

public ArrayList<Clasificacion> getclasificacionsDTO(String grupo) {
	System.out.println("gestor cla :::")	;
	System.out.println(grupo);
	List<Clasificacion> gd=  gestorBDD.getClasificaciones();
	
	ArrayList<Clasificacion> r= new ArrayList<>();
	
	
	for(Clasificacion c: gd) {
		System.out.println("tamaño grupo por clas");
		System.out.println(c.getListaGr().size());
		for(GrupoResolucion g: c.getListaGr()) {
		
			if(g.getNom_grupo().equalsIgnoreCase(grupo)) {
				r.add(c);
			}
			
			
	}}
	return r;
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