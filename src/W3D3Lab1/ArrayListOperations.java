package W3D3Lab1;

import java.util.ArrayList; // Importa la clase ArrayList para usar listas dinámicas
import java.util.Scanner;   // Importa la clase Scanner para leer la entrada del usuario

public class ArrayListOperations {

    // Se declara un objeto Scanner estático para que pueda ser utilizado por todos los métodos
    // sin tener que crearlo y cerrarlo repetidamente. Se cerrará una vez en el método main.
    private static Scanner scanner = new Scanner(System.in);

    /**
     * EJERCICIO 1: Rellenar un ArrayList con números del 20 al 50 y mostrarlo.
     */
    public void fillAndDisplayArrayList() {
        System.out.println("--- EJERCICIO 1: Rellenar ArrayList y mostrar ---");

        // Crea un nuevo ArrayList que contendrá objetos de tipo Integer
        ArrayList<Integer> numbers = new ArrayList<>();

        // Bucle for para iterar desde 20 hasta 50 (inclusive)
        for (int i = 20; i <= 50; i++) {
            numbers.add(i); // Añade cada número al ArrayList
        }

        // Muestra todo el contenido del ArrayList final
        System.out.println("Contenido del ArrayList (números del 20 al 50):");
        System.out.println(numbers); // ArrayList.toString() se encarga de formatear la salida
    }

    /**
     * EJERCICIO 2: Preguntar al usuario elementos de Sant Jordi y mostrarlos al final.
     */
    public void santJordiElements() {
        System.out.println("\n--- EJERCICIO 2: Elementos de Sant Jordi ---");
        System.out.println("Introduce elementos típicos de la fiesta de Sant Jordi. Escribe 'salir' para finalizar.");

        // Crea un nuevo ArrayList que contendrá objetos de tipo String (los elementos)
        ArrayList<String> santJordiItems = new ArrayList<>();
        String input; // Variable para almacenar la entrada del usuario

        // Bucle do-while para asegurar que se pregunta al menos una vez
        do {
            System.out.print("Elemento: "); // Pide al usuario que introduzca un elemento
            input = scanner.nextLine(); // Lee la línea completa introducida por el usuario

            // Comprueba si la entrada no es "salir" (ignorando mayúsculas/minúsculas)
            if (!input.equalsIgnoreCase("salir")) {
                santJordiItems.add(input); // Si no es "salir", añade el elemento al ArrayList
            }

        } while (!input.equalsIgnoreCase("salir")); // El bucle continúa mientras la entrada no sea "salir"

        // Muestra todos los elementos introducidos por el usuario
        System.out.println("\nElementos de Sant Jordi introducidos:");
        if (santJordiItems.isEmpty()) { // Comprueba si el ArrayList está vacío
            System.out.println("No se introdujo ningún elemento.");
        } else {
            System.out.println(santJordiItems); // Muestra el ArrayList con los elementos
        }
    }

    /**
     * EJERCICIO 3: CRUD - Recepción internacional en Montserrat.
     * Gestiona una lista de 5 elegidos con adiciones y eliminaciones.
     */
    public void montserratReceptionCRUD() {
        System.out.println("\n--- EJERCICIO 3: CRUD - Recepción Internacional en Montserrat ---");

        // Crea un ArrayList inicial con los cinco elegidos
        ArrayList<String> attendees = new ArrayList<>();
        attendees.add("Dr. Elena Petrova");    // Índice 0
        attendees.add("Prof. Kenji Tanaka");   // Índice 1 (Puesto 2)
        attendees.add("Dra. Sofia Khan");      // Índice 2 (Puesto 3)
        attendees.add("Sr. Jean-Luc Dubois");  // Índice 3
        attendees.add("Ms. Emily White");      // Índice 4 (Último puesto)

        System.out.println("Lista inicial de asistentes:");
        System.out.println(attendees); // Muestra la lista inicial

        // Dos de ellos (puestos 2 y 3) se asustan y se dan de baja.
        // Puesto 2 es índice 1, Puesto 3 es índice 2.
        System.out.println("\n--- Puestos 2 y 3 se dan de baja ---");
        attendees.remove(2); // Elimina el elemento en el índice 2 (Dra. Sofia Khan)
        attendees.remove(1); // Elimina el elemento en el índice 1 (Prof. Kenji Tanaka)
        // ¡Ojo! Después de la primera eliminación, los índices se desplazan.
        // Si eliminamos el índice 2 primero, el antiguo índice 1 ahora es índice 1.

        System.out.println("Lista después de las bajas:");
        System.out.println(attendees); // Muestra la lista actualizada

        // Entra el personaje X en el puesto 2 (que ahora es el índice 1)
        String personajeX = "Dra. Ava Sharma";
        System.out.println("\n--- Entra " + personajeX + " en el puesto 2 ---");
        attendees.add(1, personajeX); // Añade a Personaje X en el índice 1 (puesto 2)

        System.out.println("Lista después de añadir a " + personajeX + ":");
        System.out.println(attendees); // Muestra la lista actualizada

        // La persona que está en el último puesto se enferma y recomienda a Y
        System.out.println("\n--- Último puesto se enferma, entra Personaje Y ---");
        int lastIndex = attendees.size() - 1; // Calcula el índice del último elemento
        String lastPerson = attendees.get(lastIndex); // Obtiene el nombre de la persona en el último puesto
        String personajeY = "Sr. Hiroshi Sato";

        System.out.println(lastPerson + " se enferma y recomienda a " + personajeY + ".");
        attendees.remove(lastIndex); // Elimina a la persona enferma del último puesto
        attendees.add(personajeY);   // Añade a Personaje Y al final de la lista

        System.out.println("Lista después de los cambios en el último puesto:");
        System.out.println(attendees); // Muestra la lista actualizada

        // En el último momento, se añade el personaje Z al puesto vacante (puesto 3).
        // El puesto 3 es el índice 2 en la lista actual.
        String personajeZ = "Prof. Marcus Bell";
        System.out.println("\n--- Último momento: entra " + personajeZ + " en el puesto 3 ---");
        attendees.add(2, personajeZ); // Añade a Personaje Z en el índice 2 (puesto 3)

        System.out.println("Lista final de asistentes a la recepción:");
        System.out.println(attendees); // Muestra la lista final
    }

    // Método principal (main) donde se ejecutan todos los ejercicios
    public static void main(String[] args) {
        // Crea una instancia de la clase para poder llamar a sus métodos no estáticos
        ArrayListOperations program = new ArrayListOperations();

        // Llama al primer ejercicio
        program.fillAndDisplayArrayList();

        // Llama al segundo ejercicio
        program.santJordiElements();

        // Llama al tercer ejercicio
        program.montserratReceptionCRUD();

        // Cierra el objeto Scanner al finalizar el programa para liberar recursos
        scanner.close();
        System.out.println("\n--- Todos los ejercicios han finalizado ---"); // Mensaje de fin de programa
    }
}

