/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos.interfaces;

import java.util.List;
import modelos.clases.productos.Proveedor;

/**
 *
 * @author HOME
 */
public interface IProveedor {
    public List<Proveedor> obtenerTodosLosProveedores();
    public boolean actualizarProveedor(Proveedor proveedor);
    public boolean eliminarProveedor(int id);
    public Proveedor obtenerProveedorPorId(int id);
}
