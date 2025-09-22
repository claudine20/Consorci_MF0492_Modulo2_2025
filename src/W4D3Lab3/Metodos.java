package W4D3Lab3;

import java.util.Scanner;

public class Metodos {

    /**
     * Muestra una representacion grafica de los resultados electorales en barras.
     *
     * @param partidos Un array de objetos Partido.
     */
    public void mostrarResultado(Partido[] partidos) {
        // Itera a traves de cada partido en el array
        for (Partido partido : partidos) {
            System.out.printf("%-15s: ", partido.getNombre()); // Imprime el nombre del partido justificado a la izquierda
            int barras = (int) (partido.getPorcentaje() / 2); // Calcula el numero de barras, asumiendo que 1 barra = 2%
            for (int i = 0; i < barras; i++) {
                System.out.print("#"); // Imprime una barra por cada 2% de votos
            }
            // Imprime el porcentaje real al final de la barra
            System.out.printf(" %.2f%%\n", partido.getPorcentaje());
        }
    }

    /**
     * Intenta limpiar la pantalla de la consola.
     * Funciona en entornos que soporten el comando "cls" (Windows) o "clear" (Unix/Linux/Mac).
     */
    public void limpiarPantalla() {
        // Intenta ejecutar el comando de limpieza de pantalla del sistema operativo
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            // Si el comando falla, imprime un mensaje para indicar que no se pudo limpiar la pantalla
            System.out.println("\n-------------------------------------------");
            System.out.println("No se puede limpiar la pantalla. Scroll down.");
            System.out.println("-------------------------------------------\n");
        }
    }

    /**
     * Pausa la ejecucion del programa y espera a que el usuario presione Enter.
     *
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void aprietaEnter(Scanner scanner) {
        System.out.println("\nPara continuar, aprieta ENTER.");
        scanner.nextLine(); // Lee la entrada de la linea para esperar a que el usuario presione enter
    }
}
