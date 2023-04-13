package Modelo;

import java.util.ArrayList;

public class Boleta {

    private int idBoleta;
    private int idUsuario;
    private String nombreUsuario;
    private String nombreCliente;
    private int idCliente;
    private String fechaCompra;
    private double total;
    private ArrayList<BDetalle> detalle = new ArrayList();

    public Boleta() {
    }

    public Boleta(int idBoleta, int idUsuario, int idCliente, String fechaCompra, double total) {
        this.idBoleta = idBoleta;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.fechaCompra = fechaCompra;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(int idBoleta) {
        this.idBoleta = idBoleta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public ArrayList<BDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<BDetalle> detalle) {
        this.detalle = detalle;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

}
