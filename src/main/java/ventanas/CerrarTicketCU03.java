

package ventanas;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import Controlador.GestorTicket;
import Modelo.TicketDTO;

public class CerrarTicketCU03 extends javax.swing.JFrame {

	private GestorTicket gestorT = new GestorTicket();
	private JFrame frame;
	private JFrame anterior;
	private String u;
    public CerrarTicketCU03(TicketDTO td) {
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	u = td.getUsuario();
    	frame= this;
        initComponents(td);
        this.setLocationRelativeTo(null);
    }

   
    private void initComponents(TicketDTO td) {

        jLabel1 = new javax.swing.JLabel();
        jButton_Cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_Confirmar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Observaciones : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

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
                jButton_CancelarActionPerformed(evt);
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
 
        getContentPane().add(jButton_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 100, 30));

        jLabel2.setFont(new java.awt.Font("Californian FB", 3, 24)); 
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("CERRAR TICKET");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 230, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(11, 11));
        jScrollPane1.setRequestFocusEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 13)); 
        jTextArea1.setRows(5);
        jTextArea1.setText("Ingrese texto...");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 840, 180));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nuevo Estado : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("CERRADO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 150, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setText("(*) Campo Obligatorio");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, -1, 40));

        jButton_Confirmar.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Confirmar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton_Confirmar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Confirmar.setText("Confirmar");
        jButton_Confirmar.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton_Confirmar.doClick();
                }
            }
        });
        jButton_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	gestorT.cerrarTicket(td.getNumeroTicket() , jTextArea1.getText());
                jButton_ConfirmarActionPerformed(evt);
            }
        });
        jButton_Confirmar.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton_Cancelar.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton_Cancelar.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        
        getContentPane().add(jButton_Confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 490, 110, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png"))); 
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1110, 70));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("*");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        jLabelFondo.setPreferredSize(new java.awt.Dimension(1100, 650));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 590));

        pack();
    }

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {
    	anterior.invalidate();
    	anterior.validate();
    	anterior.repaint();
    	anterior.setVisible(true);
        this.dispose();
    }

    private void jButton_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
    	EjemploExito e = new EjemploExito("Ticket Cerrado ",frame,u);
    	e.setVisible(true);
 
    	
    }
    public String getUser() {
    	return u ;
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
            java.util.logging.Logger.getLogger(CerrarTicketCU03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CerrarTicketCU03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CerrarTicketCU03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CerrarTicketCU03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

       
    }


    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_Confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;

}
