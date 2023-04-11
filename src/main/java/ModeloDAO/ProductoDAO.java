package ModeloDAO;

import Config.MySQLConexion;
import Interfaces.Iproducto;
import Modelo.Categoria;
import Modelo.Producto;
import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO implements Iproducto {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Producto> ListarProducto() {

        ArrayList<Producto> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT p.idPro,p.nomPro,p.stockPro,p.precioPro,p.estadoPro,p.idCat,c.nomCat,p.idProve,pr.nomProve \n"
                + "FROM producto p\n"
                + "INNER JOIN categoria c ON (p.idCat=c.idCat)\n"
                + "INNER JOIN proveedor pr ON (p.idProve=pr.idProve)";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdPro(rs.getInt(1));
                p.setNomPro(rs.getString(2));
                p.setStockPro(rs.getInt(3));
                p.setPrecioPro(rs.getDouble(4));
                p.setEstadoPro(rs.getString(5));

                Categoria c = new Categoria();
                c.setIdCat(rs.getInt(6));
                c.setNomCat(rs.getString(7));

                Proveedor pr = new Proveedor();
                pr.setIdProve(rs.getInt(8));
                pr.setNomProve(rs.getString(9));

                p.setCategoria(c);
                p.setProveedor(pr);

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
    public int AgregarProducto(Producto p) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "INSERT INTO producto VALUES (?,?,?,?,?,?,?)";
        try {
            st = cn.prepareStatement(consulta);
            st.setInt(1, p.getIdPro());
            st.setString(2, p.getNomPro());
            st.setInt(3, p.getStockPro());
            st.setDouble(4, p.getPrecioPro());
            st.setString(5, p.getEstadoPro());
            st.setInt(6, p.getCategoria().getIdCat());
            st.setInt(7, p.getProveedor().getIdProve());
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
    public int EditarProducto(Producto p) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "UPDATE producto SET nomPro=?,stockPro=?,precioPro=?,"
                + "estadoPro=?,idCat=?,idProve=? WHERE idPro=?";
        try {
            st = cn.prepareStatement(consulta);

            st.setString(1, p.getNomPro());
            st.setInt(2, p.getStockPro());
            st.setDouble(3, p.getPrecioPro());
            st.setString(4, p.getEstadoPro());
            st.setInt(5, p.getCategoria().getIdCat());
            st.setInt(6, p.getProveedor().getIdProve());
            st.setInt(7, p.getIdPro());

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
    public int EliminarProducto(int id) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "DELETE FROM producto WHERE idPro=?";
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
    public int RetornarCodigoProducto() {

        int res = -1;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT AUTO_INCREMENT\n"
                + "FROM  INFORMATION_SCHEMA.TABLES\n"
                + "WHERE TABLE_SCHEMA = 'prywebventa'\n"
                + "AND   TABLE_NAME   = 'producto';";
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
    public ArrayList<Producto> ListarProductosActivos() {
        ArrayList<Producto> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT p.idPro,p.nomPro,p.stockPro,p.precioPro,p.estadoPro,p.idCat,c.nomCat,p.idProve,pr.nomProve \n"
                + "FROM producto p\n"
                + "INNER JOIN categoria c ON (p.idCat=c.idCat)\n"
                + "INNER JOIN proveedor pr ON (p.idProve=pr.idProve)\n"
                + "WHERE p.estadoPro='ON' AND c.estadoCat='ON' AND pr.estadoProve='ON' AND p.stockPro>0";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdPro(rs.getInt(1));
                p.setNomPro(rs.getString(2));
                p.setStockPro(rs.getInt(3));
                p.setPrecioPro(rs.getDouble(4));
                p.setEstadoPro(rs.getString(5));

                Categoria c = new Categoria();
                c.setIdCat(rs.getInt(6));
                c.setNomCat(rs.getString(7));

                Proveedor pr = new Proveedor();
                pr.setIdProve(rs.getInt(8));
                pr.setNomProve(rs.getString(9));

                p.setCategoria(c);
                p.setProveedor(pr);

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

}
