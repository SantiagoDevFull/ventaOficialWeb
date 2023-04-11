package ModeloDAO;

import Interfaces.Iusuario;
import Modelo.Rol;
import Modelo.Usuario;
import Config.MySQLConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO implements Iusuario {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public Usuario ExisteUsuario(String correo, String pass) {

        Usuario u = null;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT u.idUsu,u.nomUsu,u.patUsu,u.matUsu,u.correoUsu,"
                + "u.estadoUsu,r.nomRol,r.estadoRol FROM usuario u\n"
                + "INNER JOIN rol r ON (u.idRol=r.idRol)  WHERE u.correoUsu=? and u.passUsu=?";
        try {
            st = cn.prepareStatement(consulta);
            st.setString(1, correo);
            st.setString(2, pass);

            rs = st.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setIdUsu(rs.getInt(1));
                u.setNomUsu(rs.getString(2));
                u.setPatUsu(rs.getString(3));
                u.setMatUsu(rs.getString(4));
                u.setCorreoUsu(rs.getString(5));
                u.setEstadoUsu(rs.getString(6));

                Rol r = new Rol();
                r.setNomRol(rs.getString(7));
                r.setEstadoRol(rs.getString(8));

                u.setRol(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return u;
    }

    @Override
    public ArrayList<Usuario> ListarUsuario() {

        ArrayList<Usuario> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT u.idUsu,u.nomUsu,u.patUsu,u.matUsu,u.correoUsu,"
                + "u.passUsu,u.fechcontUsu,u.estadoUsu,u.idRol,r.nomRol \n"
                + "FROM usuario u\n"
                + "INNER JOIN rol r ON (u.idRol=r.idRol)";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsu(rs.getInt(1));
                u.setNomUsu(rs.getString(2));
                u.setPatUsu(rs.getString(3));
                u.setMatUsu(rs.getString(4));
                u.setCorreoUsu(rs.getString(5));
                u.setPassUsu(rs.getString(6));
                u.setFechcontUsu(rs.getString(7));
                u.setEstadoUsu(rs.getString(8));

                Rol r = new Rol();
                r.setIdRol(rs.getInt(9));
                r.setNomRol(rs.getString(10));

                u.setRol(r);

                lista.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public int AgregarUsuario(Usuario u) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "INSERT INTO usuario VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            st = cn.prepareStatement(consulta);
            st.setInt(1, u.getIdUsu());
            st.setString(2, u.getNomUsu());
            st.setString(3, u.getPatUsu());
            st.setString(4, u.getMatUsu());
            st.setString(5, u.getCorreoUsu());
            st.setString(6, u.getPassUsu());
            st.setString(7, u.getFechcontUsu());
            st.setString(8, u.getEstadoUsu());
            st.setInt(9, u.getRol().getIdRol());
            res = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int EditarUsuario(Usuario u) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "UPDATE usuario SET nomUsu=?,patUsu=?,matUsu=?,"
                + "correoUsu=?,passUsu=?,fechcontUsu=?,estadoUsu=?,idRol=? WHERE idUsu=?";
        try {
            st = cn.prepareStatement(consulta);

            st.setString(1, u.getNomUsu());
            st.setString(2, u.getPatUsu());
            st.setString(3, u.getMatUsu());
            st.setString(4, u.getCorreoUsu());
            st.setString(5, u.getPassUsu());
            st.setString(6, u.getFechcontUsu());
            st.setString(7, u.getEstadoUsu());
            st.setInt(8, u.getRol().getIdRol());
            st.setInt(9, u.getIdUsu());

            res = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;

    }

    @Override
    public int EliminarUsuario(int id) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "DELETE FROM usuario WHERE idUsu=?";
        try {
            st = cn.prepareStatement(consulta);
            st.setInt(1, id);
            res = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int RetornarCodigoUsuario() {

        int res = -1;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT AUTO_INCREMENT\n"
                + "FROM  INFORMATION_SCHEMA.TABLES\n"
                + "WHERE TABLE_SCHEMA = 'prywebventa'\n"
                + "AND   TABLE_NAME   = 'usuario';";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            if (rs.next()) {
                res = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

}
