/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.menu;

import javax.swing.JOptionPane;
import vistas.secciones.Catalogos.Catalogo;
import vistas.secciones.Citas;
import vistas.secciones.Colecciones;
import vistas.secciones.Sedes;
import vistas.secciones.SobreNosotros;
import vistas.secciones.perfil.LoginCliente;

/**
 *
 * @author HOME
 */
public class MenuUsuario extends javax.swing.JFrame {

    /**
     * Creates new form MenuUsuario
     */
    public MenuUsuario() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnColecciones = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnSobreNosotros = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnPanel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(118, 98, 78));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 680));

        btnColecciones.setBackground(new java.awt.Color(204, 204, 204));
        btnColecciones.setFont(new java.awt.Font("Readex Pro Medium", 0, 12)); // NOI18N
        btnColecciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons/Collectibles.png"))); // NOI18N
        btnColecciones.setText("Colecciones");
        btnColecciones.setBorder(null);
        btnColecciones.setMaximumSize(new java.awt.Dimension(141, 18));
        btnColecciones.setMinimumSize(new java.awt.Dimension(141, 18));
        btnColecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColeccionesActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Readex Pro Medium", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons/Location.png"))); // NOI18N
        jButton3.setText("Sedes");
        jButton3.setBorder(null);
        jButton3.setMaximumSize(new java.awt.Dimension(141, 18));
        jButton3.setMinimumSize(new java.awt.Dimension(141, 18));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnSobreNosotros.setBackground(new java.awt.Color(204, 204, 204));
        btnSobreNosotros.setFont(new java.awt.Font("Readex Pro Medium", 0, 12)); // NOI18N
        btnSobreNosotros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons/Info Squared.png"))); // NOI18N
        btnSobreNosotros.setText("Sobre Nosotros");
        btnSobreNosotros.setBorder(null);
        btnSobreNosotros.setMaximumSize(new java.awt.Dimension(141, 18));
        btnSobreNosotros.setMinimumSize(new java.awt.Dimension(141, 18));
        btnSobreNosotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobreNosotrosActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Readex Pro Medium", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons/Quote.png"))); // NOI18N
        jButton5.setText("Citas");
        jButton5.setBorder(null);
        jButton5.setMaximumSize(new java.awt.Dimension(141, 18));
        jButton5.setMinimumSize(new java.awt.Dimension(141, 18));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnAbandonar.setBackground(new java.awt.Color(255, 149, 0));
        btnAbandonar.setFont(new java.awt.Font("Readex Pro Medium", 0, 12)); // NOI18N
        btnAbandonar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons/Go_Back.png"))); // NOI18N
        btnAbandonar.setText("Abandonar");
        btnAbandonar.setBorder(null);
        btnAbandonar.setMaximumSize(new java.awt.Dimension(141, 18));
        btnAbandonar.setMinimumSize(new java.awt.Dimension(141, 18));
        btnAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 149, 0));
        jButton7.setFont(new java.awt.Font("Readex Pro Medium", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons/User.png"))); // NOI18N
        jButton7.setText("Iniciar Sesion");
        jButton7.setBorder(null);
        jButton7.setMaximumSize(new java.awt.Dimension(141, 18));
        jButton7.setMinimumSize(new java.awt.Dimension(141, 18));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(btnColecciones, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(btnSobreNosotros, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(btnAbandonar, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(btnColecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSobreNosotros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAbandonar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnPanel.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator2.setBackground(new java.awt.Color(255, 138, 138));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Readex Pro Light", 0, 18)); // NOI18N
        jLabel2.setText("El brillo que hace latir tu corazón");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setText("Radiant Legacy");

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(265, 265, 265))
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnPanelLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel2))
                    .addGroup(btnPanelLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(322, Short.MAX_VALUE))
        );

        jPanel1.add(btnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 760, 680));

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

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        String mensaje = "¿Seguro que quieres salir?\nTendrás que iniciar sesión nuevamente para seguir comprando.";

        int seleccion = JOptionPane.showOptionDialog(
                this,
                mensaje,
                "Confirmar cierre del programa",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new Object[]{"Sí", "No"}, // Opciones mostradas al usuario
                "No" // Opción predeterminada seleccionada
        );

        if (seleccion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa, ¡vuelve pronto!");

            MenuInicial menuInicial = new MenuInicial();
            menuInicial.setVisible(true);
            menuInicial.setLocationRelativeTo(null);
            this.dispose();
        }

    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void btnSobreNosotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobreNosotrosActionPerformed
        SobreNosotros sobreNosotros = new SobreNosotros();
        sobreNosotros.setVisible(true);
        sobreNosotros.setLocationRelativeTo(null);
        
        this.dispose();
    }//GEN-LAST:event_btnSobreNosotrosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Sedes sedeLocales = new Sedes();
        sedeLocales.setVisible(true);
        sedeLocales.setLocationRelativeTo(null);
        
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Citas citas = new Citas();
        citas.setVisible(true);
        citas.setLocationRelativeTo(null);
        
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnColeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColeccionesActionPerformed
        Colecciones colecciones = new Colecciones();
        colecciones.setVisible(true);
        colecciones.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnColeccionesActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        LoginCliente loginCliente = new LoginCliente();
        loginCliente.setVisible(true);
        loginCliente.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonar;
    private javax.swing.JButton btnColecciones;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton btnSobreNosotros;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
