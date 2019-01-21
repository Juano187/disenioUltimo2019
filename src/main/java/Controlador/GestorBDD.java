package Controlador;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Modelo.Clasificacion;
import Modelo.ClasificacionDTO;
import Modelo.Empleado;
import Modelo.GrupoResolucion;
import Modelo.GrupoResolucionDTO;
import Modelo.Ticket;
import Modelo.Usuario;

public class GestorBDD {
		private static EntityManager manager;
		private static EntityManagerFactory emf;
	
	
	public GestorBDD() {
			emf = Persistence.createEntityManagerFactory("Persistencia");
			manager = emf.createEntityManager();
		
			/* NOSE PARA QUE ESTA
			 * aca tenes un cambioooo
				@SuppressWarnings("unchecked")
				List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
				System.out.println("En esta base de datos hay " + empleados.size() + " empleados");
				
				@SuppressWarnings("unchecked")
				List<Clasificacion> clasificaciones = (List<Clasificacion>) manager.createQuery("FROM Clasificacion").getResultList();
				System.out.println("En esta base de datos hay " + clasificaciones.size() + " clan"  + clasificaciones);*/
				
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Clasificacion> getClasificacion(){
		ArrayList<Clasificacion> clasificaciones;
		manager.getTransaction().begin();
		clasificaciones = (ArrayList<Clasificacion>) manager.createQuery("FROM Clasificacion").getResultList();
		manager.getTransaction().commit();
		return clasificaciones;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Empleado>getEmpleado(){
		ArrayList<Empleado> empleado;
		manager.getTransaction().begin();
		empleado = (ArrayList<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		manager.getTransaction().commit();
		return empleado;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<GrupoResolucion> getGrupoResolucion(){
		ArrayList<GrupoResolucion> grupos;
		manager.getTransaction().begin();
		grupos = (ArrayList<GrupoResolucion>) 
				manager.createQuery("FROM GrupoResolucion").getResultList();
		manager.getTransaction().commit();
		return grupos;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Ticket> getTicket(){
	ArrayList<Ticket> T = new ArrayList<Ticket>();
	manager.getTransaction().begin();
	T = (ArrayList<Ticket>)	manager.createQuery("Select t FROM Ticket t").getResultList();
	manager.getTransaction().commit();
	
	
	return T;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Ticket> getTicket(Long numTic, Integer legajo,Date fechaABien, Date fechaUBien, String estado, ClasificacionDTO cla,  GrupoResolucionDTO ugrupo){
	ArrayList<Ticket> T = new ArrayList<Ticket>();
	manager.getTransaction().begin();
	T = (ArrayList<Ticket>)	manager.createQuery("Select t FROM Ticket t").getResultList();
	manager.getTransaction().commit();
	
	
	return T;
	}
	
	@SuppressWarnings("unchecked")
	public Usuario getUsuario(String user) {
		Usuario u =new Usuario();
		ArrayList<Usuario> U = new ArrayList<Usuario>();
		
		manager.getTransaction().begin();
		U = (ArrayList<Usuario>)manager.createQuery("Select t FROM Usuario t").getResultList();
		manager.getTransaction().commit();
		
		for(int i= 0 ;i< U.size();i++) {
			if(user.equalsIgnoreCase(U.get(i).getUsuario()) ){
				u = U.get(i);
			}
		}
		return u;
	}
	@SuppressWarnings("unchecked")
	public boolean iniciarSesion (String user, String pass ){
		ArrayList<Usuario> U = new ArrayList<Usuario>();
		
		boolean a = false;
		manager.getTransaction().begin();
		U = (ArrayList<Usuario>)manager.createQuery("Select t FROM Usuario t").getResultList();
		manager.getTransaction().commit();
		for(int i= 0 ;i< U.size();i++) {
			if(user.equalsIgnoreCase(U.get(i).getUsuario()) && pass.equalsIgnoreCase(U.get(i).getContraseña())){
				a = true;
			}
		}
		return a;
	}
	/*cami*/

	public ArrayList<Ticket> getTickets(Long numTic, Integer legajo, Date fechaABien, Date fechaUBien, String estado, ClasificacionDTO cla,  GrupoResolucionDTO ugrupo){
		
		ArrayList<Ticket> tickets = new ArrayList<>();
		
		
		String sql = "Select distinct t FROM Ticket t,Clasificacion cf, Estado e, Intervencion i, GrupoResolucion gr" ;
		
		
		if(!(numTic== null)) {
			sql+= "and t.numeroTicket =" + numTic;
		}
		
		if(!(legajo== null)) {
			sql+= "and t.empleado =" + legajo;
		}
		
		if(!(fechaABien== null)) {
			sql+= "and t.fecha_hora_apertura =" + fechaABien;
		}
		
		if(!(fechaUBien== null)) {
			sql+= "and t.fecha_hora_apertura =" + fechaUBien;
		}
		
		if(!(estado== null)) {
			sql+= "and t.fecha_hora_apertura =" + estado;
		}
		
		if(!(cla== null)) {
			sql+= "and t.fecha_hora_apertura =" + cla;
		}
		
		if(!(ugrupo== null)) {
			sql+= "and t.fecha_hora_apertura =" + ugrupo;
		}
		manager.getTransaction().begin();
		tickets = (ArrayList<Ticket>) 
				manager.createQuery(sql).getResultList();
		manager.getTransaction().commit();
		
		
		
		
		return tickets;
	}

	/*
	public ArrayList<Ticket> getTickets(Long numTic, Integer legajo, Date fechaABien, Date fechaUBien, String estado, ClasificacionDTO cla,  GrupoResolucionDTO ugrupo){
		
		
		ArrayList<Ticket> tickets;
		manager.getTransaction().begin();
		tickets = (ArrayList<Ticket>) 
				manager.createQuery("Select distinct t FROM Ticket t").getResultList();
		manager.getTransaction().commit();*/
		/*se pidio la tabla de  ticket, hay q ir filtrando, encontrando el num de ticket depende el parametro, hacer varias funciones para 
		 * filtrar cada atributo o bien una setencia de SQL q lo haga atravez de las tablas, buscando por PK de clasificacion estado e intervenciion*/
		

	

}