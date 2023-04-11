package ModeloDAO;

import Config.MySQLConexion;
import Interfaces.Icliente;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements Icliente {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Cliente> ListarCliente() {

        ArrayList<Cliente> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT c.idCli,c.docCli,c.numCli,c.nomCli,c.correoCli,c.passCli,c.estadoCli,\n"
                + "(SELECT count(*) FROM boleta b WHERE b.idCli=c.idCli)\n"
                + "FROM cliente c";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCli(rs.getInt(1));
                c.setDocCli(rs.getString(2));
                c.setNumCli(rs.getString(3));
                c.setNomCli(rs.getString(4));
                c.setCorreoCli(rs.getString(5));
                c.setPassCli(rs.getString(6));
                c.setEstadoCli(rs.getString(7));
                c.setNumBoletas(rs.getInt(8));
                lista.add(c);
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
    public int AgregarCliente(Cliente c) {

        int res = 0;
        cn = MySQLConexion.getConexion();
        String consulta = "INSERT INTO cliente VALUES (?,?,?,?,?,?,?)";
        try {
            st = cn.prepareStatement(consulta);
            st.setInt(1, c.getIdCli());
            st.setString(2, c.getDocCli());
            st.setString(3, c.getNumCli());
            st.setString(4, c.getNomCli());
            st.setString(5, c.getCorreoCli());
            st.setString(6, c.getPassCli());
            st.setString(7, c.getEstadoCli());
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
    public int EditarCliente(Cliente c) {

        int res = 0;
        cn = MySQLConexion.getConexion();
        String consulta = "UPDATE cliente SET docCli=?,numCli=?,nomCli=?,correoCli=?,passCli=?,estadoCli=?"
                + "WHERE idCli=?";
        try {
            st = cn.prepareStatement(consulta);

            st.setString(1, c.getDocCli());
            st.setString(2, c.getNumCli());
            st.setString(3, c.getNomCli());
            st.setString(4, c.getCorreoCli());
            st.setString(5, c.getPassCli());
            st.setString(6, c.getEstadoCli());
            st.setInt(7, c.getIdCli());

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
    public int EliminarCliente(int id) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "DELETE FROM cliente WHERE idCli=?";
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
    public int RetornarCodigoCliente() {

        int res = -1;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT AUTO_INCREMENT\n"
                + "FROM  INFORMATION_SCHEMA.TABLES\n"
                + "WHERE TABLE_SCHEMA = 'prywebventa'\n"
                + "AND   TABLE_NAME   = 'cliente';";
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

    @Override
    public ArrayList<Cliente> ListarClientesDNIactivos() {

        ArrayList<Cliente> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT c.idCli,c.docCli,c.numCli,c.nomCli,c.correoCli,c.passCli,c.estadoCli,\n"
                + "(SELECT count(*) FROM boleta b WHERE b.idCli=c.idCli)\n"
                + "FROM cliente c\n"
                + "WHERE c.docCli='DNI' AND c.estadoCli='ON'";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCli(rs.getInt(1));
                c.setDocCli(rs.getString(2));
                c.setNumCli(rs.getString(3));
                c.setNomCli(rs.getString(4));
                c.setCorreoCli(rs.getString(5));
                c.setPassCli(rs.getString(6));
                c.setEstadoCli(rs.getString(7));
                c.setNumBoletas(rs.getInt(8));
                lista.add(c);
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

}
