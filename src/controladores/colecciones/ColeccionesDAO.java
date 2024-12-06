/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.colecciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.dao.ConexionBD;
import java.sql.*;
import javax.swing.JOptionPane;
import modelos.clases.productos.Coleccion;
import modelos.interfaces.IColecciones;

/**
 *
 * @author HOME
 */
public class ColeccionesDAO implements IColecciones {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Coleccion obtenerColeccionPorId(int idColeccion) {
        String sql = "SELECT * FROM Colecciones WHERE id = ?";
        Coleccion coleccion = null;
        try {

            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idColeccion);
            rs = ps.executeQuery();

            if (rs.next()) {
                coleccion = new Coleccion();
                coleccion.setId(rs.getInt("id"));
                coleccion.setNombre(rs.getString("nombre"));
                coleccion.setDescripcion(rs.getString("descripcion"));
                coleccion.setFecha_lanzamiento(rs.getTimestamp("fecha_lanzamiento"));
                coleccion.setEstado(rs.getString("estado"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return coleccion;
    }

    public Coleccion obtenerColeccionPorNombre(String nombre) {
        String sql = "SELECT * FROM Colecciones WHERE nombre = ?";
        Coleccion coleccion = null;
        try {

            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {
                coleccion = new Coleccion();
                coleccion.setId(rs.getInt("id"));
                coleccion.setNombre(rs.getString("nombre"));
                coleccion.setDescripcion(rs.getString("descripcion"));
                coleccion.setFecha_lanzamiento(rs.getTimestamp("fecha_lanzamiento"));
                coleccion.setEstado(rs.getString("estado"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return coleccion;
    }

}
