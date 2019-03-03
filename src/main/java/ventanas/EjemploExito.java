
package ventanas;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;

public class EjemploExito extends javax.swing.JFrame {

	private String u; 
	private JFrame anterior;
	public Boolean abc = false;
	public EjemploExito(String s,String user, JFrame a, Boolean b) {
		if(b) {
		
			Toolkit.getDefaultToolkit().beep();
			abc = true;
			anterior =a ;
	        u= user;
	    	initComponents(s);
	        this.setLocationRelativeTo(null);
		}
		
	}
    public EjemploExito(String s) {
    	Toolkit.getDefaultToolkit().beep();
        initComponents(s);
        this.setLocationRelativeTo(null);
    }
    public EjemploExito(String s,String user,JFrame a) { 
    	Toolkit.getDefaultToolkit().beep();
    	anterior =a ;
        u= user;
    	initComponents(s);
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")

    private void initComponents(String a) {
 
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton_Confirmar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-ok-150.png"))); 
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(a);
        
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        jButton_Confirmar.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Confirmar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton_Confirmar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Confirmar.setText("Aceptar");
        jButton_Confirmar.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton_Confirmar.doClick();
                }
            }
        });
        jButton_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
                jButton_ConfirmarActionPerformed();
            }
        });
        jButton_Confirmar.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton_Confirmar.setBackground(new java.awt.Color(0, 10, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton_Confirmar.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(jButton_Confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 90, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        jLabel2.setPreferredSize(new java.awt.Dimension(618, 289));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }
    
    private void jButton_ConfirmarActionPerformed() {
    	if(abc) {
    		anterior.dispose();
        	this.dispose();
        	MenuGrupoResolucion m = new MenuGrupoResolucion(u);
        	m.setVisible(true);
    	}else {
    	anterior.dispose();
    	this.dispose();
    	MenuMesaDeAyuda m = new MenuMesaDeAyuda(u);
    	m.setVisible(true);
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
            java.util.logging.Logger.getLogger(EjemploExito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EjemploExito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EjemploExito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EjemploExito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
    }

   
    private javax.swing.JButton jButton_Confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
 
}

