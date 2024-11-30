/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.menu;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;

public class MenuInicial extends javax.swing.JFrame {

    public MenuInicial() {
        initComponents();
        try {
            URL imageUrl = new URL("https://raw.githubusercontent.com/iJosueeh/imagenes-poo-proyecto/refs/heads/main/Administrator.png");
            ImageIcon iconAdmin = new ImageIcon(imageUrl);
            btnIniciarSesion.setIcon(iconAdmin);

            URL ImagenUrl2 = new URL("https://raw.githubusercontent.com/iJosueeh/imagenes-poo-proyecto/refs/heads/main/WhatsApp%20Image%202024-11-29%20at%2011.28.26%20PM.jpeg");
            ImageIcon bgInicialImg = new ImageIcon(ImagenUrl2);
            bgInicial.setIcon(bgInicialImg);
            
            URL ImagenUrl3 = new URL("https://raw.githubusercontent.com/iJosueeh/imagenes-poo-proyecto/refs/heads/main/User.png");
            ImageIcon iconUser = new ImageIcon(ImagenUrl3);
            btnIniciarCliente.setIcon(iconUser);
            
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnIniciarCliente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bgInicial = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(118, 98, 78));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 229, 183));
        jLabel2.setText("Radiant Legacy");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(229, 229, 183));
        jLabel1.setFont(new java.awt.Font("Readex Pro Medium", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 229, 183));
        jLabel1.setText("Inicia sesión para descubrir piezas únicas y exclusivas, o regístrate si");

        jLabel3.setFont(new java.awt.Font("Readex Pro Medium", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(229, 229, 183));
        jLabel3.setText("eres un nuevo cliente y únete a nuestra familia de amantes de la joyería.");

        btnIniciarSesion.setBackground(new java.awt.Color(204, 204, 204));
        btnIniciarSesion.setFont(new java.awt.Font("Readex Pro Medium", 0, 14)); // NOI18N
        btnIniciarSesion.setIcon(new javax.swing.ImageIcon("https://raw.githubusercontent.com/iJosueeh/imagenes-poo-proyecto/refs/heads/main/Login.png"));
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.setBorder(null);
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseClicked(evt);
            }
        });
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Readex Pro Light", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(229, 229, 183));
        jLabel4.setText("Solo pueden ingresar administradores o personas con acceso. *");

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        btnIniciarCliente.setBackground(new java.awt.Color(204, 204, 204));
        btnIniciarCliente.setFont(new java.awt.Font("Readex Pro Medium", 0, 14)); // NOI18N
        btnIniciarCliente.setText("Soy un Cliente");
        btnIniciarCliente.setBorder(null);
        btnIniciarCliente.setBorderPainted(false);
        btnIniciarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarClienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Readex Pro Light", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(229, 229, 183));
        jLabel5.setText("Recuerda que deberás registrarte una vez ingresado a la aplicación. *");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnIniciarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(84, 84, 84))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIniciarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 470));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        Login loginAdmin = new Login();
        loginAdmin.setVisible(true);
        loginAdmin.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnIniciarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarClienteActionPerformed
        MenuUsuario menuUsuario = new MenuUsuario();
        menuUsuario.setVisible(true);
        menuUsuario.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnIniciarClienteActionPerformed

    private void btnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseClicked

    }//GEN-LAST:event_btnIniciarSesionMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgInicial;
    private javax.swing.JButton btnIniciarCliente;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
