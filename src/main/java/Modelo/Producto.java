package Modelo;

public class Producto {

    private int idPro;
    private String nomPro;
    private int stockPro;
    private double precioPro;
    private String estadoPro;
    private Categoria categoria;
    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(int idPro, String nomPro, int stockPro, double precioPro, String estadoPro, Categoria categoria, Proveedor proveedor) {
        this.idPro = idPro;
        this.nomPro = nomPro;
        this.stockPro = stockPro;
        this.precioPro = precioPro;
        this.estadoPro = estadoPro;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public int getStockPro() {
        return stockPro;
    }

    public void setStockPro(int stockPro) {
        this.stockPro = stockPro;
    }

    public double getPrecioPro() {
        return precioPro;
    }

    public void setPrecioPro(double precioPro) {
        this.precioPro = precioPro;
    }

    public String getEstadoPro() {
        return estadoPro;
    }

    public void setEstadoPro(String estadoPro) {
        this.estadoPro = estadoPro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
