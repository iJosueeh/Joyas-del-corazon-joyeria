package modelos.interfaces;

import modelos.clases.usuarios.Usuario;

public interface IUsuario {

    public Usuario loginAdmin(String correo_electronico, String contraseña);
    public Usuario loginUsuario(String correo_electronico, String password);
    public Boolean registrarUsuario(Usuario usuario);
    public Boolean actualizarEstadoInactivo(int idUsuario);
    public Boolean actualizarEstadoActivo(int idUsuario);
    
}
