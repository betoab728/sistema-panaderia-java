package models.entities;

import java.util.Comparator;

/**
 *
 * @author yeico
 */
public class Pedido {
    
    
    int orden;
    String cliente;
    int edadcliente;
    String MembresiaCliente;
    int productos;
    double totalpedido;

    public Pedido() {
    }
    
    public Pedido(int orden, String cliente, int edadcliente, String membresia, int productos, double totalpedido) {
        this.orden = orden;
        this.cliente = cliente;
        this.edadcliente = edadcliente;
        this.MembresiaCliente = membresia;
        this.productos = productos;
        this.totalpedido = totalpedido;
    }
    
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getEdadcliente() {
        return edadcliente;
    }

    public void setEdadcliente(int edadcliente) {
        this.edadcliente = edadcliente;
    }

    public String getMembresiaCliente() {
        return MembresiaCliente;
    }

    public void setMembresiaCliente(String MembresiaCliente) {
        this.MembresiaCliente = MembresiaCliente;
    }

    public int getProductos() {
        return productos;
    }

    public void setProductos(int productos) {
        this.productos = productos;
    }

    public double getTotalpedido() {
        return totalpedido;
    }

    public void setTotalpedido(double totalpedido) {
        this.totalpedido = totalpedido;
    }
    
    //comnparadores para ordenar los pedidos
    
    
   public  Comparator <Pedido> byorden=Comparator.comparing(Pedido::getOrden);
   public Comparator <Pedido> byedad=Comparator.comparing(Pedido::getEdadcliente);
   public Comparator <Pedido> bytipo=Comparator.comparing(Pedido::getMembresiaCliente);

    
     //reglas del negocio
 
  public   Comparator<Pedido> ReglasDelNegocio=bytipo.thenComparing(byedad).thenComparing(byorden);
    
    
}
