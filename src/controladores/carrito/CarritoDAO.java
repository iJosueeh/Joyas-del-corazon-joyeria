/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.carrito;

import controladores.colecciones.ColeccionesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.clases.productos.Producto;
import modelos.dao.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javax.swing.JOptionPane;
import modelos.clases.productos.Coleccion;

/**
 *
 * @author HOME
 */
public class CarritoDAO {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public void agregarProducto(int usuarioId, Producto producto, int cantidad) {
        String sql = "INSERT INTO Carrito (id_usuario, id_producto, nombre_producto, coleccion, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {

            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            int idColeccion = producto.getIdColeccion();

            ColeccionesDAO coleccionDAO = new ColeccionesDAO();
            Coleccion coleccion = coleccionDAO.obtenerColeccionPorId(idColeccion);

            ps.setInt(1, usuarioId);
            ps.setInt(2, producto.getId());
            ps.setString(3, producto.getNombre());
            ps.setString(4, coleccion.getNombre());
            ps.setInt(5, cantidad);
            ps.setDouble(6, producto.getPrecio());
            ps.setDouble(7, producto.getPrecio() * cantidad);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public List<Object[]> obtenerCarrito(int usuarioId) {
        List<Object[]> carrito = new ArrayList<>();
        String sql = "SELECT id_producto, nombre_producto, coleccion, cantidad, precio, subtotal FROM Carrito WHERE id_usuario = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    carrito.add(new Object[]{
                        rs.getInt("id_producto"),
                        rs.getString("nombre_producto"),
                        rs.getString("coleccion"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio"),
                        rs.getDouble("subtotal")
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return carrito;
    }

    public void vaciarCarrito(int usuarioId) {
        String sql = "DELETE FROM Carrito WHERE id_usuario = ?";
        try {

            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, usuarioId);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public double calcularSubtotalTotal(int usuarioId) {
        double subtotal = 0.0;
        String sql = "SELECT precio, cantidad FROM Carrito WHERE id_usuario = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    double precio = rs.getDouble("precio");
                    int cantidad = rs.getInt("cantidad");
                    subtotal += precio * cantidad;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return subtotal;
    }

    public double calcularCostoEnvio() {
        return 10.0;
    }

  
    public double aplicarDescuento(double subtotalTotal, double porcentajeDescuento) {
        Predicate<Double> validarDescuento = descuento -> descuento >= 0 && descuento <= 100;
        if (!validarDescuento.test(porcentajeDescuento)) {
            throw new IllegalArgumentException("Porcentaje de descuento inválido.");
        }
        return subtotalTotal - (subtotalTotal * (porcentajeDescuento / 100));
    }


    public double calcularTotal(int usuarioId, double porcentajeDescuento) {
        double subtotalTotal = calcularSubtotalTotal(usuarioId);
        double costoEnvio = calcularCostoEnvio();
        double subtotalConDescuento = aplicarDescuento(subtotalTotal, porcentajeDescuento);
        return subtotalConDescuento + costoEnvio;
    }

    private void manejarError(SQLException e) {
        Consumer<String> mostrarError = mensaje -> System.err.println("Error: " + mensaje);
        mostrarError.accept(e.toString());
    }
}
