/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controladores;

import java.util.List;

/**
 *
 * @author HOME
 * @param <T>
 */
public interface ICRUD<T> {

    boolean insertar(T clase) throws Exception;
    boolean actualizar(T clase) throws Exception;
    boolean eliminar(int id) throws Exception;
    T obtenerPorId(int id) throws Exception;
    List<T> listarTodos() throws Exception;
}
