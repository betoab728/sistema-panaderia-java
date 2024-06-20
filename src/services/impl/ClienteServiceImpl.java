package services.impl;

import java.util.List;
import models.dao.ClienteDao;
import models.dao.impl.DaoFactory;
import models.entities.Cliente;
import services.ClienteService;

public class ClienteServiceImpl implements ClienteService {

    ClienteDao clienteDao;

    public ClienteServiceImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        clienteDao = daoFactory.getClienteDao();
    }

    @Override
    public void crear(Cliente cliente) {
        clienteDao.create(cliente);
    }

    @Override
    public Cliente buscar(Object id) {
        return clienteDao.find(id);
    }

    @Override
    public List<Cliente> listar() {
        return clienteDao.findAll();
    }

    @Override
    public void update(Cliente cliente) {
        clienteDao.update(cliente);
    }

    @Override
    public void borrar(Object id) {
        clienteDao.delete(id);
    }
        @Override
   public  List<Cliente> find_Cliente_Criterio(Object dni,Object nombre, Object criterio ){
      return clienteDao.find_Cliente_Criterio(dni, nombre, criterio);
   }

}
