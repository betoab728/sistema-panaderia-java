package services.impl;

import java.util.List;
import models.dao.ProductoDao;
import models.dao.impl.DaoFactory;
import models.entities.Producto;
import services.ProductoService;

public class ProductoServiceImpl implements ProductoService {

    ProductoDao productoDao;

    public ProductoServiceImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        productoDao = daoFactory.getProductoDao();
    }

    @Override
    public void crear(Producto producto) {
        productoDao.create(producto);
    }

    @Override
    public Producto buscar(Object id) {
        return productoDao.find(id);
    }

    @Override
    public List<Producto> listar() {
        return productoDao.findAll();
    }

    @Override
    public void update(Producto producto) {
        productoDao.update(producto);
    }

    @Override
    public void borrar(Object id) {
        productoDao.delete(id);
    }

}
