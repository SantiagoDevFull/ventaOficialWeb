package Modelo;

public class Categoria {

    private int idCat;
    private String nomCat;
    private String estadoCat;
    private int numProdReg;

    public Categoria() {
    }

    public Categoria(int idCat, String nomCat, String estadoCat) {
        this.idCat = idCat;
        this.nomCat = nomCat;
        this.estadoCat = estadoCat;
    }

    public String getEstadoCat() {
        return estadoCat;
    }

    public void setEstadoCat(String estadoCat) {
        this.estadoCat = estadoCat;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public int getNumProdReg() {
        return numProdReg;
    }

    public void setNumProdReg(int numProdReg) {
        this.numProdReg = numProdReg;
    }

}
