/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

/**
 *
 * @author ELIAS
 */
public class Categoria {
    
   int categoria_id;
   int  categoria_categoriaid;
   String categoria_nombre;

    public Categoria(int categoria_id, int categoria_categoriaid, String categoria_nombre) {
        this.categoria_id = categoria_id;
        this.categoria_categoriaid = categoria_categoriaid;
        this.categoria_nombre = categoria_nombre;
    }

    public Categoria() {
    }
    
    

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getCategoria_categoriaid() {
        return categoria_categoriaid;
    }

    public void setCategoria_categoriaid(int categoria_categoriaid) {
        this.categoria_categoriaid = categoria_categoriaid;
    }

    public String getCategoria_nombre() {
        return categoria_nombre;
    }

    public void setCategoria_nombre(String categoria_nombre) {
        this.categoria_nombre = categoria_nombre;
    }
    
    @Override
    public String toString(){
        return this.getCategoria_nombre();
    }
    
}
