package services;

import java.util.List;
import models.entities.Producto;

public interface ProductoService {
    public void crear(Producto producto);
    
    public Producto buscar(Object id);
    public List<Producto> listar();
    
    public void update(Producto producto);
    public void borrar(Object id);
}
