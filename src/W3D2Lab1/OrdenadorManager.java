package W3D2Lab1;

// Importa la clase Ordenador.
// Asume que el archivo Ordenador.java está en el mismo directorio o en el classpath.
// Si estuviera en un paquete diferente, necesitaría una sentencia 'import' completa.

public class OrdenadorManager {

    public static void main(String[] args) {
        System.out.println("--- GESTIÓN DE ORDENADORES EN TIENDA DE INFORMÁTICA ---");

        // 1. Crear al menos 3 instancias (objetos) de la clase Ordenador
        System.out.println("\n--- Creando instancias de Ordenador ---");

        // Instancia 1: Un ordenador de gama alta
        Ordenador ordenador1 = new Ordenador("Dell", "XPS 15", 16, 512, 1499.99);
        // Instancia 2: Un ordenador de gama media
        Ordenador ordenador2 = new Ordenador("HP", "Pavilion Gaming", 8, 256, 799.50);
        // Instancia 3: Un ordenador económico
        Ordenador ordenador3 = new Ordenador("Lenovo", "IdeaPad 3", 4, 128, 399.00);
        // Instancia 4: Otro ordenador para demostrar más ejemplos
        Ordenador ordenador4 = new Ordenador("Apple", "MacBook Air M1", 8, 256, 1129.00);


        // 2. Imprimir los objetos de dos maneras:
        // 2.1. Imprimir todas sus características (usando el método toString() implícitamente)
        System.out.println("\n--- 2.1. Todas las características de los ordenadores ---");
        System.out.println(ordenador1); // Llama a ordenador1.toString()
        System.out.println(ordenador2); // Llama a ordenador2.toString()
        System.out.println(ordenador3); // Llama a ordenador3.toString()
        System.out.println(ordenador4); // Llama a ordenador4.toString()


        // 2.2. Imprimir solo características sueltas (marca y precio) del ordenador elegido.
        System.out.println("\n--- 2.2. Marca y Precio de ordenadores específicos ---");
        System.out.println("Marca del Ordenador 1: " + ordenador1.getMarca() + ", Precio: " + String.format("%.2f", ordenador1.getPrecio()) + "€");
        System.out.println("Marca del Ordenador 3: " + ordenador3.getMarca() + ", Precio: " + String.format("%.2f", ordenador3.getPrecio()) + "€");


        // 3. Probar a cambiar una propiedad y volver a mostrarla.
        System.out.println("\n--- 3. Cambiando una propiedad y mostrando el cambio ---");

        System.out.println("Ordenador 2 antes del cambio: " + ordenador2); // Muestra el estado actual del ordenador2

        // Cambiar la memoria RAM y el precio del ordenador2 usando los métodos setters
        ordenador2.setMemoriaRAMGB(16); // Establece la nueva memoria RAM
        ordenador2.setPrecio(849.99);   // Establece el nuevo precio

        System.out.println("Ordenador 2 después del cambio de RAM y precio: " + ordenador2); // Muestra el estado actualizado

        // Ejemplo de intento de establecer un valor inválido (se mostrará un mensaje de error)
        System.out.println("\n--- Intentando establecer valores inválidos ---");
        ordenador4.setMemoriaRAMGB(-4); // Intenta poner RAM negativa
        ordenador4.setPrecio(-100.0);   // Intenta poner precio negativo
        System.out.println("Ordenador 4 después de intentos inválidos: " + ordenador4); // Muestra el estado (no debería haber cambiado)

        System.out.println("\n--- Fin del programa ---");
    }
}

