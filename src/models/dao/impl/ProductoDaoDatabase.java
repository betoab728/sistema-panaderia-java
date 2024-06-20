package models.dao.impl;

import java.util.ArrayList;
import java.util.List;
import models.dao.ProductoDao;
import models.entities.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import utils.DBConn;

public class ProductoDaoDatabase implements ProductoDao {

    private Connection connection;
    private ResultSet resultSet;
    private CallableStatement callableStatement;

    @Override
    public void create(Producto producto) {

       try {
            connection = DBConn.getConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{CALL sp_insert_Producto(?,?,?,?)}");

            callableStatement.setInt(1, producto.getCategoria_id());
            callableStatement.setString(2,producto.getProducto_nombre() );
            callableStatement.setDouble(3,producto.getProducto_costo() );
            callableStatement.setDouble(4,producto.getProducto_precio() );
          
            callableStatement.executeUpdate();
            connection.commit();
            callableStatement.close();
            connection.close();
        } catch (SQLException ex) {
            try {
                connection.rollback();
                callableStatement.close();
                connection.close();
            } catch (SQLException exp) {
                System.out.println(exp.getMessage());
            }
        }
          
        
    }

    @Override
    public Producto find(Object id) {
         Producto producto = null;

        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_find_Producto(?)}");
            callableStatement.setString(1, id.toString());
            resultSet = callableStatement.executeQuery();

            if (resultSet.next()) {
                producto.setProducto_id(resultSet.getInt(1));
                producto.setProducto_nombre(resultSet.getString(2));
                producto.setCategoria_nombre(resultSet.getString(3));
                producto.setProducto_costo(resultSet.getInt(4));
                producto.setProducto_precio(resultSet.getInt(5));
                producto.setProducto_cantvendida(resultSet.getInt(6));
            }

            resultSet.close();
            callableStatement.close();
            connection.close();
        } catch (SQLException ex) {
            try {
                resultSet.close();
                callableStatement.close();
                connection.close();
            } catch (SQLException exp) {
                System.out.println(exp.getMessage());
            }
        }

        return producto;
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> productos = new ArrayList<>();
        Producto producto;

        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_findAll_Producto()}");
            resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                producto = new Producto();
                producto.setProducto_id(resultSet.getInt(1));
                producto.setProducto_nombre(resultSet.getString(2));
                producto.setCategoria_nombre(resultSet.getString(3));
                producto.setProducto_costo(resultSet.getInt(4));
                producto.setProducto_precio(resultSet.getInt(5));
                producto.setProducto_cantvendida(resultSet.getInt(6));
                productos.add(producto);
            }

            resultSet.close();
            callableStatement.close();
            connection.close();
        } catch (SQLException ex) {
            try {
                System.out.println(ex.getMessage());
                resultSet.close();
                callableStatement.close();
                connection.close();
            } catch (SQLException exp) {
                System.out.println(exp.getMessage());
            }
        }

        return productos;
    }

    @Override
    public void update(Producto producto) {
        
           try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_update_Producto(?,?,?,?,?)}");

            callableStatement.setInt(1, producto.getProducto_id());
            callableStatement.setInt(2, producto.getCategoria_id());
            callableStatement.setString(3, producto.getProducto_nombre());
            callableStatement.setDouble(4, producto.getProducto_costo());
            callableStatement.setDouble(5, producto.getProducto_precio());
            

            callableStatement.executeUpdate();
            callableStatement.close();
            connection.close();
        } catch (SQLException ex) {
            try {
                callableStatement.close();
                connection.close();
            } catch (SQLException exp) {
                System.out.println(exp.getMessage());
            }
        }
        

    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> find_Cliente_Criterio(Object dni, Object nombre, Object criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto Login(Producto entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
