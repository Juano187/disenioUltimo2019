package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Modelo.GrupoResolucion;

@SuppressWarnings("serial")
	public class MenuGrupoResolucion extends javax.swing.JFrame {
	    
		String u = new String();
		String grupo = new String ();
		private JFrame anterior;
		JFrame panel;
	    public MenuGrupoResolucion() {
	    	panel = this;
	        initComponents();
	        this.setLocationRelativeTo(null);
	    }
	  
	    
	    @SuppressWarnings("unchecked")
                      
	    private void initComponents() {

	        jLabel2 = new javax.swing.JLabel();
	        jButton3 = new javax.swing.JButton();
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

	        jButton3.setBackground(new java.awt.Color(0, 51, 102));
	        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14));
	        jButton3.setForeground(new java.awt.Color(255, 255, 255));
	        jButton3.setText("CONSULTAR INTERVENCIONES ASIGNADAS");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });
	        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 360, 50));

	        jButton4.setBackground(new java.awt.Color(0, 51, 102));
	        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14));
	        jButton4.setForeground(new java.awt.Color(255, 255, 255));
	        jButton4.setText("REGISTRAR CLASIFICACIÓN DE TICKET");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton4ActionPerformed(evt);
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
	        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 360, 50));

	        jLabel3.setFont(new java.awt.Font("Californian FB", 3, 24)); 
	        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
	        jLabel3.setText("GRUPO DE RESOLUCION ");
	        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 300, 30));

	        jButton1.setBackground(new java.awt.Color(0, 51, 102));
	        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
	        jButton1.setForeground(new java.awt.Color(255, 255, 255));
	        jButton1.setText("Salir");
	        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 80, 30));

	        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg")));
	        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 590));

	        pack();
	    }
	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	      
	    }                                        

	    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	       
	    }                                        

	    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    
	    }                                        
	    public void addGrupo(String g) {
	    	grupo = g;
	    }
	    public void addUser (String user) {
	    	u = user;
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

	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new MenuGrupoResolucion().setVisible(true);
	            }
	        });
	    }
	   
             
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabelFondo;
                 
	}