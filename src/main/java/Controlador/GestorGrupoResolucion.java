package Controlador;

import java.util.ArrayList;
import java.util.List;

import Modelo.GrupoResolucion;
import Modelo.GrupoResolucionDTO;

public class GestorGrupoResolucion {
	
	public GestorBDD gestorBDD= new GestorBDD();
	
	
	public GestorGrupoResolucion() {

	}
	
//Agregado para los combobox CAMI
	

	public List<GrupoResolucionDTO> getGrupoResolucion() {
		
		
		List<GrupoResolucion> gd = gestorBDD.getGrupoResolucion();
		
		ArrayList<GrupoResolucionDTO> resultado = new ArrayList<GrupoResolucionDTO>();
		for (int i=0; i<gd.size(); i++) {
			String nom = gd.get(i).getNom_grupo();
			GrupoResolucionDTO clas = new GrupoResolucionDTO(nom);
				
			resultado.add(clas);
				
			}
		return resultado;
	}
}
