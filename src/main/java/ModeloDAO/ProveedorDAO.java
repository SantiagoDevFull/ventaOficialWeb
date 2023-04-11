package ModeloDAO;

import Config.MySQLConexion;
import Interfaces.Iproveedor;
import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProveedorDAO implements Iproveedor {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Proveedor> ListarProveedor() {

        ArrayList<Proveedor> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT p.idProve,p.nomProve,p.telProve,p.direProve,p.estadoProve,\n"
                + "(SELECT count(*) FROM producto pro WHERE pro.idProve=p.idProve) \n"
                + "FROM proveedor p";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setIdProve(rs.getInt(1));
                p.setNomProve(rs.getString(2));
                p.setTelProve(rs.getString(3));
                p.setDireProve(rs.getString(4));
                p.setEstadoProve(rs.getString(5));
                p.setNumProductosReg(rs.getInt(6));
                lista.add(p);
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
    public int AgregarProveedor(Proveedor p) {

        int res = 0;
        cn = MySQLConexion.getConexion();
        String consulta = "INSERT INTO proveedor VALUES (?,?,?,?,?)";
        try {
            st = cn.prepareStatement(consulta);
            st.setInt(1, p.getIdProve());
            st.setString(2, p.getNomProve());
            st.setString(3, p.getTelProve());
            st.setString(4, p.getDireProve());
            st.setString(5, p.getEstadoProve());
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
    public int EditarProveedor(Proveedor p) {

        int res = 0;
        cn = MySQLConexion.getConexion();
        String consulta = "UPDATE proveedor SET nomProve=?,telProve=?,direProve=?,estadoProve=? WHERE idProve=?";
        try {
            st = cn.prepareStatement(consulta);

            st.setString(1, p.getNomProve());
            st.setString(2, p.getTelProve());
            st.setString(3, p.getDireProve());
            st.setString(4, p.getEstadoProve());
            st.setInt(5, p.getIdProve());

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
    public int EliminarProveedor(int id) {

        int res = 0;
        cn = MySQLConexion.getConexion();
        String consulta = "DELETE FROM proveedor WHERE idProve=?";
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
    public int RetornarCodigoProveedor() {

        int res = -1;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT AUTO_INCREMENT\n"
                + "FROM  INFORMATION_SCHEMA.TABLES\n"
                + "WHERE TABLE_SCHEMA = 'prywebventa'\n"
                + "AND   TABLE_NAME   = 'proveedor';";
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
