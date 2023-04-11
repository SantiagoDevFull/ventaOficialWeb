package Config;

import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import Config.MySQLConexion;
import Modelo.Cliente;
import Modelo.Rol;
import ModeloDAO.ClienteDAO;
import ModeloDAO.RolDAO;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        MySQLConexion.getConexion();
        
ClienteDAO dao=new ClienteDAO();

ArrayList<Cliente>lista=dao.ListarCliente();

for(Cliente x:lista){
    System.out.println(x.getNomCli());
}

    }
}
