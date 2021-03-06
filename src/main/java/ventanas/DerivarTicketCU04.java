 package ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import Controlador.GestorClasificacion;
import Controlador.GestorGrupoResolucion;
import Controlador.GestorTicket;
import Controlador.GestorUsuario;
import Modelo.Clasificacion;
import Modelo.ClasificacionDTO;
import Modelo.GrupoResolucion;
import Modelo.GrupoResolucionDTO;
import Modelo.TicketDTO;
import Modelo.Usuario;

 
public class DerivarTicketCU04 extends javax.swing.JFrame {
	private GrupoResolucion [] grupos;
	private GestorUsuario gu = new GestorUsuario();
	private JFrame anterior;
	private Usuario u ;
	
	TicketDTO ticketSelec; 

    public DerivarTicketCU04(TicketDTO ticketselec, String u2) {
  
    	u=gu.getUsuario(u2);
        initComponents(ticketselec, u);
        this.setLocationRelativeTo(null);
    }
	GestorClasificacion gestorC = new GestorClasificacion();
	GestorGrupoResolucion gestorG = new GestorGrupoResolucion();
	GestorTicket  gestorT= new GestorTicket();
    
	private void initComponents(TicketDTO ticketselec, Usuario u) {
	System.out.println("entro a derivar con este usuario :" );
		
	
		grupos = cargarg(ticketselec.getCla());
	
		Clasificacion cla= ticketselec.getCla();

        jLabel1 = new javax.swing.JLabel();
        jButton_Cancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFielNoEditable = new javax.swing.JTextField();
        jButton_Confirmar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Californian FB", 3, 24)); 
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("DERIVAR TICKET");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 210, -1));

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
        getContentPane().add(jButton_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 565, 100, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("N\u00famero de ticket:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripci\u00f3n : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText(ticketselec.getDescripcion());
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 880, 110));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nuevo estado: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png"))); 
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 440, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estado: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText(ticketselec.getEstado().toString());   
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, -1, 30));

        jTextFielNoEditable.setEditable(false);
        jTextFielNoEditable.setText(ticketselec.getNumeroTicket().toString());
        jTextFielNoEditable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFielNoEditableActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFielNoEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 290, 30));

        jButton_Confirmar.setBackground(new java.awt.Color(0, 51, 102));
        jButton_Confirmar.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        jButton_Confirmar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Confirmar.setText("Confirmar");
        getContentPane().add(jButton_Confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 565, 100, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Clasificaci\u00f3n:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));       
      
        JComboBox<GrupoResolucion> ultgrupos= new JComboBox<GrupoResolucion>();  
        ultgrupos.setModel(new DefaultComboBoxModel<GrupoResolucion>(grupos));
        getContentPane().add(ultgrupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 270, 30));
        
        
        
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Grupo de resoluci\u00f3n:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Observaciones:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        JComboBox<Clasificacion> combocalif= new JComboBox<Clasificacion>(cambiarCla(ticketselec.getCla()));  // ACA
        getContentPane().add(combocalif, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 340, 30));

    	 

        combocalif.addActionListener( new ActionListener ()  {
        
        	@Override
        		public void actionPerformed(ActionEvent a) {
        		 
        		ultgrupos.removeAllItems();
        	Clasificacion c = (Clasificacion) combocalif.getSelectedItem();
        	grupos = cargarg(c);
        	ultgrupos.setModel( new DefaultComboBoxModel<GrupoResolucion>(cargarg((Clasificacion)combocalif.getSelectedItem())));
        	combocalif.setModel(new DefaultComboBoxModel<Clasificacion>(cambiarCla((Clasificacion)combocalif.getSelectedItem())));
        	

        	}
       });

         
        jButton_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
           	 String descripcion = jTextArea2.getText();
        	 if( descripcion.equalsIgnoreCase("Ingrese descripcion (max de caracteres 150)")) {
     	 		EjemploError error = new EjemploError("Ingrese una observaci\u00f3n");
    			  	error.setVisible(true); 	}
        	 else {
    			  		
  
                	if(jLabel10.getText().isEmpty()) {
                		String e= "Error Observaciones vacio";
            			EjemploError i = new EjemploError(e);
                		i.setVisible(true);
                		}
                	else if(ultgrupos.getSelectedIndex() == 0){
                		String e= "Seleccione Grupo de Resolucion";
            			EjemploError i = new EjemploError(e);
                		i.setVisible(true);
                	}
                	else {
                		
                		GrupoResolucion gr = (GrupoResolucion) ultgrupos.getSelectedItem();
      //          		System.out.println("Se apreto bton derivar gila y este es el grupo q se seleccionó");
                		System.out.println(gr.getNom_grupo());
                		Clasificacion cs = (Clasificacion) combocalif.getSelectedItem();
        //        		System.out.println("esta es la clasificacion:");
                		System.out.println(cs.getNom_clasificacion());
                		
                		Boolean a = false;
                		if(((Clasificacion) combocalif.getSelectedItem()).getCodigo() == cla.getCodigo()) {
                			
                			gestorT.derivarTicket(ticketselec.getNumeroTicket(),jTextArea2.getText() , gr.getNom_grupo(), u, cs.getCodigo(), a);
                			exito ();
                		} else{
                		 a = true;
                		
                		gestorT.derivarTicket(ticketselec.getNumeroTicket(),jTextArea2.getText() , gr.getNom_grupo(), u, cs.getCodigo(), a);
      //          		System.out.println("salio derivar");
                		exito ();

                		}
                	}

                
            }}
        });

        jTextArea2.setEditable(true);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setLineWrap(true);
        jTextArea2.setTabSize(5);
       
        jTextArea2.setText("Ingrese observacion (max de caracteres 150)");
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);
        jTextArea2.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {
        		
        		super.keyTyped(e);
        		if(jTextArea2 != null && jTextArea2.getText() != null && jTextArea2.getText().length() >= 300){
        			
        			e.setKeyChar((char) KeyEvent.VK_CLEAR);
        		}
        	}
        });
        jTextArea2.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB) {
                    jButton_Cancelar.requestFocus();
                }
            }
        });
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 620, 120));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("'Abierto derivado'");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("(*) Campo Obligatorio");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setText("*");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        jLabel14.setForeground(new java.awt.Color(0, 51, 102));
        jLabel14.setText("*");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        jLabelFondo.setPreferredSize(new java.awt.Dimension(1100, 650));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        pack();
    }
    
	
	
	// TODO aca de clasificacionDTO a clasificacion
    private Clasificacion[] cambiarCla(Clasificacion clasificacion) {
    	Clasificacion[] clas = new Clasificacion[gestorC.getClasificaciones2().size()];
    	    	
    	Clasificacion n;
   
    	
    	Integer i = 0;
    	for(int j=0 ; j <gestorC.getClasificaciones().size() ; j++) {
    		
    		clas[j] = gestorC.getClasificaciones2().get(j);
 
    		if(clas[j].getNom_clasificacion().equalsIgnoreCase(clasificacion.getNom_clasificacion())) {
    			i= j;
    		}
    	}
    	n=clas[0];
    	clas[i] = n;
    	clas[0]= clasificacion;
    	
    	
    	
    	
    	
		return clas;
	}
    
    
    private GrupoResolucion[] cargarg(Clasificacion cl) {
    	int n =0;
    	
    	GrupoResolucion[] g = new GrupoResolucion[n] ;
    	System.out.println("nombre cla");
    	System.out.println(cl.getNom_clasificacion());
    	String c = cl.getNom_clasificacion();
    	
    	
    	if(cl.getNom_clasificacion().equalsIgnoreCase("Mal funcionamiento de Hardware")) {
    		System.out.println("Mal funcionamiento de Hardware");
    			
    		
			n=7;
			g = new GrupoResolucion[n+1];
			g[1] = gestorG.getGrupo("Mesa de Ayuda");
			System.out.println(g[1].getNom_grupo());
			g[2] = gestorG.getGrupo("Soporte");	
			System.out.println(g[2].getNom_grupo());
			g[3] = gestorG.getGrupo("Servicio tecnico");
			System.out.println(g[3].getNom_grupo());
			g[4] = gestorG.getGrupo("Administrador SUSE Linux");
			System.out.println(g[4].getNom_grupo());
			g[5] = gestorG.getGrupo("Administrador DEBIAN");
			System.out.println(g[5].getNom_grupo());
			g[6] = gestorG.getGrupo("Redes Lan");	
			System.out.println(g[6].getNom_grupo());
			g[7] = gestorG.getGrupo("Comunicaciones");	
			System.out.println(g[7].getNom_grupo());
			
			
		
		} else {
				if(cl.getNom_clasificacion().equalsIgnoreCase("Cambios de Configuración de Sistema Operativo de PC") || cl.getNom_clasificacion().equalsIgnoreCase("Problemas en el funcionamiento del Sistema Operativo de PC y utilitarios")){
					n=4;
					g = new GrupoResolucion[n+1];
					g[1] = gestorG.getGrupo("Mesa de Ayuda");
					g[2] = gestorG.getGrupo("Soporte");
					g[3] = gestorG.getGrupo("Administrador SUSE Linux");
					g[4] = gestorG.getGrupo("Administrador DEBIAN");}
    					
    	
				else {
						if(cl.getNom_clasificacion().equalsIgnoreCase("Solicitud de instalación de aplicaciones")){
							n=7;
							g = new GrupoResolucion[n+1];
							g[1] = gestorG.getGrupo("Mesa de ayuda");
							g[2] = gestorG.getGrupo("Soporte");
							g[3] = gestorG.getGrupo("Administrador SUSE Linux");
							g[4] = gestorG.getGrupo("Administrador de base de datos");
							g[5] = gestorG.getGrupo("Desarrollo sistema comercial");
							g[6] = gestorG.getGrupo("Desarrollo sistema RRHH");
							g[7] = gestorG.getGrupo("Desarrollo sistema de reclamos");
    			
							}
						else {
							if(cl.getNom_clasificacion().equalsIgnoreCase("Solicitud de Cambio de Contraseñas") || cl.getNom_clasificacion().equalsIgnoreCase("Modificacion en los perfiles de usuarios")) {
								n=7;
								g = new GrupoResolucion[n+1];
								g[1] = gestorG.getGrupo("Mesa de Ayuda");
								g[2] = gestorG.getGrupo("Soporte");
								g[3] = gestorG.getGrupo("Administrador SUSE Linux");
								g[4] = gestorG.getGrupo("Administrador proxy y correo electronico");
								g[5] = gestorG.getGrupo("Desarrollo sistema comercial");
								g[6] = gestorG.getGrupo("Desarrollo Sistema RRHH");
								g[7] = gestorG.getGrupo("Desarrollo sistema de reclamos");
							}
							else {
								
									if(cl.getNom_clasificacion().equalsIgnoreCase("Problemas en la autenticación en los distintos sistemas")) {
										n=6;
										g = new GrupoResolucion[n+1];
										g[1] = gestorG.getGrupo("Mesa de Ayuda");
										g[2] = gestorG.getGrupo("Soporte");
										g[3] = gestorG.getGrupo("Servicio tecnico");	
										g[4] = gestorG.getGrupo("Desarrollo sistema comercial");
										g[5] = gestorG.getGrupo("Desarrollo sistema RRHH");
										g[6] = gestorG.getGrupo("Desarrollo sistema de reclamos");
									}
									else{
										if(cl.getNom_clasificacion().equalsIgnoreCase( "Problemas de acceso a la red local o remota")){
											n=6;
											g = new GrupoResolucion[n+1];
											g[1] = gestorG.getGrupo("Mesa de Ayuda");
											g[2] = gestorG.getGrupo("Soporte");
											g[3] = gestorG.getGrupo("Servicio tecnico");
											g[4] = gestorG.getGrupo("Administrador proxy y correo electronico");
											g[5] = gestorG.getGrupo("Redes Lan");	
											g[6] = gestorG.getGrupo("Comunicaciones");	
										}
										else {
											if(cl.getNom_clasificacion().equalsIgnoreCase( "Solicitud de usuarios de red")) {
												n=4;	
												g = new GrupoResolucion[n+1];	
												g[1] = gestorG.getGrupo("Mesa de Ayuda");
												g[2] = gestorG.getGrupo("Soporte");
                    							g[3] = gestorG.getGrupo("Administrador SUSE Linux");
                    							g[4] = gestorG.getGrupo("Administrador proxy y correo electronico");
											}
    		
											else {
												if(cl.getNom_clasificacion().equalsIgnoreCase( "Problemas con el correo electrónico")) {
													n=3;
													g = new GrupoResolucion[n+1];
													g[1] = gestorG.getGrupo("Mesa de Ayuda");
													g[2] = gestorG.getGrupo("Soporte");
													g[3] = gestorG.getGrupo("Administrador proxy y correo electronico");
												}	
												else {
													if(cl.getNom_clasificacion().equalsIgnoreCase( "Solicitud de cuentas de correo electrónico")) {
														n=2;
														g = new GrupoResolucion[n+1];
														g[1] = gestorG.getGrupo("Mesa de Ayuda");
														g[2] = gestorG.getGrupo("Administrador proxy y correo electronico");
													}
													else {
														if(cl.getNom_clasificacion().equalsIgnoreCase("Solicitud de nuevos puestos de trabajo")) {
															n=2;
															g = new GrupoResolucion[n+1];
															g[1] = gestorG.getGrupo("Mesa de Ayuda");
															g[2] = gestorG.getGrupo("Soporte");
														}
														else {
															if(cl.getNom_clasificacion().equalsIgnoreCase( "Solicitud soporte en el uso de alguna aplicación o sistema")) {
																n=2;
																g = new GrupoResolucion[n+1];
																g[1] = gestorG.getGrupo("Mesa de Ayuda");
																g[2] = gestorG.getGrupo("Soporte");
																g[3] = gestorG.getGrupo("Administrador de base de datos");
																g[4] = gestorG.getGrupo("Administrador SUSE Linux");
																g[5] = gestorG.getGrupo("Administrador proxy y correo electronico");
																g[5] = gestorG.getGrupo("Desarrollo sistema comercial");
																g[6] = gestorG.getGrupo("Desarrollo sistema RRHH");
																g[7] = gestorG.getGrupo("Desarrollo sistema de reclamos");
                                			
                                			
    									}
	    									else  {
	    										g = new GrupoResolucion[gestorG.getGrupoR().size()+1];
	    										for(int i=0; i < gestorG.getGrupoR().size(); i++) {
	    											g[i+1]= gestorG.getGrupoR().get(i);
	    										
	    										}
	    									}
    									}
    								}		
    							}		
                              }
    						}
    					}
    				}
    			}
    			}
    		}
    		System.out.println("entro al fin dle if");
    				
    		g[0] = new GrupoResolucion("Seleccione una opcion...",0);
    		return g;
    
}


    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {
    	EjemploExito e = new EjemploExito("Derivaci\u00f3n cancelada ",u.getUsuario(),this);
    	e.setVisible(true);
    }

    private void exito() {
    	EjemploExito e = new EjemploExito("Ticket Derivado ",u.getUsuario(),this);
    	e.setVisible(true);
    	
    }
    private void jTextFielNoEditableActionPerformed(java.awt.event.ActionEvent evt) {
      
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
            java.util.logging.Logger.getLogger(DerivarTicketCU04.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DerivarTicketCU04.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DerivarTicketCU04.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DerivarTicketCU04.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_Confirmar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextFielNoEditable;

}
