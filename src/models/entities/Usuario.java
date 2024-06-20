/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

/**
 *
 * @author ELIAS
 */
public class Usuario {
    private int idusuario;
    private String nombre;
    private String contraseña;

    public Usuario(int idusuario, String nombre, String contraseña) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
