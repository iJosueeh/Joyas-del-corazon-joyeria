/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.proveedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelos.clases.productos.Proveedor;
import modelos.dao.ConexionBD;
import modelos.interfaces.IProveedor;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HOME
 */
public class ProveedorDAO implements IProveedor {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Proveedor> obtenerTodosLosProveedores() {
        List<Proveedor> listaProveedores = new ArrayList<>();
        String sql = "SELECT * FROM Proveedor WHERE id = ?";
        Proveedor proveedor = null;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setId(rs.getInt("id"));
                proveedor.setIdColeccion(rs.getInt("id_coleccion"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setTelefono(rs.getInt("telefono"));
                proveedor.setDireccion(rs.getString("direccion"));

                listaProveedores.add(proveedor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaProveedores;
    }

    @Override
    public boolean actualizarProveedor(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarProveedor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proveedor obtenerProveedorPorId(int id) {
        String sql = "SELECT * FROM Proveedor WHERE id = ?";
        Proveedor proveedor = null;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setId(rs.getInt("id"));
                proveedor.setIdColeccion(rs.getInt("id_coleccion"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setTelefono(rs.getInt("telefono"));
                proveedor.setDireccion(rs.getString("telefono"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
        return proveedor;
    }

}
