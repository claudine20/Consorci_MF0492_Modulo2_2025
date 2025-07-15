package W3D3Lab4;

import java.util.ArrayList; // Importa la clase ArrayList para usar listas dinámicas
import java.util.Scanner;   // Importa la clase Scanner para leer la entrada del usuario

// Importa la clase Disco.
// Asume que el archivo Disco.java está en el mismo directorio o en el classpath.

public class DiscoManager {

    // Se declara un objeto Scanner estático para que pueda ser utilizado por todos los métodos
    // sin tener que crearlo y cerrarlo repetidamente. Se cerrará una vez en el método main.
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- GESTIÓN DE COLECCIÓN DE DISCOS ---");

        // Crear un ArrayList con al menos 5 discos
        ArrayList<Disco> miColeccionDeDiscos = new ArrayList<>();

        // Añadir discos a la colección
        miColeccionDeDiscos.add(new Disco("Queen", "A Night at the Opera", 1975, 43.1));
        miColeccionDeDiscos.add(new Disco("Pink Floyd", "The Dark Side of the Moon", 1973, 42.9));
        miColeccionDeDiscos.add(new Disco("Michael Jackson", "Thriller", 1982, 42.2));
        miColeccionDeDiscos.add(new Disco("Adele", "21", 2011, 48.0));
        miColeccionDeDiscos.add(new Disco("The Beatles", "Abbey Road", 1969, 47.2));
        miColeccionDeDiscos.add(new Disco("Nirvana", "Nevermind", 1991, 41.2)); // Un disco extra

        // 1. Mostrar todos los discos, con todos los datos
        System.out.println("\n--- 1. Todos los discos en la colección ---");
        for (Disco disco : miColeccionDeDiscos) { // Bucle for-each para recorrer cada disco
            System.out.println(disco); // Imprime el objeto Disco, que usa su método toString()
        }

        // 2. Mostrar uno determinado: por ejemplo el año del tercer disco
        System.out.println("\n--- 2. Mostrar el año del tercer disco ---");
        // Los ArrayLists son base 0, así que el tercer disco está en el índice 2
        if (miColeccionDeDiscos.size() >= 3) { // Asegurarse de que el índice existe
            Disco tercerDisco = miColeccionDeDiscos.get(2); // Obtiene el tercer disco
            System.out.println("El año del tercer disco ('" + tercerDisco.getTitulo() + "') es: " + tercerDisco.getAno());
        } else {
            System.out.println("No hay suficientes discos en la colección para acceder al tercer disco.");
        }

        // 3. Cambiar ese mismo año y mostrar ese cambio.
        System.out.println("\n--- 3. Cambiar el año del tercer disco y mostrar el cambio ---");
        if (miColeccionDeDiscos.size() >= 3) {
            Disco tercerDisco = miColeccionDeDiscos.get(2); // Obtiene el tercer disco de nuevo
            int anoOriginal = tercerDisco.getAno(); // Guarda el año original
            tercerDisco.setAno(1983); // Cambia el año del tercer disco
            System.out.println("El año del tercer disco ('" + tercerDisco.getTitulo() + "') ha cambiado de " + anoOriginal + " a " + tercerDisco.getAno());
            System.out.println("Estado actualizado del tercer disco: " + tercerDisco); // Muestra el disco con el año modificado
        }

        // --- Etc hacer pruebas ---
        System.out.println("\n--- Otras pruebas ---");
        // Mostrar solo marca y duración del segundo disco
        if (miColeccionDeDiscos.size() >= 2) {
            Disco segundoDisco = miColeccionDeDiscos.get(1);
            System.out.println("El segundo disco es de '" + segundoDisco.getArtista() + "' y dura " + String.format("%.1f", segundoDisco.getDuracionMinutos()) + " minutos.");
        }

        // --- EXTRA: Buscador con contains() o con equals() ---
        System.out.println("\n--- EXTRA: Buscador de artista ---");
        System.out.print("Introduce el nombre de un artista para buscar en la colección: ");
        String artistaBuscado = scanner.nextLine(); // Lee el nombre del artista a buscar

        boolean encontrado = false; // Bandera para saber si se encontró el artista
        for (int i = 0; i < miColeccionDeDiscos.size(); i++) { // Recorre la lista por índice
            // Compara el nombre del artista del disco actual con el artista buscado (ignorando mayúsculas/minúsculas)
            if (miColeccionDeDiscos.get(i).getArtista().equalsIgnoreCase(artistaBuscado)) {
                System.out.println("¡Artista '" + artistaBuscado + "' encontrado!");
                System.out.println("Se encuentra en la posición (índice) " + i + " de la lista.");
                System.out.println("Disco: " + miColeccionDeDiscos.get(i)); // Muestra el disco completo
                encontrado = true; // Marca como encontrado
                // Si el artista puede aparecer varias veces y quieres mostrar todas las posiciones, no uses 'break'.
                // Si solo quieres la primera aparición, puedes usar 'break;' aquí.
            }
        }
        if (!encontrado) { // Si después de recorrer toda la lista no se encontró el artista
            System.out.println("El artista '" + artistaBuscado + "' no se encuentra en la colección.");
        }

        // --- NIVEL 2: Que todos estos datos los entre el cliente ---
        System.out.println("\n--- NIVEL 2: Añadir un nuevo disco (entrada de usuario) ---");
        System.out.println("Por favor, introduce los datos del nuevo disco:");

        System.out.print("Artista: ");
        String nuevoArtista = scanner.nextLine(); // Lee el artista

        System.out.print("Título: ");
        String nuevoTitulo = scanner.nextLine(); // Lee el título

        int nuevoAno = 0;
        boolean anoValido = false;
        while (!anoValido) { // Bucle para validar la entrada del año
            System.out.print("Año de lanzamiento: ");
            if (scanner.hasNextInt()) { // Verifica si la entrada es un entero
                nuevoAno = scanner.nextInt();
                if (nuevoAno > 1900 && nuevoAno <= 2100) { // Validación básica del año
                    anoValido = true;
                } else {
                    System.out.println("Año no válido. Por favor, introduce un año razonable (ej. entre 1900 y 2100).");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número entero para el año.");
                scanner.next(); // Consume la entrada no válida
            }
        }
        scanner.nextLine(); // Consume el salto de línea pendiente después de nextInt()

        double nuevaDuracion = 0.0;
        boolean duracionValida = false;
        while (!duracionValida) { // Bucle para validar la entrada de la duración
            System.out.print("Duración en minutos (ej. 45.5): ");
            if (scanner.hasNextDouble()) { // Verifica si la entrada es un número decimal
                nuevaDuracion = scanner.nextDouble();
                if (nuevaDuracion > 0) { // Validación básica de la duración
                    duracionValida = true;
                } else {
                    System.out.println("La duración debe ser un valor positivo.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número para la duración.");
                scanner.next(); // Consume la entrada no válida
            }
        }
        scanner.nextLine(); // Consume el salto de línea pendiente después de nextDouble()

        // Crea un nuevo objeto Disco con los datos introducidos por el usuario
        Disco nuevoDiscoUsuario = new Disco(nuevoArtista, nuevoTitulo, nuevoAno, nuevaDuracion);
        miColeccionDeDiscos.add(nuevoDiscoUsuario); // Añade el nuevo disco a la colección

        System.out.println("\n¡Nuevo disco añadido con éxito!");
        System.out.println("Colección actualizada (incluyendo el nuevo disco):");
        for (Disco disco : miColeccionDeDiscos) { // Muestra toda la colección de nuevo
            System.out.println(disco);
        }

        scanner.close(); // Cierra el objeto Scanner al finalizar el programa para liberar recursos
        System.out.println("\n--- Fin del programa de gestión de discos ---");
    }
}

