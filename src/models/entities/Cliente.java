package models.entities;

public class Cliente  {
    
    public enum membresia{BLACK,ORO,PLATA,CLASICO};

    int cliente_id;
    int membresia_id;
    String  cliente_orden;
    private String cliente_nombres;
    private String cliente_apellidos;
    private String cliente_edad;
    private String cliente_telefono;
    private String membresia_nombre;
     private String dni;
    
    public Cliente() {
        
    }

    public Cliente(int cliente_id, int membresia_id, String cliente_orden, String cliente_nombres, String cliente_apellidos, String edad, String telefono, String membresia, String dni) {
        this.cliente_id = cliente_id;
        this.membresia_id = membresia_id;
        this.cliente_orden = cliente_orden;
        this.cliente_nombres = cliente_nombres;
        this.cliente_apellidos = cliente_apellidos;
        this.cliente_edad = edad;
        this.cliente_telefono = telefono;
        this.membresia_nombre = membresia;
        this.dni = dni;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getMembresia_id() {
        return membresia_id;
    }

    public void setMembresia_id(int membresia_id) {
        this.membresia_id = membresia_id;
    }

    public String getCliente_orden() {
        return cliente_orden;
    }

    public void setCliente_orden(String cliente_orden) {
        this.cliente_orden = cliente_orden;
    }

    public String getCliente_nombres() {
        return cliente_nombres;
    }

    public void setCliente_nombres(String cliente_nombres) {
        this.cliente_nombres = cliente_nombres;
    }

    public String getCliente_apellidos() {
        return cliente_apellidos;
    }

    public void setCliente_apellidos(String cliente_apellidos) {
        this.cliente_apellidos = cliente_apellidos;
    }

    public String getCliente_edad() {
        return cliente_edad;
    }

    public void setCliente_edad(String cliente_edad) {
        this.cliente_edad = cliente_edad;
    }

    public String getCliente_telefono() {
        return cliente_telefono;
    }

    public void setCliente_telefono(String cliente_telefono) {
        this.cliente_telefono = cliente_telefono;
    }

    public String getMembresia_nombre() {
        return membresia_nombre;
    }

    public void setMembresia_nombre(String membresia_nombre) {
        this.membresia_nombre = membresia_nombre;
    }
    
    
}
    
    