package Controlador;


import ventanas.ActualizarEstadoIntervencionCU08;
import ventanas.EjemploError;
import ventanas.Inicializador01;
import ventanas.IniciarSesionCU00;


public class Principal {

    public static void main(String[] args) throws InterruptedException {
    	
    	
    Inicializador01 cp = new Inicializador01();
    
        cp.setVisible(true);
        EjemploError b = new EjemploError(" HOLA TOTI");
     IniciarSesionCU00 a = new IniciarSesionCU00();
     System.out.println("HOLA TOTI COMO VA LA BAINA");
      //ActualizarEstadoIntervencionCU08 a = new ActualizarEstadoIntervencionCU08();
       	cp.dispose();
       	
      a.setVisible(true);
      b.setVisible(true);  

    }
    
}
