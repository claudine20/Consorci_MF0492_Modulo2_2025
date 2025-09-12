package W4D2Lab2;

/**
 * Interfaz que define las operaciones basicas para una lista de numeros enteros.
 */
public interface IntList {

    /**
     * Anade un nuevo numero entero al final de la lista.
     *
     * @param number El numero entero a anadir.
     */
    void add(int number);

    /**
     * Recupera un numero entero de la lista por su indice (ID).
     *
     * @param id El indice del elemento a recuperar.
     * @return El numero entero en el indice especificado.
     */
    int get(int id);
}
