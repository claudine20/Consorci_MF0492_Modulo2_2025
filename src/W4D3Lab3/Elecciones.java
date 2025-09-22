package W4D3Lab3;

import java.util.Scanner;

public class Elecciones {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // --- EJERCICIO 1: PRINTAR CARACTERES LETRAS MINUSCULAS ---
        System.out.println("--- Ejercicio 1: Imprimir Caracteres ---");
        System.out.println("Letras minusculas de la 'a' a la 'z':");
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println("\n");

        // +EXTRA: Imprimir mayusculas y minusculas sin los signos entre medio
        System.out.println("Letras mayusculas y minusculas sin simbolos intermedios:");
        for (char c = 'A'; c <= 'z'; c++) {
            // Se usa una condicion para omitir los caracteres especiales entre 'Z' y 'a'
            if (c > 'Z' && c < 'a') {
                continue;
            }
            System.out.print(c + " ");
        }
        System.out.println();

        // Pausa para que el usuario pueda ver el resultado
        System.out.println("\nPresiona ENTER para continuar con el siguiente ejercicio.");
        teclado.nextLine();

        // --- EJERCICIO 2: PRINTAR CARACTER SEGUN NUMERO ---
        System.out.println("--- Ejercicio 2: Caracter segun numero ---");
        boolean numeroValido = false;
        while (!numeroValido) {
            System.out.print("Introduce un numero entre 33 y 126: ");
            if (teclado.hasNextInt()) {
                int numero = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer del scanner

                if (numero >= 33 && numero <= 126) {
                    char caracter = (char) numero; // Convierte el numero a su caracter ASCII
                    System.out.println("El caracter que corresponde al numero " + numero + " es: " + caracter);
                    numeroValido = true;
                } else {
                    System.out.println("Numero fuera de rango. Por favor, intentalo de nuevo.");
                }
            } else {
                System.out.println("Entrada invalida. Por favor, introduce un numero.");
                teclado.next(); // Consumir el input incorrecto
            }
        }

        // Pausa antes de pasar al siguiente ejercicio
        System.out.println("\nPresiona ENTER para continuar con el ejercicio de las elecciones.");
        teclado.nextLine();

        // --- EJERCICIO 3: BARRAS RESULTADOS ELECTORALES ---
        Metodos metodos = new Metodos();
        boolean continuar = true;

        while (continuar) {
            metodos.limpiarPantalla(); // Limpia la pantalla al inicio de cada ciclo
            System.out.println("--- RESULTADOS ELECCIONES ---");

            // Se crea un array de objetos Partido con 5 instancias
            Partido[] partidos = new Partido[5];
            partidos[0] = new Partido("Partido A");
            partidos[1] = new Partido("Partido B");
            partidos[2] = new Partido("Partido C");
            partidos[3] = new Partido("Partido D");
            partidos[4] = new Partido("Partido E");

            double sumaPorcentajes = 0.0;
            // Bucle para pedir el porcentaje de votos para cada partido
            for (Partido partido : partidos) {
                boolean inputValido = false;
                while (!inputValido) {
                    System.out.print("Introduce el porcentaje de votos para " + partido.getNombre() + ": ");
                    if (teclado.hasNextDouble()) {
                        double porcentaje = teclado.nextDouble();
                        // Controla que el porcentaje no sea negativo y que la suma total no exceda el 100%
                        if (porcentaje < 0) {
                            System.out.println("El porcentaje no puede ser negativo.");
                        } else if (sumaPorcentajes + porcentaje > 100.0) {
                            System.out.println("La suma total de porcentajes no puede exceder el 100%. Por favor, introduce un valor menor.");
                        } else {
                            partido.setPorcentaje(porcentaje);
                            sumaPorcentajes += porcentaje;
                            inputValido = true; // El input es valido, se sale del bucle interno
                        }
                    } else {
                        System.out.println("Entrada invalida. Por favor, introduce un numero.");
                        teclado.next(); // Consume el input incorrecto para evitar un bucle infinito
                    }
                }
            }
            teclado.nextLine(); // Consume el salto de linea restante

            metodos.limpiarPantalla(); // Limpia la pantalla antes de mostrar los resultados finales
            metodos.mostrarResultado(partidos); // Llama al metodo para mostrar el grafico

            // Pregunta al usuario si quiere actualizar los resultados
            metodos.aprietaEnter(teclado);
            System.out.print("¿Actualizar resultados (S/N)? ");
            char respuesta = teclado.nextLine().toLowerCase().charAt(0); // Convierte la respuesta a minusculas

            // Si la respuesta no es 's', el bucle se detiene
            if (respuesta != 's') {
                continuar = false;
            }
        }

        metodos.limpiarPantalla(); // Limpia la pantalla antes de salir
        System.out.println("¡Hasta la proxima!");
        teclado.close(); // Cierra el objeto Scanner
    }
}
