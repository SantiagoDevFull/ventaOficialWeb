package Interfaces;

import Modelo.Rol;
import java.util.ArrayList;

public interface Irol {
    
    public ArrayList<Rol>ListarRol();
    public int AgregarRol(Rol r);
    public int EditarRol(Rol r);
    public int EliminarRol(int id);
    public int RetornarCodigoRol();
    
}
