/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.citas;

import modelos.dao.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.clases.servicio.Cita;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.interfaces.ICitas;

public class CitasDAO implements ICitas {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Boolean registrarCitas(Cita cita) {
        String sql = "INSERT INTO citas (idUsuario, motivo, telefono, descripcion, tipo_cita, preferencia, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, cita.getIdUsuario());
            ps.setString(2, cita.getMotivo());
            ps.setString(3, cita.getTelefono());
            ps.setString(4, cita.getDescripcion());
            ps.setString(5, cita.getModoCita());
            ps.setString(6, cita.getPreferenciaContacto());
            ps.setString(7, cita.getEstado());

            int filasInsertadas = ps.executeUpdate();

            return filasInsertadas > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    @Override
    public Boolean eliminarCita() {
        return true;
    }

}
