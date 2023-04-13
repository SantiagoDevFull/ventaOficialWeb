package Interfaces;

import Modelo.BDetalle;
import Modelo.Boleta;
import java.util.ArrayList;

public interface Iboleta {
    
    public int RetornarCodigoBoleta();
    public int ProcesarBoleta(Boleta b);
    public ArrayList<Boleta>ListarBoleta();
    public ArrayList<BDetalle>ListarDetalle(int id);
    
}
