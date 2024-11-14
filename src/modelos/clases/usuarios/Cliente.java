
package modelos.clases.usuarios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelos.clases.Productos.Producto;
import modelos.clases.pedidos.Direccion;
import modelos.clases.pedidos.Pedido;


public class Cliente {
    private Direccion direccion;
    private String correo;
    private String telefono;
    private Set<Pedido> historialDePedidos;
    private String nombre;

    public Cliente(Direccion direccion, String correo, String telefono, Set<Pedido> historialDePedidos,String nombre) {
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.historialDePedidos = new HashSet<>();
        this.nombre= nombre;
    }

   

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Pedido> getHistorialDePedidos() {
        return historialDePedidos;
    }

    public void realizarPedido(List<Producto> producto) {
        // Lógica para realizar un pedido
    }

    public int getIdUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

   

   
}
