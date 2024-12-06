/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.pedidos;

import controladores.carrito.CarritoDAO;
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
import modelos.clases.usuarios.Usuario;

public class NuevoPedido implements ActionListener {

    private ProductoDAO productoDAO;
    private String nombreProducto;
    private JButton btnNuevaCompra;
    private CarritoDAO carritoDAO;

    public NuevoPedido(ProductoDAO productoDAO, String nombreProducto, JButton btnNuevaCompra) {
        this.productoDAO = productoDAO;
        this.nombreProducto = nombreProducto;
        this.carritoDAO = new CarritoDAO();
        this.btnNuevaCompra = btnNuevaCompra;
        this.btnNuevaCompra.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNuevaCompra) {
            try {
                Producto producto = productoDAO.obtenerProductoPorNombre(nombreProducto);
                if (producto == null) {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                    return;
                }

                int stock = productoDAO.obtenerStockPorNombre(nombreProducto);
                if (stock <= 0) {
                    JOptionPane.showMessageDialog(null, "Se agotaron los stocks de este producto.");
                    return;
                }

                int usuarioId = Usuario.getUsuarioActual().getIdUsuario();
                int cantidad = 1;

                carritoDAO.agregarProducto(usuarioId, producto, cantidad);

                JOptionPane.showMessageDialog(null, "Producto añadido al carrito correctamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al añadir el producto: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
