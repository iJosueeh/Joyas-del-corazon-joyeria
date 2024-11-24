package modelos.clases.usuarios;

public class Usuario {

    private int idUsuario;
    private String nombre_completo;
    private String correo_electronico;
    private String contraseña;
    private String telefono;
    private String estado;
    private String direccion;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre_completo, String correo_electronico, String contraseña, String telefono, String direccion) {
        this.idUsuario = idUsuario;
        this.nombre_completo = nombre_completo;
        this.correo_electronico = correo_electronico;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.estado = "activo";
        this.direccion = direccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEstado() {
        return estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre_completo=" + nombre_completo + ", correo_electronico=" + correo_electronico + ", contrase\u00f1a=" + contraseña + ", telefono=" + telefono + ", estado=" + estado + ", direccion=" + direccion + '}';
    }

}
