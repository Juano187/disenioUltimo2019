
package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import Controlador.GestorClasificacion;
import Controlador.GestorGrupoResolucion;
import Controlador.GestorTicket;
import Modelo.ClasificacionDTO;
import Modelo.EstadoTicket;
import Modelo.GrupoResolucion;
import Modelo.GrupoResolucionDTO;
import Modelo.TicketDTO;
import Modelo.Usuario;





@SuppressWarnings("serial")
public class ConsultarTicketCU02 extends javax.swing.JFrame {

	
	//agregar
	private GestorClasificacion gestorC= new GestorClasificacion();
	private GestorGrupoResolucion gestorG= new GestorGrupoResolucion();
	private GestorTicket gestorT = new GestorTicket(); 
	private Usuario u ;
	private JFrame anterior;
	private JFrame frame;
	JFrame panel=this;
	DefaultTableModel TablaTickets;
	ArrayList<TicketDTO> listaTencontrados;
	private int seleccion;
	
	TicketDTO ticketselec;

	
    public ConsultarTicketCU02(Usuario u2) {
    	  u=u2;
    	  System.out.println(u.getUsuario());
        initComponents(u);
        this.setLocationRelativeTo(null); 
        frame = this;
    }


  
    private void initComponents(Usuario u) {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
       
        
        numTicket = new javax.swing.JTextField();
        legajo = new javax.swing.JTextField();
        fechaApertura = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fechaUltimo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Californian FB", 3, 24)); 
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("CONSULTAR TICKET");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 270, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Clasificaci\u00f3n");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("\u00daltimo grupo asignado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("N\u00famero de ticket:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver al men\u00fa");
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton1.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton1.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton1.doClick();
                }
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionVolver(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 540, 160, 30));

    
        
        buscar.setBackground(new java.awt.Color(0, 51, 102));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar");
        buscar.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    buscar.doClick();
                }
            }
        });
        buscar.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		buscar.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	buscar.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 540, 90, 30));

       
        TablaTickets = new DefaultTableModel(
        	 new Object [][] {
                },
                new String [] {
                  "Nro ticket", "Legajo", "Fecha Apertura", "Estado", "Clasificacion "  /*"Grupo de resolucion"*/
                }
            );
        
            jTable1.setModel(TablaTickets);
            jScrollPane1.setViewportView(jTable1);

   
            jTable1.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseReleased(MouseEvent e) {
    				int r = jTable1.rowAtPoint(e.getPoint());
    				seleccion = r;
    			}

    		});
            
            
            
        JComboBox<EstadoTicket> comboBox = new JComboBox<>();
        
        comboBox.setModel(new DefaultComboBoxModel<>(EstadoTicket.values()));
        getContentPane().add(comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 410, 30));
        /*
        JComboBox ComboEstado = new JComboBox();
        ComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abierto Sin Derivar", "Abierto Derivado", "Solucionado a la espera del Ok", "Cerrado" , "Todos"}));*/
        
        List<ClasificacionDTO> clasificaciones= gestorC.getClasificaciones();
        JComboBox<ClasificacionDTO> jComboBox1= new JComboBox<ClasificacionDTO>();
        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Todas" }));
               
        for(int i=1 ; i < clasificaciones.size(); i++) {
            	jComboBox1.addItem(clasificaciones.get(i));}
        
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 360, 30));

        List<GrupoResolucionDTO> ultgrupos= gestorG.getGrupoResolucion();
        JComboBox<GrupoResolucionDTO> combogrupo= new JComboBox<GrupoResolucionDTO>();
        combogrupo.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));

        for(int i=1 ; i < ultgrupos.size(); i++) {
        	combogrupo.addItem(ultgrupos.get(i));
        }
        getContentPane().add(combogrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 270, 30));
        //hasta aca	 AGREGAR Y CAMBIAR POR LOS OTROS COMBOX Q HABIA        
        
        
        numTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFielNoEditableActionPerformed(evt);
            }
        });
        getContentPane().add(numTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 220, 30));

        legajo.setPreferredSize(new java.awt.Dimension(52, 22));/*numero legajo*/
        legajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(legajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 220, 30));

        fechaApertura.setPreferredSize(new java.awt.Dimension(52, 22));  //fecha partura cuadtrito
        fechaApertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(fechaApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 230, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha de Apertura:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("N\u00famero de Legajo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("cambio de estado:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha de \u00faltimo ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        fechaUltimo.setPreferredSize(new java.awt.Dimension(52, 22));
        fechaUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(fechaUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 230, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png")));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 41, 830, 40));
        
        //funcion boton buscar 
        ErrorFormatoFecha ven = new ErrorFormatoFecha();
        ErrorCamposVacios ven1 = new ErrorCamposVacios();
       ; 
        buscar.addActionListener(new ActionListener() {
        
        	public void actionPerformed(ActionEvent ae) {	

        		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        		model.setRowCount(0);
        		Long numTic = null;
        		Integer numLegajo = null;
        		Date fechaABien = null;
        		Date fechaUBien = null ;
        		Date fechaAct = new Date();
        		String estado = null;
        		ClasificacionDTO clasificacion;
        		GrupoResolucionDTO ultimoG;
        
        		if(!numTicket.getText().isEmpty()) numTic = Long.valueOf(numTicket.getText());
        		if(!legajo.getText().isEmpty()) numLegajo = Integer.valueOf(legajo.getText());
        		estado = comboBox.getSelectedItem().toString();
        		
        		/*estado= comboBox.getSelectedItem();*/
        		clasificacion = (ClasificacionDTO) jComboBox1.getSelectedItem();
        		ultimoG = (GrupoResolucionDTO) combogrupo.getSelectedItem();
        		
        		boolean res=true;
        		
        		//error en validar fecha
        	
        		if(!fechaApertura.getText().isEmpty()) {
        			res= GestorTicket.validarFecha(fechaApertura.getText());
        		
        			
        
            		if(res==true){
            				fechaABien= GestorTicket.stringtodate(fechaApertura.getText());
            				System.out.println(fechaABien);
            				
            		}else {
            			ven.setVisible(true); //muestra ventana error
            			}
            	} 
        		
        		if(!fechaUltimo.getText().isEmpty()) {
        			res=GestorTicket.validarFecha(fechaUltimo.getText());
            		if(res==true){
            			fechaUBien= GestorTicket.stringtodate(fechaUltimo.getText());
        				System.out.println(fechaUBien);
            		}else {
            			ven.setVisible(true);
            			}
            	}
        		
 
        		/*ErrorDatosIncorrectos ven2= new ErrorDatosIncorrectos();
        		if(((fechaABien.compareTo(fechaAct) >= 0) || (!fechaApertura.getText().isEmpty()) ) && (fechaUBien.compareTo(fechaAct)>=0) || (!fechaUltimo.getText().isEmpty())){
        			ven2.setVisible(true);
        		}else {*/
        	
        		listaTencontrados = gestorT.consultarTicket(numTic, numLegajo,fechaABien, fechaUBien ,  estado, clasificacion , ultimoG  );	
        			
        		System.out.println("tamaño lista : " +listaTencontrados.size());
        			//System.out.println("num tic" + numTic + " legajo " + numLegajo + " fechaABien " + fechaABien + " estado " + estado + " clasificacion " + clasificacion + "ultimo " + ultimoG);
        		//}

                		
                	//}
                	
                	if(listaTencontrados.size() > 0) {
                		
                		ObtenerListaTicket(listaTencontrados);
        			}
        			
        			else {
        				EjemploError e = new EjemploError("No existen tickets que cumplan con los criterios ingresados.");
                		e.setVisible(true);  

        			}
                	
                	
                	
                	
                	}
                	
                	
                	
                });
        
        
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 630, 970, 160));

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cerrar Ticket");
        jButton3.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton3.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton3.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter(){
        	
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton3.doClick();
                }
                
            }
        });
        

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Detalle");
        jButton4.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton4.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton4.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	Integer numTSeleccionado = Integer.valueOf(((Vector) TablaTickets.getDataVector().elementAt(jTable1.getSelectedRow())).elementAt(0).toString());
        		
        		ticketselec = gestorT.consultarTicket(numTSeleccionado, listaTencontrados);
        		System.out.println(ticketselec.getNumeroTicket());

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
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 110, 30));//330, 830, 110, 30));

        jButton5.setBackground(new java.awt.Color(0, 51, 102));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Configurar reporte");
        jButton5.addFocusListener(new java.awt.event.FocusAdapter() {
        	public void focusGained(java.awt.event.FocusEvent e) {
        		jButton5.setBackground(new java.awt.Color(0, 10	, 30));
        	}
        public void focusLost(java.awt.event.FocusEvent e) {
        	jButton5.setBackground(new java.awt.Color(0, 51, 102));	
          }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter(){
        	
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton5.doClick();
                }
                
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 830, 180, 30));
        
        //cerrar
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	Integer numTSeleccionado = Integer.valueOf(((Vector) TablaTickets.getDataVector().elementAt(jTable1.getSelectedRow())).elementAt(0).toString());
            	ticketselec = gestorT.consultarTicket(numTSeleccionado, listaTencontrados);
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 830, 140, 30));
        
        
        jButton6.setBackground(new java.awt.Color(0, 51, 102));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Derivar Ticket");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        	if(jTable1.getSelectedRow() != -1 || jTable1.getSelectedRow() < listaTencontrados.size()) {
        		
        		Integer numTSeleccionado = Integer.valueOf(((Vector) TablaTickets.getDataVector().elementAt(jTable1.getSelectedRow())).elementAt(0).toString());
        		
        		ticketselec = gestorT.consultarTicket(numTSeleccionado, listaTencontrados);
        		System.out.println(ticketselec.getNumeroTicket());
        		
        		if((ticketselec.getEstado() == EstadoTicket.SOLUCIONADOALAESPERAOK) || (ticketselec.getEstado()== EstadoTicket.ABIERTOSINDERIVAR)) {
        			jButton6ActionPerformed(evt);
        		}
        		else {
            	
        			EstadoTicket estado = ticketselec.getEstado();
        			String e= "No se puede derivar en estado\n";
        			String a= e + estado;
        			System.out.println(a);
        			EjemploError i = new EjemploError(a);
            		i.setVisible(true);
        		}
        	}
        	//TicketDTO t = TablaTickets.get ;
        	
        	
        	
        	
        	
           
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
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20 /*830*/, 140, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        jLabelFondo.setPreferredSize(new java.awt.Dimension(1100, 650));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 910));

        pack();
    }

    private void jTextFielNoEditableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFielNoEditableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFielNoEditableActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    public void addUser (Usuario user) {
    	u= user;
    }
    
  
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
        	
            CerrarTicketCU03 r = new CerrarTicketCU03(ticketselec);
            r.setAnterior(frame);
            r.setVisible(true);
            this.setVisible(false);
            
            }catch(Exception ex) {
            	
            	EjemploError error = new EjemploError(ex.getMessage());
        	  	error.setVisible(true); }
            }      
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      try {
        	System.out.println("usuario: "+u.getUsuario() +" ;"+"numTicket"+ticketselec.getNumeroTicket());
            DetalleTicketCU02 r = new DetalleTicketCU02(u, ticketselec);
            r.setAnterior(frame);
            r.setVisible(true);
            this.setVisible(false); 
            
            }catch(Exception ex) {
            
            	EjemploError error = new EjemploError(ex.getMessage());//"error al entrar a detalleTicket");
        	  	error.setVisible(true); }
    		}
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            ConfigurarReporteCU05 r = new ConfigurarReporteCU05();
            r.setAnterior(frame);
            r.setVisible(true);
            this.setVisible(false);
            
            }catch(Exception ex) {
            	
            	EjemploError error = new EjemploError(ex.getMessage());
        	  	error.setVisible(true); }
            }      
    
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
        
        	DerivarTicketCU04 d = new DerivarTicketCU04(ticketselec, u);
            d.setAnterior(frame);
            d.setVisible(true);
            this.setVisible(false);
            
            }catch(Exception ex) {
            	
            	EjemploError error = new EjemploError(ex.getMessage());
        	  	error.setVisible(true); }
            }  
    

    
    private void accionVolver(java.awt.event.ActionEvent evt) {
        anterior.setVisible(true);
        this.dispose();
    }
    
 	public void setAnterior(JFrame anterior) {
 		this.anterior = anterior;
 	}
 	
 	
	public void ObtenerListaTicket(ArrayList<TicketDTO> resultado) {
 		System.out.println(resultado.size());
 		
 	for(TicketDTO t: resultado) {
 		
 		System.out.println(t.getNumeroTicket().toString());
 		System.out.println(t.getNumlegajo().toString());
 	//	System.out.println(t.getFechaA().toString());
 	//	System.out.println(t.getFechaU().toString());
 		System.out.println(t.getCla().getNom_clasificacion());
 		System.out.println(t.getEstado().toString());
 		TablaTickets.addRow(new String[] {t.getNumeroTicket().toString(), t.getNumlegajo().toString(),/*t.getFechaA().toString() ,t.getFechaU().toString() ,*/t.getEstado().toString(), t.getUsuario().toString() ,t.getCla().getNom_clasificacion(),t.getGru().getNom_grupo()});
 	
 			}
 		
 		
 		}
 	
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
            java.util.logging.Logger.getLogger(ConsultarTicketCU02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarTicketCU02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarTicketCU02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarTicketCU02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
       
        
      
    }
    
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton buscar;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> combocalif;
    private javax.swing.JComboBox<String> combogrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField numTicket;
    private javax.swing.JTextField fechaApertura;
    private javax.swing.JTextField legajo;
    private javax.swing.JTextField fechaUltimo;
    // End of variables declaration//GEN-END:variables
}