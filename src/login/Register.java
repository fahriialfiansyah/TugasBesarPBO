package login;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }
    
    public boolean checkUsername(String username) {
        PreparedStatement ps;
        ResultSet rs;
        boolean username_exist = false;
        
        String sql = "select * from users where username = ?";
        
        try {
            
            ps = DBConnection.getCon().prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                username_exist = true;
                JOptionPane.showMessageDialog(null, "This username is already taken, choose another username");
            }
        } catch (HeadlessException | SQLException e) {
            
        }
        
        return username_exist;
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txFullName = new javax.swing.JTextField();
        txUserName = new javax.swing.JTextField();
        txEmail = new javax.swing.JTextField();
        txPassword = new javax.swing.JPasswordField();
        txConfPass = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jTextField4.setText("jTextField4");

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\LFD\\Downloads\\airplane2.jpg")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Full Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, 30));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, 30));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, 30));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Confirm Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, 30));

        txFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txFullNameActionPerformed(evt);
            }
        });
        getContentPane().add(txFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 195, 30));

        txUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txUserNameActionPerformed(evt);
            }
        });
        getContentPane().add(txUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 195, 30));

        txEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 195, 30));
        getContentPane().add(txPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 195, 30));
        getContentPane().add(txConfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 195, 30));

        btnRegister.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(51, 153, 0));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, 30));

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 73, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/login-register.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 470, 310));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(jLabel2);
        jLabel1.setText("REGISTER");
        jLabel1.setAutoscrolls(true);
        jLabel1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel1)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 60));

        setSize(new java.awt.Dimension(479, 405));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txFullNameActionPerformed

    private void txUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txUserNameActionPerformed

    private void txEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailActionPerformed
        // TODO add your handling code here:
//        if(! Character.isLowerCase(evt.get)) {
//            evt.consume();
//        }
    }//GEN-LAST:event_txEmailActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        String fullname = txFullName.getText().toString().trim();
        String username = txUserName.getText().toString().trim();
        String email = txEmail.getText().toString().trim();
        String password = txPassword.getText().toString().trim();
        String confpassword = txConfPass.getText().toString().trim();
        
        if (fullname.equals("") || username.equals("") || email.equals("") || password.equals("") || confpassword.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        }else if (!password.equals(confpassword)){
            JOptionPane.showMessageDialog(null, "Password not match");
        }else if(checkUsername(username)) {
            txUserName.setText("");
        }else if(!checkUsername(username)){
            try {
                Connection c = DBConnection.getCon();
                String sql = "insert into users(full_name, username, email, password)" 
                + " values (?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, fullname);
                p.setString(2, username);
                p.setString(3, email);
                p.setString(4, password);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
            } catch (SQLException e) {
                System.out.println("Error");
            } finally{
                this.dispose();
                Login a = new Login();
                a.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        Login a = new Login();
        a.setVisible(true);
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPasswordField txConfPass;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txFullName;
    private javax.swing.JPasswordField txPassword;
    private javax.swing.JTextField txUserName;
    // End of variables declaration//GEN-END:variables
}
