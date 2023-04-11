package Modelo;

public class Proveedor {

    private int idProve;
    private String nomProve;
    private String telProve;
    private String direProve;
    private String estadoProve;
    private int numProductosReg;

    public Proveedor() {
    }

    public Proveedor(int idProve, String nomProve, String telProve, String direProve, String estadoProve) {
        this.idProve = idProve;
        this.nomProve = nomProve;
        this.telProve = telProve;
        this.direProve = direProve;
        this.estadoProve = estadoProve;
    }

    public String getEstadoProve() {
        return estadoProve;
    }

    public void setEstadoProve(String estadoProve) {
        this.estadoProve = estadoProve;
    }

    public int getIdProve() {
        return idProve;
    }

    public void setIdProve(int idProve) {
        this.idProve = idProve;
    }

    public String getNomProve() {
        return nomProve;
    }

    public void setNomProve(String nomProve) {
        this.nomProve = nomProve;
    }

    public String getTelProve() {
        return telProve;
    }

    public void setTelProve(String telProve) {
        this.telProve = telProve;
    }

    public String getDireProve() {
        return direProve;
    }

    public void setDireProve(String direProve) {
        this.direProve = direProve;
    }

    public int getNumProductosReg() {
        return numProductosReg;
    }

    public void setNumProductosReg(int numProductosReg) {
        this.numProductosReg = numProductosReg;
    }

}
