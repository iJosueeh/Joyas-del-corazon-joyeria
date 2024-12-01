/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos.interfaces;

import java.util.List;
import javax.swing.JPanel;
import modelos.clases.reseñas.Reseña;

/**
 *
 * @author HOME
 */
public interface IReseñas {
    public Boolean agregarReseña(Reseña reseña);
    public List<Reseña> obtenerReseñasPorProducto(int productoId);    
    public int obtenerIdProducto(String nombreProducto);
}
