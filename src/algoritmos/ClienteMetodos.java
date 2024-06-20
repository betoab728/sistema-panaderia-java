package algoritmos;

import java.util.LinkedList;
import models.entities.Cliente;

public class ClienteMetodos extends PrioridadCliente{

    public LinkedList<Cliente> elementos = new LinkedList();

    public ClienteMetodos() {
    }

    public void enqueue(Cliente e) {
        cola.offer(e);
    }

    public Cliente dequeue() {
        if (!elementos.isEmpty()) {
            Cliente e = elementos.getFirst();
            elementos.remove(0);
            return e;
        } else {
            System.out.println("la cola está vacía");
            return null;
        }
    }

    public void clear() {
        elementos.clear();
    }

    public void print() {

        System.out.println("COLA DE ATENCIÓN\n---------------------------\n");
        while (!cola.isEmpty()) {
            System.out.println(cola.poll().toString());
        }

        System.out.println("---------------------------\n");

    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }

    public Cliente peek() {
        return elementos.getFirst();
    }

}
