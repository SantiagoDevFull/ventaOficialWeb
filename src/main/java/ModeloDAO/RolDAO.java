package ModeloDAO;

import Config.MySQLConexion;
import Interfaces.Irol;
import Modelo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolDAO implements Irol {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Rol> ListarRol() {

        ArrayList<Rol> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT r.idRol,r.nomRol,r.estadoRol,\n"
                + "(SELECT count(*) fROM usuario u WHERE u.idRol=r.idRol) \n"
                + "FROM rol r ORDER BY r.idRol";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Rol r = new Rol();
                r.setIdRol(rs.getInt(1));
                r.setNomRol(rs.getString(2));
                r.setEstadoRol(rs.getString(3));
                r.setNumUsuReg(rs.getInt(4));
                lista.add(r);
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
    public int AgregarRol(Rol r) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "INSERT INTO rol VALUES (?,?,?)";
        try {
            st = cn.prepareStatement(consulta);
            st.setInt(1, r.getIdRol());
            st.setString(2, r.getNomRol());
            st.setString(3, r.getEstadoRol());
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
    public int EditarRol(Rol r) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "UPDATE rol SET nomRol=?,estadoRol=? WHERE idRol=?";
        try {
            st = cn.prepareStatement(consulta);

            st.setString(1, r.getNomRol());
            st.setString(2, r.getEstadoRol());
            st.setInt(3, r.getIdRol());

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
    public int EliminarRol(int id) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "DELETE FROM rol WHERE idRol=?";
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
    public int RetornarCodigoRol() {

        int res = -1;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT AUTO_INCREMENT\n"
                + "FROM  INFORMATION_SCHEMA.TABLES\n"
                + "WHERE TABLE_SCHEMA = 'prywebventa'\n"
                + "AND   TABLE_NAME   = 'rol';";
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
