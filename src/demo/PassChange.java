/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author FireBlazeTSETSR
 */
public class PassChange extends javax.swing.JFrame {

    /**
     * Creates new form PassChange
     */
    public PassChange() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Old Password:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel2.setText("New Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setText("Retype password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 180, -1));
        getContentPane().add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, -1));
        getContentPane().add(jPasswordField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 180, -1));

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        setSize(new java.awt.Dimension(416, 253));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jPasswordField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Old password is a required field!");
            return;
        }
        
        if(jPasswordField2.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "New password cannot be empty!");
            return;
        }
        
        if(jPasswordField3.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Please retype your password!");
            return;
        }
        
        if(!StaticVars.getMd5(jPasswordField1.getText()).equals(getPassword())){
            /*System.out.println(StaticVars.getMd5(jPasswordField1.getText()));
            System.out.println(getPassword()+" getpasswd");*/
            
            JOptionPane.showMessageDialog(rootPane, "Old password doesn't match!");
            return;
        }
        
        if(!jPasswordField2.getText().equals(jPasswordField3.getText())){
            JOptionPane.showMessageDialog(rootPane, "New passowords do not match!");
            return;
        }
        
        if(jPasswordField2.getText().equals(jPasswordField1.getText())){
              JOptionPane.showMessageDialog(rootPane, "New password cannot be the same as the old one!");
            return;
        }
        
        
        try {
            Connection con= OracleConnection.getConnection();
            Statement st = con.createStatement();
            con.setAutoCommit(false);
            
            st.execute("update USERS\n" +
                "set PASSWD = '"+StaticVars.getMd5(jPasswordField2.getText())+"'" +
                "where IDUSER ="+StaticVars.g_strUserID);
            con.commit();
            JOptionPane.showMessageDialog(rootPane, "Password sucsessfully changed!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        new MainOverview().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new MainOverview().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PassChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassChange().setVisible(true);
            }
        });
    }
    
    public String getPassword(){
        String passwd="";
        try {
            Connection con= OracleConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = null;
            con.setAutoCommit(false);
            System.out.println(StaticVars.g_strUserID);
            rs = st.executeQuery("select PASSWD from users\n" +
                "where iduser="+StaticVars.g_strUserID);
            
            con.commit();
            
            while(rs.next()){
                passwd = rs.getString(1);
            }
            
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return passwd;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables
}
