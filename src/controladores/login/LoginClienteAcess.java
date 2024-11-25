/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.login;

import controladores.usuarios.UsuariosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.clases.usuarios.Usuario;
import vistas.menu.MenuUsuario;
import vistas.secciones.perfil.LoginCliente;

public class LoginClienteAcess implements ActionListener {

    private Usuario usuario;
    private UsuariosDAO usuarioDAO;
    private LoginCliente loginClientePanel;

    public LoginClienteAcess(Usuario usuario, UsuariosDAO usuarioDAO, LoginCliente loginClientePanel) {
        this.usuario = usuario;
        this.usuarioDAO = usuarioDAO;
        this.loginClientePanel = loginClientePanel;
        this.loginClientePanel.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginClientePanel.btnLogin) {

            if (Usuario.isLoggedIn()) {
                JOptionPane.showMessageDialog(null, "Ya tienes una sesión activa.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String email = loginClientePanel.txtEmail.getText();
            String password = String.valueOf(loginClientePanel.txtPassword.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los campos están vacios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                loginClientePanel.txtEmail.setText("Ingresa tu correo electronico");
                loginClientePanel.txtPassword.setText("*********");
                return;
            }

            if (email.equals("Ingresa tu correo electronico") || password.equals("*********")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa tus credenciales.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Usuario loginCliente = usuarioDAO.loginUsuario(email, password);

            if (loginCliente != null) {

                String mensajeBienvenida = "Bienvenido, " + loginCliente.getNombre_completo() + "!";
                JOptionPane.showMessageDialog(null, mensajeBienvenida, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                loginCliente.setStatus(true);
                Usuario.setLoggedIn(true);

                MenuUsuario menuUsuario = new MenuUsuario();
                menuUsuario.setVisible(true);
                menuUsuario.setLocationRelativeTo(null);
                loginClientePanel.dispose();

            } else {

                JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                loginClientePanel.txtEmail.setText("Ingresa tu correo electronico");
                loginClientePanel.txtPassword.setText("*********");

            }

        }
    }

}
