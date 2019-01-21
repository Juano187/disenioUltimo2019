package Controlador;


import ventanas.ActualizarEstadoIntervencionCU08;
import ventanas.EjemploError;
import ventanas.Inicializador01;
import ventanas.IniciarSesionCU00;


public class Principal {

    public static void main(String[] args) throws InterruptedException {
    	
    	
    Inicializador01 cp = new Inicializador01();
    
        cp.setVisible(true);
     
     IniciarSesionCU00 a = new IniciarSesionCU00();
   
      //ActualizarEstadoIntervencionCU08 a = new ActualizarEstadoIntervencionCU08();
       	cp.dispose();
       	
      a.setVisible(true);

    }
    
}
