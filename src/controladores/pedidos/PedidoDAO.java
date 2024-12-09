/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.pedidos;

import com.mysql.cj.xdevapi.Statement;
import controladores.ICRUD;
import controladores.usuarios.UsuariosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.clases.pedidos.Pedido;
import modelos.dao.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.clases.pedidos.DetallePedido;
import modelos.clases.productos.Producto;

/**
 *
 * @author HOME
 */
public class PedidoDAO implements ICRUD<Pedido> {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement psPedido;
    PreparedStatement psDetalle;
    ResultSet rs;

    @Override
    public boolean insertar(Pedido clase) throws Exception {
        String sqlPedido = "INSERT INTO Pedido (idCliente, fecha, direccion, total, estado) "
                + "VALUES (?, ?, ?, ?, ?)";
        String sqlDetalles = "INSERT INTO DetallesPedidos (id_pedido, id_producto, cantidad, precio_unitario, subtotal)"
                + " VALUES (?, ?, ?, ?, ?)";

        try {
            con = cn.getConexion();
            con.setAutoCommit(false);

            psPedido = con.prepareStatement(sqlPedido, PreparedStatement.RETURN_GENERATED_KEYS);
            psPedido.setInt(1, clase.getIdCliente());
            psPedido.setTimestamp(2, new Timestamp(clase.getFecha().getTime()));
            psPedido.setString(3, clase.getDireccion());
            psPedido.setDouble(4, clase.getTotal());
            psPedido.setString(5, clase.getEstado());
            psPedido.executeUpdate();

            rs = psPedido.getGeneratedKeys();
            int idPedido = 0;
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }

            psDetalle = con.prepareStatement(sqlDetalles);
            for (DetallePedido detalle : clase.getDetalles()) {
                psDetalle.setInt(1, idPedido);
                psDetalle.setInt(2, detalle.getProducto().getId());
                psDetalle.setInt(3, detalle.getCantidad());
                psDetalle.setDouble(4, detalle.getPrecioUnitario());
                psDetalle.setDouble(5, detalle.getSubtotal());
                psDetalle.addBatch();
            }
            psDetalle.executeBatch();
            con.commit();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(Pedido clase) throws Exception {
        String sqlPedido = "UPDATE Pedido SET idCliente = ?, fecha = ?, direccion = ?, total = ?, estado = ? WHERE id = ?";

        try {
            if (clase.getId() <= 0) {
                JOptionPane.showMessageDialog(null, "El ID del pedido no es válido.");
                return false;
            }

            con = cn.getConexion();
            psPedido = con.prepareStatement(sqlPedido);

            psPedido.setInt(1, clase.getIdCliente());
            psPedido.setTimestamp(2, new Timestamp(clase.getFecha().getTime()));
            psPedido.setString(3, clase.getDireccion());
            psPedido.setDouble(4, clase.getTotal());
            psPedido.setString(5, clase.getEstado());
            psPedido.setInt(6, clase.getId());

            int filasActualizadas = psPedido.executeUpdate();

            return filasActualizadas > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el pedido: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedido obtenerPorId(int id) throws Exception {
        String sqlPedido = "SELECT * FROM Pedido WHERE id = ?";  // Consulta para obtener el pedido
        String sqlDetalles = "SELECT * FROM DetallesPedidos WHERE id_pedido = ?";  // Consulta para obtener los detalles del pedido

        Pedido pedido = null;
        ResultSet rsPedido = null;
        ResultSet rsDetalles = null;

        try {

            con = cn.getConexion();

            psPedido = con.prepareStatement(sqlPedido);
            psPedido.setInt(1, id);
            rsPedido = psPedido.executeQuery();

            if (rsPedido.next()) {
                pedido = new Pedido();
                pedido.setId(rsPedido.getInt("id"));
                pedido.setIdCliente(rsPedido.getInt("idCliente"));
                pedido.setFecha(rsPedido.getTimestamp("fecha"));
                pedido.setDireccion(rsPedido.getString("direccion"));
                pedido.setTotal(rsPedido.getDouble("total"));
                pedido.setEstado(rsPedido.getString("estado"));
            }

            psDetalle = con.prepareStatement(sqlDetalles);
            psDetalle.setInt(1, id);
            rsDetalles = psDetalle.executeQuery();

            List<DetallePedido> detalles = new ArrayList<>();
            while (rsDetalles.next()) {
                DetallePedido detalle = new DetallePedido();
                Producto producto = new Producto();
                producto.setId(rsDetalles.getInt("id_producto"));

                detalle.setId(rsDetalles.getInt("id"));
                detalle.setIdPedido(rsDetalles.getInt("id_pedido"));
                detalle.setProducto(producto);
                detalle.setCantidad(rsDetalles.getInt("cantidad"));
                detalle.setPrecioUnitario(rsDetalles.getDouble("precio_unitario"));
                detalle.setSubtotal(rsDetalles.getDouble("subtotal"));

                detalles.add(detalle);
            }

            if (pedido != null) {
                pedido.setDetalles(detalles);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el pedido: " + e.getMessage());
            e.printStackTrace();
        }

        return pedido;
    }

    @Override
    public List<Pedido> listarTodos() throws Exception {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT p.id, p.idCliente, p.fecha, p.direccion, p.total, p.estado "
                + "FROM Pedido p";
        String sqlDetalle = "SELECT * FROM DetallesPedidos WHERE id_pedido = ?";

        UsuariosDAO usuarioDAO = new UsuariosDAO();

        try {
            con = cn.getConexion();
            psPedido = con.prepareStatement(sql);
            rs = psPedido.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                int idCliente = rs.getInt("idCliente");
                pedido.setIdCliente(idCliente);

                String nombreCliente = usuarioDAO.obtenerNombreClientePorId(idCliente); // Método para obtener el nombre por ID
                pedido.setNombreCliente(nombreCliente);

                pedido.setFecha(rs.getDate("fecha"));
                pedido.setDireccion(rs.getString("direccion"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setEstado(rs.getString("estado"));

                List<DetallePedido> detalles = new ArrayList<>();
                try {
                    psDetalle = con.prepareStatement(sqlDetalle);

                    psDetalle.setInt(1, pedido.getId()); // Pasar el ID del pedido
                    try (ResultSet rsDetalle = psDetalle.executeQuery()) {
                        while (rsDetalle.next()) {
                            DetallePedido detalle = new DetallePedido();
                            detalle.setId(rsDetalle.getInt("id"));
                            detalle.setIdPedido(rsDetalle.getInt("id_pedido"));
                            detalle.setCantidad(rsDetalle.getInt("cantidad"));
                            detalle.setPrecioUnitario(rsDetalle.getDouble("precio_unitario"));
                            detalle.setSubtotal(rsDetalle.getDouble("subtotal"));

                            Producto producto = new Producto();
                            producto.setId(rsDetalle.getInt("id_pedido"));
                            detalle.setProducto(producto);

                            detalles.add(detalle);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                pedido.setDetalles(detalles);

                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }

}
