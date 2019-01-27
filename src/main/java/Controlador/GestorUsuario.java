package Controlador;

import java.util.ArrayList;

import Modelo.Usuario;
import ventanas.EjemploError;

public class GestorUsuario {

	private GestorBDD gbdd = new GestorBDD();
	
	public GestorUsuario() {
		
	}
	public Usuario getUsuario(String e) {
		
		Usuario u =new Usuario();
		ArrayList<Usuario> U = gbdd.getUsuarios();
		
		for(int i= 0 ;i< U.size();i++) {
			if(e.equalsIgnoreCase(U.get(i).getUsuario()) ){
				u = U.get(i);
			}
		}
		return u;
	}
}
