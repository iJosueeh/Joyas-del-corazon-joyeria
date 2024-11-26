/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.citas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.clases.servicio.Cita;
import modelos.clases.usuarios.Usuario;
import vistas.secciones.Citas;

/**
 *
 * @author HOME
 */
public class RegistrarCitas implements ActionListener {

    private Cita citas;
    private CitasDAO citasDAO;
    private Citas citasPanel;

    public RegistrarCitas(Cita citas, CitasDAO citasDAO, Citas citasPanel) {
        this.citas = citas;
        this.citasDAO = citasDAO;
        this.citasPanel = citasPanel;
        this.citasPanel.btnSolicitar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == citasPanel.btnSolicitar) {

            if (Usuario.isLoggedIn()) {

                Usuario usuarioLogueado = Usuario.getUsuarioActual();
                int idUsuario = usuarioLogueado.getIdUsuario();
                String motivo = (String) citasPanel.comboBoxMotivo.getSelectedItem();
                String informacionContacto = citasPanel.txtContactoInfo.getText();
                String descripcion = citasPanel.txtDescripcion.getText();
                String modoCita = (String) citasPanel.comboBoxModoCita.getSelectedItem();
                String preferenciaContacto = (String) citasPanel.comboBoxPreferencia.getSelectedItem();

                if (informacionContacto.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los campos están vacíos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    citasPanel.txtContactoInfo.setText("Ingresa tu numero");
                    citasPanel.txtDescripcion.setText("Escribe el motivo de tu cita");
                    citasPanel.comboBoxModoCita.setSelectedIndex(0);
                    citasPanel.comboBoxMotivo.setSelectedIndex(0);
                    citasPanel.comboBoxPreferencia.setSelectedIndex(0);
                    return;
                }

                if (informacionContacto.equals("") || descripcion.equals("Escribe el motivo de tu cita")) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa los datos correspondientes.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Cita citaNueva = new Cita(idUsuario, motivo, informacionContacto, descripcion, modoCita, preferenciaContacto);
                boolean citaResultado = citasDAO.registrarCitas(citaNueva);

                if (citaResultado) {
                    JOptionPane.showMessageDialog(null, "Cita registrada correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                    citasPanel.txtContactoInfo.setText("Ingresa tu numero");
                    citasPanel.txtDescripcion.setText("Escribe el motivo de tu cita");
                    citasPanel.comboBoxModoCita.setSelectedIndex(0);
                    citasPanel.comboBoxMotivo.setSelectedIndex(0);
                    citasPanel.comboBoxPreferencia.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al momento de registrar una cita, intente de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario debe iniciar sesion para hacer una cita.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                citasPanel.txtContactoInfo.setText("Ingresa tu numero");
                citasPanel.txtDescripcion.setText("Escribe el motivo de tu cita");
                citasPanel.comboBoxModoCita.setSelectedIndex(0);
                citasPanel.comboBoxMotivo.setSelectedIndex(0);
                citasPanel.comboBoxPreferencia.setSelectedIndex(0);
            }

        }
    }

}
