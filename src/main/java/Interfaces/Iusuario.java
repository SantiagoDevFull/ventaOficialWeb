package Interfaces;

import Modelo.Usuario;
import java.util.ArrayList;

public interface Iusuario {

    public Usuario ExisteUsuario(String correo, String pass);

    public ArrayList<Usuario> ListarUsuario();

    public int AgregarUsuario(Usuario u);

    public int EditarUsuario(Usuario u);

    public int EliminarUsuario(int id);

    public int RetornarCodigoUsuario();

}
