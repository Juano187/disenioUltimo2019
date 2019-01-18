
package ventanas;


public class ConfirmarDatos extends javax.swing.JFrame {

  
    public ConfirmarDatos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();
        jLabelFondo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nro de Clasificaci\u00f3n:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 32, -1, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripci\u00f3n:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Grupo de resoluci\u00f3n:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, 30));

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Aceptar");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 90, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("�Desea confirmar los datos?");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-ok-150.png"))); 
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        jLabelFondo.setPreferredSize(new java.awt.Dimension(618, 289));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabelFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg")));
        jLabelFondo1.setPreferredSize(new java.awt.Dimension(618, 289));
        getContentPane().add(jLabelFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ConfirmarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmarDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelFondo1;
    // End of variables declaration//GEN-END:variables
}
