/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dao.impl;

import com.lowagie.text.pdf.codec.Base64;
import java.security.Key;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import models.dao.UsuarioDao;
import models.entities.Usuario;
import utils.DBConn;

/**
 *
 * @author ELIAS
 */
public class UsuarioDaoDatabase implements UsuarioDao {
    private Connection connection;
    private ResultSet resultSet;
    private CallableStatement callableStatement;
    @Override
    public void create(Usuario entity) {
        
            try {
            connection = DBConn.getConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{CALL sp_insert_Usuario(?,?)}");

            
            callableStatement.setString(1,entity.getNombre());           
            callableStatement.setString(2,entity.getContraseña());
           

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
    public Usuario find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
 

    @Override
    public List<Usuario> findAll() {
        
           List<Usuario> usuarios = new ArrayList<>();
            Usuario usuario;

        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_findAll_usuario()}");
            resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                usuario = new Usuario();
                 usuario.setIdusuario(resultSet.getInt(1));
                usuario.setNombre(resultSet.getString(2));
                usuario.setContraseña(resultSet.getString(3));
                
                usuarios.add(usuario);
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

        return usuarios;

        
    }

    @Override
    public void update(Usuario entity) {

         try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_update_Usuario(?,?,?)}");

            callableStatement.setInt(1, entity.getIdusuario());
            callableStatement.setString(2, entity.getNombre());
            callableStatement.setString(3, entity.getContraseña());
            

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
     
     public Usuario Login(Usuario usuario) {
         
        boolean result=false;
        Usuario  usuario_login = new Usuario();
        try {
             
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_find_Usuario(?,?)}");
            
            callableStatement.setString(1, usuario.getNombre());
            callableStatement.setString(2, usuario.getContraseña());
            
            resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
               
                usuario_login.setIdusuario(resultSet.getInt(1));
                usuario_login.setNombre(resultSet.getString(2));
                usuario_login.setContraseña(resultSet.getString(3));
                
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

        return usuario_login;

     }
 
   
     
    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> find_Cliente_Criterio(Object dni, Object nombre, Object criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
 

    // Clave de encriptación / desencriptación
  
    
}
