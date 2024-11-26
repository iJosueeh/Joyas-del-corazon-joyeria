/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.clases.servicio;

/**
 *
 * @author HOME
 */
public class Cita {
    private int id;
    private int idUsuario;
    private String motivo;
    private String telefono;
    private String descripcion;
    private String modoCita;
    private String preferenciaContacto;
    private String estado;

    public Cita(){
    }
    
    public Cita(int idUsuario, String motivo, String telefono, String descripcion, String modoCita, String preferenciaContacto) {
        this.idUsuario = idUsuario;
        this.motivo = motivo;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.modoCita = modoCita;
        this.preferenciaContacto = preferenciaContacto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModoCita() {
        return modoCita;
    }

    public void setModoCita(String modoCita) {
        this.modoCita = modoCita;
    }

    public String getPreferenciaContacto() {
        return preferenciaContacto;
    }

    public void setPreferenciaContacto(String preferenciaContacto) {
        this.preferenciaContacto = preferenciaContacto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
