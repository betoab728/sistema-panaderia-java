/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.entities.Usuario;

/**
 *
 * @author ELIAS
 */
public interface UsuarioService {
    
    public void crear(Usuario usuario);
    
    public Usuario buscar(Object id);
    public List<Usuario> listar();
    
    public void update(Usuario usuario);
    public void borrar(Object id);
    public Usuario Login(Usuario usuario);
}
