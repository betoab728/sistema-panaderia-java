package models.entities;

public class PedidoConProducto {

    private String pedido_fecha;
    private String pedido_orden;
    private String cliente;
    private String producto_nombre;
    private String producto_precio;

    public PedidoConProducto() {
    }

    /**
     * @return the pedido_fecha
     */
    public String getPedido_fecha() {
        return pedido_fecha;
    }

    /**
     * @param pedido_fecha the pedido_fecha to set
     */
    public void setPedido_fecha(String pedido_fecha) {
        this.pedido_fecha = pedido_fecha;
    }

    /**
     * @return the pedido_orden
     */
    public String getPedido_orden() {
        return pedido_orden;
    }

    /**
     * @param pedido_orden the pedido_orden to set
     */
    public void setPedido_orden(String pedido_orden) {
        this.pedido_orden = pedido_orden;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the producto_nombre
     */
    public String getProducto_nombre() {
        return producto_nombre;
    }

    /**
     * @param producto_nombre the producto_nombre to set
     */
    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    /**
     * @return the producto_precio
     */
    public String getProducto_precio() {
        return producto_precio;
    }

    /**
     * @param producto_precio the producto_precio to set
     */
    public void setProducto_precio(String producto_precio) {
        this.producto_precio = producto_precio;
    }

}
