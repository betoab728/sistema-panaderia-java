package services;

import java.util.List;
import models.entities.Cliente;

public interface ClienteService {
    public void crear(Cliente cliente);
    
    public Cliente buscar(Object id);
    public List<Cliente> listar();
    
    public void update(Cliente cliente);
    public void borrar(Object id);
    
    public List<Cliente>  find_Cliente_Criterio(Object dni,Object nombre, Object criterio );
    
}
