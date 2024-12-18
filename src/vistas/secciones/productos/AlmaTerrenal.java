/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.secciones.productos;

import controladores.pedidos.NuevoPedido;
import controladores.productos.ProductoDAO;
import controladores.proveedores.ProveedorDAO;
import controladores.reseñas.NuevaReseñas;
import controladores.reseñas.ReseñasDAO;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.clases.productos.Producto;
import modelos.clases.productos.Proveedor;
import modelos.clases.reseñas.Reseña;
import modelos.clases.usuarios.Usuario;
import vistas.menu.MenuUsuario;
import vistas.secciones.Colecciones;
import vistas.secciones.carrito.CarritoCompras;

public class AlmaTerrenal extends javax.swing.JFrame {

    private String nombreProducto; // Nombre del producto específico
    private AñadirReseña reseñaPanel = new AñadirReseña();
    private int idProducto;
    private CarritoCompras carritoCompras; // Ventana del carrito
    private NuevoPedido nuevoPedido;      // Manejo de la lógica de pedidos

    private ReseñasDAO reseñaDAO = new ReseñasDAO();
    private ProveedorDAO proveedorDAO = new ProveedorDAO();
    private ProductoDAO productoDAO = new ProductoDAO();

    public AlmaTerrenal() {
        initComponents();

        this.nombreProducto = "Alma Terrenal";

        try {
            URL urlmagenxd = new URL("https://i.ibb.co/378xXF3/file-22.jpg");
            ImageIcon imagenxd = new ImageIcon(urlmagenxd);
            jLabel1.setIcon(imagenxd);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        this.idProducto = reseñaDAO.obtenerIdProducto(nombreProducto);
        this.carritoCompras = new CarritoCompras();

        NuevaReseñas nuevaReseña = new NuevaReseñas(reseñaDAO, reseñaPanel, idProducto);
        actualizarPanelReseñas(idProducto);

        Producto producto = productoDAO.obtenerProductoPorNombre(nombreProducto);
        Proveedor proveedor = proveedorDAO.obtenerProveedorPorId(1);

        labelTitle.setText(producto.getNombre());
        textAreaDescripcion.setText(producto.getDescripcion());
        txtProveedor.setText(proveedor.getNombre());
        txtMoney.setText(String.valueOf(producto.getPrecio()));
        txtPrecioOnline.setText(String.valueOf(producto.getPrecio() - 30));

        String cantidad = (String) comboBoxCantidad.getSelectedItem();
        int cantidadNumerica = Integer.parseInt(cantidad);

        nuevoPedido = new NuevoPedido(productoDAO, nombreProducto, btnNuevaCompra, cantidadNumerica);

    }

    public void actualizarPanelReseñas(int idProducto) {
        List<Reseña> listaReseñas = reseñaDAO.obtenerReseñasPorProducto(idProducto);
        StringBuilder todasReseñas = new StringBuilder();

        for (Reseña reseña : listaReseñas) {
            todasReseñas.append("Usuario: ").append(reseña.getComentario().split("\n")[0]).append("\n");  // Nombre del usuario
            todasReseñas.append("Calificación: ").append(reseña.getCalificacion()).append(" estrellas\n");
            todasReseñas.append("Comentario: ").append(reseña.getComentario().split("\n")[1]).append("\n");
            todasReseñas.append("Fecha: ").append(reseña.getFechaCreacion()).append("\n");
            todasReseñas.append("\n----------------------------------------------------\n\n");
        }

        jTextArea2.setText(todasReseñas.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        comboBoxCantidad = new javax.swing.JComboBox<>();
        btnNuevaCompra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDescripcion = new javax.swing.JTextArea();
        ScrollPanelRseñas = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        btnAgregarReseña = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioOnline = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMoney = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        txtProveedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(118, 98, 78));
        jPanel1.setForeground(new java.awt.Color(118, 98, 78));

        labelTitle.setFont(new java.awt.Font("Bodoni MT", 0, 36)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(229, 229, 183));
        labelTitle.setText("Title");

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(229, 229, 183));
        jLabel4.setText("Vendido por: ");

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(229, 229, 183));
        jLabel5.setText("Online");

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(229, 229, 183));
        jLabel6.setText("Regular");

        comboBoxCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        btnNuevaCompra.setBackground(new java.awt.Color(69, 73, 74));
        btnNuevaCompra.setForeground(new java.awt.Color(229, 229, 183));
        btnNuevaCompra.setText("Agregar al carrito");
        btnNuevaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCompraActionPerformed(evt);
            }
        });

        textAreaDescripcion.setEditable(false);
        textAreaDescripcion.setBackground(new java.awt.Color(118, 98, 78));
        textAreaDescripcion.setColumns(20);
        textAreaDescripcion.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        textAreaDescripcion.setForeground(new java.awt.Color(229, 229, 183));
        textAreaDescripcion.setLineWrap(true);
        textAreaDescripcion.setRows(10);
        textAreaDescripcion.setWrapStyleWord(true);
        textAreaDescripcion.setAutoscrolls(false);
        textAreaDescripcion.setBorder(null);
        jScrollPane1.setViewportView(textAreaDescripcion);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        ScrollPanelRseñas.setViewportView(jTextArea2);

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(229, 229, 183));
        jLabel7.setText("Reseñas");

        btnAgregarReseña.setBackground(new java.awt.Color(69, 73, 74));
        btnAgregarReseña.setForeground(new java.awt.Color(229, 229, 183));
        btnAgregarReseña.setText("Agregar reseña");
        btnAgregarReseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarReseñaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(229, 229, 183));
        jLabel8.setText("S/");

        txtPrecioOnline.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        txtPrecioOnline.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecioOnline.setText("0");

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(229, 229, 183));
        jLabel10.setText("S/");

        txtMoney.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        txtMoney.setForeground(new java.awt.Color(255, 255, 255));
        txtMoney.setText("0");

        btnRegresar.setBackground(new java.awt.Color(255, 149, 0));
        btnRegresar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(null);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtProveedor.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        txtProveedor.setForeground(new java.awt.Color(255, 255, 255));
        txtProveedor.setText("Desconocido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel10)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtMoney)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtProveedor))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtPrecioOnline))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(comboBoxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnNuevaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(670, 670, 670)
                                        .addComponent(btnAgregarReseña, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(labelTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScrollPanelRseñas, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtProveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(txtPrecioOnline))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(txtMoney))
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(labelTitle)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarReseña)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanelRseñas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCompraActionPerformed
        if (Usuario.isLoggedIn()) {
            carritoCompras.cargarCarrito();
            carritoCompras.setVisible(true);
            carritoCompras.setLocationRelativeTo(null);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes iniciar sesión para comprar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNuevaCompraActionPerformed

    private void btnAgregarReseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarReseñaActionPerformed

        if (Usuario.isLoggedIn()) {
            reseñaPanel.setVisible(true);
            reseñaPanel.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(null, "Debes iniciar sesion para dejar una reseña.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnAgregarReseñaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Colecciones menuColecciones = new Colecciones();
        menuColecciones.setVisible(true);
        menuColecciones.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane ScrollPanelRseñas;
    private javax.swing.JButton btnAgregarReseña;
    public javax.swing.JButton btnNuevaCompra;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboBoxCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextArea textAreaDescripcion;
    private javax.swing.JLabel txtMoney;
    private javax.swing.JLabel txtPrecioOnline;
    private javax.swing.JLabel txtProveedor;
    // End of variables declaration//GEN-END:variables
}
