package Controlador;

import java.util.Date;

import Modelo.EstadoTicket;
import Modelo.HistorialTicket;
import Modelo.Ticket;
import Modelo.Usuario;

public class GestorHistorial {
	public GestorBDD gestorbdd = new GestorBDD(); 

	public HistorialTicket crearHistorialT(Usuario u, EstadoTicket abiertoderivado, Ticket t, Date f, Date fecha) {
		
		HistorialTicket ht1= new HistorialTicket(EstadoTicket.ABIERTODERIVADO ,f); 
		
		HistorialTicket h= gestorbdd.cargarHistorialT(ht1);
		
		return h;
	}

}
