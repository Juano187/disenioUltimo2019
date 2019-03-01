package Controlador;

import java.time.LocalDate;
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

	public HistorialTicket crearHistorialT(Usuario u, EstadoTicket abiertoderivado, Ticket t, LocalDate f, LocalDate fecha) {
		
		HistorialTicket ht1= new HistorialTicket(EstadoTicket.ABIERTODERIVADO ,f); 
		//ht1.setTicket(t);
		HistorialTicket h= gestorbdd.cargarHistorialT(ht1);
		
		return h;
	}

	public HistorialClasificacion crearHistorialC(Clasificacion c, Usuario u, LocalDate f) {
		
		
		HistorialClasificacion hc1= new HistorialClasificacion(f);
		hc1.setClasificacion(c);
		HistorialClasificacion h= gestorbdd.cargarHistorialC(hc1);
		
		
		return h;
	}

	public Historial_Intervencion crearHistorialI(EstadoIntervencion i, int id ,Usuario u, LocalDate f) {
		System.out.println(i);
		System.out.println(id);
		System.out.println(u.getUsuario());

		Historial_Intervencion hi1= new Historial_Intervencion(f , i );
		
		Historial_Intervencion h= gestorbdd.cargarHistorialI(hi1);
		
		
		return h;
	}

}
