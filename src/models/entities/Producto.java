package models.entities;

import java.util.Comparator;

public class Producto implements Comparable<Producto> {

    int producto_id;
    int categoria_id;
    String producto_nombre;
    double producto_costo;
    double producto_precio;
    int producto_cantvendida;
    String categoria_nombre;

    @Override
    public int compareTo(Producto o) {
        return PRODUCTO_COMPARATOR_NATURAL_ORDER.compare(this, o);
    }

    public Producto() {
    }

    private static final Comparator<Producto> PRODUCTO_COMPARATOR_NATURAL_ORDER = Comparator.comparing(Producto::getProducto_nombre);

    public Comparator<Producto> bycantidad = Comparator.comparing(Producto::getProducto_cantvendida);

    public Producto(String producto_nombre, int id, int id_categoria, double costo, double precio, int cantvendida, String nombre_categoria) {
        this.producto_nombre = producto_nombre;
        this.producto_id  = id;
        this.categoria_id = id_categoria;
        this.producto_costo = costo;
        this.producto_precio = precio;
        this.producto_cantvendida = cantvendida;
        this.categoria_nombre = nombre_categoria;
    }
    
    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public double getProducto_costo() {
        return producto_costo;
    }

    public void setProducto_costo(double producto_costo) {
        this.producto_costo = producto_costo;
    }

    public double getProducto_precio() {
        return producto_precio;
    }

    public void setProducto_precio(double producto_precio) {
        this.producto_precio = producto_precio;
    }

    public int getProducto_cantvendida() {
        return producto_cantvendida;
    }

    public void setProducto_cantvendida(int producto_cantvendida) {
        this.producto_cantvendida = producto_cantvendida;
    }

    public String getCategoria_nombre() {
        return categoria_nombre;
    }

    public void setCategoria_nombre(String categoria_nombre) {
        this.categoria_nombre = categoria_nombre;
    }

    @Override
    public String toString() {
        return "nombre = " + producto_nombre + ", codigo = " + producto_id + ", id_categoria = " + categoria_id
                + ", costo = " + producto_costo + ", precio = " + producto_precio + ", cantidad vendida = " + producto_cantvendida;
    }

}
