package modelos.clases.productos;

import java.util.Date;

public class Colecciones {

    private int id;
    private String nombre;
    private String descripcion;
    private Date fecha_creacion;
    private String estado;

    public Colecciones(int id, String nombre, String descripcion, Date fecha_creacion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
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

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Colecciones{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha_creacion=" + fecha_creacion + ", estado=" + estado + '}';
    }

}
