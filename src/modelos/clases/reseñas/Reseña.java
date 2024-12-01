
package modelos.clases.reseñas;

import java.util.Date;

public class Reseña {
    private int id;
    private int idProducto;
    private int idUsuario;
    private int calificacion;
    private Date fechaCreacion;
    private String comentario;

    public Reseña(int idProducto, int idUsuario, int calificacion, Date fechaCreacion, String comentario) {
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.calificacion = calificacion;
        this.fechaCreacion = fechaCreacion;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
