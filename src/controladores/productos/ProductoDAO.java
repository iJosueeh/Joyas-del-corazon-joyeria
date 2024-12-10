/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.productos;

import controladores.ICRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.clases.productos.Producto;
import modelos.dao.ConexionBD;
import modelos.interfaces.IProductos;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductoDAO implements IProductos, ICRUD<Producto> {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Producto obtenerProductoPorNombre(String nombreProducto) {
        String sql = "SELECT * FROM Productos WHERE nombre = ?";
        Producto producto = null;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreProducto);
            rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setIdColeccion(rs.getInt("id_coleccion"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setStock(rs.getInt("stock"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return producto;
    }

    @Override
    public int obtenerStockPorNombre(String nombreProducto) {
        String sql = "SELECT stock FROM Productos WHERE nombre = ?";
        int stockProducto = 0;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreProducto);
            rs = ps.executeQuery();

            if (rs.next()) {
                stockProducto = rs.getInt("stock");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return stockProducto;
    }

    public void cargarProductosEnTabla(JTable tabla) throws Exception {
        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> listaProductos = productoDAO.listarTodos();

        Iterator<Producto> iterator = listaProductos.iterator();

        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            Object[] fila = {
                producto.getId(),
                producto.getIdColeccion(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getCantidad(),
                producto.getStock()
            };
            modeloTabla.addRow(fila);
        }
    }

    @Override
    public boolean insertar(Producto clase) throws Exception {
        String sql = "INSERT INTO Productos (id_coleccion, nombre, descripcion, precio, cantidad, stock) VALUES (?, ?, ?, ?, ?, ?)";
        boolean agregado = false;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, clase.getIdColeccion());
            ps.setString(2, clase.getNombre());
            ps.setString(3, clase.getDescripcion());
            ps.setDouble(4, clase.getPrecio());
            ps.setInt(5, clase.getCantidad());
            ps.setInt(6, clase.getStock());

            int filasAfectadas = ps.executeUpdate();
            agregado = (filasAfectadas > 0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error al agregar producto", JOptionPane.ERROR_MESSAGE);
        }

        return agregado;
    }

    @Override
    public boolean actualizar(Producto clase) throws Exception {
        String sql = "UPDATE Productos SET id_coleccion = ?, nombre = ?, descripcion = ?, precio = ?, cantidad = ?, stock = ? WHERE id = ?";
        boolean actualizado = false;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, clase.getIdColeccion());
            ps.setString(2, clase.getNombre());
            ps.setString(3, clase.getDescripcion());
            ps.setDouble(4, clase.getPrecio());
            ps.setInt(5, clase.getCantidad());
            ps.setInt(6, clase.getStock());
            ps.setInt(7, clase.getId());

            int filasAfectadas = ps.executeUpdate();
            actualizado = (filasAfectadas > 0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error al editar producto", JOptionPane.ERROR_MESSAGE);
        }

        return actualizado;
    }

    @Override
    public boolean eliminar(int id) throws Exception {
        String sql = "DELETE FROM Productos WHERE id = ?";
        boolean eliminado = false;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            eliminado = (filasAfectadas > 0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error al eliminar producto", JOptionPane.ERROR_MESSAGE);
        }

        return eliminado;
    }

    @Override
    public Producto obtenerPorId(int id) throws Exception {
        String sql = "SELECT * FROM Productos WHERE id = ?";
        Producto producto = null;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setIdColeccion(rs.getInt("id_coleccion"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setStock(rs.getInt("stock"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return producto;
    }

    @Override
    public List<Producto> listarTodos() throws Exception {
        String sql = "SELECT * FROM Productos";
        List<Producto> listaProductos = new ArrayList<>();

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setIdColeccion(rs.getInt("id_coleccion"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setStock(rs.getInt("stock"));

                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaProductos;
    }

}
