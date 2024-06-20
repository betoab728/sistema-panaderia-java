package models.dao.impl;

import java.util.ArrayList;
import java.util.List;
import models.dao.ClienteDao;
import models.entities.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import utils.DBConn;

public class ClienteDaoDatabase implements ClienteDao {

    private Connection connection;
    private ResultSet resultSet;
    private CallableStatement callableStatement;

    @Override
    public void create(Cliente cliente) {

        try {
            connection = DBConn.getConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{CALL sp_insert_Cliente(?,?,?,?,?,?,?)}");

            callableStatement.setInt(1, cliente.getMembresia_id());
            callableStatement.setString(2, cliente.getCliente_orden());
            callableStatement.setString(3, cliente.getCliente_nombres());
            callableStatement.setString(4, cliente.getCliente_apellidos());
            callableStatement.setString(5, cliente.getCliente_edad());
            callableStatement.setString(6, cliente.getCliente_telefono());
             callableStatement.setString(7, cliente.getDni());

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
    public Cliente find(Object id) {
        Cliente cliente = null;

        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_find_Cliente(?)}");
            callableStatement.setString(1, id.toString());
            resultSet = callableStatement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setCliente_id(resultSet.getInt(1));
                cliente.setCliente_nombres(resultSet.getString(2));
                cliente.setCliente_apellidos(resultSet.getString(3));
                cliente.setMembresia_nombre(resultSet.getString(4));
                cliente.setCliente_edad(resultSet.getString(5));
                cliente.setCliente_telefono(resultSet.getString(6));
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

        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente;

        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_findAll_Cliente()}");
            resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setCliente_id(resultSet.getInt(1));
                 cliente.setDni(resultSet.getString(2));
                cliente.setCliente_nombres(resultSet.getString(3));
                cliente.setCliente_apellidos(resultSet.getString(4));
                cliente.setMembresia_nombre(resultSet.getString(5));
                cliente.setCliente_edad(resultSet.getString(6));
                cliente.setCliente_telefono(resultSet.getString(7));
                
                clientes.add(cliente);
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

        return clientes;
    }

    @Override
    public void update(Cliente cliente) {
        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_update_Cliente(?,?,?,?,?,?,?,?)}");

            callableStatement.setInt(1, cliente.getCliente_id());
            callableStatement.setInt(2, cliente.getMembresia_id());
            callableStatement.setString(3, cliente.getCliente_orden());
            callableStatement.setString(4, cliente.getCliente_nombres());
            callableStatement.setString(5, cliente.getCliente_apellidos());
            callableStatement.setString(6, cliente.getCliente_edad());
            callableStatement.setString(7, cliente.getCliente_telefono());
             callableStatement.setString(8, cliente.getDni());

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
        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_delete_Cliente(?)}");

            callableStatement.setInt(1, Integer.parseInt(id.toString()));

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
    
       
    public List<Cliente>  find_Cliente_Criterio(Object dni,Object nombre, Object criterio ) {
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_find_Cliente_Criterio(?,?,?)}");
            callableStatement.setString(1, dni.toString());
            callableStatement.setString(2, nombre.toString());
            callableStatement.setString(3, criterio.toString());
            resultSet = callableStatement.executeQuery();

             while (resultSet.next())  {
                cliente = new Cliente();
                cliente.setCliente_id(resultSet.getInt(1));
                cliente.setCliente_nombres(resultSet.getString(4));
                cliente.setCliente_apellidos(resultSet.getString(5));
                cliente.setDni(resultSet.getString(8));
              
                 clientes.add(cliente);
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

        return clientes;
    }

    @Override
    public Cliente Login(Cliente entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
