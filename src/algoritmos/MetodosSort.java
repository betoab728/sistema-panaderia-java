package algoritmos;

import java.util.ArrayList;
import models.entities.Producto;

public class MetodosSort {

    private static void swap_buble(Object[] data, int i, int j) {
        Object aux = data[i];
        data[i] = data[j];
        data[j] = aux;
    }

    public void bubbleSort(Object[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (((Comparable) data[j])
                        .compareTo(data[j + 1]) > 0) {
                    swap_buble(data, j, j + 1);
                }
            }
        }
    }

    private static void swap(ArrayList<Producto> products, int i, int j) {
        Producto aux = products.get(i);
        products.set(i, products.get(j));
        products.set(j, aux);
    }

    public void OrdenarQuickSort(ArrayList<Producto> products) {
        quicksort1(products);
    }

    private void quicksort1(ArrayList<Producto> products) {
        quicksort2(products, 0, products.size() - 1);
    }

    private void quicksort2(ArrayList<Producto> products, int izq, int der) {
        if (izq >= der) {
            return;
        }
        int i = izq, d = der;
        if (izq != der) {
            int pivote;
            Producto aux;
            pivote = izq;
            while (izq != der) {
                while (products.get(der).getProducto_precio() >= products.get(pivote).getProducto_precio() && izq < der) {
                    der--;
                }
                while (products.get(izq).getProducto_precio() < products.get(pivote).getProducto_precio() && izq < der) {
                    izq++;
                }
                if (der != izq) {
                    swap(products, der, izq);
                }
            }
            if (izq == der) {
                quicksort2(products, i, izq - 1);
                quicksort2(products, izq + 1, d);
            }
        } else {
            return;
        }

    }

    public void ShellSort(ArrayList<Producto> productos) {
        int n = productos.size();
        Producto aux;
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                for (int j = i; j >= gap; j -= gap) {
                    if (productos.get(j - gap).getProducto_cantvendida() > productos.get(j).getProducto_cantvendida()) {
                        swap(productos, j, j - gap);
                    }

                }
            }
        }
    }

    public void insertionSort(ArrayList<Producto> productos) {

        int i = 1;
        Producto aux;

        while (i < productos.size()) {

            aux = productos.get(i);

            for (int k = i - 1; k >= 0; k--) {

                if (productos.get(k).getProducto_costo() > aux.getProducto_costo()) {

                    productos.set(k + 1, productos.get(k));
                    productos.set(k, aux);

                    System.out.println(productos.get(k).getProducto_costo());
                }

            }

            i++;
        }
    }

    private static int getIdxMinimo(Object[] data,
            int inicio) {
        int idxMin = inicio;
        for (int i = inicio; i < data.length; i++) {
            if (((Comparable) data[i])
                    .compareTo(data[idxMin]) < 0) {
                idxMin = i;
            }
        }
        return idxMin;
    }

    private static void selectionSort(Object[] data,
            int inicio) {
        if (inicio >= data.length) {
            return;
        }
        int min = getIdxMinimo(data, inicio);
        if (min != inicio) {
            swap_buble(data, inicio, min);
        }
        selectionSort(data, inicio + 1);
    }

    public void selectionSort(Object[] data) {
        selectionSort(data, 0);
    }

    //******************************MERGE SORT******************************************
    public void sortGivenArray(ArrayList<Producto> productos) {
        divide(0, productos.size() - 1, productos);
    }

    public void divide(int startIndex, int endIndex, ArrayList<Producto> productos) {

        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
            int mid = (endIndex + startIndex) / 2;
            divide(startIndex, mid, productos);
            divide(mid + 1, endIndex, productos);

            merger(productos, startIndex, mid, endIndex);
        }
    }

    public void merger(ArrayList<Producto> productos, int startIndex, int midIndex, int endIndex) {

        ArrayList<Producto> mergedSortedArray = new ArrayList();

        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;

        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if (productos.get(leftIndex).getProducto_cantvendida()<= productos.get(rightIndex).getProducto_cantvendida()) {
                mergedSortedArray.add(productos.get(leftIndex));
                leftIndex++;
            } else {
                mergedSortedArray.add(productos.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex <= midIndex) {
            mergedSortedArray.add(productos.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= endIndex) {
            mergedSortedArray.add(productos.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        while (i < mergedSortedArray.size()) {
            productos.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }

}
