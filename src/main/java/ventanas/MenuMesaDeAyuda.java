package ventanas;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MenuMesaDeAyuda extends javax.swing.JFrame {
	private JFrame frame;
	private JFrame anterior;
	private String u = new String();
	JFrame panel=this;
    
	public MenuMesaDeAyuda(String user) { 
		u=user;
		initComponents();
        this.setLocationRelativeTo(null);
        frame = this;
    } 

    @SuppressWarnings("unchecked")
                        
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png"))); 
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 40, -1, 40));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REGISTRAR TICKET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton1.doClick();
                }
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 360, 50));

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CONSULTAR TICKET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton2.doClick();
                }
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
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 360, 50));

        jLabel3.setFont(new java.awt.Font("Californian FB", 3, 24));
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("MESA DE AYUDA ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 280, 30));

        botonSalir.setBackground(new java.awt.Color(0, 51, 102));
        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 14));
        botonSalir.setForeground(new java.awt.Color(255, 255, 255));
        botonSalir.setText("Salir");
        botonSalir.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    botonSalir.doClick();
                }
            }
        });
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        botonSalir.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		botonSalir.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	botonSalir.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 90, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg")));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 500));

        pack();
    }             
    
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	IniciarSesionCU00 i = new IniciarSesionCU00();
    	i.setVisible(true);

        this.dispose();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            RegistrarTicketCU01 r = new RegistrarTicketCU01(u);
            r.setAnterior(frame);
            r.setVisible(true);
            this.setVisible(false);
            
            }catch(Exception ex) {
            	
            	EjemploError error = new EjemploError(ex.getMessage());
        	  	error.setVisible(true); }
            }                                      

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            ConsultarTicketCU02 r = new ConsultarTicketCU02();
            r.setAnterior(frame);
            r.addUser(u);
            r.setVisible(true);
            this.setVisible(false);
            
            }catch(Exception ex) {
            	
            	EjemploError error = new EjemploError(ex.getMessage());
        	  	error.setVisible(true); }
            }                  
    
	public void setAnterior(JFrame anterior) {
		this.anterior = anterior;
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
            java.util.logging.Logger.getLogger(MenuMesaDeAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuMesaDeAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuMesaDeAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuMesaDeAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }
   
               
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo;
                      
}

