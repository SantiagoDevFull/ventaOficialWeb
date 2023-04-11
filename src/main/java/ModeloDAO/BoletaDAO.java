package ModeloDAO;

import Config.MySQLConexion;
import Interfaces.Iboleta;
import Modelo.BDetalle;
import Modelo.Boleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoletaDAO implements Iboleta {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public int RetornarCodigoBoleta() {

        int res = -1;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT AUTO_INCREMENT\n"
                + "FROM  INFORMATION_SCHEMA.TABLES\n"
                + "WHERE TABLE_SCHEMA = 'prywebventa'\n"
                + "AND   TABLE_NAME   = 'boleta';";
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
    public int ProcesarBoleta(Boleta b) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "INSERT INTO boleta VALUES (?,?,?,?,?)";
        try {
            st = cn.prepareStatement(consulta);
            st.setInt(1, b.getIdBoleta());
            st.setInt(2, b.getIdUsuario());
            st.setInt(3, b.getIdCliente());
            st.setString(4, b.getFechaCompra());
            st.setDouble(5, b.getTotal());
            res = st.executeUpdate();

            if (res > 0) {
                for (BDetalle x : b.getDetalle()) {

                    String consulta2 = "INSERT INTO boletadetalle VALUES (?,?,?,?,?,?)";
                    st = cn.prepareStatement(consulta2);

                    st.setInt(1, 0);
                    st.setInt(2, b.getIdBoleta());
                    st.setInt(3, x.getIdPro());
                    st.setInt(4, x.getCantidad());
                    st.setDouble(5, x.getPrecioPro());
                    st.setDouble(6, x.Importe());
                    res += st.executeUpdate();

                }
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
