/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.cupones;

import modelos.dao.ConexionBD;
import java.sql.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javax.swing.JOptionPane;
import modelos.clases.pedidos.Cupon;
import java.util.Date;

/**
 *
 * @author HOME
 */
public class CuponesDAO {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean esCuponValido(String codigoCupon) {
        Predicate<String> esValido = (codigo) -> {
            String sql = "SELECT fecha_inicio, fecha_final FROM Cupones WHERE codigo = ? AND estado = 'activo'";
            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                ps.setString(1, codigo);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Date fechaInicio = rs.getDate("fecha_inicio");
                        Date fechaFinal = rs.getDate("fecha_final");
                        Date fechaActual = new Date();

                        return fechaActual.after(fechaInicio) && fechaActual.before(fechaFinal);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            return false;
        };

        return esValido.test(codigoCupon);
    }

    public Cupon obtenerCuponPorCodigo(String codigo) {
        Cupon cupon = null;
        String sql = "SELECT * FROM Cupones WHERE codigo = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cupon = new Cupon(
                            rs.getInt("id"),
                            rs.getString("codigo"),
                            rs.getDouble("valor_descuento"),
                            rs.getDate("fecha_inicio"),
                            rs.getDate("fecha_final"),
                            rs.getString("estado"),
                            rs.getInt("uso_maximo"),
                            rs.getInt("id_usuario")
                    );
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return cupon;
    }

    public double aplicarCuponDescuento(double total, String codigoCupon) {
        if (!esCuponValido(codigoCupon)) {
            JOptionPane.showMessageDialog(null, "El cupón no es válido o ha expirado.");
            return total;
        }

        Cupon cupon = obtenerCuponPorCodigo(codigoCupon);
        if (cupon != null) {
            final double descuento = cupon.getValor_descuento();

            double nuevoTotal = total - (total * (descuento / 100.0));

            if (nuevoTotal < 0) {
                nuevoTotal = 0;
            }

            return nuevoTotal;
        }

        return total; 
    }

    public void usarCupon(String codigoCupon) {
        Consumer<String> disminuirUsoMaximo = (codigo) -> {
            String sql = "UPDATE Cupones SET uso_maximo = uso_maximo - 1 WHERE codigo = ? AND uso_maximo > 0";
            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                ps.setString(1, codigo);
                ps.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        };

        disminuirUsoMaximo.accept(codigoCupon);
    }

    public boolean tieneUsoDisponible(String codigoCupon) {
        Predicate<String> tieneUso = (codigo) -> {
            String sql = "SELECT uso_maximo FROM Cupones WHERE codigo = ?";
            try {
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                ps.setString(1, codigo);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("uso_maximo") > 0;
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            return false;
        };

        return tieneUso.test(codigoCupon);
    }

    public boolean existeCupon(String codigoCupon) {
        String sql = "SELECT COUNT(*) AS total FROM Cupones WHERE codigo = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigoCupon);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total") > 0;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return false;
    }

}
