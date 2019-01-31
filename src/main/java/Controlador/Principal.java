package Controlador;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Modelo.EntidadA;
import Modelo.EntidadB;
import Modelo.HistorialTicket;
import ventanas.ActualizarEstadoIntervencionCU08;
import ventanas.EjemploError;
import ventanas.Inicializador01;
import ventanas.IniciarSesionCU00;


public class Principal {
	private static EntityManager manager;
	private static EntityManagerFactory emf;

    public static void main(String[] args) throws InterruptedException {
    	emf = Persistence.createEntityManagerFactory("Persistencia");
    	
		manager = emf.createEntityManager();
    	EntidadA a=new EntidadA((long) 31312130);
    	EntidadB b=new EntidadB((long) 232121321);    	
    	a.addB(b);
    	manager.getTransaction().begin();
		manager.persist(a);
		manager.getTransaction().commit();
    	
    	//Inicializador01 cp = new Inicializador01();
    
        //cp.setVisible(true);
     
    // IniciarSesionCU00 a = new IniciarSesionCU00();
   
      //ActualizarEstadoIntervencionCU08 a = new ActualizarEstadoIntervencionCU08();
      // 	cp.dispose();
       	
      //a.setVisible(true);

    }
    
}
