package Controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Modelo.Clasificacion;
import Modelo.Empleado;
import Modelo.Ticket;

public class test {
	


		private static EntityManager manager;
		private static EntityManagerFactory emf;
		

		
		public static void main(String[] args) {
			emf = Persistence.createEntityManagerFactory("Persistencia");
			manager = emf.createEntityManager();
			
			List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
			System.out.println("En esta base de datos hay " + empleados.size() + " empleados");
			List<Clasificacion> clasificaciones = (List<Clasificacion>) manager.createQuery("FROM Clasificacion").getResultList();
			System.out.println("En esta base de datos hay " + clasificaciones.size() + " cla");
			

		}
		
		public static List<String> llenarCombo(){
			List<String> clasificaciones = (List<String>) manager.createQuery("FROM Clasificacion").getResultList();
			return clasificaciones;
		}
	
		/*static void crearDatos() {
			EntityManger em = emf.createEntitymanager();
			
			em.getTransaction().begin();
			
			em.getTransaction().commit();
			
			
			em.close();
			*/
			
			
		
		
}


