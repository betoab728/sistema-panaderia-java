package algoritmos;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import models.entities.Cliente;

public class PrioridadCliente {

    Comparator<Cliente> porMembresia = Comparator.comparing(Cliente::getMembresia_nombre);
    Comparator<Cliente> porNombre = Comparator.comparing(Cliente::getCliente_nombres);
    Comparator<Cliente> porEdad = Comparator.comparing(Cliente::getCliente_edad);
    Comparator<Cliente> porNumOrden = Comparator.comparing(Cliente::getCliente_orden);

    Comparator<Cliente> total = porMembresia.thenComparing(porEdad).thenComparing(porNumOrden);

    Queue<Cliente> cola = new PriorityQueue<>(total);

}
