package Interfaces;

import Modelo.Cliente;
import java.util.ArrayList;

public interface Icliente {

    public ArrayList<Cliente> ListarCliente();

    public ArrayList<Cliente> ListarClientesDNIactivos();

    public int AgregarCliente(Cliente c);

    public int EditarCliente(Cliente c);

    public int EliminarCliente(int id);

    public int RetornarCodigoCliente();

}
