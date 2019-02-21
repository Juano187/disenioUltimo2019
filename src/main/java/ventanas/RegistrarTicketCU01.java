
package ventanas;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlador.GestorClasificacion;
import Controlador.GestorEmpleado;
import Controlador.GestorTicket;
import Modelo.ClasificacionDTO;
import Modelo.Empleado;
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
	String claSeleccionada = new String("Seleccione un tipo...");
	String descripcion = new String();
	private Usuario u ;

	private JFrame frame;
	private JFrame anterior;
	SimpleDateFormat fecha_hora =new SimpleDateFormat ( "dd-MM-yyyy HH:mm");
    SimpleDateFormat fecha = new SimpleDateFormat ("dd-MM-yyyy");
    SimpleDateFormat hora = new SimpleDateFormat ("HH:mm");
    Date date = new Date();
    String fechaString = fecha.format(date);
    String horaString = hora.format(date);
    String fechaHoraString = fecha_hora.format(date);
    
    public RegistrarTicketCU01() {  
        initComponents(u);
        this.setLocationRelativeTo(null); 
    }


    @SuppressWarnings({ "unchecked"})

    private void initComponents(Usuario user) {
    	
    	
       
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
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
        jTextField1.setText(fechaString);
        jTextField1.setPreferredSize(new java.awt.Dimension(52, 22));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 230, 30));

        jTextField2.setEditable(false);
        jTextField2.setText(horaString);
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
        	}
        	});
        
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

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton1.doClick();
                }
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionCancelar(evt);
            }
        });
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton1.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton1.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 590, 110, 30));

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cerrar ticket");
        jButton2.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton3.doClick();
                }
            }
        });
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton2.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton2.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, 140, 30));

      
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
        jTextArea1.setText("Ingrese descripcion");
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB) {
                    jButton1.requestFocus();
                }
            }
        });
        
        jScrollPane1.setViewportView(jTextArea1);

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

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Derivar ticket");
        jButton3.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton3.doClick();
                }
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton3.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton3.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 590, 140, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg")));
        jLabelFondo.setText("jbj");
        jLabelFondo.setPreferredSize(new java.awt.Dimension(1110, 650));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, -1));

        pack();
    }

       
    public void addUser ( Usuario user) {
    	u = user;
    }


 	public void setAnterior(JFrame anterior) {
 		this.anterior = anterior;
 	}
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
    
    	
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        try {
       
        	 String descripcion = jTextArea1.getText();
        	 int legajo = Integer.parseInt(jTextField4.getText());
        	 int longLegajo= String.valueOf(legajo).length();
       
        	 
      
        	 System.out.println("long legajo: "+ longLegajo + " descripcion: " + descripcion + " clasificacion: " + claSeleccionada );
        	 
        	 if(longLegajo != 5 || claSeleccionada.equalsIgnoreCase("Seleccione un tipo...") || descripcion.equalsIgnoreCase("Ingrese descripcion")) {
        	 		EjemploError error = new EjemploError("Datos invalidos");
    			  	error.setVisible(true); 
    		
    			  	
    			  		
        	 }
        	 else {
        		
        		 	gt.registrarTicket(legajo,claSeleccionada,descripcion, u,date,GestorTicket.stringtodate(fechaString), GestorTicket.stringtodate(horaString));
        		 	
                   CerrarTicketCU03 c = new CerrarTicketCU03();
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
     	
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
     
 
    try {
   
    	 String descripcion = jTextArea1.getText();
    	 int legajo = Integer.parseInt(jTextField4.getText());
    	 int longLegajo= String.valueOf(legajo).length();
    	 
    	 //prueba para ver los datos
    	 //System.out.println("long legajo: "+ longLegajo + " descripcion: " + descripcion + " clasificacion: " + claSeleccionada );
    	 
    	 if(longLegajo != 5 || claSeleccionada.equalsIgnoreCase("Seleccione un tipo...")  || descripcion.equalsIgnoreCase("Ingrese descripcion")) {
    	 		EjemploError error = new EjemploError("Datos invalidos");
			  	error.setVisible(true); 
			  	
			  		
    	 }
    	 else {
    		 	Empleado emp = ge.validarLegajo(legajo);    	  
    		 	TicketDTO t = new TicketDTO();
    		 	GrupoResolucionDTO g = new GrupoResolucionDTO();
    		 	
    		 	//Date fecha_ini = ;
    		 	
    		 	int num_ticket = (gbdd.getTickets().size()+1);
    		 	
                DerivarTicketCU04 r = new DerivarTicketCU04(t, u);
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

  

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
