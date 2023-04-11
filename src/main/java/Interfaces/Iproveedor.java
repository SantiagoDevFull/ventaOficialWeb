package Interfaces;

import Modelo.Proveedor;
import java.util.ArrayList;

public interface Iproveedor {

    public ArrayList<Proveedor> ListarProveedor();

    public int AgregarProveedor(Proveedor p);

    public int EditarProveedor(Proveedor p);

    public int EliminarProveedor(int id);

    public int RetornarCodigoProveedor();

}
