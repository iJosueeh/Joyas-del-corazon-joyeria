/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.reseñas;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelos.clases.reseñas.Reseña;
import modelos.dao.ConexionBD;
import modelos.interfaces.IReseñas;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HOME
 */
public class ReseñasDAO implements IReseñas {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Boolean agregarReseña(Reseña reseña) {
        String sql = "INSERT INTO Comentarios (id_producto, id_usuario, calificacion, fecha_creacion, comentario) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, reseña.getIdProducto());
            ps.setInt(2, reseña.getIdUsuario());
            ps.setInt(3, reseña.getCalificacion());
            ps.setTimestamp(4, new Timestamp(reseña.getFechaCreacion().getTime()));
            ps.setString(5, reseña.getComentario());

            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
        return true;
    }

    @Override
    public List<Reseña> obtenerReseñasPorProducto(int idProducto) {
        List<Reseña> reseñas = new ArrayList<>();
        String sql = "SELECT c.id, c.id_producto, c.id_usuario, c.calificacion, c.fecha_creacion, c.comentario, u.nombre_completo "
                + " FROM Comentarios c "
                + " INNER JOIN usuarios u ON c.id_usuario = u.id "
                + " WHERE c.id_producto = ?";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, idProducto);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int productoId = rs.getInt("id_producto");
                int usuarioId = rs.getInt("id_usuario");
                int calificacion = rs.getInt("calificacion");
                Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                String comentario = rs.getString("comentario");
                String nombreUsuario = rs.getString("nombre_completo");

                Reseña reseña = new Reseña(productoId, usuarioId, calificacion, fechaCreacion, comentario);
                reseña.setId(id);
                reseña.setComentario(nombreUsuario + "\n" + comentario);
                reseñas.add(reseña);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return reseñas;
    }

    @Override
    public int obtenerIdProducto(String nombreProducto) {
        String sql = "SELECT id FROM Productos WHERE nombre = ?";
        int idProducto = -1;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, nombreProducto);
            rs = ps.executeQuery();

            if (rs.next()) {
                idProducto = rs.getInt("id");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return idProducto;
    }

}
