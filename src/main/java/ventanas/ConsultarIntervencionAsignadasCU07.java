
package ventanas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import Controlador.GestorGrupoResolucion;
import Controlador.GestorIntervencion;
import Controlador.GestorTicket;
import Modelo.EstadoIntervencion;
import Modelo.GrupoResolucion;
import Modelo.IntervencionDTO;
import Modelo.TicketDTO;

public class ConsultarIntervencionAsignadasCU07 extends javax.swing.JFrame {

	private String U;
	private Integer idgru;
	private GestorIntervencion gestorI = new GestorIntervencion();
	private GestorGrupoResolucion gestorR = new GestorGrupoResolucion();
	ArrayList<IntervencionDTO> listaIencontrados;
	DefaultTableModel TablaInterv;
	private JFrame anterior;
	private JFrame frame;
	private EstadoIntervencion[] estados;
	
	IntervencionDTO InterSelec ;
	
    public ConsultarIntervencionAsignadasCU07(String user, Integer idgrupo) {
    	idgru = idgrupo;
    	U=user;
        initComponents(user, idgrupo);
        this.setLocationRelativeTo(null);
        frame = this;
    }

  

    
    private void initComponents(String user, Integer idgrupo) {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        numTic = new javax.swing.JTextField();
        numlegajo = new javax.swing.JTextField();
        fhasta = new javax.swing.JTextField();
        fdesde = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        boton_modEstad = new javax.swing.JButton();
        buttonBuscar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Californian FB", 3, 24)); 
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("CONSULTAR INTERVENCIONES ASIGNADAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 500, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png"))); 
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("N\u00famero de ticket:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hasta:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("N\u00famero de legajo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha \u00faltimo cambio de estado:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Desde:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, -1, -1));

        numTic.setEditable(true);
        numTic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numTicActionPerformed(evt);
            }
        });
        getContentPane().add(numTic, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 230, 30));
        
        numlegajo.setEditable(true);
        numlegajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numlegajoActionPerformed(evt);
            }
        });
        getContentPane().add(numlegajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 220, 30));

        
        //hasta
        fhasta.setEditable(true);
        fhasta.setPreferredSize(new java.awt.Dimension(52, 22));
        fhasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fhastaActionPerformed(evt);
            }
        });
        getContentPane().add(fhasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 200, 30));

        // TODO AGREGAR COMBOOOOOOOOOOOOOOOX 
        JComboBox<EstadoIntervencion> comboBox = new JComboBox<EstadoIntervencion>();
      //  comboBox.add("Todos");
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
        EstadoIntervencion[] tipoEN = EstadoIntervencion.values();
        for(EstadoIntervencion ei: tipoEN) {
        	comboBox.addItem(ei);
        }
         
        
     //   comboBox.setModel(new DefaultComboBoxModel<>(EstadoIntervencion.values()));
        
        getContentPane().add(comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 320, 30));
       // comboBox.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
        
        //desde
        fdesde.setEditable(true);
        fdesde.setPreferredSize(new java.awt.Dimension(52 , 22));
        fdesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fdesdeActionPerformed(evt);
            }
        });
        getContentPane().add(fdesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 200, 30));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver a men\u00fa");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 170, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            			accionVolver(evt);
            }
            });
        
        
        
        		
        TablaInterv = new DefaultTableModel(
            new Object [][] {
               
            },
            new String [] {
                "N\u00famero ticket", "N\u00famero Legajo", "Clasificaci\u00f3n", "Estado ticket", "Fecha apertura", "Estado intervenci\u00f3n", "Fecha asignada", "Grupo resoluci\u00f3n", "Observaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        jTable1.setModel(TablaInterv);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 1010, 160));

        ErrorFormatoFecha ven = new ErrorFormatoFecha();
        buttonBuscar.setBackground(new java.awt.Color(0, 51, 102));
        buttonBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        buttonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        buttonBuscar.setText("Buscar");
        getContentPane().add(buttonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 110, 30));
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	LocalDate fechaA = LocalDate.now();
            	LocalDate desde = null;
            	LocalDate hasta = null;
            	Long numTicket = null;
        		Integer numLeg = null; 
        		String estado = null;
            	boolean res=true;
            	
            	DefaultTableModel ModelTablaInterv = (DefaultTableModel) jTable1.getModel();
            	ModelTablaInterv.setRowCount(0);
        	
            	
            	if(!(comboBox.getSelectedItem().toString().equals("Todos"))) {
        			estado = comboBox.getSelectedItem().toString();
        		}
        		
        		
        		if(!fhasta.getText().isEmpty()) {
        			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        			hasta = LocalDate.parse(new String (fhasta.toString()), formatter);
               		if(hasta.isAfter(LocalDate.now())){
            			
            			ven.setVisible(true); //muestra ventana error
            			}
        		}
        		
        		      		
        		
        		if(!fdesde.getText().isEmpty()) {
        			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        			desde = LocalDate.parse(new String (fdesde.toString()), formatter);
             		if(desde.isAfter(LocalDate.now())){
            			
            			ven.setVisible(true); //muestra ventana error
            			}
            	}
        		
        		
        	/*	if((!fdesde.getText().isEmpty() && desde.compareTo(fechaA)>= 0) || (!fhasta.getText().isEmpty() && (hasta.compareTo(fechaA) >= 0 || (!fhasta.getText().isEmpty() && !fdesde.getText().isEmpty() && desde.compareTo(hasta)> 0)))){
        			ven.setVisible(true);
        		}*/
        		
        			if(!numTic.getText().isEmpty()) numTicket = Long.valueOf(numTic.getText());
            		if(!numlegajo.getText().isEmpty()) numLeg = Integer.valueOf(numlegajo.getText());
   		
        	
        		listaIencontrados = gestorI.consultarIntervAsigna(numTicket , numLeg, estado, desde, hasta );
  
        		
        		if(listaIencontrados.size() > 0) {
            		
            		ObtenerListaInterv(listaIencontrados);
    			}
    			
    			else {
    				EjemploError e = new EjemploError("No existen tickets que cumplan con los criterios ingresados.");
            		e.setVisible(true);  }
           
            }
        });
        
       
        
        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Modificar comentario  ");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 590, -1, 30));

        boton_modEstad.setBackground(new java.awt.Color(0, 51, 102));
        boton_modEstad.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        boton_modEstad.setForeground(new java.awt.Color(255, 255, 255));
        boton_modEstad.setText("Modificar estado");
        getContentPane().add(boton_modEstad, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 590, 150, 30));
        boton_modEstad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	Integer numISeleccionado = Integer.valueOf(((Vector) TablaInterv.getDataVector().elementAt(jTable1.getSelectedRow())).elementAt(0).toString());
            	System.out.println("tamaño3");
        		System.out.println(listaIencontrados.size());
        		
        		InterSelec = gestorI.consultarI(numISeleccionado, listaIencontrados);
        		
        		
        		System.out.println("nui me toma el num del ticjeeeeeeeeeet");
        		System.out.println(numISeleccionado);
        		System.out.println(InterSelec.getEstadoI());
        		System.out.println(InterSelec.getIdTicket());
        		
        	
        		System.out.println(idgrupo);
        		GrupoResolucion gr = gestorR.getGrupo(idgrupo);
        		
        		if(InterSelec.getGrup().getNom_grupo() == gr.getNom_grupo()) {
        			   boton_modEstadActionPerformed(evt);
        		 
        			 
        		}else {
    				EjemploError e = new EjemploError("Derive su intervencion");
            		e.setVisible(true);  }
            	
            
    
            }
        });
        
       

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        jLabelFondo.setPreferredSize(new java.awt.Dimension(1100, 650));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        pack();
    }

    protected void ObtenerListaInterv(ArrayList<IntervencionDTO> listaIencontrados) {
			
    	for(IntervencionDTO i : listaIencontrados) {
    		System.out.println("obteer");
    		/*System.out.println(i.getIdTicket().toString());
    		System.out.println(i.getLegajo().toString());
    		System.out.println(i.getClas().getNombre());
    		System.out.println(i.getEstadoT().toString());
    		System.out.println(i.getFechap().toString());
    		System.out.println(i.getEstadoI().toString());
    		System.out.println(i.getFechaAs().toString());
    		System.out.println(i.getGrup().getNom_grupo());
    		System.out.println(i.getObserv());*/
    		TablaInterv.addRow(new String[] {i.getIdTicket().toString(), i.getLegajo().toString(), i.getClas().getNombre(),
    				i.getEstadoT().toString(), i.getFechap().toString(), i.getEstadoI().toString() ,i.getFechaAs().toString(),
    				i.getGrup().getNom_grupo().toString(), i.getObserv() });
    	}
			
		}




	private void numTicActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void numlegajoActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void fhastaActionPerformed(java.awt.event.ActionEvent evt) {
     
    }

    private void fdesdeActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void accionVolver(java.awt.event.ActionEvent evt) {
        anterior.setVisible(true);
        this.dispose();
    }

 // TODO PONER BOTON
    private void boton_modEstadActionPerformed(java.awt.event.ActionEvent evt) {  
    	System.out.println("id grupo a act");
    	System.out.println(idgru);
    	ActualizarEstadoIntervencionCU08 a = new ActualizarEstadoIntervencionCU08(InterSelec, U, idgru);
    	a.setVisible(true);
    	this.dispose();
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
            java.util.logging.Logger.getLogger(ConsultarIntervencionAsignadasCU07.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarIntervencionAsignadasCU07.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarIntervencionAsignadasCU07.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarIntervencionAsignadasCU07.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
     
    }

  
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton boton_modEstad;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField numTic;
    private javax.swing.JTextField numlegajo;
    private javax.swing.JTextField fhasta;
    private javax.swing.JTextField fdesde;
   
}