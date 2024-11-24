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
import vistas.menu.Login;
import vistas.menu.MenuGestionar;

public class LoginAccess implements ActionListener {

    private Usuario usuario;
    private UsuariosDAO usuarioDao;
    private Login loginPanel;

    public LoginAccess(Usuario usuario, UsuariosDAO usuarioDao, Login loginPanel) {
        this.usuario = usuario;
        this.usuarioDao = usuarioDao;
        this.loginPanel = loginPanel;
        this.loginPanel.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginPanel.btnLogin) {
            String email = loginPanel.txtEmail.getText();
            String password = String.valueOf(loginPanel.txtPassword.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los campos están vacíos.");
                return;
            }

            if (email.equals("ingresa tu correo electronico") || password.equals("*********")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa tus credenciales.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Usuario login = usuarioDao.login(email, password);

            if (login != null) {

                String mensajeBienvenida = "Bienvenido, " + login.getNombre_completo() + "!";
                JOptionPane.showMessageDialog(null, mensajeBienvenida, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);

                MenuGestionar menuGestionar = new MenuGestionar();
                menuGestionar.setVisible(true);
                menuGestionar.setLocationRelativeTo(null);
                loginPanel.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
