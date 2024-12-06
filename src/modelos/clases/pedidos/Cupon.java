package modelos.clases.pedidos;

import java.util.Date;

public class Cupon {

    private int id;
    private String codigo;
    private double valor_descuento;
    private Date fecha_inicio;
    private Date fecha_final;
    private String estado;
    private int uso_maximo;
    private int id_usuario;

    public Cupon(int id, String codigo, double valor_descuento, Date fecha_inicio, Date fecha_final, String estado, int uso_maximo, int id_usuario) {
        this.id = id;
        this.codigo = codigo;
        this.valor_descuento = valor_descuento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.estado = estado;
        this.uso_maximo = uso_maximo;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValor_descuento() {
        return valor_descuento;
    }

    public void setValor_descuento(double valor_descuento) {
        this.valor_descuento = valor_descuento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getUso_maximo() {
        return uso_maximo;
    }

    public void setUso_maximo(int uso_maximo) {
        this.uso_maximo = uso_maximo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    
}
