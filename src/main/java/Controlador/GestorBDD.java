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
			
			/*@SuppressWarnings("unchecked")
			ArrayList<Ticket> tickets = (ArrayList<Ticket>) manager.createQuery("FROM Ticket").getResultList();
		
		
			manager.getTransaction().begin();
			ArrayList<Empleado> e = (ArrayList<Empleado>) manager.createQuery("FROM Empleado").getResultList();
			manager.getTransaction().commit();
			
			
			*/
				/*@SuppressWarnings("unchecked")
				ArrayList<Clasificacion> clasificaciones = (ArrayList<Clasificacion>) manager.createQuery("FROM Clasificacion").getResultList();
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
	
	private void imprimirtodo(ArrayList<Empleado> e) {
		// TODO Auto-generated method stub
		/*ArrayList<Empleado> emps = (ArrayList<Empleado>) manager.createQuery("FROM Empleado").getResultList();*/
		System.out.println("En esta base de datos hay " + e.size() + " empleados");
		for (Empleado emp : e ) {
			System.out.println(emp.getNombre());
		}
		
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

	public ArrayList<Ticket> getTickets(Long numTic, Integer legajo, Date fechaABien, /*Date fechaUBien,*/ Integer estado, ClasificacionDTO cla,  GrupoResolucionDTO ugrupo){
		
		ArrayList<Ticket> tickets = new ArrayList<>();
		
		
		String sql = "Select distinct t FROM Ticket t,Clasificacion cf, Estado e, GrupoResolucion gr WHERE " ;
		
		
		if(!(numTic== null)) {
			sql+= " and t.NUM_TICKET = " + numTic;
		}
		
		if(!(legajo== null)) {
			sql+= " and t.LEGAJO = " + legajo;
		}
		
		if(!(fechaABien== null)) {
			sql+= " and t.FECHA_HORA_APERTURA = " + fechaABien;
		}
		
		/*if(!(fechaUBien== null)) {
			sql+= " and t.FECHA_HORA_CIERRE = " + fechaUBien;
		}*/
		
		if(!(estado== null)) {
			sql+= " and e.estadoticket = '" + estado+ "'";
		}
		
		if(!(cla== null)) {
			sql+= " and cf.NOMBRE = '" + cla+ "'";
		}
		
		if(!(ugrupo== null)) {
			sql+= " and gr.NOM_GRUPO = '" + ugrupo+ "'";
		}
		
		
		manager.getTransaction().begin();
		tickets = (ArrayList<Ticket>) 
				manager.createQuery(sql).getResultList();
		manager.getTransaction().commit();
		
		
		for (int i=0; i<tickets.size(); i++ ) {
			System.out.println(tickets.get(i).getNum_ticket());
			System.out.println(tickets.get(i).getEstadoticket());
		}
		
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