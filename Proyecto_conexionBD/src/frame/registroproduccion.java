/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yeisson Camelo
 */
public class registroproduccion extends javax.swing.JFrame {
    
    Conexion nueva = new Conexion();
    Connection con = nueva.procesoConexion();

    /**
     * Creates new form registroproduccion
     */
    public registroproduccion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
        public final void registarEntregas(){
            
            java.util.Date utilFecha = jDateChooser1.getDate();
            java.sql.Date fecha_sql = new java.sql.Date(utilFecha.getTime());
    
            
        try {
            int idCliente = Integer.parseInt(jTextField1.getText());
            Date fecha = fecha_sql;
            String litros = jTextField8.getText();

            // Crear la consulta SQL para la inserción de datos
            String sql = "INSERT INTO entregas (ID_Cliente, Fecha_Entrega, Litros_Entregados) VALUES (?, ?, ?)";

            // Preparar la declaración SQL
            PreparedStatement statement = con.prepareStatement(sql);

            // Establecer los valores de los parámetros en la consulta preparada
            statement.setInt(1, idCliente);
            statement.setDate(2, fecha);
            statement.setString(3, litros);

            // Ejecutar la consulta de inserción
            int filasInsertadas = statement.executeUpdate();

            // Verificar si los datos se han insertado correctamente
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Los datos se han insertado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo insertar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al intentar registrar los datos en la tabla Clientes.", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (NumberFormatException e) {
            // Manejar error de conversión de número (por ejemplo, si un campo de número está vacío o tiene un formato incorrecto)
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de formato en los datos. Verifique los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        Retroceder = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 170));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro entregas");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 5, 400, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 60));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel2.setText("Id cliente: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 40));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 310, 40));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel4.setText("Fecha entrega:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 40));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel11.setText("Litros entregados:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 40));

        jTextField8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 280, 40));

        Retroceder.setBackground(new java.awt.Color(153, 153, 153));
        Retroceder.setText("Atras");
        Retroceder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RetrocederMouseClicked(evt);
            }
        });
        Retroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetrocederActionPerformed(evt);
            }
        });
        jPanel1.add(Retroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 150, 40));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 170, 40));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setText("Guardar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 150, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RetrocederMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RetrocederMouseClicked
        registarEntregas();
    }//GEN-LAST:event_RetrocederMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void RetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetrocederActionPerformed
       // Crear una instancia del frame del menú
        menu menuFrame = new menu();
        // Hacer visible el frame del menú
        menuFrame.setVisible(true);
        // Cerrar el frame actual si es necesario
        this.dispose();    // TODO add your handling code here:        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_RetrocederActionPerformed

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
            java.util.logging.Logger.getLogger(registroproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroproduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroproduccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Retroceder;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
