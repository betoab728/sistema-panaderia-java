package models.dao.impl;

import models.dao.CategoriaDao;
import models.dao.ClienteDao;
import models.dao.PedidoConProductoDao;
import models.dao.ProductoDao;
import models.dao.UsuarioDao;

public class DaoFactory {

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }

    public ProductoDao getProductoDao() {
        return new ProductoDaoDatabase();
    }

    public ClienteDao getClienteDao() {
        return new ClienteDaoDatabase();
    }

    public PedidoConProductoDao getPedidoConProductoDao() {
        return new PedidoConProductoDaoDatabase();
    }
    
    public CategoriaDao getCategoriaDao() {
        return new CategoriaDaoDatabase();
    }
    public UsuarioDao getUsuarioDao() {
        return new UsuarioDaoDatabase();
    }
}
