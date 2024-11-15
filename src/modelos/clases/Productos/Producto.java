
package modelos.clases.Productos;

import java.util.List;


public class Producto {
    //Atributos
    private int contador;
    private int id_Producto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private int stock;
    private List<Proveedor> proveedores;

    public Producto(int id_Producto, String nombre, String descripcion, double precio, int stock, List<Proveedor> proveedores) {
        this.id_Producto = contador++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.proveedores = proveedores;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void actualizarStock(int cantidad) {
        if (cantidad < 0 && Math.abs(cantidad) > stock) {
            System.out.println("El Stock no puede estar por debajo de 0");

        } else {
            this.stock += cantidad;
            System.out.println("Stock actualizado. Nuevo Stock : " + this.stock);
        }
    }

    @Override
    public String toString() {
        return "Producto{" + "id_Producto=" + id_Producto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + ", proveedores=" + proveedores + '}';
    }

   
    public void agregarProducto() {
        System.out.println("Producto agregado: " + nombre);
    }


    public void eliminarProducto() {
        System.out.println("Producto eliminado: " + nombre);
    }


    public void actualizarProducto() {
        System.out.println("Producto actualizado: " + nombre);
    }


    public void verProducto() {
        System.out.println("ID: " + id_Producto + ", Nombre: " + nombre + ", Precio: " + precio + ", Stock: " + stock);
    }

}
