package Interfaces;

import Modelo.Producto;
import java.util.ArrayList;

public interface Iproducto {

    public ArrayList<Producto> ListarProducto();
    
    public ArrayList<Producto>ListarProductosActivos();

    public int AgregarProducto(Producto p);

    public int EditarProducto(Producto p);

    public int EliminarProducto(int id);

    public int RetornarCodigoProducto();

}
