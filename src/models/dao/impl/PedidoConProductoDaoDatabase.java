package models.dao.impl;

import java.util.ArrayList;
import java.util.List;
import models.dao.PedidoConProductoDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import models.entities.PedidoConProducto;
import utils.DBConn;

public class PedidoConProductoDaoDatabase implements PedidoConProductoDao {

    private Connection connection;
    private ResultSet resultSet;
    private CallableStatement callableStatement;

    @Override
    public void create(PedidoConProducto entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PedidoConProducto find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PedidoConProducto> findAll() {
        List<PedidoConProducto> pedidosConProductos = new ArrayList<>();
        PedidoConProducto pedidoConProducto;

        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_findAll_Pedido()}");
            resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                pedidoConProducto = new PedidoConProducto();
                pedidoConProducto.setPedido_fecha(resultSet.getString(1));
                pedidoConProducto.setPedido_orden(resultSet.getString(2));
                pedidoConProducto.setCliente(resultSet.getString(3));
//                pedidoConProducto.setProducto_nombre(resultSet.getString(4));
                pedidoConProducto.setProducto_precio(resultSet.getString(4));

                pedidosConProductos.add(pedidoConProducto);
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

        return pedidosConProductos;
    }

    @Override
    public void update(PedidoConProducto entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PedidoConProducto> find_Cliente_Criterio(Object dni, Object nombre, Object criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PedidoConProducto Login(PedidoConProducto entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
