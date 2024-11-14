
package modelos.clases.servicio;

import java.util.ArrayList;
import java.util.List;
import modelos.clases.usuarios.Cliente;
import modelos.clases.usuarios.Usuario;


public class GestionUsuario {
    private List<Cliente> listaCliente;

    public GestionUsuario() {
        this.listaCliente = new ArrayList<>();
    }

    public GestionUsuario(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente != null ? listaCliente : new ArrayList<>();
    }

  
    public Cliente buscarClientePorId(int idCliente, List<Cliente> listaCliente) {
        for (Cliente cliente : listaCliente) {
            if (cliente.getIdUsuario() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

 
    public Cliente buscarClientePorNombre(String nombreCliente) {
    if (listaCliente == null || listaCliente.isEmpty()) {
        System.out.println("No hay clientes registrados.");
        return null;
    }

    for (Cliente cliente : listaCliente) {
        if (cliente.getNombre() != null && cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
            return cliente;
        }
    }

    System.out.println("No se encontró ningún cliente con el nombre: " + nombreCliente);
    return null;
}


    public void registrarUsuario(Usuario usuario) {
    }


    public void modificarPerfil() {
    }


    public Boolean verificarUsuario(String correo, String contraseña) {
        return true;
    }

 
    public void eliminarUsuario(Usuario usuario) {
    }
}
