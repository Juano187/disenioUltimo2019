
package ventanas;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.GestorBDD;
import Controlador.GestorTicket;
import Modelo.Empleado;
import Modelo.HistorialTicket;
import Modelo.Ticket;
import Modelo.TicketDTO;
import Modelo.Usuario;

public class DetalleTicketCU02 extends javax.swing.JFrame {
	private JFrame frame;
	private JFrame anterior;
	JFrame panel=this;
	private Usuario u ;
	private GestorBDD gBDD = new GestorBDD();
	private GestorTicket gt = new GestorTicket();
	private Empleado e;
	public DetalleTicketCU02(Usuario u2, TicketDTO tdo) {
		
		u = u2;
		e= u.getEmpleado();
		Ticket t = gt.getTicket(tdo.getNumeroTicket());
        initComponents(u, t);
        this.setLocationRelativeTo(null);
        frame = this;
    }
	
    private void initComponents(Usuario u, Ticket t) {
    	
    			//System.out.println(ticketselec.getEmpleado().getDescripcioncargo().toString());
    	
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFielNoEditable = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        telefonoInterno = new javax.swing.JTextField();
        jTextFielNoEditable2 = new javax.swing.JTextField();
        jTextFielNoEditable3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFielNoEditable8 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Californian FB", 3, 24)); 
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("DETALLE TICKET");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 260, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 19)); 
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Datos usuario");    
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Datos del reclamo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Legajo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jTextField4.setEditable(false);
        jTextField4.setForeground(new java.awt.Color(51, 51, 51));
        jTextField4.setPreferredSize(new java.awt.Dimension(52, 22));
        jTextField4.setText((t.getEmpleado().getLegajo().toString()));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 200, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido y Nombre:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tel\u00e9fono interno:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jTextFielNoEditable.setEditable(false);
        jTextFielNoEditable.setText(t.getNum_ticket().toString());
        jTextFielNoEditable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFielNoEditableActionPerformed(evt);
            }
        });
        
        getContentPane().add(jTextFielNoEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 250, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ubicaci\u00f3n:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tel\u00e9fono directo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Descripci\u00f3n del cargo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        telefonoInterno.setEditable(false);
        telefonoInterno.setText(u.getEmpleado().getTelefonoint().toString());
        telefonoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoInternoActionPerformed(evt);
            }
        });
        getContentPane().add(telefonoInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 260, 30));

        jTextFielNoEditable2.setEditable(false);
        jTextFielNoEditable2.setText(e.getTelefono().toString());
        jTextFielNoEditable2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFielNoEditable2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFielNoEditable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 290, 30));

        jTextFielNoEditable3.setEditable(false);
        jTextFielNoEditable3.setText(e.getDireccion().get(0).getCalle()+ " "+ e.getDireccion().get(0).getNumero().toString());
        jTextFielNoEditable3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFielNoEditable3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFielNoEditable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 320, 30));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setText("Descripcion del cargo");
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 13)); 
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 690, 80));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cerrar");
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton1.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton1.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 590, 90, 30));

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Derivar");
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
        
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 590, 90, 30));

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Atr\u00e1s");
        jButton3.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton3.doClick();
                }
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
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionAtras(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 590, 80, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png"))); 
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 420, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nro de Ticket:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, 30));

        jTextFielNoEditable8.setEditable(false);
        jTextFielNoEditable8.setText(e.getApellido() + " "+ e.getNombre());
        jTextFielNoEditable8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFielNoEditable8ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFielNoEditable8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 370, 30));

    
        

       String [] columnas = { "Fecha/Hora cambio estado", "Operador a cargo", "Estado", "Grupo de resoluci\u00f3n", "Clasificaci\u00f3n", "Observaciones"};
       DefaultTableModel tablaTickets = new DefaultTableModel(columnas,0);
       jTable1.setModel(tablaTickets);
       
       for(HistorialTicket i: t.getListahistorial()) {
    	 
    	   tablaTickets.addRow( new String[] {	 
    			   i.getFechaIni().toString(),
    			   i.getUser().getUsuario(),
    			   i.getEstado().toString(),
    			   i.getUser().getGruporesolucion().getNom_grupo(),
    			   i.getClasif(),
    			   i.getDescripcion()});
     
      			}

        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 1010, 160));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        jLabelFondo.setPreferredSize(new java.awt.Dimension(1100, 650));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, -1));

        pack();
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
     
    }

    private void jTextFielNoEditableActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jTextFielNoEditable2ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jTextFielNoEditable3ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void telefonoInternoActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void jTextFielNoEditable8ActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

	public void setAnterior(JFrame anterior) {
		this.anterior = anterior;
	}
	
    private void accionAtras(java.awt.event.ActionEvent evt) {
        anterior.setVisible(true);
        this.dispose();
    }
	
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            DerivarTicketCU04 d = new DerivarTicketCU04(null, null);
            d.setAnterior(frame);
            d.setVisible(true);
            this.setVisible(false);
            
            }catch(Exception ex) {
            	
            	EjemploError error = new EjemploError(ex.getMessage());
        	  	error.setVisible(true); }
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
            java.util.logging.Logger.getLogger(DetalleTicketCU02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleTicketCU02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleTicketCU02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleTicketCU02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }


    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFielNoEditable;
    private javax.swing.JTextField telefonoInterno;
    private javax.swing.JTextField jTextFielNoEditable2;
    private javax.swing.JTextField jTextFielNoEditable3;
    private javax.swing.JTextField jTextFielNoEditable8;
    private javax.swing.JTextField jTextField4;

}
