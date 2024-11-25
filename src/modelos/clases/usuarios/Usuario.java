package modelos.clases.usuarios;

public class Usuario {

    private int idUsuario;
    private String nombre_completo;
    private String correo_electronico;
    private String contraseña;
    private String telefono;
    private String estado;
    private String direccion;
    private String rol;
    private boolean status;
    private static boolean loggedIn = false;
    private static Usuario usuarioActual;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre_completo, String correo_electronico, String contraseña, String telefono, String direccion) {
        this.idUsuario = idUsuario;
        this.nombre_completo = nombre_completo;
        this.correo_electronico = correo_electronico;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.estado = estado;
        this.direccion = direccion;
        this.rol = rol;
        this.status = false;
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

    public String getRol() {
        return rol;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
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

    public void setRol(String rol) {
        this.rol = rol;
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        Usuario.loggedIn = loggedIn;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuario) {
        Usuario.usuarioActual = usuario;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("idUsuario=").append(idUsuario);
        sb.append(", nombre_completo=").append(nombre_completo);
        sb.append(", correo_electronico=").append(correo_electronico);
        sb.append(", contrase\u00f1a=").append(contraseña);
        sb.append(", telefono=").append(telefono);
        sb.append(", estado=").append(estado);
        sb.append(", direccion=").append(direccion);
        sb.append(", rol=").append(rol);
        sb.append('}');
        return sb.toString();
    }

}
