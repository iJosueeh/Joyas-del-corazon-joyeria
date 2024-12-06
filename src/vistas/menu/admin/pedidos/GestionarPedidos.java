/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.menu.admin.pedidos;

import controladores.pedidos.PedidoDAO;
import vistas.menu.admin.usuarios.*;
import controladores.usuarios.UsuariosDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelos.clases.pedidos.Pedido;
import modelos.clases.usuarios.Usuario;
import vistas.menu.MenuGestionar;
import vistas.menu.admin.pedidos.AgregarPedidos;

/**
 *
 * @author HOME
 */
public class GestionarPedidos extends javax.swing.JFrame {

    private Usuario usuarioLogueado = Usuario.getUsuarioActual();
    private PedidoDAO pedidoDAO;
    private UsuariosDAO usuarioDAO;

    public GestionarPedidos() {
        initComponents();

        this.pedidoDAO = new PedidoDAO();

        String[] columnas = {"ID", "Cliente", "Fecha", "Dirección", "Total", "Estado"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);
        tablaPedidos.setModel(modeloTabla);

        cargarPedidosEnTabla();
        tablaPedidos.setDefaultEditor(Object.class, null); //
    }

    private void cargarPedidosEnTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaPedidos.getModel();
        modeloTabla.setRowCount(0); 

        List<Pedido> pedidos = pedidoDAO.obtenerPedidos();

        for (Pedido pedido : pedidos) {
            Object[] fila = {
                pedido.getId(),
                pedido.getNombreCliente(),
                pedido.getFecha(),
                pedido.getDireccion(),
                pedido.getTotal(),
                pedido.getEstado()
            };
            modeloTabla.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAgregarPedido = new javax.swing.JButton();
        btnEditarPedido = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaPedidos);

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 229, 183));
        jLabel1.setText("Gestionar Pedidos");

        btnAgregarPedido.setText("Agregar Pedido");
        btnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedidoActionPerformed(evt);
            }
        });

        btnEditarPedido.setText("Editar Pedido");
        btnEditarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPedidoActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(btnEditarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(325, 325, 325)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuGestionar menuGestionar = new MenuGestionar(usuarioLogueado);
        menuGestionar.setVisible(true);
        menuGestionar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPedidoActionPerformed
        EditarPedido editarPedido = new EditarPedido();
        editarPedido.setVisible(true);
        editarPedido.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnEditarPedidoActionPerformed

    private void btnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedidoActionPerformed
        AgregarPedidos agregarPedido = new AgregarPedidos();
        agregarPedido.setVisible(true);
        agregarPedido.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnAgregarPedidoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPedido;
    private javax.swing.JButton btnEditarPedido;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
