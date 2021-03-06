
package ventanas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlador.GestorBDD;
import Controlador.GestorUsuario;
import Modelo.Usuario;


@SuppressWarnings("serial")
public class IniciarSesionCU00 extends javax.swing.JFrame {
	private GestorUsuario gu = new GestorUsuario ();
	private GestorBDD gbdd = new GestorBDD();
	private JFrame frame;


    public IniciarSesionCU00() {
            frame = this;
            initComponents();
            this.setLocationRelativeTo(null); 
    
        
    }
    
    


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton_Ingresar = new javax.swing.JButton();
        jButton_Salir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contrase\u00f1a:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, -1, 20));

        jTextFieldUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 260, 30));


        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter(){
        	
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton_Ingresar.doClick();
                }
                
            }

		
        });

        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 260, 30));

        jButton_Ingresar.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Ingresar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton_Ingresar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Ingresar.setText("Ingresar");
        jButton_Ingresar.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton_Ingresar.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton_Ingresar.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });


        jButton_Ingresar.addKeyListener(new java.awt.event.KeyAdapter(){
        	
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton_Ingresar.doClick();
                }
                
            }
        });
        
        jButton_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IngresarActionPerformed(evt);
            }
        });
        
        getContentPane().add(jButton_Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 670, 100, 30));

        jButton_Salir.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Salir.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton_Salir.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Salir.setText("Salir");
        jButton_Salir.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton_Salir.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton_Salir.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
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
        getContentPane().add(jButton_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 670, 100, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MiniICONO.png"))); 
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 800));

        pack();
    }
    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {
        
  
        
    }

    private void jTextFieldUserActionPerformed(java.awt.event.ActionEvent evt) {
    	
    }


    private void jButton_SalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    
    private void jButton_IngresarActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	  
    	  String contra = new String(jPasswordField1.getPassword());
    	  
    	  try {
        if( gbdd.iniciarSesion(jTextFieldUser.getText(),contra )) {
        	if(gu.getUsuario(jTextFieldUser.getText()).getGruporesolucion().getNivel() == 0) {
        		
        		
        		MenuMesaDeAyuda m = new MenuMesaDeAyuda(jTextFieldUser.getText());
     
        		m.setAnterior(frame);   
        		this.setVisible(false);
            	m.setVisible(true);
            	
        	}
        	else {
        		MenuGrupoResolucion m = new MenuGrupoResolucion((jTextFieldUser.getText()));
        	
      			m.setAnterior(frame);
       			this.setVisible(false);
       			m.setVisible(true);
        	
        	}
        }
        
        else {
        	
        	EjemploError e = new EjemploError("Datos invalidos");
        		e.setVisible(true);
        }}	catch(Exception ex) {
        	
        	EjemploError e = new EjemploError(ex.getMessage());
        	e.setVisible(true);
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesionCU00().setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButton_Ingresar;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JPasswordField jPasswordField1;
    public static javax.swing.JTextField jTextFieldUser;


    
}
