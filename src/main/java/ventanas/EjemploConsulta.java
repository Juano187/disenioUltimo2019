
	package ventanas;


	public class EjemploConsulta extends javax.swing.JFrame {

	    public EjemploConsulta(String b) {
	    	
	        initComponents(b);
	        this.setLocationRelativeTo(null);
	    }

	
	    @SuppressWarnings("unchecked")
	                    
	    private void initComponents(String a) {
	    	 jLabel3 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jLabelFondo = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

	        jButton1.setBackground(new java.awt.Color(0, 51, 102));
	        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
	        jButton1.setForeground(new java.awt.Color(255, 255, 255));
	        jButton1.setText("SI");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 100, 30));

	        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18));
	        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
	        jLabel3.setText(a);
	        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));
	       
	        jButton2.setBackground(new java.awt.Color(0, 51, 102));
	        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
	        jButton2.setForeground(new java.awt.Color(255, 255, 255));
	        jButton2.setText("NO");
	        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 100, 30));

	        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg")));
	        jLabelFondo.setPreferredSize(new java.awt.Dimension(618, 289));
	        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 295));

	        pack();
	    }                    

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    			this.dispose();
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
	            java.util.logging.Logger.getLogger(EjemploConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(EjemploConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(EjemploConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(EjemploConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	      
	   
	    }

	           
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JLabel jLabelFondo;
	    private javax.swing.JLabel jLabel3;
	}

