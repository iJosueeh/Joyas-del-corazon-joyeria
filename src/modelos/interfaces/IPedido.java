/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos.interfaces;

import modelos.clases.pedidos.Pedido;

/**
 *
 * @author HOME
 */
public interface IPedido {
    public Boolean agregarPedido(Pedido pedido);
    public Pedido obtenerPedidoPorId(int idPedido);
    
}
