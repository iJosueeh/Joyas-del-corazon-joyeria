/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author HOME
 */
public class ConexionBD {

    Connection con;

    public Connection getConexion() {
        try {
            String db = "jdbc:mysql://root:WncvdUgIwTgZbvGcuPNCdVRYBxpwHsAq@junction.proxy.rlwy.net:44526/railway";
            con = DriverManager.getConnection(db, "root", "WncvdUgIwTgZbvGcuPNCdVRYBxpwHsAq");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }

}
