
package modelos.clases.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import modelos.clases.Productos.Producto;
import modelos.clases.pedidos.Pedido;

public class GestionPedido {
    private Map<Integer, Pedido> pedidos;
    private List<Producto> productosDisponibles;
    private int contador;
    private Scanner scanner;

    public GestionPedido() {
        this.scanner = scanner;
        this.contador = 0;
        this.productosDisponibles = productosDisponibles;
        this.pedidos = new HashMap<>();
    }

    public Map<Integer, Pedido> getPedidos() {
        return pedidos;
    }

    public List<Producto> getProductosDisponibles() {
        return productosDisponibles;
    }

    public void mostrarPedido(int idPedido) {
        Pedido pedido = pedidos.get(idPedido);

        if (pedido != null) {
            System.out.println("ID del Pedido: " + pedido.getIdPedido());
            System.out.println("Fecha del pedido: " + pedido.getFechaPedido());
            System.out.println("Productos: ");

            for (Map.Entry<Producto, Integer> productos : pedido.getProductos().entrySet()) {
                Producto producto = productos.getKey();
                int cantidad = productos.getValue();
                System.out.println("- " + producto.getNombre() + " (Cantidad: " + cantidad + ", Precio: " + producto.getPrecio() + ")");
            }
            System.out.println("Total: " + pedido.getTotal());
        } else {
            System.out.println("El pedido con el ID " + idPedido + " no existe.");
        }
    }

    
    public void realizarPedido(Pedido pedido) {
        if (pedido.getProductos().isEmpty()) {
            System.out.println("No hay productos agregados.");
            return;
        }

        pedido.setIdPedido(++contador);
        pedidos.put(pedido.getIdPedido(), pedido);

        System.out.println("Pedido realizado con exito. ID del Pedido: " + pedido.getIdPedido());
    }

 
    public void cancelarPedido(Pedido pedido) {
        if (pedidos.containsKey(pedido.getIdPedido())) {
            pedidos.remove(pedido.getIdPedido());
            System.out.println("El pedido con ID " + pedido.getIdPedido() + " ha sido cancelado.");
        } else {
            System.out.println("El pedido con ID " + pedido.getIdPedido() + " no existe.");
        }
    }

    public Producto buscarProductoID(int idProducto) {
        for (Producto producto : productosDisponibles) {
            if (producto.getId_Producto() == idProducto) {
                return producto; // Retorna el producto si lo encuentra
            }
        }
        return null; 
    }
}
