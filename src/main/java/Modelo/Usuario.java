package Modelo;

public class Usuario {

    private int idUsu;
    private String nomUsu;
    private String patUsu;
    private String matUsu;
    private String correoUsu;
    private String passUsu;
    private String fechcontUsu;
    private String estadoUsu;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int idUsu, String nomUsu, String patUsu, String matUsu, String correoUsu, String passUsu, String fechcontUsu, String estadoUsu, Rol rol) {
        this.idUsu = idUsu;
        this.nomUsu = nomUsu;
        this.patUsu = patUsu;
        this.matUsu = matUsu;
        this.correoUsu = correoUsu;
        this.passUsu = passUsu;
        this.fechcontUsu = fechcontUsu;
        this.estadoUsu = estadoUsu;
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public String getPatUsu() {
        return patUsu;
    }

    public void setPatUsu(String patUsu) {
        this.patUsu = patUsu;
    }

    public String getMatUsu() {
        return matUsu;
    }

    public void setMatUsu(String matUsu) {
        this.matUsu = matUsu;
    }

    public String getCorreoUsu() {
        return correoUsu;
    }

    public void setCorreoUsu(String correoUsu) {
        this.correoUsu = correoUsu;
    }

    public String getPassUsu() {
        return passUsu;
    }

    public void setPassUsu(String passUsu) {
        this.passUsu = passUsu;
    }

    public String getFechcontUsu() {
        return fechcontUsu;
    }

    public void setFechcontUsu(String fechcontUsu) {
        this.fechcontUsu = fechcontUsu;
    }

    public String getEstadoUsu() {
        return estadoUsu;
    }

    public void setEstadoUsu(String estadoUsu) {
        this.estadoUsu = estadoUsu;
    }

}
