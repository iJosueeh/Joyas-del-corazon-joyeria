
package modelos.interfaces;

import modelos.clases.pedidos.Pedido;


public interface IGestionPedido {
    public void realizarPedido(Pedido pedido);
    public void cancelarPedido(Pedido pedido);
}
