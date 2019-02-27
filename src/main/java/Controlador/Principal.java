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
import ventanas.EjemploConsulta;
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

    public static void main(String[] args) throws InterruptedException {	
    
    	EjemploConsulta a = new EjemploConsulta("Termina xq no le incumbe?");
    	
    	a.setVisible(true);
    	
   /*
    	System.out.println( "hola");
    	Inicializador01 cp = new Inicializador01();
    	
        cp.setVisible(true);
        
        IniciarSesionCU00  b= new IniciarSesionCU00();
        
     	//ActualizarEstadoIntervencionCU08 a = new ActualizarEstadoIntervencionCU08();
      	cp.dispose();
       	
      	b.setVisible(true);*/
    }
}
