
package modelos.interfaces;

import java.util.List;
import modelos.clases.usuarios.Usuario;


public interface IUsuario {
   public void registrarUsuario(Usuario usuario);
    public void modificarPerfil();
    public Boolean verificarUsuario(String correo, String contraseña);
    public void eliminarUsuario(Usuario usuario);

}
