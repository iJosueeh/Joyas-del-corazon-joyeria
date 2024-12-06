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
import java.util.ArrayList;
import java.util.List;
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
                    usuario.setId(rs.getInt("id"));
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
                    usuario.setId(rs.getInt("id"));
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
                        usuario.setId(idGenerado);
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

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id, nombre_completo, correo_electronico, contraseña, telefono, estado, direccion, rol FROM usuarios";

        try {

            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNombre_completo(rs.getString("nombre_completo"));
                usuario.setCorreo_electronico(rs.getString("correo_electronico"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setRol(rs.getString("rol"));

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getString("nombre_completo"),
                        rs.getString("correo_electronico"),
                        rs.getString("contraseña"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                );
                usuario.setId(rs.getInt("id"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return usuario;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre_completo = ?, correo_electronico = ?, contraseña = ?, telefono = ?, estado = ?, direccion = ?, rol = ? WHERE id = ?";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNombre_completo());
            ps.setString(2, usuario.getCorreo_electronico());
            ps.setString(3, usuario.getContraseña());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getEstado());
            ps.setString(6, usuario.getDireccion());
            ps.setString(7, usuario.getRol());
            ps.setInt(8, usuario.getId());

            int filasActualizadas = ps.executeUpdate();

            return filasActualizadas > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public boolean eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, idUsuario);

            int filasEliminadas = ps.executeUpdate();
            return filasEliminadas > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public String obtenerNombreClientePorId(int idCliente) {
        String sql = "SELECT nombre_completo FROM usuarios WHERE id = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nombre_completo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
