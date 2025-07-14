package W2D3Lab2;

import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario

public class CharityCollectionExercise {

    /**
     * EJERCICIO 1: SWITCH
     * Pregunta la estación del año y responde con un mensaje específico.
     */
    public void switchExercise() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- EJERCICIO 1: SWITCH - Estaciones del Año ---");
        System.out.print("¿Cuál es tu estación favorita? (primavera, verano, otoño, invierno): ");
        String season = scanner.nextLine().toLowerCase(); // Lee la estación y la convierte a minúsculas

        switch (season) {
            case "primavera":
                System.out.println("¡Ah, la primavera! La sangre altera.");
                break;
            case "verano":
                System.out.println("¡Verano! Tiempo de sol, playa y diversión.");
                break;
            case "otoño":
                System.out.println("El otoño, con sus colores cálidos y sus hojas cayendo.");
                break;
            case "invierno":
                System.out.println("¡Invierno! Ideal para un chocolate caliente y una manta.");
                break;
            default:
                System.out.println("Esa no es una estación válida. Por favor, elige entre primavera, verano, otoño o invierno.");
                break;
        }
        // No cerramos el scanner aquí, ya que main lo cerrará.
    }

    /**
     * EJERCICIO 2: WHILE
     * Simula la recaudación de caridad, preguntando repetidamente hasta que el usuario dice 'no'.
     * Al final, muestra el total de gente que ayudó y el dinero recaudado.
     */
    public void charityCollection() {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para la entrada
        System.out.println("\n--- EJERCICIO 2: BUCLE WHILE - Recaudación de Caridad ---");

        int peopleHelped = 0;
        double totalMoney = 0.0;
        String response = "";

        while (true) { // Bucle infinito que se romperá con un 'break'
            System.out.print("¿Una ayudita para la asociación benéfica? (sí/no): ");
            response = scanner.nextLine().toLowerCase(); // Lee la respuesta y la convierte a minúsculas

            if (response.equals("sí") || response.equals("si")) {
                System.out.print("¿Cuánto quieres poner? (cantidad numérica): ");
                if (scanner.hasNextDouble()) { // Verifica si la entrada es un número decimal
                    double amount = scanner.nextDouble();
                    if (amount > 0) {
                        totalMoney += amount; // Suma la cantidad al total
                        peopleHelped++; // Incrementa el contador de gente
                        System.out.println("¡Muchas gracias por tu contribución!");
                    } else {
                        System.out.println("Por favor, introduce una cantidad positiva.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor, introduce una cantidad numérica.");
                    scanner.next(); // Consume la entrada no válida
                }
                scanner.nextLine(); // Consume el salto de línea pendiente
            } else if (response.equals("no")) {
                System.out.println("Entendido. ¡Me deprimo y me voy para casa! Gracias de todos modos.");
                break; // Sale del bucle
            } else {
                System.out.println("Respuesta no válida. Por favor, responde 'sí' o 'no'.");
            }
        }

        System.out.printf("Al final, has ayudado a %d personas y has recaudado un total de %.2f euros.%n",
                peopleHelped, totalMoney);
        // No cerramos el scanner aquí, ya que main lo cerrará.
    }

    /**
     * EJERCICIO 3: SWITCH - WHILE - El Archivo Sonoro
     * Permite al usuario elegir un sonido y escuchar su onomatopeya,
     * repitiendo hasta que el usuario decida no escuchar más.
     */
    public void soundFilePlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- EJERCICIO 3: SWITCH - WHILE - El Archivo Sonoro ---");

        char continuePlaying; // Variable para controlar el bucle do-while

        do {
            System.out.println("\nElige un sonido para escuchar:");
            System.out.println("1 - Cohete");
            System.out.println("2 - Moto");
            System.out.println("3 - Gato");
            System.out.println("4 - Perro");
            System.out.print("Introduce el número del sonido que quieres escuchar: ");

            if (scanner.hasNextByte()) { // Verifica si la entrada es un byte
                byte choice = scanner.nextByte(); // Lee la elección del usuario

                switch (choice) {
                    case 1:
                        System.out.println("¡Ziuuum!");
                        break;
                    case 2:
                        System.out.println("¡Brrrmmm!");
                        break;
                    case 3:
                        System.out.println("¡Miau!");
                        break;
                    case 4:
                        System.out.println("¡Guau guau!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elige un número entre 1 y 4.");
                        break;
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                scanner.next(); // Consume la entrada no válida
            }
            scanner.nextLine(); // Consume el salto de línea pendiente

            System.out.print("¿Quieres escuchar otro sonido? (s/n): ");
            String response = scanner.nextLine().toLowerCase();
            continuePlaying = response.length() > 0 ? response.charAt(0) : 'n'; // Obtiene el primer carácter o 'n' si está vacío

        } while (continuePlaying == 's'); // Continúa si la respuesta es 's'

        System.out.println("¡Hasta la próxima!");
        // No cerramos el scanner aquí.
    }

    public static void main(String[] args) {
        CharityCollectionExercise exercise = new CharityCollectionExercise(); // Crea una instancia de la clase
        Scanner mainScanner = new Scanner(System.in); // Crea un único Scanner para toda la aplicación

        // Llama a cada uno de los ejercicios
        exercise.switchExercise();
        exercise.charityCollection();
        exercise.soundFilePlayer();

        mainScanner.close(); // Cierra el scanner al finalizar el programa
        System.out.println("\n---- Fin de todos los ejercicios ----");
    }
}

