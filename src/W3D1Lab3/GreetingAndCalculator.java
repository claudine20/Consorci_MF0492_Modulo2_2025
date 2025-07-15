package W3D1Lab3;

import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario

public class GreetingAndCalculator {

    // Se declara un objeto Scanner estático para que pueda ser utilizado por todos los métodos
    // sin tener que crearlo y cerrarlo repetidamente. Se cerrará una vez en el método main.
    private static Scanner scanner = new Scanner(System.in);

    /**
     * EJERCICIO 1.1 - SALUDAR!
     * Función que saluda y pide el nombre sin parámetros y sin valor de retorno (void).
     * Muestra el resultado directamente dentro de la función.
     */
    public void greet1() {
        System.out.println("\n--- EJERCICIO 1.1: Saludo sin parámetros ni retorno ---");
        System.out.print("Por favor, introduce un saludo (ej. Hola): "); // Pide al usuario que introduzca un saludo
        String greeting = scanner.nextLine(); // Lee el saludo introducido por el usuario

        System.out.print("Por favor, introduce tu nombre (ej. Andrés): "); // Pide al usuario que introduzca su nombre
        String name = scanner.nextLine(); // Lee el nombre introducido por el usuario

        System.out.println(greeting + " " + name); // Imprime el saludo y el nombre concatenados
    }

    /**
     * EJERCICIO 1.2 - SALUDAR!
     * Función que saluda con parámetros (saludo y nombre) y sin valor de retorno (void).
     * Muestra el resultado directamente dentro de la función.
     *
     * @param greeting El saludo a utilizar (ej. "Hola")
     * @param name El nombre de la persona a saludar (ej. "Andrés")
     */
    public void greet2(String greeting, String name) {
        System.out.println("\n--- EJERCICIO 1.2: Saludo con parámetros, sin retorno ---");
        System.out.println(greeting + " " + name); // Imprime el saludo y el nombre concatenados
    }

    /**
     * EJERCICIO 1.3 - SALUDAR!
     * Función que saluda con parámetros (saludo y nombre) y con valor de retorno (String).
     * Construye la cadena de saludo y la devuelve.
     *
     * @param greeting El saludo a utilizar (ej. "Hola")
     * @param name El nombre de la persona a saludar (ej. "Andrés")
     * @return Una cadena de texto con el saludo completo (ej. "Hola Andrés")
     */
    public String greet3(String greeting, String name) {
        // System.out.println("\n--- EJERCICIO 1.3: Saludo con parámetros y con retorno ---"); // Opcional: mensaje de inicio
        return greeting + " " + name; // Concatena el saludo y el nombre y los devuelve
    }

    // Métodos para las operaciones de la calculadora (EJERCICIO 2)
    /**
     * Suma dos números.
     * @param a Primer número.
     * @param b Segundo número.
     * @return La suma de a y b.
     */
    public double sum(double a, double b) {
        return a + b; // Devuelve la suma de los dos números
    }

    /**
     * Resta dos números.
     * @param a Primer número.
     * @param b Segundo número.
     * @return La resta de a y b.
     */
    public double subtract(double a, double b) {
        return a - b; // Devuelve la resta de los dos números
    }

    /**
     * Multiplica dos números.
     * @param a Primer número.
     * @param b Segundo número.
     * @return El producto de a y b.
     */
    public double multiply(double a, double b) {
        return a * b; // Devuelve el producto de los dos números
    }

    /**
     * Divide dos números.
     * @param a Dividendo.
     * @param b Divisor.
     * @return El cociente de a y b. Devuelve Double.NaN si el divisor es cero.
     */
    public double divide(double a, double b) {
        if (b == 0) { // Comprueba si el divisor es cero
            System.out.println("Error: No se puede dividir por cero."); // Muestra un mensaje de error
            return Double.NaN; // Devuelve "Not a Number" para indicar un resultado indefinido
        }
        return a / b; // Devuelve el cociente de los dos números
    }

    /**
     * EJERCICIO 2 - CALCULAR
     * Implementa una calculadora básica usando un switch para seleccionar la operación.
     * Incluye un bucle para seguir funcionando hasta que el usuario decida salir.
     */
    public void calculatorExercise() {
        System.out.println("\n--- EJERCICIO 2: Calculadora con Switch y Bucle ---");
        char operationChoice; // Variable para almacenar la operación elegida por el usuario
        double num1, num2; // Variables para almacenar los números de la operación
        double result; // Variable para almacenar el resultado de la operación

        do { // Bucle do-while para asegurar que el programa se ejecuta al menos una vez
            System.out.print("Introduce el primer número: "); // Pide el primer número
            while (!scanner.hasNextDouble()) { // Valida que la entrada sea un número
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                scanner.next(); // Consume la entrada no válida
            }
            num1 = scanner.nextDouble(); // Lee el primer número

            System.out.print("Introduce el segundo número: "); // Pide el segundo número
            while (!scanner.hasNextDouble()) { // Valida que la entrada sea un número
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                scanner.next(); // Consume la entrada no válida
            }
            num2 = scanner.nextDouble(); // Lee el segundo número

            System.out.print("Elige una operación (+, -, *, /) o 's' para salir: "); // Pide la operación o salir
            operationChoice = scanner.next().charAt(0); // Lee el primer carácter de la entrada como la operación
            scanner.nextLine(); // Consume el salto de línea pendiente

            result = 0; // Inicializa el resultado

            // Estructura switch para seleccionar la operación basada en la elección del usuario
            switch (operationChoice) {
                case '+': // Si la operación es suma
                    result = sum(num1, num2); // Llama al método sum
                    System.out.println("Resultado: " + num1 + " + " + num2 + " = " + result); // Muestra el resultado
                    break; // Sale del switch
                case '-': // Si la operación es resta
                    result = subtract(num1, num2); // Llama al método subtract
                    System.out.println("Resultado: " + num1 + " - " + num2 + " = " + result); // Muestra el resultado
                    break; // Sale del switch
                case '*': // Si la operación es multiplicación
                    result = multiply(num1, num2); // Llama al método multiply
                    System.out.println("Resultado: " + num1 + " * " + num2 + " = " + result); // Muestra el resultado
                    break; // Sale del switch
                case '/': // Si la operación es división
                    result = divide(num1, num2); // Llama al método divide
                    // El mensaje de error para división por cero ya se maneja dentro de divide()
                    if (!Double.isNaN(result)) { // Si el resultado no es NaN (no hubo división por cero)
                        System.out.println("Resultado: " + num1 + " / " + num2 + " = " + result); // Muestra el resultado
                    }
                    break; // Sale del switch
                case 's': // Si la opción es 's' (salir)
                case 'S': // También acepta 'S' mayúscula
                    System.out.println("Saliendo de la calculadora..."); // Mensaje de salida
                    break; // Sale del switch
                default: // Si la operación no es válida
                    System.out.println("Operación no válida. Por favor, usa +, -, *, / o 's' para salir."); // Mensaje de error
                    break; // Sale del switch
            }
            System.out.println(); // Imprime una línea en blanco para mejor formato
        } while (operationChoice != 's' && operationChoice != 'S'); // El bucle continúa mientras la opción no sea 's' o 'S'
    }

    /**
     * Método auxiliar para el EJERCICIO 3: CACATÚA CACAHUETES!
     * Simula a la cacatúa durmiéndose.
     */
    public void dormirse() {
        System.out.println("zzZzzzz..."); // Imprime el sonido de la cacatúa durmiéndose
    }

    /**
     * Método auxiliar para el EJERCICIO 3: CACATÚA CACAHUETES!
     * Pregunta al usuario qué comida le da a la cacatúa.
     * @return La comida introducida por el usuario.
     */
    public String pideComida() {
        System.out.print("¿Qué comida le das a la cacatúa? "); // Pide al usuario que introduzca la comida
        return scanner.nextLine(); // Lee y devuelve la comida introducida
    }

    /**
     * EJERCICIO 3: CACATÚA CACAHUETES!
     * Simula una cacatúa que pide cacahuetes hasta que se le dan.
     */
    public void parrotPeanutsExercise() {
        System.out.println("\n--- EJERCICIO 3: Cacatúa Cacahuetes! ---");
        String food; // Variable para almacenar la comida introducida por el usuario

        // Bucle while que continúa mientras la comida no sea "cacahuetes"
        while (true) { // Bucle infinito que se romperá con un 'break'
            System.out.println("¡Cacatúa cacahuetes!"); // La cacatúa pide cacahuetes
            food = pideComida().toLowerCase(); // Llama a pideComida() y convierte la entrada a minúsculas

            if (food.equals("cacahuetes")) { // Comprueba si la comida es "cacahuetes"
                dormirse(); // Si es "cacahuetes", llama al método dormirse()
                break; // Sale del bucle, terminando el programa de la cacatúa
            } else {
                System.out.println("La cacatúa no quiere eso."); // Si no son cacahuetes, la cacatúa no los quiere
            }
        }
    }

    // Método principal (main) donde se ejecutan todos los ejercicios
    public static void main(String[] args) {
        // Crea una instancia de la clase para poder llamar a sus métodos no estáticos
        GreetingAndCalculator program = new GreetingAndCalculator();

        // --- EJERCICIO 1: SALUDAR! ---
        program.greet1(); // Llama a la función greet1 (sin parámetros, sin return)

        // Llama a la función greet2 (con parámetros, sin return)
        program.greet2("Hola", "Andrés");

        // Llama a la función greet3 (con parámetros, con return) y muestra el resultado en main()
        String fullGreeting = program.greet3("Saludos", "María"); // Almacena el resultado devuelto
        System.out.println("\n--- EJERCICIO 1.3: Saludo con parámetros y con retorno (mostrado en main) ---");
        System.out.println(fullGreeting); // Imprime el resultado almacenado

        // --- EJERCICIO 2: CALCULAR ---
        program.calculatorExercise(); // Llama al método del ejercicio de la calculadora

        // --- EJERCICIO 3: CACATÚA CACAHUETES! ---
        program.parrotPeanutsExercise(); // Llama al método del ejercicio de la cacatúa

        scanner.close(); // Cierra el objeto Scanner al finalizar el programa para liberar recursos
        System.out.println("\n--- Todos los ejercicios han finalizado ---"); // Mensaje de fin de programa
    }
}
