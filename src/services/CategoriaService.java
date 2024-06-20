/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.entities.Categoria;

/**
 *
 * @author ELIAS
 */
public interface CategoriaService {
    
    public void crear(Categoria categoria);
    
    public Categoria buscar(Object id);
    public List<Categoria> listar();
    
    public void update(Categoria categoria);
    public void borrar(Object id);

}
