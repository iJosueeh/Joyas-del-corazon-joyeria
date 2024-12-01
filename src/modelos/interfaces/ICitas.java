/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos.interfaces;

import modelos.clases.servicio.Cita;

/**
 *
 * @author hp
 */
public interface ICitas {
    public Boolean registrarCitas(Cita cita);
    public Boolean eliminarCita();
}
