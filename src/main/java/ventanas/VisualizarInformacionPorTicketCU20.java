
package ventanas;


public class VisualizarInformacionPorTicketCU20 extends javax.swing.JFrame {

 
    public VisualizarInformacionPorTicketCU20() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 204, 102));
        jLabel1.setFont(new java.awt.Font("Californian FB", 3, 24)); 
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("VISUALIZAR INFORMACI\u00d3N POR TICKET");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 460, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png"))); 
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descripci\u00f3n del cargo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tel\u00e9fono directo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ubicaci\u00f3n:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Legajo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, 40));

        jTextField3.setEditable(false);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 220, 30));

        jTextField1.setEditable(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 820, 70));

        jTextField5.setEditable(false);
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 240, 30));

        jTextField6.setEditable(false);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 470, 30));

        jTextField7.setEditable(false);
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 490, 30));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("<< Primera ");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 860, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tel\u00e9fono interno:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Apellido:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, 40));

        jTextField8.setEditable(false);
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 240, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nro de ticket:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jTextField9.setEditable(false);
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 140, 30));

        jTextField10.setEditable(false);
        getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 210, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tiempo de atenci\u00f3n:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Clasificaci\u00f3n: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Estado:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Usuario:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jTextField11.setEditable(false);
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 140, 30));

        jTextField12.setEditable(false);
        getContentPane().add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, 140, 30));

        jTextField13.setEditable(false);
        getContentPane().add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 270, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Historial Grupo de resoluci\u00f3n:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Grupo de resoluci\u00f3n", "Facha de asignaci\u00f3n al grupo", "Tiempo real de atenci\u00f3n", "Tiempo total asignado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 820, 60));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Reclasificaci\u00f3n:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 690, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fecha", "Clasificaci\u00f3n previa", "Clasificaci\u00f3n nueva"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 740, 820, 70));

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Última >>");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 860, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Siguiente >");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 860, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cerrar");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 920, -1, -1));

        jButton5.setBackground(new java.awt.Color(0, 51, 102));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("< Anterior");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 860, -1, -1));

        jButton6.setBackground(new java.awt.Color(0, 51, 102));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Imprimir");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 920, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("P\u00e1gina X de Y");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 830, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("... 8 9 10 11 12 ...");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 860, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 980));

        pack();
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
            java.util.logging.Logger.getLogger(VisualizarInformacionPorTicketCU20.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarInformacionPorTicketCU20.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarInformacionPorTicketCU20.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarInformacionPorTicketCU20.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarInformacionPorTicketCU20().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
