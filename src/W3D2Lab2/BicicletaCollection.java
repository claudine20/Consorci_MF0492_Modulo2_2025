package W3D2Lab2;

import java.util.ArrayList; // Importa la clase ArrayList para crear listas dinámicas de objetos
import java.util.Scanner;   // Importa la clase Scanner para leer la entrada del usuario

// Importa la clase Bicicleta. Asume que Bicicleta.java está en el mismo directorio (o en el classpath)
// Si estuviera en un paquete diferente, necesitaría 'import com.tuempresa.Bicicleta;' por ejemplo.

public class BicicletaCollection {

    // Se declara un objeto Scanner estático para que pueda ser utilizado por todos los métodos
    // sin tener que crearlo y cerrarlo repetidamente. Se cerrará una vez en el método main.
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("--- GESTIÓN DE COLECCIÓN DE BICICLETAS ---");

        // 1. Probar a instanciar una o dos bicicletas sueltas
        System.out.println("\n--- Instanciando bicicletas sueltas ---");
        Bicicleta miBiciMontaña = new Bicicleta("Specialized", "Stumpjumper", 45.0, true, 12);
        Bicicleta miBiciPaseo = new Bicicleta("Decathlon", "Elops 120", 25.0, false, 0);

        System.out.println(miBiciMontaña); // Muestra la primera bicicleta usando toString()
        miBiciMontaña.tocarClaxon();       // Llama a un método de acción
        miBiciMontaña.cambiarMarchas(7);   // Llama a un método de acción

        System.out.println(miBiciPaseo);   // Muestra la segunda bicicleta
        miBiciPaseo.pedalear();            // Llama a un método de acción
        miBiciPaseo.cambiarMarchas(1);     // Intenta cambiar marchas en una bici sin ellas

        // 2. Probar a crear un ArrayList de bicicletas
        System.out.println("\n--- Creando un ArrayList de bicicletas ---");
        ArrayList<Bicicleta> misBicicletas = new ArrayList<>(); // Crea un ArrayList vacío de objetos Bicicleta

        // Añadir las bicicletas ya creadas al ArrayList
        misBicicletas.add(miBiciMontaña);
        misBicicletas.add(miBiciPaseo);

        // Añadir más bicicletas directamente al ArrayList
        misBicicletas.add(new Bicicleta("Trek", "Marlin 5", 38.0, true, 9));
        misBicicletas.add(new Bicicleta("BH", "California", 30.0, false, 0));
        misBicicletas.add(new Bicicleta("Cannondale", "Topstone", 50.0, true, 11));

        // 3. Recorrer el ArrayList para mostrarlo con bucle for y for-each
        System.out.println("\n--- Mostrando todas las bicicletas en el ArrayList (bucle for) ---");
        for (int i = 0; i < misBicicletas.size(); i++) { // Bucle for tradicional
            System.out.println("Bicicleta " + (i + 1) + ": " + misBicicletas.get(i)); // Accede a cada elemento por índice
        }

        System.out.println("\n--- Mostrando todas las bicicletas en el ArrayList (bucle for-each) ---");
        for (Bicicleta bici : misBicicletas) { // Bucle for-each (más conciso para recorrer colecciones)
            System.out.println(bici); // Imprime cada objeto Bicicleta
        }

        // 4. Mostrar una sola propiedad (o varias) de las bicicletas
        System.out.println("\n--- Mostrando solo Marca y Velocidad Máxima de todas las bicicletas ---");
        for (Bicicleta bici : misBicicletas) {
            System.out.println("Marca: " + bici.getMarca() + ", Velocidad Máxima: " + String.format("%.1f", bici.getVelocidadMaxima()) + " km/h");
        }

        // 5. Probar métodos set desde el main()
        System.out.println("\n--- Probando métodos set ---");
        System.out.println("Bicicleta antes de cambiar: " + miBiciMontaña);
        miBiciMontaña.setVelocidadMaxima(48.5); // Cambia la velocidad máxima
        miBiciMontaña.setModelo("Fuel EX");     // Cambia el modelo
        System.out.println("Bicicleta después de cambiar: " + miBiciMontaña);

        // Intentar cambiar una propiedad booleana y su efecto
        System.out.println("Bicicleta antes de quitar marchas: " + miBiciPaseo);
        miBiciPaseo.setTieneMarchas(true); // Intenta añadir marchas (pero no tiene sentido sin un numMarchas)
        miBiciPaseo.setNumMarchas(3); // Establece un número de marchas
        System.out.println("Bicicleta después de añadir marchas: " + miBiciPaseo); // Ahora debería decir que sí tiene marchas

        // 6. +EXTRA: Crear o cambiar o leer desde el scanner de usuario
        System.out.println("\n--- EXTRA: Interacción con el usuario (Crear nueva bicicleta) ---");
        System.out.print("¿Quieres añadir una nueva bicicleta a la colección? (s/n): ");
        String respuesta = scanner.nextLine().toLowerCase();

        if (respuesta.equals("s")) {
            System.out.print("Introduce la marca de la nueva bicicleta: ");
            String nuevaMarca = scanner.nextLine();
            System.out.print("Introduce el modelo: ");
            String nuevoModelo = scanner.nextLine();
            System.out.print("Introduce la velocidad máxima (km/h): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Entrada no válida. Por favor, introduce un número para la velocidad.");
                scanner.next();
            }
            double nuevaVelocidad = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea

            System.out.print("¿Tiene marchas? (s/n): ");
            boolean nuevaTieneMarchas = scanner.nextLine().toLowerCase().equals("s");

            int nuevoNumMarchas = 0;
            if (nuevaTieneMarchas) {
                System.out.print("Introduce el número de marchas: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrada no válida. Por favor, introduce un número entero para las marchas.");
                    scanner.next();
                }
                nuevoNumMarchas = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
            }

            Bicicleta nuevaBiciUsuario = new Bicicleta(nuevaMarca, nuevoModelo, nuevaVelocidad, nuevaTieneMarchas, nuevoNumMarchas);
            misBicicletas.add(nuevaBiciUsuario); // Añade la nueva bicicleta a la colección
            System.out.println("¡Bicicleta añadida con éxito!");
            System.out.println("Colección actualizada:");
            for (Bicicleta bici : misBicicletas) {
                System.out.println(bici);
            }
        } else {
            System.out.println("No se añadió ninguna bicicleta nueva.");
        }

        scanner.close(); // Cierra el objeto Scanner al finalizar el programa
        System.out.println("\n--- Fin del programa de gestión de bicicletas ---");
    }
}

