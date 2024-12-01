/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos.interfaces;

import modelos.clases.productos.Producto;

public interface IProductos {

    public Producto obtenerProductoPorNombre(String nombreProducto);
    public boolean actualizarProducto(Producto producto);
    
}
