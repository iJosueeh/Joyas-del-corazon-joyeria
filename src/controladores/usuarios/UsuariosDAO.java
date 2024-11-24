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

/**
 *
 * @author HOME
 */
public class UsuariosDAO {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Usuario login(String correo_electronico, String contraseña) {
        String sql = "SELECT * FROM usuarios WHERE correo_electronico = ?";
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
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return usuario;
    }

}
