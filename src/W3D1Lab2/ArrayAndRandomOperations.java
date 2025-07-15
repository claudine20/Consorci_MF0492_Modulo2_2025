package W3D1Lab2;

import java.util.ArrayList; // Importa la clase ArrayList para arrays dinámicos
import java.util.Arrays;    // Importa la clase Arrays para utilidades con arrays
import java.util.Random;    // Importa la clase Random para generar números aleatorios
import java.util.Scanner;   // Importa la clase Scanner para leer la entrada del usuario

public class ArrayAndRandomOperations {

    /**
     * EJERCICIO 1: Crear un array con tamaño definido por el usuario, rellenarlo y mostrarlo.
     */
    public void dynamicArrayExercise() {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario
        System.out.println("\n--- EJERCICIO 1: Array Dinámico ---");

        int size = 0; // Variable para almacenar el tamaño del array
        boolean validInput = false; // Bandera para controlar la validación de la entrada

        // Bucle para asegurar que el usuario introduce un tamaño válido (entero positivo)
        while (!validInput) {
            System.out.print("Introduce el tamaño deseado para el array: "); // Pide al usuario el tamaño
            if (scanner.hasNextInt()) { // Verifica si la próxima entrada es un entero
                size = scanner.nextInt(); // Lee el tamaño
                if (size > 0) { // Comprueba si el tamaño es positivo
                    validInput = true; // Si es válido, sale del bucle
                } else {
                    System.out.println("El tamaño del array debe ser un número positivo. Inténtalo de nuevo.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número entero.");
                scanner.next(); // Consume la entrada no válida para evitar un bucle infinito
            }
        }
        scanner.nextLine(); // Consume el salto de línea pendiente después de leer el entero

        String[] userArray = new String[size]; // Declara y crea un array de Strings con el tamaño especificado

        System.out.println("Por favor, introduce " + size + " elementos para rellenar el array:"); // Informa al usuario

        // Bucle para rellenar el array con elementos introducidos por el usuario
        for (int i = 0; i < size; i++) {
            System.out.print("Elemento " + (i + 1) + ": "); // Pide cada elemento
            userArray[i] = scanner.nextLine(); // Lee el elemento y lo guarda en el array
        }

        System.out.println("\nEl array rellenado es:"); // Mensaje para mostrar el array
        System.out.println(Arrays.toString(userArray)); // Muestra el array completo usando Arrays.toString()
        // Nota: El scanner se cerrará al final en el método main.
    }

    /**
     * EJERCICIO 2: Identificar números pares e impares en un array y separarlos en nuevos arrays.
     */
    public void evenOddNumbersExercise() {
        System.out.println("\n--- EJERCICIO 2: Números Pares e Impares ---");

        // Array inicial de 20 números enteros
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        // ArrayLists para almacenar números pares e impares (tamaño dinámico)
        ArrayList<Integer> evenNumbers = new ArrayList<>(); // Crea un ArrayList para números pares
        ArrayList<Integer> oddNumbers = new ArrayList<>();  // Crea un ArrayList para números impares

        System.out.println("Array original: " + Arrays.toString(originalArray)); // Muestra el array original

        // Bucle para iterar sobre el array original
        for (int number : originalArray) { // Bucle for-each para recorrer cada elemento
            if (number % 2 == 0) { // Comprueba si el número es par (el resto de la división por 2 es 0)
                evenNumbers.add(number); // Si es par, lo añade al ArrayList de pares
            } else {
                oddNumbers.add(number); // Si es impar, lo añade al ArrayList de impares
            }
        }

        System.out.println("Números pares: " + evenNumbers.toString()); // Muestra los números pares
        System.out.println("Números impares: " + oddNumbers.toString()); // Muestra los números impares
    }

    /**
     * EJERCICIO 3: Seleccionar aleatoriamente un ganador de vacaciones y permitir repetir.
     */
    public void ibizaVacationPrizeExercise() {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada
        Random random = new Random(); // Crea un objeto Random para generar números aleatorios
        System.out.println("\n--- EJERCICIO 3: Premio Vacaciones en Ibiza ---");

        // Listado de nombres de personas en un array
        String[] participants = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Heidi"};

        char playAgain; // Variable para controlar si se juega de nuevo

        do {
            // Genera un índice aleatorio dentro del rango del array de participantes
            int winnerIndex = random.nextInt(participants.length); // random.nextInt(N) devuelve un número entre 0 (inclusive) y N (exclusivo)

            // Obtiene el nombre del ganador usando el índice aleatorio
            String winner = participants[winnerIndex];

            System.out.println("\n¡Y el ganador de las vacaciones en Ibiza es... " + winner + "!"); // Muestra el ganador

            System.out.print("¿Otra vez? (S/N): "); // Pregunta al usuario si quiere repetir
            String response = scanner.nextLine().toLowerCase(); // Lee la respuesta y la convierte a minúsculas

            // Comprueba si la respuesta comienza con 's' para continuar
            playAgain = response.length() > 0 ? response.charAt(0) : 'n'; // Si la respuesta está vacía, asume 'n'

        } while (playAgain == 's'); // El bucle continúa mientras el usuario responda 's'

        System.out.println("¡Gracias por participar! ¡Hasta la próxima!"); // Mensaje de despedida
        // Nota: El scanner se cerrará al final en el método main.
    }

    // Método principal (conductor) para ejecutar todos los ejercicios
    public static void main(String[] args) {
        // Crea una instancia de la clase para poder llamar a sus métodos
        ArrayAndRandomOperations program = new ArrayAndRandomOperations();
        Scanner mainScanner = new Scanner(System.in); // Se crea un solo Scanner para toda la aplicación

        // Llama al primer ejercicio
        program.dynamicArrayExercise();

        // Llama al segundo ejercicio
        program.evenOddNumbersExercise();

        // Llama al tercer ejercicio
        program.ibizaVacationPrizeExercise();

        mainScanner.close(); // Cierra el objeto Scanner al finalizar el programa para liberar recursos
        System.out.println("\n--- Todos los ejercicios han finalizado ---"); // Mensaje de fin de programa
    }
}

