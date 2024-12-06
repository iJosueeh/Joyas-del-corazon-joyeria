package modelos.clases.pedidos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private int id;
    private int idCliente;
    private Date fecha;
    private String direccion;
    private double total;
    private String estado;
    private List<DetallePedido> detalles;
    private String nombreCliente;

    public Pedido() {
    }

    public Pedido(int idCliente, Date fecha, String direccion, double total, String estado) {
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.direccion = direccion;
        this.total = total;
        this.estado = estado;
        this.detalles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    

}
