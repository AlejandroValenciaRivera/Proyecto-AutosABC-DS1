/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ;

import ACCESO_DATOS.controladores.*;
import ACCESO_DATOS.entidades_y_relaciones.*;
import Login.*;
import java.awt.CardLayout;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author aleja_000
 */
public class GUIlogin extends javax.swing.JFrame {
    
    GUIgerente gerente;
    GUIvendedor vendedor;
    /**
     * Creates new form Login
     */
    public GUIlogin() {
        initComponents();
        
        getContentPane().add(panelLogin);
        
        panelLogin.setBounds(0,0,521,191);
        setBounds(0,0,535,191);
        setResizable(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        botonLogeo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuariologin = new javax.swing.JTextField();
        contraseñalogin = new javax.swing.JPasswordField();
        pin_login_text = new javax.swing.JLabel();
        pin_login = new javax.swing.JPasswordField();

        panelLogin.setToolTipText("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/INTERFAZ/logotipo.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/AYUDA-LOGIN.png"))); // NOI18N
        jButton2.setToolTipText("Presione para obtener ayuda ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        botonLogeo.setText("Ingresar");
        botonLogeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLogeoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña:");

        usuariologin.setToolTipText("Nombre de la cuenta del usuario");

        contraseñalogin.setToolTipText("Contraseña de la cuenta del usuario");

        pin_login_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pin_login_text.setText("PIN: ");

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuariologin)
                                    .addComponent(contraseñalogin, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(pin_login_text)
                                .addGap(63, 63, 63)
                                .addComponent(pin_login)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonLogeo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuariologin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(contraseñalogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pin_login_text)
                            .addComponent(pin_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonLogeo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AUTOS ABC");
        setAlwaysOnTop(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void reset(){
        usuariologin.setText("");
        contraseñalogin.setText("");
        pin_login.setText("");
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Aqui va un texto de ayuda");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonLogeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLogeoActionPerformed

        String usuario = "";
        String contraseña = "";
        int cargo = 0;
        ControladorUsuario cUsuario = new ControladorUsuario();
        
        ArrayList<Usuario> users = cUsuario.consultarLogin();
        if (usuariologin.getText().equals(usuario) | Arrays.equals(contraseñalogin.getPassword(), explode(contraseña))){
            JOptionPane.showMessageDialog(rootPane, "Debe introducir datos en ambos campos");
        }
        else {
            
            int peso1 = 0;
            int peso2 = 0;
            int peso3 = 0;
            int peso4 = 0;
            int peso5 = 0;
            int peso6 = 0;
                
            char[] pin = pin_login.getPassword();
            char [] valor = new char[2];
                
            valor[0] = pin[0];
            valor[1] = pin[1];
            peso1 = Integer.parseInt(String.valueOf(valor));
                
            valor[0] = pin[2];
            valor[1] = pin[3];
            peso2 = Integer.parseInt(String.valueOf(valor));
                
            valor[0] = pin[4];
            valor[1] = pin[5];
            peso3 = Integer.parseInt(String.valueOf(valor));
            
            valor[0] = pin[6];
            valor[1] = pin[7];
            peso4 = Integer.parseInt(String.valueOf(valor));
                
            valor[0] = pin[8];
            valor[1] = pin[9];
            peso5 = Integer.parseInt(String.valueOf(valor));
                
            valor[0] = pin[10];
            valor[1] = pin[11];
            peso6 = Integer.parseInt(String.valueOf(valor));
            Encriptacion encripto = new Encriptacion();
                
            for (int i = 0; i < users.size(); i++) {
                
                usuario = encripto.desencriptar(peso4, peso5, peso6, users.get(i).getCuenta());
                contraseña = encripto.desencriptar(peso1, peso2, peso3, users.get(i).getContrasena());
                cargo = users.get(i).getCargo();
                if (usuariologin.getText().equals(usuario)) {

                    if (Arrays.equals(contraseñalogin.getPassword(), explode(contraseña))) {

                        switch (cargo) {
                            case 1:
                                gerente = new GUIgerente(this);
                                break;
                            case 3:
                                vendedor = new GUIvendedor(this);
                                break;
                            default:
                                JOptionPane.showMessageDialog(rootPane, "La aplicación sólo soporta ingreso de gerente y vendedor por el momento");
                                break;
                        }

                        break;

                    }

                    else {
                        if((i + 1) == users.size()){
                            JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrectos");
                        }
                    }

                }
                
                else {
                    if((i + 1) == users.size()){
                        JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrectos");
                    }
                }
            }
        }

    }//GEN-LAST:event_botonLogeoActionPerformed
    
    private char[] explode(String cadena){
        char[] resultado = new char[cadena.length()];
        for (int i=0; i<cadena.length(); i++){
            resultado[i] = cadena.charAt(i);
        }
        return resultado;
    }
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
            java.util.logging.Logger.getLogger(GUIlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new GUIlogin().setVisible(true);
                
                
                Encriptacion encripto = new Encriptacion();
                System.out.println(encripto.encriptar("Pedper") + "::--->");
                System.out.println(encripto.desencriptar(25, 55, 79, "6d]<btWRJ/^$<UJkN("));
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLogeo;
    private javax.swing.JPasswordField contraseñalogin;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField pin_login;
    private javax.swing.JLabel pin_login_text;
    private javax.swing.JTextField usuariologin;
    // End of variables declaration//GEN-END:variables
}
