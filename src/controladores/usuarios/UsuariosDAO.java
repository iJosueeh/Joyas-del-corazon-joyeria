/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.usuarios;

import modelos.dao.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.clases.usuarios.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.interfaces.IUsuario;

public class UsuariosDAO implements IUsuario {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Usuario loginAdmin(String correo_electronico, String contraseña) {
        String sql = "SELECT * FROM usuarios WHERE correo_electronico = ? AND rol = 'administrador'";
        Usuario usuario = null;

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo_electronico);
            rs = ps.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("contraseña");
                if (contraseña.equals(storedPassword)) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("id"));
                    usuario.setNombre_completo(rs.getString("nombre_completo"));
                    usuario.setCorreo_electronico(rs.getString("correo_electronico"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setEstado(rs.getString("estado"));
                    usuario.setDireccion(rs.getString("direccion"));
                    usuario.setRol(rs.getString("rol"));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return usuario;
    }

    @Override
    public Usuario loginUsuario(String correo_electronico, String password) {
        String sql = "SELECT * FROM usuarios WHERE correo_electronico = ?";
        Usuario usuario = null;

        try {
            con = cn.getConexion();
            ps = con.prepareCall(sql);
            ps.setString(1, correo_electronico);
            rs = ps.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("contraseña");
                if (password.equals(storedPassword)) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("id"));
                    usuario.setNombre_completo(rs.getString("nombre_completo"));
                    usuario.setCorreo_electronico(rs.getString("correo_electronico"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setEstado(rs.getString("estado"));
                    usuario.setDireccion(rs.getString("direccion"));
                    usuario.setRol(rs.getString("rol"));
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return usuario;
    }

    @Override
    public Boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre_completo, correo_electronico, contraseña, telefono, estado, direccion, rol) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, usuario.getNombre_completo());
            ps.setString(2, usuario.getCorreo_electronico());
            ps.setString(3, usuario.getContraseña());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getEstado());
            ps.setString(6, usuario.getDireccion());
            ps.setString(7, usuario.getRol());

            int filasInsertadas = ps.executeUpdate();

            if (filasInsertadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        usuario.setIdUsuario(idGenerado);
                    }
                }
            }
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }

    }

    @Override
    public Boolean actualizarEstadoInactivo(int idUsuario) {
        String sql = "UPDATE usuarios SET estado = 'inactivo' WHERE id = ?";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, idUsuario);

            int filasActualizadas = ps.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    @Override
    public Boolean actualizarEstadoActivo(int idUsuario) {
        String sql = "UPDATE usuarios SET estado = 'activo' WHERE id = ?";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, idUsuario);

            int filasActualizadas = ps.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

}
