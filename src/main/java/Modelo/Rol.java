package Modelo;

public class Rol {

    private int idRol;
    private String nomRol;
    private String estadoRol;
    private int numUsuReg;

    public Rol() {
    }

    public Rol(int idRol, String nomRol, String estadoRol) {
        this.idRol = idRol;
        this.nomRol = nomRol;
        this.estadoRol = estadoRol;
    }

    public String getEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(String estadoRol) {
        this.estadoRol = estadoRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    public int getNumUsuReg() {
        return numUsuReg;
    }

    public void setNumUsuReg(int numUsuReg) {
        this.numUsuReg = numUsuReg;
    }

}
