package Controlador;

import java.util.Date;

import Modelo.Clasificacion;
import Modelo.EstadoIntervencion;
import Modelo.EstadoTicket;
import Modelo.HistorialClasificacion;
import Modelo.HistorialTicket;
import Modelo.Historial_Intervencion;
import Modelo.Intervencion;
import Modelo.Ticket;
import Modelo.Usuario;

public class GestorHistorial {
	public GestorBDD gestorbdd = new GestorBDD(); 

	public HistorialTicket crearHistorialT(Usuario u, EstadoTicket abiertoderivado, Ticket t, Date f, Date fecha) {
		
		HistorialTicket ht1= new HistorialTicket(EstadoTicket.ABIERTODERIVADO ,f , t); 
	
		HistorialTicket h= gestorbdd.cargarHistorialT(ht1);
		
		return h;
	}

	public HistorialClasificacion crearHistorialC(Clasificacion c, Usuario u, Date f) {
		
		
		HistorialClasificacion hc1= new HistorialClasificacion(f ,u );
		hc1.setClasificacion(c);
		HistorialClasificacion h= gestorbdd.cargarHistorialC(hc1);
		
		
		return h;
	}

	public Historial_Intervencion crearHistorialI(EstadoIntervencion i, int id ,Usuario u, Date f) {
		System.out.println(i);
		System.out.println(id);
		System.out.println(u.getUsuario());

		Historial_Intervencion hi1= new Historial_Intervencion(f , i , id, u);
		
		Historial_Intervencion h= gestorbdd.cargarHistorialI(hi1);
		
		
		return h;
	}

}
