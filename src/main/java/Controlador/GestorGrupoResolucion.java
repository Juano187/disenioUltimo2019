package Controlador;

import java.util.ArrayList;
import java.util.List;

import Modelo.Clasificacion;
import Modelo.GrupoResolucion;
import Modelo.GrupoResolucionDTO;

public class GestorGrupoResolucion {
	
	public GestorBDD gBDD= new GestorBDD();
	
	
	public GestorGrupoResolucion() {

	}
	
	public GrupoResolucion getGrupo(Integer grupo) {
		
		return gBDD.getgrupo(grupo);
	}
	
	public GrupoResolucion getGrupo(String grupo) {
		return gBDD.getgrupo(grupo); 
	}
	
	//Agregado para los combobox CAMI
	public List<GrupoResolucionDTO> getGrupoResolucion() {
		
		
		List<GrupoResolucion> gd = gBDD.getGrupoResolucion();
		
		ArrayList<GrupoResolucionDTO> resultado = new ArrayList<GrupoResolucionDTO>();
		for (int i=0; i<gd.size(); i++) {
			String nom = gd.get(i).getNom_grupo();
			Integer id = gd.get(i).getId_grupo();
			GrupoResolucionDTO clas = new GrupoResolucionDTO(nom, id);
				
			resultado.add(clas);
				
			}
		return resultado;
	}
	
	
	
	
public List<GrupoResolucion> getGrupoR() {
		
		
		List<GrupoResolucion> gd = gBDD.getGrupoResolucion();
		
		ArrayList<GrupoResolucion> resultado = new ArrayList<GrupoResolucion>();
		for (int i=0; i<gd.size(); i++) {
			String nom = gd.get(i).getNom_grupo();
			Integer niv = gd.get(i).getNivel();
			GrupoResolucion clas = new GrupoResolucion(nom, niv);
				
			resultado.add(clas);
				
			}
		return resultado;
	}
	
	



	/*public GrupoResolucionDTO getGrupo(int codcla) {   

		List<GrupoResolucion> listagrupos = gBDD.getGrupoResolucion();
		for(GrupoResolucion g : listagrupos) {
			List<Clasificacion> clasificaciones = g.getListaclasificacion();
			for(Clasificacion c:clasificaciones) {
				if(c.getCodigo()==codcla) {
					GrupoResolucionDTO a = new GrupoResolucionDTO(g.getNom_grupo());
							
							
					return a;
				}
			}
		}
		return null;
	}*/
			
	
	


}
