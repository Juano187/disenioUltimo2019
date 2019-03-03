
package ventanas;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Guard;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import  java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlador.GestorClasificacion;
import Controlador.GestorEmpleado;
import Controlador.GestorGrupoResolucion;
import Controlador.GestorTicket;
import Controlador.GestorUsuario;
import Modelo.ClasificacionDTO;
import Modelo.Empleado;
import Modelo.EstadoTicket;
import Modelo.GrupoResolucion;
import Modelo.GrupoResolucionDTO;
import Modelo.Ticket;
import Modelo.TicketDTO;
import Modelo.Usuario;
import Controlador.GestorBDD;


@SuppressWarnings("serial")
public class RegistrarTicketCU01 extends javax.swing.JFrame {
	private GestorEmpleado ge = new GestorEmpleado();
	private GestorBDD gbdd = new GestorBDD();
	private GestorClasificacion gc = new GestorClasificacion();
	private GestorTicket gt = new GestorTicket();
	private GestorGrupoResolucion gg= new GestorGrupoResolucion();
	private GestorUsuario gu = new GestorUsuario();
	String claSeleccionada = new String("Seleccione un tipo...");
	String descripcion = new String();
	private Usuario u ;
	private Integer num_t;
	private JFrame frame;
	private JFrame anterior;
    SimpleDateFormat fecha = new SimpleDateFormat ("yyyy-MM-dd");
    SimpleDateFormat hora = new SimpleDateFormat ("HH:mm");
    LocalDate date= LocalDate.now();
    LocalTime time = LocalTime.now();
    
   //String fechaString = fecha.format(date); 
   //String horaString = hora.format(date);

    
    public RegistrarTicketCU01(String user) {  
    	
        frame = this;
    	u=gu.getUsuario(user);
    	
    	initComponents();
        
        
        this.setLocationRelativeTo(null); 
    }


    @SuppressWarnings({ "unchecked"})

    private void initComponents() {
      
    	
       
    	jLabelTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFielNoEditable = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton_Cancelar = new javax.swing.JButton();
        jButton_Cerrar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton_Derivar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); 

        jLabelTitulo.setFont(new java.awt.Font("Californian FB", 3, 24)); 
        jLabelTitulo.setForeground(new java.awt.Color(0, 51, 102)); 
        jLabelTitulo.setText("REGISTRAR TICKET");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 320, 80));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("N\u00famero de ticket:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));
        Integer numTicket = gbdd.getTickets().size()+1;
        num_t = numTicket;
        jTextFielNoEditable.setEditable(false);
        jTextFielNoEditable.setText(numTicket.toString());
        jTextFielNoEditable.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jTextField4.requestFocus();
        	}
        	});
        getContentPane().add(jTextFielNoEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 230, 30));
        

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha de Apertura:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hora de Apertura:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setText(date.toString());
        jTextField1.setPreferredSize(new java.awt.Dimension(52, 22));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 230, 30));

        jTextField2.setEditable(false);
        jTextField2.setText(time.toString()); 
        jTextField2.setPreferredSize(new java.awt.Dimension(52, 22));
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {

        		try { 
        		    Robot robot = new Robot(); 
        		    robot.keyPress(KeyEvent.VK_TAB); 
        		} catch(Exception ex) {
                	EjemploError error = new EjemploError(ex.getMessage());
            		error.setVisible(true); 
            	}
        	}});
        
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 240, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Clasificaci\u00f3n de ticket");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripci\u00f3n del problema:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("N\u00famero de Legajo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jTextField4.setPreferredSize(new java.awt.Dimension(52, 22));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                legajoletras(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 220, 30));

        jButton_Cancelar.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Cancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Cancelar.setText("Cancelar");
        jButton_Cancelar.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton_Cancelar.doClick();
                }
            }
        });
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionCancelar(evt);
            }
        });
        jButton_Cancelar.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton_Cancelar.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton_Cancelar.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(jButton_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 590, 110, 30));

        jButton_Cerrar.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Cerrar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton_Cerrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Cerrar.setText("Cerrar ticket");
        jButton_Cerrar.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton_Cerrar.doClick();
                }
            }
        });
        
        jButton_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CerrarActionPerformed(evt);
            }
        });
        jButton_Cerrar.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton_Cerrar.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton_Cerrar.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(jButton_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, 140, 30));

      
        ArrayList<ClasificacionDTO> clasificaciones= gc.getClasificaciones();
        
        JComboBox<String> jComboBox1= new JComboBox<String>();
        
        jComboBox1.addItem("Seleccione un tipo...");
        
        for(int i=0 ; i < clasificaciones.size(); i++) {
        	
   
      	jComboBox1.addItem(clasificaciones.get(i).getNombre());}
        
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JComboBox<String> clasificaciones = (JComboBox<String>) e.getSource();
                    claSeleccionada = (String) clasificaciones.getSelectedItem();
                }
            
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTextArea1.requestFocus();
                }
            }
        });
        
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 360, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 13)); 
        jTextArea1.setRows(5);
        jTextArea1.setEditable(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setLineWrap(true);
        jTextArea1.setTabSize(5);
        jTextArea1.setText("Ingrese descripcion (max de caracteres 150)");
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB) {
                    jButton_Cancelar.requestFocus();
                }
            }
        });
        
        jScrollPane1.setViewportView(jTextArea1);
        
        
       
        
        jTextArea1.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {
        		
        		super.keyTyped(e);
        		if(jTextArea1 != null && jTextArea1.getText() != null && jTextArea1.getText().length() >= 300){
        			
        			e.setKeyChar((char) KeyEvent.VK_CLEAR);
        		}
        	}
        }); 

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 880, 150));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png"))); 
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 660, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("(*) Campo Obligatorio");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("*");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("*");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("*");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, -1, -1));

        jButton_Derivar.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Derivar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton_Derivar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Derivar.setText("Derivar ticket");
        jButton_Derivar.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton_Derivar.doClick();
                }
            }
        });
        jButton_Derivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DerivarActionPerformed(evt);
            }
        });
        jButton_Derivar.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton_Derivar.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton_Derivar.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(jButton_Derivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 590, 140, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg")));
        jLabelFondo.setText("jbj");
        jLabelFondo.setPreferredSize(new java.awt.Dimension(1110, 650));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, -1));

        pack();
    }

   

 	public void setAnterior(JFrame anterior) {
 		this.anterior = anterior;
 	}
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
    
    	
    }

    private void jButton_CerrarActionPerformed(java.awt.event.ActionEvent evt) {

        try {
       
        	 String descripcion = jTextArea1.getText();
        	 int legajo = Integer.parseInt(jTextField4.getText());
        	 int longLegajo= String.valueOf(legajo).length();
       
        	 
      
        	 System.out.println("long legajo: "+ longLegajo + " descripcion: " + descripcion + " clasificacion: " + claSeleccionada );
        	 
        	 if(longLegajo != 5 || claSeleccionada.equalsIgnoreCase("Seleccione un tipo...") || descripcion.equalsIgnoreCase("Ingrese descripcion (max de caracteres 150)")) {
        	 		EjemploError error = new EjemploError("Datos invalidos");
    			  	error.setVisible(true); 	
    			  		
        	 }
        	 else {
        		 System.out.println("long legajo: "+ longLegajo + " descripcion: " + descripcion + " clasificacion: " + claSeleccionada );
        		 	// TODO guarde en t tipo TICKET, cree TICKETDTO con los datos de t para pasarlo como parametro
        		 	Ticket t = gt.registrarTicket(legajo,claSeleccionada,descripcion, u,date);
        		 	
        		 	GrupoResolucion g = gg.getGrupo("Mesa de Ayuda");
        		 	System.out.println("Grupo : " + g.getNom_grupo());
        		 	TicketDTO td = new TicketDTO(t.getNum_ticket(), t.getEmpleado().getLegajo() ,
        		 		t.getFecha_apertura() , t.getFecha_cierre() , t.getClasificacion() , g ,
        		 		t.getEstadoticket() , u.getUsuario(),descripcion);
        		 	
        		 	CerrarTicketCU03 c = new CerrarTicketCU03(td);
                    c.setAnterior(frame);
                    c.setVisible(true);
                    this.setVisible(false);
        		 	
      		}
        	 
        	 
        
        	}catch(Exception ex) {
        		System.out.println(ex.getMessage());
        		EjemploError error = new EjemploError(ex.getMessage());
        		error.setVisible(true); 
        	}
        	

    	
    }
    private void accionCancelar(java.awt.event.ActionEvent evt) {
        anterior.setVisible(true);
        this.dispose();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void legajoletras(java.awt.event.KeyEvent evt) {
        char pass = evt.getKeyChar();
        
        if(pass < '0' || pass > '9'){
            
            evt.consume();}
        }
     	
    private void jButton_DerivarActionPerformed(java.awt.event.ActionEvent evt) {
     
 
    try {
   
    	 String descripcion = jTextArea1.getText();
    	 int legajo = Integer.parseInt(jTextField4.getText());
    	 int longLegajo= String.valueOf(legajo).length();
    	 
    	 //prueba para ver los datos
 
    	 if(longLegajo != 5 || claSeleccionada.equalsIgnoreCase("Seleccione un tipo...")  || descripcion.equalsIgnoreCase("Ingrese descripcion")) {
    	 		EjemploError error = new EjemploError("Datos invalidos");
			  	error.setVisible(true); 
			  	
			  		
    	 }
    	 else {
    		 //TODO guarde en t tipo TICKET, cree TICKETDTO con los datos de t para pasarlo como parametro
    		 System.out.println("legajo:"+legajo+" usuario:: "+ u.getUsuario());
    		 	Ticket t = gt.registrarTicket(legajo,claSeleccionada,descripcion, u,date);
    		
    		 	GrupoResolucion	g = gg.getGrupo("Mesa de Ayuda");
    		 	
    		 	TicketDTO td = new TicketDTO(t.getNum_ticket(), t.getEmpleado().getLegajo() ,
    		 			t.getFecha_apertura() , t.getFecha_cierre() , t.getClasificacion() , g ,
    		 			t.getEstadoticket() , u.getUsuario(),descripcion);
    		 	System.out.println("datos ticket : num:"+td.getNumeroTicket()+ " legajo: "+td.getLegajo()+" clasificacion: "+ td.getCla().getNom_clasificacion());
    		 
    		 	
                DerivarTicketCU04 r = new DerivarTicketCU04(td, u.getUsuario());
                r.setAnterior(frame);
                r.setVisible(true);
                this.setVisible(false);
    		 	
  		}
    	 
    	 
    
    	}catch(Exception ex) {
    	
    		EjemploError error = new EjemploError(ex.getMessage());
    		error.setVisible(true); 
    	}
    	}

   
   
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IniciarSesionCU00.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesionCU00.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesionCU00.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesionCU00.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    
    }

  

    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_Cerrar;
    private javax.swing.JButton jButton_Derivar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFielNoEditable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;

}
