/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.reseñas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelos.clases.reseñas.Reseña;
import modelos.clases.usuarios.Usuario;
import vistas.secciones.productos.AñadirReseña;

/**
 *
 * @author HOME
 */
public class NuevaReseñas implements ActionListener {

    private ReseñasDAO reseñaDAO;
    private AñadirReseña reseñaPanel;

    private int idProducto;

    public NuevaReseñas(ReseñasDAO reseñaDAO, AñadirReseña reseñaPanel, int idProducto) {
        this.reseñaDAO = reseñaDAO;
        this.reseñaPanel = reseñaPanel;
        this.idProducto = idProducto;
        this.reseñaPanel.btnAñadirReseña.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reseñaPanel.btnAñadirReseña) {
            String userName = reseñaPanel.txtUsuario.getText();
            String comentario = reseñaPanel.txtAreaComentario.getText();
            int calificacion = Integer.parseInt(reseñaPanel.comboBoxCalificacion.getSelectedItem().toString());
            int idUsuario = Usuario.getUsuarioActual().getIdUsuario();

            if (comentario.equals("Escribe tu comentario..")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa el comentario adecuado.");
                return;
            }

            if (!comentario.isEmpty()) {
                Reseña reseña = new Reseña(idProducto, idUsuario, calificacion, new Date(), comentario);

                if (reseñaDAO.agregarReseña(reseña)) {
                    JOptionPane.showMessageDialog(null, "Reseña añadida con éxito.");
                    reseñaPanel.txtAreaComentario.setText("");  // Limpiar el campo de comentario
                    reseñaPanel.comboBoxCalificacion.setSelectedIndex(0);
                    reseñaPanel.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Reseña no fue registrada con exito.");
                    return;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un comentario.");
            }

        }
    }

}
