package Modelo;

public class Cliente {

    private int idCli;
    private String docCli;
    private String numCli;
    private String nomCli;
    private String correoCli;
    private String passCli;
    private String estadoCli;
    private int numBoletas;
    private int numFacturas;

    public Cliente() {
    }

    public Cliente(int idCli, String docCli, String numCli, String nomCli, String correoCli, String passCli, String estadoCli) {
        this.idCli = idCli;
        this.docCli = docCli;
        this.numCli = numCli;
        this.nomCli = nomCli;
        this.correoCli = correoCli;
        this.passCli = passCli;
        this.estadoCli = estadoCli;
    }

    public String getEstadoCli() {
        return estadoCli;
    }

    public void setEstadoCli(String estadoCli) {
        this.estadoCli = estadoCli;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public String getDocCli() {
        return docCli;
    }

    public void setDocCli(String docCli) {
        this.docCli = docCli;
    }

    public String getNumCli() {
        return numCli;
    }

    public void setNumCli(String numCli) {
        this.numCli = numCli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getCorreoCli() {
        return correoCli;
    }

    public void setCorreoCli(String correoCli) {
        this.correoCli = correoCli;
    }

    public String getPassCli() {
        return passCli;
    }

    public void setPassCli(String passCli) {
        this.passCli = passCli;
    }

    public int getNumBoletas() {
        return numBoletas;
    }

    public void setNumBoletas(int numBoletas) {
        this.numBoletas = numBoletas;
    }

    public int getNumFacturas() {
        return numFacturas;
    }

    public void setNumFacturas(int numFacturas) {
        this.numFacturas = numFacturas;
    }

}
