
package modelos.clases.Productos;

public class Reseña {
    private int idReseña;
    private Producto producto;
    private String comentario;
    private int puntuacion;

    public Reseña(int idReseña, Producto producto, String comentario, int puntuacion) {
        this.idReseña = idReseña;
        this.producto = producto;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
    }
    
    public void CrearReseña(){
        System.out.println("Reseña creada: "+this.comentario + "Con una puntacion: "+ this.puntuacion);
    }
    public void EditarR(String nuevoComentario, int NuevoPuntaje){
        this.comentario= nuevoComentario;
        this.puntuacion= NuevoPuntaje;
        System.out.println("Reseña editada:"+ this.comentario + "Con la nueva puntacion" + this.puntuacion);
    }
    public void EliminarR(){
        System.out.println("Reseña con ID: "+ this.idReseña + "ha sido eliminada");
        
    }
    public void mostrarR(){
        System.out.println("Reseña del Producto:"+ this.producto.getNombre());
        System.out.println("Comentario: "+ this.comentario);
        System.out.println("Puntuacion: " + this.puntuacion);
        
    }

    public int getIdReseña() {
        return idReseña;
    }

    public void setIdReseña(int idReseña) {
        this.idReseña = idReseña;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
