package W4D1Lab1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Definición de la clase principal
public class TiendaZapateria {

    public static void main(String[] args) {
        // Crear listas separadas para cada tipo de zapato, ya que no comparten una superclase.
        List<Elegante> elegantes = new ArrayList<>();
        List<Casual> casuales = new ArrayList<>();
        List<Deporte> deportivos = new ArrayList<>();

        // Inicializar el inventario con instancias de cada clase de zapato.
        inicializarInventario(elegantes, casuales, deportivos);

        // Mostrar todo el inventario de la zapatería.
        mostrarInventario(elegantes, casuales, deportivos);

        Scanner scanner = new Scanner(System.in);
        double gastoTotal = 0.0;
        String eleccion = "";

        // Bucle principal para la compra.
        do {
            System.out.println("\n¿Qué tipo de zapatos quieres comprar?");
            System.out.println("1- ELEGANTES");
            System.out.println("2- CASUAL");
            System.out.println("3- DEPORTIVOS");
            System.out.print("O escribe 'salir' para finalizar la compra: ");
            eleccion = scanner.nextLine().toLowerCase();

            switch (eleccion) {
                case "1":
                    gastoTotal += gestionarCompra(scanner, elegantes);
                    break;
                case "2":
                    gastoTotal += gestionarCompra(scanner, casuales);
                    break;
                case "3":
                    gastoTotal += gestionarCompra(scanner, deportivos);
                    break;
                case "salir":
                    System.out.println("\nHas decidido salir de la compra.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige 1, 2, 3 o escribe 'salir'.");
            }

            // Mostrar el gasto total acumulado en cada paso.
            System.out.printf("Gasto actual: %.2f€\n", gastoTotal);

        } while (!eleccion.equals("salir"));

        // Mensaje final y resumen de la compra.
        System.out.println("\n--- Resumen de la Compra ---");
        System.out.printf("Gasto total: %.2f€\n", gastoTotal);
        System.out.println("¡Hasta la próxima!");

        scanner.close();
    }

    // Método para inicializar las listas con datos de ejemplo.
    private static void inicializarInventario(List<Elegante> elegantes, List<Casual> casuales, List<Deporte> deportivos) {
        // Añadir zapatos elegantes a su lista
        elegantes.add(new Elegante("Calvin Klein", "Oxford Clásico", "Cuero", 42, 120.0));
        elegantes.add(new Elegante("Zara", "Stiletto Negro", "Sintético", 38, 59.99));

        // Añadir zapatos casuales a su lista
        casuales.add(new Casual("Vans", "Old Skool", "Lona", 43, 75.0));
        casuales.add(new Casual("Converse", "All Star", "Lona", 40, 65.50));

        // Añadir zapatos deportivos a su lista
        deportivos.add(new Deporte("Nike", "Air Max 270", "Malla", 44, 150.0));
        deportivos.add(new Deporte("Adidas", "Ultraboost", "Tejido", 45, 180.0));
    }

    // Método para mostrar el inventario completo, llamando a cada lista por separado.
    private static void mostrarInventario(List<Elegante> elegantes, List<Casual> casuales, List<Deporte> deportivos) {
        System.out.println("--- Inventario de la Zapatería ---");
        System.out.println("\n--- ZAPATOS ELEGANTES ---");
        for (Elegante zapato : elegantes) {
            zapato.mostrarCaracteristicas();
            System.out.println("--------------------");
        }
        System.out.println("\n--- ZAPATOS CASUALES ---");
        for (Casual zapato : casuales) {
            zapato.mostrarCaracteristicas();
            System.out.println("--------------------");
        }
        System.out.println("\n--- ZAPATOS DEPORTIVOS ---");
        for (Deporte zapato : deportivos) {
            zapato.mostrarCaracteristicas();
            System.out.println("--------------------");
        }
    }

    // Método genérico para gestionar la compra en cada tipo de lista de zapatos.
    // Usamos el tipo de lista genérico List<?> para que el método sea reutilizable.
    private static double gestionarCompra(Scanner scanner, List<?> listaZapatos) {
        System.out.print("\nIntroduce el modelo que quieres comprar: ");
        String modeloCompra = scanner.nextLine().toLowerCase();

        for (Object zapatoObj : listaZapatos) {
            // Usamos 'instanceof' para determinar el tipo de objeto y llamar a sus métodos.
            if (zapatoObj instanceof Elegante) {
                Elegante zapato = (Elegante) zapatoObj;
                if (zapato.getModelo().toLowerCase().equals(modeloCompra)) {
                    System.out.printf("¡%s añadido a tu compra!\n", zapato.getModelo());
                    return zapato.getPrecio(); // Devuelve el precio para sumarlo al total.
                }
            } else if (zapatoObj instanceof Casual) {
                Casual zapato = (Casual) zapatoObj;
                if (zapato.getModelo().toLowerCase().equals(modeloCompra)) {
                    System.out.printf("¡%s añadido a tu compra!\n", zapato.getModelo());
                    return zapato.getPrecio();
                }
            } else if (zapatoObj instanceof Deporte) {
                Deporte zapato = (Deporte) zapatoObj;
                if (zapato.getModelo().toLowerCase().equals(modeloCompra)) {
                    System.out.printf("¡%s añadido a tu compra!\n", zapato.getModelo());
                    return zapato.getPrecio();
                }
            }
        }

        System.out.println("Modelo no encontrado. Intenta de nuevo.");
        return 0.0; // Si no se encuentra el modelo, se devuelve 0.
    }
}
