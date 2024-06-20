package models.dao;

import java.util.List;

public interface EntityDao<T> {
    public void create(T entity);
    
    public T find(Object id);
    public List<T> findAll();
    
    public void update(T entity);
    public void delete(Object id);
    public List<T>  find_Cliente_Criterio(Object dni,Object nombre, Object criterio );
    public  T Login(T entity);
}
