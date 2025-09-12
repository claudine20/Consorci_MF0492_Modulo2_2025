package W4D2Lab2;

import java.util.Arrays;

/**
 * Implementacion de IntList que utiliza un array que crece un 50% cuando se llena.
 */
public class IntArrayList implements IntList {
    private static final int DEFAULT_SIZE = 10; // Tamano inicial del array por defecto.
    private int[] data; // Array para almacenar los numeros enteros.
    private int size; // El numero actual de elementos en la lista.

    // Constructor que inicializa el array con el tamano por defecto.
    public IntArrayList() {
        this.data = new int[DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public void add(int number) {
        // Comprueba si el array esta lleno.
        if (size == data.length) {
            System.out.println("Array lleno. Redimensionando...");
            // Calcula el nuevo tamano del array (150% del tamano actual).
            int newSize = (int) (data.length * 1.5);
            // Crea un nuevo array con el nuevo tamano.
            int[] newData = new int[newSize];
            // Copia todos los elementos del array viejo al nuevo.
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            // Asigna el nuevo array a la variable de instancia.
            data = newData;
        }
        // Anade el nuevo numero al final del array y incrementa el tamano.
        data[size] = number;
        size++;
    }

    @Override
    public int get(int id) {
        // Valida que el indice este dentro de los limites de la lista.
        if (id < 0 || id >= size) {
            throw new IndexOutOfBoundsException("El indice " + id + " esta fuera de los limites de la lista.");
        }
        // Devuelve el elemento en el indice especificado.
        return data[id];
    }

    public int size() {
        return size;
    }

    public void printList() {
        System.out.println(Arrays.toString(Arrays.copyOf(data, size)));
    }
}

