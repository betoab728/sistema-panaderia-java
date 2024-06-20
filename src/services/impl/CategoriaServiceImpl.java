/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import models.dao.CategoriaDao;
import models.dao.impl.DaoFactory;
import models.entities.Categoria;
import services.CategoriaService;

/**
 *
 * @author ELIAS
 */
public class CategoriaServiceImpl implements CategoriaService{

    CategoriaDao categoriaDao;
    public CategoriaServiceImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        categoriaDao = daoFactory.getCategoriaDao();
    }
    
    
    @Override
    public void crear(Categoria categoria) {
        categoriaDao.create(categoria);
    }

    @Override
    public Categoria buscar(Object id) {
     return categoriaDao.find(id);
    }

    @Override
    public List<Categoria> listar() {
      return categoriaDao.findAll();
    }

    @Override
    public void update(Categoria categoria) {
         categoriaDao.update(categoria);
    }

    @Override
    public void borrar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
