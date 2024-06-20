package services.impl;

import java.util.List;
import models.dao.PedidoConProductoDao;
import models.dao.impl.DaoFactory;
import models.entities.PedidoConProducto;

public class PedidoConProductoServiceImpl {

    PedidoConProductoDao pedidoConProductoDao;

    public PedidoConProductoServiceImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        pedidoConProductoDao = daoFactory.getPedidoConProductoDao();
    }

    public List<PedidoConProducto> listar() {
        return pedidoConProductoDao.findAll();
    }

  

}
