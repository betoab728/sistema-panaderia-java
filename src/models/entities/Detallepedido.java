/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

/**
 *
 * @author ELIAS
 */
public class Detallepedido {
    
    int detallepedido_id;
    int producto_id;
    int pedido_id;
    int detallepedido_cantidad;
    double detallepedido_precio;

    public Detallepedido(int detallepedido_id, int producto_id, int pedido_id, int detallepedido_cantidad, double detallepedido_precio) {
        this.detallepedido_id = detallepedido_id;
        this.producto_id = producto_id;
        this.pedido_id = pedido_id;
        this.detallepedido_cantidad = detallepedido_cantidad;
        this.detallepedido_precio = detallepedido_precio;
    }

    public int getDetallepedido_id() {
        return detallepedido_id;
    }

    public void setDetallepedido_id(int detallepedido_id) {
        this.detallepedido_id = detallepedido_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public int getDetallepedido_cantidad() {
        return detallepedido_cantidad;
    }

    public void setDetallepedido_cantidad(int detallepedido_cantidad) {
        this.detallepedido_cantidad = detallepedido_cantidad;
    }

    public double getDetallepedido_precio() {
        return detallepedido_precio;
    }

    public void setDetallepedido_precio(double detallepedido_precio) {
        this.detallepedido_precio = detallepedido_precio;
    }
    
    
    
}
