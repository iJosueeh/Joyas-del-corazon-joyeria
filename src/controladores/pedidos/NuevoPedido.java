/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.pedidos;

import controladores.colecciones.ColeccionesDAO;
import controladores.productos.ProductoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.clases.productos.Coleccion;
import modelos.clases.productos.Producto;

public class NuevoPedido implements ActionListener {

    private DefaultTableModel modeloCarrito;
    private ProductoDAO productoDAO;
    private String nombreProducto;
    private JButton btnNuevaCompra;
    private ColeccionesDAO coleccionDAO;

    public NuevoPedido(DefaultTableModel modeloCarrito, ProductoDAO productoDAO, String nombreProducto, JButton btnNuevaCompra) {
        this.modeloCarrito = modeloCarrito;
        this.productoDAO = productoDAO;
        this.nombreProducto = nombreProducto;
        this.coleccionDAO = new ColeccionesDAO();
        this.btnNuevaCompra = btnNuevaCompra;
        this.btnNuevaCompra.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNuevaCompra) {
            try {
                Producto producto = productoDAO.obtenerProductoPorNombre(nombreProducto);
                int stock = productoDAO.obtenerStockPorNombre(nombreProducto);

                if (stock <= 0) {
                    JOptionPane.showMessageDialog(null, "Se agotaron los stocks de este producto.");
                    return;
                }

                if (producto != null) {
                    Coleccion nombreColeccion = coleccionDAO.obtenerColeccionPorId(producto.getIdColeccion());
                    double precio = producto.getPrecio();
                    int cantidad = 1; // Supongamos que el usuario siempre agrega 1 producto
                    double subtotal = precio * cantidad;

                    Object[] nuevaFila = {
                        producto.getId(),
                        producto.getNombre(),
                        nombreColeccion != null ? nombreColeccion.toString() : "N/A",
                        cantidad,
                        precio,
                        subtotal
                    };

                    modeloCarrito.addRow(nuevaFila);
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

}
