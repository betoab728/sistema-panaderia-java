/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

/**
 *
 * @author ELIAS
 */
public class Membresia {
   int membresia_id;
   String membresia_nombre;

    public Membresia(int membresia_id, String membresia_nombre) {
        this.membresia_id = membresia_id;
        this.membresia_nombre = membresia_nombre;
    }

    public int getMembresia_id() {
        return membresia_id;
    }

    public void setMembresia_id(int membresia_id) {
        this.membresia_id = membresia_id;
    }

    public String getMembresia_nombre() {
        return membresia_nombre;
    }

    public void setMembresia_nombre(String membresia_nombre) {
        this.membresia_nombre = membresia_nombre;
    }
   
   
}
