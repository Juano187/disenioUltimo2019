package ventanas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import Controlador.GestorClasificacion;
import Controlador.GestorGrupoResolucion;
import Controlador.GestorTicket;
import Controlador.GestorUsuario;
import Modelo.Clasificacion;
import Modelo.ClasificacionDTO;
import Modelo.EstadoIntervencion;
import Modelo.GrupoResolucion;
import Modelo.IntervencionDTO;
import Modelo.Ticket;
import Modelo.Usuario;



public class ActualizarEstadoIntervencionCU08 extends javax.swing.JFrame {

	private GestorClasificacion gestorC= new GestorClasificacion();
	private GestorGrupoResolucion gestorG= new GestorGrupoResolucion();
	private GestorTicket gestorT = new GestorTicket(); 
	private GestorUsuario gu = new GestorUsuario();
	private Clasificacion[] clasificaciones;
	private IntervencionDTO in;
	private JFrame anterior;
	 final int SCROLL_BUFFER_SIZE = 20;
	private JTextArea textarea;
	private Usuario u;
	
	
//TODO PONER PARAMETROS
    public ActualizarEstadoIntervencionCU08(IntervencionDTO interv, String user, Integer idgrupo) {
    	u = gu.getUsuario(user);
    	in=interv;
        initComponents(interv, user, idgrupo);
        this.setLocationRelativeTo(null);
    }

 
    private void initComponents(IntervencionDTO interv, String user, Integer idgrupo) {

    	Ticket ticket = gestorT.getTicket(interv.getIdTicket());
    	GrupoResolucion grupo = gestorG.getGrupo(idgrupo);
    	clasificaciones = cargarClasificaciones(grupo.getNom_grupo());
    	
    	jScrollPane1 = new javax.swing.JScrollPane();
    	jScrollPane2 = new javax.swing.JScrollPane();
    	String cla = interv.getClas().getNombre();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textDescrip = new javax.swing.JTextField();
       jTextArea1 = new javax.swing.JTextArea();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        comboestado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboClasificacion = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Californian FB", 3, 24)); 
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("ACTUALIZAR EL ESTADO DE INTERVENCI\u00d3N");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 510, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripci\u00f3n del problema:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));
        
       // textarea = new JTextArea(2, 2);
      
        	
        jTextArea1.setColumns(5);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 13)); 
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(5);
        jTextArea1.setText("Ingrese descripcion (max de caracteres 150)");
        
        
        jTextArea1.setEditable(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setLineWrap(true);
       jScrollPane1.setViewportView(jTextArea1);
       
        
      //  textDescrip.setText(ticket.getDescrip_problema());
        getContentPane().add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 890, 110));
        
        jTextArea1.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {
        		
        		super.keyTyped(e);
        		if(jTextArea1 != null && jTextArea1.getText() != null && jTextArea1.getText().length() >= 300){
        			
        			e.setKeyChar((char) KeyEvent.VK_CLEAR);
        		}
        	}
        }); 
   

       
  

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nuevo estado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));
        JComboBox<EstadoIntervencion> comboestado = new JComboBox<>();
        comboestado.setModel(new DefaultComboBoxModel(new String[] { "Todas" }));
        comboestado.setModel(new DefaultComboBoxModel<>(EstadoIntervencion.values()));
        
       
        getContentPane().add(comboestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 490, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Clasificaci\u00f3n:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

    	System.out.println("id grupo actualiza");
    	System.out.println(idgrupo);
    	JComboBox<Clasificacion> comboClasificacion = new JComboBox<Clasificacion>();
    	comboClasificacion.setModel(new DefaultComboBoxModel(new String[] { "Todas" }));
    	comboClasificacion.setModel(new DefaultComboBoxModel<Clasificacion>(clasificaciones));
		
	
        getContentPane().add(comboClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 500, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Observaciones:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));
        
        
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 13)); 
        jTextArea2.setRows(5);
              
        jTextArea2.setEditable(false);
        jTextArea2.setText(ticket.getDescrip_problema());
       
        jScrollPane2.setViewportView(jTextArea2);
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 155, 890, 100));

        jButtonCancelar.setBackground(new java.awt.Color(0, 51, 102));
        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jButtonCancelar.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButtonCancelar.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButtonCancelar.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        jButtonCancelar.requestFocusInWindow();
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 100, 30));

        jButtonAceptar.setBackground(new java.awt.Color(0, 51, 102));
        jButtonAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButtonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	if(comboestado.getSelectedIndex() == 0) {
            		EjemploError e = new EjemploError("Elija estado");
            		e.setVisible(true);
            		
            	}
            	else if(jLabel6.getText().isEmpty()) {
            		EjemploError e = new EjemploError("Coloque observaciones");
            		e.setVisible(true);
            	}
            	else {
            		gestorT.actualizarEstadoI(interv, comboestado.getSelectedItem().toString(), jTextField2.getText(), (Clasificacion)comboClasificacion.getSelectedItem());
            	}
            	
            	
                jButtonAceptarActionPerformed(evt);
            }
        });
        jButtonAceptar.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButtonAceptar.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButtonAceptar.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        
        getContentPane().add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, 90, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png"))); 
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 950, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("(*) Campo Obligatorio");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, -1, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel10.setForeground(new java.awt.Color(255, 204, 102));
        jLabel10.setText("*");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, 70, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("*");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Estado:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setText(interv.getEstadoI().toString());
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, 80));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nro de ticket:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jTextField3.setEditable(false);
        jTextField3.setText(ticket.getNum_ticket().toString());
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 210, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        jLabelFondo.setPreferredSize(new java.awt.Dimension(1100, 650));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //TODO toma grupo que viene por parametro, toma todas als clas de la base, compara que no sea igual a la clasf q tmb 
    //viene por parametro, y si no es la misma la agrega
    
    private Clasificacion[] cargarClasificaciones(String grupo) {
    	 List<Clasificacion> clas=gestorC.getclasificacionsDTO(grupo);
    	 System.out.println("tamaño cals");
    	 System.out.println(clas.size());
    	 clasificaciones = new Clasificacion[clas.size()];
    	 List<Clasificacion> c = new ArrayList<>();
    	 
    	 for(Clasificacion ct : clas) {
    		if(!ct.getNom_clasificacion().equalsIgnoreCase(in.getClas().getNombre())){
    			c.add(ct);
    			
    		}
    	 }
    	 clasificaciones[0] = new Clasificacion(in.getClas().getNombre()) ;
    	 for(int i=0 ; i< c.size() ; i++) {
    		 clasificaciones[i+1] = c.get(i);
     	 }
		return clasificaciones;
	}
    
    public void setAnterior (JFrame a) {
    	this.anterior = a;

    }


	private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
		EjemploExito e = new EjemploExito("Cambio Cancelado ",u.getUsuario(),this,true);
    	e.setVisible(true);

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
    	EjemploExito e = new EjemploExito("Cambio Realizado ",u.getUsuario(),this,true);
    	e.setVisible(true);
	        }//GEN-LAST:event_jButtonAceptarActionPerformed

   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ActualizarEstadoIntervencionCU08.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarEstadoIntervencionCU08.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarEstadoIntervencionCU08.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarEstadoIntervencionCU08.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JComboBox<String> comboestado;
    private javax.swing.JComboBox<String> comboClasificacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;    
    private javax.swing.JTextField textDescrip;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}