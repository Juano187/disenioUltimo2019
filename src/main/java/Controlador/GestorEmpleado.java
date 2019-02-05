package Controlador;

import java.util.ArrayList;

import Modelo.Direccion;
import Modelo.Empleado;
import ventanas.EjemploError;

public class GestorEmpleado {
	public GestorBDD gestorBDD = new GestorBDD();
	
	
	public GestorEmpleado() {
		
	}
	
	public ArrayList<Integer> getLegajos(){
		
		ArrayList<Empleado> e = gestorBDD.getEmpleado();
		ArrayList<Integer> legajos = new ArrayList<Integer>();
		
		for ( int i=0; i<e.size(); i++) {
			legajos.add(e.get(i).getLegajo());
			
		}
		
		return legajos;
		
	}
	
	public Empleado validarLegajo(int legajo) {
		boolean a = false;
		Empleado emp = new Empleado();
		ArrayList<Empleado> e = gestorBDD.getEmpleado();
		for( int i=0 ; i<e.size(); i++) {
			if(legajo == e.get(i).getLegajo()) {
				emp = e.get(i);
				a= true;
			}
		}
		if(a) {
			return emp;
		}
		else {
		EjemploError cartel = new EjemploError("legajo invalido");	
		cartel.setVisible(true);
		return emp;
		}
	}

	public Direccion getDireccion(int legajo) {
		
	
		return gestorBDD.getDireccion( legajo);
	}
}
