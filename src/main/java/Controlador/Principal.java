package Controlador;


import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Modelo.Clasificacion;
import Modelo.Direccion;
import Modelo.Empleado;
import Modelo.EntidadA;
import Modelo.EntidadB;
import Modelo.EstadoIntervencion;
import Modelo.EstadoTicket;
import Modelo.GrupoResolucion;
import Modelo.HistorialClasificacion;
import Modelo.HistorialTicket;
import Modelo.Historial_Intervencion;
import Modelo.Intervencion;
import Modelo.Ticket;
import Modelo.Ticket2;
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
		Direccion d = new Direccion (2,"diaz velez",1061);
		
		d.setEmp(e);
		
		//int id_t = (gestorBDD.getTickets().size() +1);
		
		System.out.println("hasta aca todo bien");
		Ticket t = new Ticket(2,fecha,descripcion,EstadoTicket.ABIERTODERIVADO,hora);
		t.setEmp(e);
		c.addTicket(t);
		
		HistorialTicket ht=new HistorialTicket(f);	
		ht.setUser(u);
		
		GrupoResolucion gr = ggr.getGrupo(u.getGruporesolucion().getNom_grupo());
		if(gr == null ) {
			System.out.println("esta vacio el gr");
		}
		int id_intervencion = (gestorBDD.getIntervenciones().size()+1);
		Intervencion i = new Intervencion(id_intervencion,f,a,descripcion,EstadoIntervencion.TRABAJANDO);
		i.setGr(gr);
		
		c.addGr(gr);
		HistorialClasificacion hc = new HistorialClasificacion (f);
		hc.setUser(u);
		
		Historial_Intervencion hi = new Historial_Intervencion(f);
		hi.setUser(u);
		i.addHi(hi);
		t.addH(ht);
		t.addInt(i);
		
		
	//	System.out.println("MOSTRAME LA INTERVENCION GATO "  +id_intervencion+ "  " + (gestorBDD.getTickets().size() +1));

		gestorBDD.cargarTicket(t);
		/*Empleado e= ge.validarLegajo(23234);
    	
    	//System.out.println("empleado "+ e.getNombre());
    	
    	Ticket2 a = new Ticket2(3,new Date(),"descripcion",EstadoTicket.ABIERTODERIVADO,new Date());
    	
    	a.setEmp(e);
    	
    	emf = Persistence.createEntityManagerFactory("Persistencia");
    	
		manager = emf.createEntityManager();   	
   		
    	manager.getTransaction().begin();
    	
    	manager.persist(a);
		
    	manager.getTransaction().commit();*/
    	
    	Inicializador01 cp = new Inicializador01();
    	
        cp.setVisible(true);
        
        IniciarSesionCU00  b= new IniciarSesionCU00();
        
     	// ActualizarEstadoIntervencionCU08 a = new ActualizarEstadoIntervencionCU08();
      	cp.dispose();
       	
      	b.setVisible(true);
    }
    
}
