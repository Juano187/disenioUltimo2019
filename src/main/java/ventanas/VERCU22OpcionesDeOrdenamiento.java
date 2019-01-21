
package ventanas;


public class VERCU22OpcionesDeOrdenamiento extends javax.swing.JFrame {


    public VERCU22OpcionesDeOrdenamiento() {
        initComponents();
        this.setLocationRelativeTo(null);
    }



    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabelFondo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Californian FB", 1, 24)); 
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("OPCIONES DE ORDENAMIENTO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 370, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/untitled.png"))); 
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 20));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 560, 110, 30));

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Aceptar");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 561, 110, 30));

        jRadioButton8.setFont(new java.awt.Font("Tahoma", 1, 18));
        jRadioButton8.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton8.setText("Descendente");
        getContentPane().add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, -1, -1));

        jRadioButton9.setFont(new java.awt.Font("Tahoma", 1, 18));
        jRadioButton9.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setText("Ascendente");
        getContentPane().add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, -1, -1));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("N\u00famero de ticket");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 18));
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Tiempo acumulado total de atenci\u00f3n");
        getContentPane().add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Clasificaci\u00f3n actual de ticket");
        getContentPane().add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Fecha de apertura");
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 1, 18));
        jCheckBox5.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("\u00daltimo grupo de resoluci\u00f3n");
        getContentPane().add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        jLabelFondo1.setForeground(new java.awt.Color(255, 204, 102));
        jLabelFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/orig_83357.jpg"))); 
        jLabelFondo1.setPreferredSize(new java.awt.Dimension(1100, 650));
        getContentPane().add(jLabelFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

        pack();
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
            java.util.logging.Logger.getLogger(VERCU22OpcionesDeOrdenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VERCU22OpcionesDeOrdenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VERCU22OpcionesDeOrdenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VERCU22OpcionesDeOrdenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VERCU22OpcionesDeOrdenamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFondo1;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    // End of variables declaration//GEN-END:variables
}
