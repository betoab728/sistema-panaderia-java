package models.entities;

public class ArbolClientes {

    private Nodo<Cliente> raiz;

    public ArbolClientes() {

    }

    public Cliente existe(String busqueda) {
        return existe(this.raiz, busqueda);
    }

    public Cliente existe(Nodo<Cliente> nodo, String busqueda) {
        if (nodo == null) {
            return null;
        }

        if (nodo.getDato().getDni().equals(busqueda)) {
            return nodo.getDato();
        } else if (busqueda.compareTo(nodo.getDato().getDni()) < 0) {
            return existe(nodo.getIzquierda(), busqueda);
        } else {
            return existe(nodo.getDerecha(), busqueda);
        }
    }

    public void insertar(Cliente cliente) {
        if (this.raiz == null) {
            this.raiz = new Nodo(cliente);
        } else {
            this.insertar(this.raiz, cliente);
        }
    }

    private void insertar(Nodo<Cliente> padre, Cliente cliente) {
        if (cliente.getDni().compareTo(padre.getDato().getDni()) > 0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(cliente));
            } else {
                this.insertar(padre.getDerecha(), cliente);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(cliente));
            } else {
                this.insertar(padre.getIzquierda(), cliente);
            }
        }
    }

    private void preorden(Nodo<Cliente> cliente) {
        if (cliente != null) {
            System.out.println(cliente.getDato().getDni());
            preorden(cliente.getIzquierda());
            preorden(cliente.getDerecha());
        }
    }

    private void inorden(Nodo<Cliente> cliente) {
        if (cliente != null) {
            inorden(cliente.getIzquierda());
            System.out.println(cliente.getDato().getDni());
            inorden(cliente.getDerecha());
        }
    }

    private void postorden(Nodo<Cliente> cliente) {
        if (cliente != null) {
            inorden(cliente.getIzquierda());
            inorden(cliente.getDerecha());
            System.out.println(cliente.getDato().getDni());
        }
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }

}
