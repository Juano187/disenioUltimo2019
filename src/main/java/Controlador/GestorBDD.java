package Controlador;

import java.lang.Exception;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Modelo.Clasificacion;
import Modelo.ClasificacionDTO;
import Modelo.Direccion;
import Modelo.Empleado;
import Modelo.GrupoResolucion;
import Modelo.GrupoResolucionDTO;

import Modelo.HistorialClasificacion;
import Modelo.HistorialTicket;
import Modelo.Historial_Intervencion;
import Modelo.Intervencion;
import Modelo.Ticket;

import Modelo.Usuario;

public class GestorBDD {
		private static EntityManager manager;
		private static EntityManagerFactory emf;
	
	
	public GestorBDD() {
			emf = Persistence.createEntityManagerFactory("Persistencia");
			manager = emf.createEntityManager();
			
			/*@SuppressWarnings("unchecked")
			ArrayList<Ticket> tickets = (ArrayList<Ticket>) manager.createQuery("Select NUM_TICKET FROM Ticket t, Clasificacion cf WHERE t.NUM_TICKET = 3 and t.estadoticket = 'CERRADO' and \r\n" + 
					"cf.NOMBRE = 'Problemas en el funcionamiento del Sistema Operativo de PC y utilitarios' ").getResultList();
			System.out.println("En esta base de datos hay " + tickets.size() + " empleados");
			for (Ticket emp : tickets ) {
				System.out.println(emp.getNum_ticket());
			}
		*/
			/*
			manager.getTransaction().begin();
			ArrayList<Empleado> e = (ArrayList<Empleado>) manager.createQuery("FROM Empleado").getResultList();
			manager.getTransaction().commit();*/
			
			
		
				/*@SuppressWarnings("unchecked")
				ArrayList<Clasificacion> clasificaciones = (ArrayList<Clasificacion>) manager.createQuery("FROM Clasificacion").getResultList();
				System.out.println("En esta base de datos hay " + clasificaciones.size() + " clan"  + clasificaciones);*/
			
	}
	public Direccion cargarDir(Direccion d) {
		System.out.println(d.getCalle());
		manager.getTransaction().begin();
		manager.persist(d);
		manager.getTransaction().commit();
		return d;
	}
	public Ticket cargarTicket ( Ticket t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
		return t;
	}
	
	public Ticket actualizarTicket (Ticket ticket) {
		manager.getTransaction().begin();
		ticket = manager.merge(ticket);
		manager.persist(ticket);
		manager.getTransaction().commit();
		return ticket;
	}
	public HistorialTicket cargarHistorialT(HistorialTicket a) {
		manager.getTransaction().begin();
		manager.persist(a);
		manager.getTransaction().commit();
		return a;
	}
	
	public Historial_Intervencion cargarHistorialI(Historial_Intervencion I) {
		manager.getTransaction().begin();
		manager.persist(I);
		manager.getTransaction().commit();
		return I;
	}
	public HistorialClasificacion cargarHistorialC(HistorialClasificacion c) {
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		return c;
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
	


	
	public Intervencion actualizarIntervencion (Intervencion intervencion) {
		
		System.out.println("llego a la base");
		System.out.println(intervencion.getId_intervencion());
		manager.getTransaction().begin();
		intervencion = manager.merge(intervencion);
		manager.persist(intervencion);
		manager.getTransaction().commit();
		return intervencion;
	}
	


	
	public Intervencion guardarIntervencion(Intervencion interv) {
		manager.getTransaction().begin();
		manager.persist(interv);
		manager.getTransaction().commit();
	
		return interv;
	}
	
	public Intervencion getIntervMESA (Integer numTicket) {
		Intervencion interv;
		String cs = "Select i FROM Intervencion i, GrupoDeResolucion gr WHERE i.grupo = gr and numero_ticket = " + numTicket + " and gr.nombre = 'Mesa de Ayuda'";
		manager.getTransaction().begin();
		interv = (Intervencion) manager.createQuery(cs).getSingleResult();
		manager.getTransaction().commit();
		return interv;
	}
	
	public Intervencion ultimaInt(Integer numeroTicket, GrupoResolucion grupo) {
		Intervencion resultado;
		ArrayList<Intervencion> intervencionesTicket;
		System.out.println(grupo.getId_grupo());
		System.out.println(numeroTicket);
		String cs = "from Intervencion where ticket = " + numeroTicket + " and gruporesolucion = " + grupo.getId_grupo();
		
		manager.getTransaction().begin();
		intervencionesTicket = (ArrayList<Intervencion>) manager.createQuery(cs).getResultList();
		manager.getTransaction().commit();
		

		
		if(intervencionesTicket.size() == 0) {
			resultado = null;
		}
		else {
			resultado = intervencionesTicket.get(intervencionesTicket.size()-1);
			
		}
		return resultado;
	}
	
	

	

	
	
/*@SuppressWarnings("unchecked")
public ArrayList<Historial>getHistoriales(){
	
	ArrayList<Historial> h ;
	manager.getTransaction().begin();
	h = (ArrayList<Historial>) manager.createQuery("FROM Historial").getResultList();
	manager.getTransaction().commit();
	return h;
}*/

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
	public ArrayList<GrupoResolucionDTO> getGrupoResoluciondto(){
		ArrayList<GrupoResolucionDTO> grupos;
		manager.getTransaction().begin();
		grupos = (ArrayList<GrupoResolucionDTO>) 
				manager.createQuery("FROM GrupoResolucion").getResultList();
		manager.getTransaction().commit();
		return grupos;
	}


	
	@SuppressWarnings("unchecked")
	public ArrayList<Ticket> getTickets(){
	ArrayList<Ticket> T = new ArrayList<Ticket>();
	manager.getTransaction().begin();
	T = (ArrayList<Ticket>)	manager.createQuery("Select t FROM Ticket t").getResultList();
	manager.getTransaction().commit();
	
	
	return T;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Intervencion> getIntervenciones(){
		ArrayList<Intervencion> i = new ArrayList<Intervencion>();
		manager.getTransaction().begin();
		i = (ArrayList<Intervencion>)	manager.createQuery("Select i FROM Intervencion i").getResultList();
		manager.getTransaction().commit();
		return i;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Ticket> getTicket(Long numTic, Integer legajo,LocalDate fechaABien, LocalDate fechaUBien, String estado, ClasificacionDTO cla,  GrupoResolucionDTO ugrupo){
	ArrayList<Ticket> T = new ArrayList<Ticket>();
	manager.getTransaction().begin();
	T = (ArrayList<Ticket>)	manager.createQuery("Select t FROM Ticket t").getResultList();
	manager.getTransaction().commit();
	
	
	return T;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Usuario>  getUsuarios() {
	
		ArrayList<Usuario> U = new ArrayList<Usuario>();
		
		manager.getTransaction().begin();
		U = (ArrayList<Usuario>)manager.createQuery("Select t FROM Usuario t").getResultList();
		manager.getTransaction().commit();
	
		return U;
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


public ArrayList<Ticket> getTickets(Long numTic, Integer legajo, LocalDate fechaABien, LocalDate fechaUBien, String estado, ClasificacionDTO cla  , GrupoResolucionDTO ugrupo){
	System.out.println("fechas");
		System.out.println(fechaABien);
		
		ArrayList<Ticket> tickets = new ArrayList<>();
		
	//	SELECT DISTINCT * FROM ticket t, clasificacion cf , grupo_clasificacion gr WHERE t.CODIGO= cf.CODIGO and cf.CODIGO = gr.codigo
		String sql = "Select distinct t FROM Ticket t, Clasificacion cf , GrupoResolucion g WHERE t.clasificacion= cf.codigo and cf.codigo = g " ;
		
		
		if(!(numTic== null)) {
			sql+= " and t.num_ticket = " + numTic; 
		}
		
		if(!(legajo== null)) {
			sql+= " and t.empleado = " + legajo;
		}
		
		if(!(fechaABien== null)) {
			sql+= " and t.fecha_apertura = '" + fechaABien + "'";
		}
		
		if(!(fechaUBien== null)) {
			sql+= " and t.fecha_cierre = '" + fechaUBien + "'";
		}
		
		if(!(estado== null)) {
			sql+= " and t.estadoticket = '" + estado + "'";
		}
		
		if(!(cla== null)) {
			sql+= " and cf.nom_clasificacion = '" + cla+ "'";
		}
		
		
		
		if(!(ugrupo== null)) {
			sql+= " and g.nom_grupo = '" + ugrupo+ "'";
		}
		
		
		System.out.println(sql);
	
		
		manager.getTransaction().begin();
		tickets = (ArrayList<Ticket>) 
				manager.createQuery(sql).getResultList();
		manager.getTransaction().commit();
		
		System.out.println(tickets.size());
		
		
		//System.out.println(tickets.get(0).getIntervencion(2).getId_intervencion()); 
		//System.out.println(tickets.get(0).ultimaIGrupo().toString()); 
				
		return tickets;
	}


	
	
	public Direccion getDireccion(int legajo) {
			Direccion direccion;
			String c = "FROM Direccion Where legajo = " + legajo;
			manager.getTransaction().begin();
			direccion = (Direccion) manager.createQuery(c).getSingleResult();
			manager.getTransaction().commit();
		
			
			
			
		return direccion;
	}
	
	
	
	public GrupoResolucion getgrupo(String grupo) {
		GrupoResolucion grupoR;
		
		 
		manager.getTransaction().begin();
		grupoR = (GrupoResolucion) 
				manager.createQuery("FROM GrupoResolucion WHERE nom_grupo = '" + grupo+"'").getSingleResult();
		manager.getTransaction().commit();
		
		
		return grupoR;
	}
	
	public GrupoResolucion getgrupo(Integer i) {
		System.out.println("asd5");
		GrupoResolucion grupoR;
	
		String con = "FROM GrupoResolucion WHERE id_grupo = " + i;
		
		
		manager.getTransaction().begin();
		grupoR = (GrupoResolucion) 
				manager.createQuery(con).getSingleResult();
		manager.getTransaction().commit();
	
	
		
		return grupoR;
	}

	public Ticket buscarTicket(Integer numTicket) {
		Ticket ticket;
		String cs = "FROM Ticket WHERE num_ticket = " + numTicket ;
		manager.getTransaction().begin();
		ticket = (Ticket) manager.createQuery(cs).getSingleResult();
		manager.getTransaction().commit();
		
		
		return ticket;	
	}
	public ArrayList<Intervencion> consultarItervencion(Long numTicket, Integer numLeg, String estado, LocalDate desde,
			LocalDate hasta , Integer idgrup) {
		ArrayList<Intervencion> resulI = new ArrayList<Intervencion>();
		
		
		
		String csql = "Select distinct i FROM Intervencion i, Ticket t WHERE i.ticket = t and i.gruporesolucion = " + idgrup;
		
		

		if(!(numTicket== null)) {
			csql+= " and t.num_ticket = " + numTicket;
		}
		
		if(!(numLeg== null)) {
			csql+= " and t.empleado = " + numLeg;
		}
		
		if(!(desde== null)) {
			csql+= " and t.fecha_apertura = '" + desde + "'";
		}
		
		
		if(!(estado== null)) {
			csql+= " and i.estadointervencion = '" + estado + "'";
		}
		
		
		manager.getTransaction().begin();
		resulI = (ArrayList<Intervencion>) 
				manager.createQuery(csql).getResultList();
		manager.getTransaction().commit();
		
		
		System.out.println("no encontro nada"+resulI.size());
		return resulI;
	}
	
	public Intervencion getIntervencion (Integer idIntevercion) {
		String consulta = "FROM Intervencion where id_Intervencion = " + idIntevercion;
		manager.getTransaction().begin();
		Intervencion intervencionEncontrada = (Intervencion) manager.createQuery(consulta).getSingleResult();
		manager.getTransaction().commit();
		return intervencionEncontrada;
	}
	
	public List<Clasificacion> getClasificaciones() {
		List<Clasificacion> clasificaciones;
		manager.getTransaction().begin();
		clasificaciones = (List<Clasificacion>) manager.createQuery("FROM Clasificacion").getResultList();
		manager.getTransaction().commit();
		return clasificaciones;
		
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