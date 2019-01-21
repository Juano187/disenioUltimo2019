package Controlador;

import java.util.ArrayList;

public class Pruebas {
	
	
	public static GestorEmpleado ge = new GestorEmpleado();
	

	public static void main(String[] args) {
		
		ArrayList<Integer> a = ge.getLegajos();
		
		
		for(int i = 0 ; i < a.size() ; i++ ) {
			System.out.println(a.get(i));
		}

	}

}
