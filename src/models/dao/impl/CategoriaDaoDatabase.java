/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dao.impl;

import java.util.ArrayList;
import java.util.List;
import models.dao.CategoriaDao;
import models.entities.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import models.entities.Cliente;
import utils.DBConn;
/**
 *
 * @author ELIAS
 */
public class CategoriaDaoDatabase implements CategoriaDao {
    
    private Connection connection;
    private ResultSet resultSet;
    private CallableStatement callableStatement;

    @Override
    public void create(Categoria categoria) {

         try {
            connection = DBConn.getConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{CALL sp_insert_Categoria(?,?)}");

            callableStatement.setInt(1, categoria.getCategoria_categoriaid());
            callableStatement.setString(2,categoria.getCategoria_nombre() );
           

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
    public Categoria find(Object id) {

         Categoria categoria = null;

        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_find_Categoria(?)}");
            callableStatement.setString(1, id.toString());
            resultSet = callableStatement.executeQuery();

            if (resultSet.next()) {
                categoria.setCategoria_id(resultSet.getInt(1));
                categoria.setCategoria_categoriaid(resultSet.getInt(2));
                categoria.setCategoria_nombre(resultSet.getString(3));
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

        return categoria;
    }

    @Override
    public List<Categoria> findAll() {
        
          List<Categoria> categorias = new ArrayList<>();
        Categoria categoria;

        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_findAll_Categoria()}");
            resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                categoria = new Categoria();
                categoria.setCategoria_id(resultSet.getInt(1));
                categoria.setCategoria_categoriaid(resultSet.getInt(2));
                categoria.setCategoria_nombre(resultSet.getString(3));
                
                categorias.add(categoria);
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

        return categorias;

    }

    @Override
    public void update(Categoria categoria) {
        
         try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_update_Categoria(?,?,?)}");

            callableStatement.setInt(1, categoria.getCategoria_id());
            callableStatement.setInt(2, categoria.getCategoria_categoriaid());
            callableStatement.setString(3, categoria.getCategoria_nombre());
            

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
    public List<Categoria> find_Cliente_Criterio(Object dni, Object nombre, Object criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categoria Login(Categoria entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
