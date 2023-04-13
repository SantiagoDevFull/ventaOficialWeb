package Modelo;

public class BDetalle {

    private int idPro;
    private String descripcion;
    private double precioPro;
    private int cantidad;
    private double total;

    public double Importe() {
        return precioPro * cantidad;
    }

    public BDetalle() {
    }

    public BDetalle(int idPro, String descripcion, double precioPro, int cantidad) {
        this.idPro = idPro;
        this.descripcion = descripcion;
        this.precioPro = precioPro;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioPro() {
        return precioPro;
    }

    public void setPrecioPro(double precioPro) {
        this.precioPro = precioPro;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
