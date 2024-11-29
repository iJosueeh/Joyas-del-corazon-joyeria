/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.login;

import controladores.usuarios.UsuariosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelos.clases.usuarios.Usuario;
import vistas.menu.MenuUsuario;
import vistas.secciones.perfil.RegisterCliente;

public class RegisterUsuarios implements ActionListener {

    private Usuario usuario;
    private UsuariosDAO usuarioDAO;
    private RegisterCliente registrarPanel;

    public RegisterUsuarios(Usuario usuario, UsuariosDAO usuarioDAO, RegisterCliente registrarPanel) {
        this.usuario = usuario;
        this.usuarioDAO = usuarioDAO;
        this.registrarPanel = registrarPanel;
        this.registrarPanel.btnRegistrar.addActionListener(this);
    }

    public static boolean esCorreoValido(String correo) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarPanel.btnRegistrar) {

            String nombreCompleto = registrarPanel.txtNombreCompleto.getText();
            String correo = registrarPanel.txtEmail.getText();
            String contraseña = String.valueOf(registrarPanel.txtPassword.getPassword());
            String contraseñaConfirm = String.valueOf(registrarPanel.txtPasswordConfirm.getPassword());
            String telefono = registrarPanel.txtTelefono.getText();
            String direccion = registrarPanel.txtDireccion.getText();

            if (!esCorreoValido(correo)) {
                JOptionPane.showMessageDialog(null, "El formato del correo electronico es incorrecto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                registrarPanel.txtEmail.setText("Ingresa tu correo electronico");
                return;
            }

            if (nombreCompleto.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || contraseñaConfirm.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los campos están vacios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                registrarPanel.txtNombreCompleto.setText("Ingresa tu nombre completo");
                registrarPanel.txtEmail.setText("Ingresa tu correo electronico");
                registrarPanel.txtPassword.setText("*********");
                registrarPanel.txtPasswordConfirm.setText("*********");
                registrarPanel.txtTelefono.setText("Ingresa tu numero");
                registrarPanel.txtDireccion.setText("Ingresa tu direccion");
                return;
            }

            if (!contraseña.equals(contraseñaConfirm)) {
                JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Usuario nuevoUsuario = new Usuario(nombreCompleto, correo, contraseña, telefono, direccion);
            boolean nuevoRegistro = usuarioDAO.registrarUsuario(nuevoUsuario);

            if (nuevoRegistro) {
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                registrarPanel.txtNombreCompleto.setText("Ingresa tu nombre completo");
                registrarPanel.txtEmail.setText("Ingresa tu correo electronico");
                registrarPanel.txtPassword.setText("*********");
                registrarPanel.txtPasswordConfirm.setText("*********");
                registrarPanel.txtTelefono.setText("Ingresa tu numero");
                registrarPanel.txtDireccion.setText("Ingresa tu direccion");

                Usuario.setUsuarioActual(nuevoUsuario);
                
                Usuario.setLoggedIn(true);
                nuevoUsuario.setStatus(true);

                MenuUsuario menuUsuario = new MenuUsuario();
                menuUsuario.setVisible(true);
                menuUsuario.setLocationRelativeTo(null);
                registrarPanel.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar al usuario, intente de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                registrarPanel.txtNombreCompleto.setText("Ingresa tu nombre completo");
                registrarPanel.txtEmail.setText("Ingresa tu correo electronico");
                registrarPanel.txtPassword.setText("*********");
                registrarPanel.txtPasswordConfirm.setText("*********");
                registrarPanel.txtTelefono.setText("Ingresa tu numero");
                registrarPanel.txtDireccion.setText("Ingresa tu direccion");
            }

        }
    }

}
