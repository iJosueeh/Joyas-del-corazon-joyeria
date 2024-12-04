/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.pedidos;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.clases.pedidos.Pedido;
import modelos.dao.ConexionBD;
import modelos.interfaces.IPedido;
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
public class PedidoDAO implements IPedido {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement psPedido;
    PreparedStatement psDetalle;
    ResultSet rs;

    @Override
    public Boolean agregarPedido(Pedido pedido) {
        String sqlPedido = "INSERT INTO Pedidos (idCliente, fecha, direccion, total, estado) "
                + "VALUES (?, ?, ?, ?, ?)";
        String sqlDetalles = "INSERT INTO DetallesPedidos (id_pedido, id_producto, cantidad, precio_unitario, subtotal)"
                + " VALUES (?, ?, ?, ?, ?)";

        try {
            con = cn.getConexion();
            con.setAutoCommit(false);
            psPedido = con.prepareStatement(sqlPedido, PreparedStatement.RETURN_GENERATED_KEYS);

            psPedido.setInt(1, pedido.getIdCliente());
            psPedido.setTimestamp(2, new Timestamp(pedido.getFecha().getTime()));
            psPedido.setString(3, pedido.getDireccion());
            psPedido.setDouble(4, pedido.getTotal());
            psPedido.setString(5, pedido.getEstado());
            psPedido.executeQuery();

            rs = psPedido.getGeneratedKeys();
            int idPedido = 0;
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }

            psDetalle = con.prepareStatement(sqlDetalles);
            for (DetallePedido detalle : pedido.getDetalles()) {
                psDetalle.setInt(1, idPedido);
                psDetalle.setInt(2, detalle.getProducto().getId());
                psDetalle.setInt(3, detalle.getCantidad());
                psDetalle.setDouble(4, detalle.getPrecioUnitario());
                psDetalle.setDouble(5, detalle.getSubtotal());
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
    public Pedido obtenerPedidoPorId(int idPedido) {
        String sqlPedido = "SELECT * FROM Pedidos WHERE id = ?";
        String sqlDetalles = "SELECT * FROM DetallesPedido WHERE id_pedido = ?";

        Pedido pedido = null;
        ResultSet rsPedido = null;
        ResultSet rsDetalles = null;

        try {
            con = cn.getConexion();
            psPedido = con.prepareStatement(sqlPedido);
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
            psDetalle.setInt(1, idPedido);
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
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return pedido;
    }

}
