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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import javax.swing.JOptionPane;
import modelos.interfaces.ICitas;

public class CitasDAO implements ICitas {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    private List<Cita> listaCitas = new ArrayList<>();

    @Override
    public Boolean registrarCitas(Cita cita) {
        String sql = "INSERT INTO citas (idUsuario, motivo, telefono, descripcion, tipo_cita, preferencia, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            
            Predicate<Cita> validarCita = c -> c.getIdUsuario() > 0 && !c.getMotivo().isEmpty();
            if (!validarCita.test(cita)) {
                throw new IllegalArgumentException("Cita no válida");
            }

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
            if (filasInsertadas > 0) {
                // Agregamos la cita a la lista local
                listaCitas.add(cita);
                return true;
            }
        } catch (SQLException e) {
            manejarError(e);
        }
        return false;
    }

    @Override
    public Boolean eliminarCita() {
        Cita citaAEliminar = listaCitas.stream()
                .filter(c -> "pendiente".equals(c.getEstado()))
                .findFirst()
                .orElse(null);

        if (citaAEliminar != null) {
            listaCitas.remove(citaAEliminar);
            return true;
        }
        return false;
    }

    public List<Cita> obtenerCitas() {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM citas";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setIdUsuario(rs.getInt("idUsuario"));
                cita.setMotivo(rs.getString("motivo"));
                cita.setTelefono(rs.getString("telefono"));
                cita.setDescripcion(rs.getString("descripcion"));
                cita.setModoCita(rs.getString("tipo_cita"));
                cita.setPreferenciaContacto(rs.getString("preferencia"));
                cita.setEstado(rs.getString("estado"));
                citas.add(cita);
            }
        } catch (SQLException e) {
            manejarError(e);
        }
        return citas;
    }

    private void manejarError(SQLException e) {
        System.err.println("Error en base de datos: " + e.getMessage());
    }
}
