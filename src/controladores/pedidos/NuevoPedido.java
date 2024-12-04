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
    private ColeccionesDAO coleccionDAO;
    private ProductoDAO productoDAO;
    private JButton btnNuevaCompra;
    private String nombreProducto;

    public NuevoPedido(DefaultTableModel modeloCarrito, ProductoDAO productoDAO, String nombreProducto, JButton btnNuevaCompra) {
        this.modeloCarrito = modeloCarrito;
        this.productoDAO = productoDAO;
        this.coleccionDAO = new ColeccionesDAO();
        this.btnNuevaCompra = btnNuevaCompra;
        this.nombreProducto = nombreProducto;
        this.btnNuevaCompra.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNuevaCompra) {
            try {
                Producto producto = productoDAO.obtenerProductoPorNombre(nombreProducto);
                int stock = productoDAO.obtenerStockPorNombre(nombreProducto);
                Coleccion coleccion = null;

                if (stock <= 0) {
                    JOptionPane.showMessageDialog(null, "Se agotaron los stocks de este producto.");
                    return;
                }

                if (producto != null) {
                    coleccion = coleccionDAO.obtenerColeccionPorId(producto.getIdColeccion());
                    double precio = producto.getPrecio();
                    double cantidad = producto.getCantidad();
                    double subtotal = (precio * cantidad);

                    Object[] nuevaFila = {
                        producto.getId(),
                        producto.getNombre(),
                        coleccion != null ? coleccion.getNombre() : "N/A",
                        cantidad,
                        precio,
                        subtotal
                    };
                    // Verifica si los datos son correctos antes de añadirlos
                    System.out.println("Añadiendo fila: " + Arrays.toString(nuevaFila));
                    modeloCarrito.addRow(nuevaFila);
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }
    }

}
