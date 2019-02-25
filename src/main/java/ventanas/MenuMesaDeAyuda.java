package ventanas;

import java.awt.event.KeyEvent;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JFrame;

import Controlador.GestorBDD;
import Controlador.GestorTicket;
import Controlador.GestorUsuario;
import Modelo.HistorialTicket;
import Modelo.Ticket;
import Modelo.Usuario;


@SuppressWarnings("serial")
public class MenuMesaDeAyuda extends javax.swing.JFrame {
	GestorUsuario gu = new GestorUsuario();
	GestorTicket gt = new GestorTicket();
	GestorBDD gbdd = new GestorBDD ();
	private JFrame frame;
	private JFrame anterior;
	private Usuario u;
	JFrame panel=this;
    
	public MenuMesaDeAyuda(String user) { 
		u=gu.getUsuario(user);
		initComponents( u);
        this.setLocationRelativeTo(null);
        frame = this;
    } 

    @SuppressWarnings("unchecked")
                        
    private void initComponents(Usuario user) {

        jLabel2 = new javax.swing.JLabel();
        jButton_Registrar = new javax.swing.JButton();
        jButton_Consultar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton_Salir = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png"))); 
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 40, -1, 40));

        jButton_Registrar.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Registrar.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton_Registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Registrar.setText("REGISTRAR TICKET");
        jButton_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarActionPerformed(evt);
            }
        });
        jButton_Registrar.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton_Registrar.doClick();
                }
            }
        });
        jButton_Registrar.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton_Registrar.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton_Registrar.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(jButton_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 360, 50));

        jButton_Consultar.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Consultar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton_Consultar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Consultar.setText("CONSULTAR TICKET");
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
        getContentPane().add(jButton_Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 360, 50));

        jLabel3.setFont(new java.awt.Font("Californian FB", 3, 24));
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("MESA DE AYUDA ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 280, 30));

        jButton_Salir.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Salir.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton_Salir.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Salir.setText("Salir");
        jButton_Salir.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton_Salir.doClick();
                }
            }
        });
        jButton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalirActionPerformed(evt);
            }
        });
        jButton_Salir.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton_Salir.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton_Salir.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(jButton_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 90, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg")));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 500));

        pack();
    }             
    
    public void addUser ( Usuario user) {
    	u = user;
    }

    private void jButton_SalirActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	IniciarSesionCU00 i = new IniciarSesionCU00();
    	i.setVisible(true);

        this.dispose();
    }
    
    private void jButton_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            RegistrarTicketCU01 r = new RegistrarTicketCU01(u.getUsuario());
            r.setAnterior(frame);
            r.setVisible(true);
            this.setVisible(false);
            
            }catch(Exception ex) {
            	
            	EjemploError error = new EjemploError(ex.getMessage());
        	  	error.setVisible(true); }
            }                                      

    private void jButton_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
        	
            ConsultarTicketCU02 r = new ConsultarTicketCU02(u.getUsuario());
            r.setAnterior(frame);
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
   
               
    private javax.swing.JButton jButton_Registrar;
    private javax.swing.JButton jButton_Consultar;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo;
                      
}

