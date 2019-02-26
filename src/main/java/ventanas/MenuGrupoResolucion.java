package ventanas;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlador.GestorTicket;
import Controlador.GestorUsuario;
import Modelo.GrupoResolucion;
import Modelo.Usuario;

@SuppressWarnings("serial")
	public class MenuGrupoResolucion extends javax.swing.JFrame {
	    
		
		private GestorUsuario gu = new GestorUsuario();
		private Usuario u;
		private JFrame anterior;
		JFrame frame;
	    public MenuGrupoResolucion(String user) {
	    	
	    	u=gu.getUsuario(user);
	    	frame = this;
	        initComponents();
	        this.setLocationRelativeTo(null);
	    }
	  
	    
	    @SuppressWarnings("unchecked")
                      
	    private void initComponents() {

	        jLabel2 = new javax.swing.JLabel();
	        jButton_Consultar = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        jButton6 = new javax.swing.JButton();
	        jLabel3 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jLabelFondo = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

	        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
	        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png")));
	        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 40, -1, 40));

	        jButton_Consultar.setBackground(new java.awt.Color(0, 51, 102));
	        jButton_Consultar.setFont(new java.awt.Font("Tahoma", 1, 14));
	        jButton_Consultar.setForeground(new java.awt.Color(255, 255, 255));
	        jButton_Consultar.setText("CONSULTAR INTERVENCIONES ASIGNADAS");
	        jButton_Consultar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton_ConsultarActionPerformed(evt);
	            }
	        });
	        jButton_Consultar.addKeyListener(new java.awt.event.KeyAdapter(){
	            public void keyPressed(java.awt.event.KeyEvent ke) {
	                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
	                	jButton_Consultar.doClick();
	                }
	            }
	        });
	        jButton_Consultar.addFocusListener(new java.awt.event.FocusAdapter() {
	        	public void focusGained(java.awt.event.FocusEvent e) {
	        		jButton_Consultar.setBackground(new java.awt.Color(0, 10	, 30));
	        	}
	        public void focusLost(java.awt.event.FocusEvent e) {
	        	jButton_Consultar.setBackground(new java.awt.Color(0, 51, 102));	
	          }
	        });
	        getContentPane().add(jButton_Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 360, 50));

	        jButton4.setBackground(new java.awt.Color(0, 51, 102));
	        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14));
	        jButton4.setForeground(new java.awt.Color(255, 255, 255));
	        jButton4.setText("REGISTRAR CLASIFICACIÓN DE TICKET");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton4ActionPerformed(evt);
	            }
	        });
	        jButton4.addKeyListener(new java.awt.event.KeyAdapter(){
	            public void keyPressed(java.awt.event.KeyEvent ke) {
	                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
	                	jButton4.doClick();
	                }
	            }
	        });
	        jButton4.addFocusListener(new java.awt.event.FocusAdapter() {
	        	public void focusGained(java.awt.event.FocusEvent e) {
	        		jButton4.setBackground(new java.awt.Color(0, 10	, 30));
	        	}
	        public void focusLost(java.awt.event.FocusEvent e) {
	        	jButton4.setBackground(new java.awt.Color(0, 51, 102));	
	          }
	        });
	        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 360, 50));

	        jButton6.setBackground(new java.awt.Color(0, 51, 102));
	        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14));
	        jButton6.setForeground(new java.awt.Color(255, 255, 255));
	        jButton6.setText("BUSCAR CLASIFICACIÓN TICKETS");
	        jButton6.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton6ActionPerformed(evt);
	            }
	        });
	        jButton6.addKeyListener(new java.awt.event.KeyAdapter(){
	            public void keyPressed(java.awt.event.KeyEvent ke) {
	                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
	                	jButton6.doClick();
	                }
	            }
	        });
	        jButton6.addFocusListener(new java.awt.event.FocusAdapter() {
	        	public void focusGained(java.awt.event.FocusEvent e) {
	        		jButton6.setBackground(new java.awt.Color(0, 10	, 30));
	        	}
	        public void focusLost(java.awt.event.FocusEvent e) {
	        	jButton6.setBackground(new java.awt.Color(0, 51, 102));	
	          }
	        });
	        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 360, 50));

	        jLabel3.setFont(new java.awt.Font("Californian FB", 3, 24)); 
	        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
	        jLabel3.setText("GRUPO DE RESOLUCION ");
	        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 300, 30));

	        jButton1.setBackground(new java.awt.Color(0, 51, 102));
	        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
	        jButton1.setForeground(new java.awt.Color(255, 255, 255));
	        jButton1.setText("Salir");
	        jButton1.addKeyListener(new java.awt.event.KeyAdapter(){
	            public void keyPressed(java.awt.event.KeyEvent ke) {
	                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
	                	jButton1.doClick();
	                }
	            }
	        });
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jButton1ActionPerformed(evt);
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
	        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 80, 30));

	        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg")));
	        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 590));

	        pack();
	    }
	    
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	    	
	    	IniciarSesionCU00 i = new IniciarSesionCU00();
	    	i.setVisible(true);

	        this.dispose();
	    }
	    
	    //consultar interv asignada
	    private void jButton_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	ConsultarIntervencionAsignadasCU07 a = new ConsultarIntervencionAsignadasCU07();
	    	a.setVisible(true);
	    	this.dispose();
	    }                                        

	    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	       
	    }                                        

	    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    
	    }                                   


		public void setAnterior(JFrame ant) {
			this.anterior = ant;
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
	            java.util.logging.Logger.getLogger(MenuGrupoResolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(MenuGrupoResolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(MenuGrupoResolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(MenuGrupoResolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }

	    }
	   
             
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton_Consultar;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabelFondo;
                 
	}