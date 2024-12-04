/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.clases.productos;

import java.util.Date;

/**
 *
 * @author HOME
 */
public class Coleccion {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fecha_lanzamiento;
    private String estado;

    public Coleccion(){
    }
    
    public Coleccion(String nombre, String descripcion, Date fecha_lanzamiento, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(Date fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
    
}
