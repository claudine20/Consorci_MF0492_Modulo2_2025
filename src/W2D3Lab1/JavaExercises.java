package W2D3Lab1;

import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario

public class JavaExercises {

    /**
     * EJERCICIO 1: CONDICIONALES JAVA
     * Pregunta la edad al usuario y, según la respuesta, le contesta en qué etapa de la vida está.
     * Incluye manejo de errores para edades fuera de un rango razonable.
     */
    public void conditionalExercise() {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para la entrada
        System.out.println("--- EJERCICIO 1: CONDICIONALES ---");
        System.out.print("Por favor, introduce tu edad: "); // Pide al usuario que introduzca su edad

        if (scanner.hasNextInt()) { // Verifica si la entrada es un número entero
            int age = scanner.nextInt(); // Lee la edad introducida por el usuario

            // +EXTRA: Mensaje de error para edades fuera de rango
            if (age < 6) {
                System.out.println("Error: La edad introducida es demasiado baja. ¡Seguro que eres más mayor!");
            } else if (age > 120) {
                System.out.println("Error: La edad introducida es demasiado alta. Por favor, introduce una edad válida.");
            } else if (age >= 6 && age <= 11) { // Rango de edad para primaria
                System.out.println("Estás en primaria.");
            } else if (age >= 12 && age <= 16) { // Rango de edad para secundaria
                System.out.println("Estás en secundaria.");
            } else if (age >= 17 && age <= 25) { // Rango de edad para universidad (ejemplo)
                System.out.println("Estás en la universidad.");
            } else { // Cualquier otra edad se considera trabajando (ejemplo)
                System.out.println("Estás trabajando.");
            }
        } else {
            System.out.println("Entrada no válida. Por favor, introduce un número entero para la edad.");
        }
        // No cerramos el scanner aquí porque lo usaremos en otros métodos.
        // Se cerrará en el método main al final.
    }

    /**
     * EJERCICIO 2: BUCLE EN JAVA
     * Cuenta del 20 al 10 en orden descendente y muestra el cuadrado de cada número.
     */
    public void loopExercise() {
        System.out.println("\n--- EJERCICIO 2: BUCLE ---");
        System.out.println("Contando del 20 al 10 en orden descendente y mostrando su cuadrado:");

        // Bucle for que itera desde 20 hasta 10 (inclusive)
        for (int i = 20; i >= 10; i--) {
            int square = i * i; // Calcula el cuadrado del número actual
            System.out.println("Número: " + i + ", Cuadrado: " + square); // Muestra el número y su cuadrado
        }
    }

    /**
     * EJERCICIO 3: MEDIA DE EDADES DE TUS PADRES
     * Pregunta el nombre y la edad de la madre y el padre, y luego calcula y muestra
     * la media de sus edades.
     */
    public void averageParentAges() {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para la entrada
        System.out.println("\n--- EJERCICIO 3: MEDIA DE EDADES ---");

        // Preguntar datos de la madre
        System.out.print("Introduce el nombre de tu madre: ");
        String motherName = scanner.nextLine(); // Lee el nombre de la madre

        int motherAge = 0;
        boolean validMotherAge = false;
        while (!validMotherAge) { // Bucle para asegurar una entrada de edad válida
            System.out.print("Introduce la edad de tu madre: ");
            if (scanner.hasNextInt()) { // Verifica si la entrada es un número entero
                motherAge = scanner.nextInt(); // Lee la edad de la madre
                if (motherAge > 0 && motherAge < 120) { // Validación simple de edad
                    validMotherAge = true;
                } else {
                    System.out.println("Edad no válida. Por favor, introduce una edad razonable (entre 1 y 120).");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número entero para la edad.");
                scanner.next(); // Consume la entrada no válida para evitar un bucle infinito
            }
        }
        scanner.nextLine(); // Consume el salto de línea pendiente después de leer el entero

        // Preguntar datos del padre
        System.out.print("Introduce el nombre de tu padre: ");
        String fatherName = scanner.nextLine(); // Lee el nombre del padre

        int fatherAge = 0;
        boolean validFatherAge = false;
        while (!validFatherAge) { // Bucle para asegurar una entrada de edad válida
            System.out.print("Introduce la edad de tu padre: ");
            if (scanner.hasNextInt()) { // Verifica si la entrada es un número entero
                fatherAge = scanner.nextInt(); // Lee la edad del padre
                if (fatherAge > 0 && fatherAge < 120) { // Validación simple de edad
                    validFatherAge = true;
                } else {
                    System.out.println("Edad no válida. Por favor, introduce una edad razonable (entre 1 y 120).");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número entero para la edad.");
                scanner.next(); // Consume la entrada no válida
            }
        }
        scanner.nextLine(); // Consume el salto de línea pendiente

        // Calcular la media de las edades (usando double para los decimales)
        double averageAge = (double) (motherAge + fatherAge) / 2;

        // Mostrar la frase final
        System.out.printf("Tu madre se llama %s y tiene %d años, y tu padre se llama %s y tiene %d años, y la media de sus edades es %.2f%n",
                motherName, motherAge, fatherName, fatherAge, averageAge);
        // %.2f formatea el double a dos decimales
    }

    public static void main(String[] args) {
        JavaExercises exercises = new JavaExercises(); // Crea una instancia de la clase JavaExercises
        Scanner mainScanner = new Scanner(System.in); // Scanner para la entrada principal

        // Ejecuta el ejercicio de condicionales
        exercises.conditionalExercise();

        // Ejecuta el ejercicio de bucle
        exercises.loopExercise();

        // Ejecuta el ejercicio de media de edades
        exercises.averageParentAges();

        mainScanner.close(); // Cierra el objeto Scanner al finalizar el programa
        System.out.println("\n--- Fin de los ejercicios ---");
    }
}
