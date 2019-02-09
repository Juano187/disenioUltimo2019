package Controlador;


import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Modelo.Clasificacion;
import Modelo.Direccion;
import Modelo.Empleado;

import Modelo.EstadoIntervencion;
import Modelo.EstadoTicket;
import Modelo.GrupoResolucion;
import Modelo.HistorialClasificacion;
import Modelo.HistorialTicket;
import Modelo.Historial_Intervencion;
import Modelo.Intervencion;
import Modelo.Ticket;

import Modelo.Usuario;
import ventanas.ActualizarEstadoIntervencionCU08;
import ventanas.EjemploError;
import ventanas.Inicializador01;
import ventanas.IniciarSesionCU00;


public class Principal {
	static GestorBDD gestorBDD = new GestorBDD();
	static GestorClasificacion gc = new GestorClasificacion();
	static GestorGrupoResolucion ggr = new GestorGrupoResolucion();
	static GestorUsuario gu = new GestorUsuario();
	static GestorTicket gt = new GestorTicket();
	static GestorEmpleado ge = new GestorEmpleado();
	private static EntityManager manager;
	private static EntityManagerFactory emf;

    public static void main(String[] args) throws InterruptedException {
    	
    	Date f = new Date();
    	Date hora = new Date();
    	
    	
    	
    	Clasificacion c = gc.getClasificacion("Solicitud de usuarios de red");
		Empleado e = ge.validarLegajo(23234);
		Date a = new Date();
		Date fecha = new Date();
		String descripcion = "descripcion";
		
		Usuario u = gu.getUsuario("admin");
	
		// prueba crear un ticket 
		Direccion d = new Direccion ("prueba2",10163);
		
		e.addDir(d);
			
		gestorBDD.cargarDir(d);
		
		System.out.println("todo tranqui");
		
		GrupoResolucion gr =ggr.getGrupo("Mesa de ayuda"); 
			
		Ticket t =(new Ticket(fecha,descripcion,EstadoTicket.ABIERTODERIVADO,hora));
		
		
		e.addTicket(t);
		c.addTicket(t);
		
		HistorialTicket ht=(new HistorialTicket(f));	
	
	
		t.add(ht);
		gestorBDD.cargarHistorialT(ht);
		Intervencion i = new Intervencion(descripcion,f,a,EstadoIntervencion.TRABAJANDO);
		i.setGr(gr);
		
		HistorialClasificacion hc = new HistorialClasificacion (f,u);
		gestorBDD.cargarHistorialC(hc);


			
	
		Historial_Intervencion hi = new Historial_Intervencion(f,EstadoIntervencion.TRABAJANDO);
		gestorBDD.cargarHistorialI(hi);
			
		System.out.println("id historial_I: "+ hi.getIdHistorial()+ " id historial_C" + hc.getIdHistorial()+ " id historial_T"+ ht.getIdHistorial());
		
		c.addHistorial(hc);
		u.addHI(hi);
		u.addHT(ht);
		u.addHC(hc);
		i.add(hi);
		t.add(i);
		
	//	System.out.println("MOSTRAME LA INTERVENCION GATO "  +id_intervencion+ "  " + (gestorBDD.getTickets().size() +1));
		gestorBDD.cargarTicket(t);

    	Inicializador01 cp = new Inicializador01();
    	
        cp.setVisible(true);
        
        IniciarSesionCU00  b= new IniciarSesionCU00();
        
     	// ActualizarEstadoIntervencionCU08 a = new ActualizarEstadoIntervencionCU08();
      	cp.dispose();
       	
      	b.setVisible(true);
    }
    
}
