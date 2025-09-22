package W4D3Lab2;
import java.util.ArrayList;

public class AlmacenJuguetes {

    public static void main(String[] args) {
        // Se crea un ArrayList para almacenar los objetos Juguete
        ArrayList<Juguete> inventario = new ArrayList<>();

        // Se instancian varios juguetes con diferentes dimensiones
        // Juguete 1: Volumen pequeno
        Juguete peluche = new Juguete("Oso de Peluche", 15.50, new Dimension(0.2, 0.3, 0.4));
        inventario.add(peluche);

        // Juguete 2: Volumen mediano
        Juguete cocheRC = new Juguete("Coche de Carreras", 45.00, new Dimension(0.5, 0.2, 0.8));
        inventario.add(cocheRC);

        // Juguete 3: Volumen grande
        Juguete casaMunecas = new Juguete("Casa de Munecas", 99.99, new Dimension(1.2, 0.8, 0.6));
        inventario.add(casaMunecas);

        // Llamar al metodo para imprimir todos los juguetes
        imprimirJuguetes(inventario);
    }

    /**
     * Imprime cada juguete de la lista con un salto de linea entre ellos.
     * Este metodo es reutilizable y evita repetir codigo.
     * @param juguetes Un ArrayList de objetos Juguete.
     */
    public static void imprimirJuguetes(ArrayList<Juguete> juguetes) {
        System.out.println("--- INVENTARIO DE JUGUETES ---");
        // Bucle for-each para iterar sobre cada juguete en el ArrayList
        for (Juguete juguete : juguetes) {
            System.out.println(juguete); // toString() se llama automaticamente
            System.out.println("-----------------------------------"); // Salto de linea para separar
        }
    }
}
