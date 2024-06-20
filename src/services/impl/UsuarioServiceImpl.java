/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import models.dao.UsuarioDao;
import models.dao.impl.DaoFactory;
import models.entities.Usuario;
import services.UsuarioService;

/**
 *
 * @author ELIAS
 */
public class UsuarioServiceImpl implements UsuarioService {
       UsuarioDao usuarioDao;

    public UsuarioServiceImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        usuarioDao = daoFactory.getUsuarioDao();
    }

    @Override
    public void crear(Usuario usuario) {
          usuarioDao.create(usuario);
    }

    @Override
    public Usuario buscar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> listar() {
         return usuarioDao.findAll();
    }

    @Override
    public void update(Usuario usuario) {

         usuarioDao.update(usuario);
    }
    
    public Usuario Login(Usuario usuario) {
        
        return usuarioDao.Login(usuario);
    }
    

    @Override
    public void borrar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
