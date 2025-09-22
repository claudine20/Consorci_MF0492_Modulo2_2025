package W4D3Lab1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarritoDeCompra {
    // Lista para almacenar los objetos Comida
    private static List<Comida> carrito = new ArrayList<>();
    // Scanner para leer la entrada del usuario
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        // Bucle principal del programa, se ejecuta hasta que el usuario elija 'salir'
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);

        System.out.println("¡Gracias por usar nuestro carrito de la compra! Hasta la proxima.");
        scanner.close();
    }

    /**
     * Muestra el menu de opciones al usuario.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENU CARRITO DE LA COMPRA ---");
        System.out.println("1 - Anadir comida");
        System.out.println("2 - Mostrar lista completa");
        System.out.println("3 - Mostrar un producto especifico por nombre");
        System.out.println("4 - Modificar un producto por nombre");
        System.out.println("5 - Borrar un producto por nombre");
        System.out.println("6 - Mover un elemento en la lista");
        System.out.println("0 - Salir");
        System.out.print("Seleccione una opcion: ");
    }

    /**
     * Lee y valida la opcion del menu introducida por el usuario.
     * @return La opcion valida o -1 si la entrada no es un numero.
     */
    private static int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada invalida. Por favor, ingrese un numero.");
            scanner.next(); // Consume la entrada invalida
            System.out.print("Seleccione una opcion: ");
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de linea restante
        return opcion;
    }

    /**
     * Ejecuta la accion correspondiente a la opcion seleccionada.
     * @param opcion El numero de la opcion a ejecutar.
     */
    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                anadirComida();
                break;
            case 2:
                mostrarListaCompleta();
                break;
            case 3:
                mostrarProductoEspecifico();
                break;
            case 4:
                modificarProducto();
                break;
            case 5:
                borrarProducto();
                break;
            case 6:
                moverElemento();
                break;
            case 0:
                break;
            default:
                System.out.println("Opcion no valida. Por favor, intente de nuevo.");
        }
    }

    /**
     * Permite al usuario anadir un nuevo producto al carrito.
     */
    private static void anadirComida() {
        System.out.println("\n--- ANADIR COMIDA ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Origen: ");
        String origen = scanner.nextLine();

        double peso = 0;
        boolean pesoValido = false;
        while (!pesoValido) {
            System.out.print("Peso (kg): ");
            if (scanner.hasNextDouble()) {
                peso = scanner.nextDouble();
                pesoValido = true;
            } else {
                System.out.println("Entrada invalida. Ingrese un numero para el peso.");
                scanner.next(); // Limpia el buffer
            }
        }

        double precioKg = 0;
        boolean precioValido = false;
        while (!precioValido) {
            System.out.print("Precio por Kg (€): ");
            if (scanner.hasNextDouble()) {
                precioKg = scanner.nextDouble();
                precioValido = true;
            } else {
                System.out.println("Entrada invalida. Ingrese un numero para el precio.");
                scanner.next(); // Limpia el buffer
            }
        }
        scanner.nextLine(); // Consumir el salto de linea restante

        Comida nuevaComida = new Comida(nombre, origen, peso, precioKg);
        carrito.add(nuevaComida);
        System.out.println("Producto anadido con exito.");
    }

    /**
     * Muestra todos los productos en el carrito.
     */
    private static void mostrarListaCompleta() {
        System.out.println("\n--- LISTA COMPLETA DEL CARRITO ---");
        if (carrito.isEmpty()) {
            System.out.println("El carrito esta vacio.");
        } else {
            for (Comida comida : carrito) {
                System.out.println(comida);
            }
        }
    }

    /**
     * Busca y muestra un producto por su nombre.
     */
    private static void mostrarProductoEspecifico() {
        System.out.println("\n--- BUSCAR PRODUCTO POR NOMBRE ---");
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombreABuscar = scanner.nextLine();

        Comida encontrada = buscarComidaPorNombre(nombreABuscar);
        if (encontrada != null) {
            System.out.println("Producto encontrado:");
            System.out.println(encontrada);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * Busca y permite modificar un producto por su nombre.
     */
    private static void modificarProducto() {
        System.out.println("\n--- MODIFICAR PRODUCTO ---");
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombreAModificar = scanner.nextLine();

        Comida comida = buscarComidaPorNombre(nombreAModificar);
        if (comida != null) {
            System.out.println("Producto encontrado. Ingrese los nuevos valores (deje vacio para no cambiar):");
            System.out.print("Nuevo nombre (" + comida.getNombre() + "): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                comida.setNombre(nuevoNombre);
            }

            System.out.print("Nuevo origen (" + comida.getOrigen() + "): ");
            String nuevoOrigen = scanner.nextLine();
            if (!nuevoOrigen.isEmpty()) {
                comida.setOrigen(nuevoOrigen);
            }

            System.out.print("Nuevo peso (" + comida.getPeso() + "): ");
            String nuevoPesoStr = scanner.nextLine();
            if (!nuevoPesoStr.isEmpty()) {
                try {
                    comida.setPeso(Double.parseDouble(nuevoPesoStr));
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida para el peso. El peso no fue modificado.");
                }
            }

            System.out.print("Nuevo precio por Kg (" + comida.getPrecioPorKg() + "): ");
            String nuevoPrecioStr = scanner.nextLine();
            if (!nuevoPrecioStr.isEmpty()) {
                try {
                    comida.setPrecioPorKg(Double.parseDouble(nuevoPrecioStr));
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida para el precio. El precio no fue modificado.");
                }
            }
            System.out.println("Producto modificado con exito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * Busca y borra un producto por su nombre.
     */
    private static void borrarProducto() {
        System.out.println("\n--- BORRAR PRODUCTO ---");
        System.out.print("Ingrese el nombre del producto a borrar: ");
        String nombreABorrar = scanner.nextLine();

        Comida comidaABorrar = buscarComidaPorNombre(nombreABorrar);
        if (comidaABorrar != null) {
            carrito.remove(comidaABorrar);
            System.out.println("Producto borrado con exito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * Mueve un elemento del carrito a otra posicion.
     */
    private static void moverElemento() {
        if (carrito.size() < 2) {
            System.out.println("Necesita al menos dos elementos para mover.");
            return;
        }

        System.out.println("\n--- MOVER ELEMENTO ---");
        mostrarListaConIndices();

        System.out.print("Ingrese el indice del elemento a mover: ");
        int indiceOrigen = leerIndice();

        System.out.print("Ingrese el nuevo indice de destino: ");
        int indiceDestino = leerIndice();

        if (indiceOrigen >= 0 && indiceOrigen < carrito.size() &&
                indiceDestino >= 0 && indiceDestino < carrito.size()) {

            Comida comidaAMover = carrito.remove(indiceOrigen);
            carrito.add(indiceDestino, comidaAMover);
            System.out.println("Elemento movido con exito.");
        } else {
            System.out.println("Indices invalidos.");
        }
    }

    /**
     * Metodo auxiliar para buscar una comida por su nombre, ignorando mayusculas y minusculas.
     * @param nombre El nombre a buscar.
     * @return El objeto Comida encontrado o null si no se encuentra.
     * El método equalsIgnoreCase() se usa para comparar dos cadenas de texto y determinar si son iguales, 0
     *
     * ignorando si las letras son mayúsculas o minúsculas.
     */
    private static Comida buscarComidaPorNombre(String nombre) {
        for (Comida comida : carrito) {
            if (comida.getNombre().equalsIgnoreCase(nombre)) {
                return comida;
            }
        }
        return null;
    }

    /**
     * Muestra la lista con los indices numerados.
     */
    private static void mostrarListaConIndices() {
        System.out.println("--- LISTA CON INDICES ---");
        for (int i = 0; i < carrito.size(); i++) {
            System.out.println(i + " - " + carrito.get(i).getNombre());
        }
    }

    /**
     * Lee y valida un indice del usuario.
     * @return El indice valido o -1 si es invalido.
     */
    private static int leerIndice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada invalida. Por favor, ingrese un numero.");
            scanner.next(); // Limpia el buffer
            System.out.print("Ingrese un indice valido: ");
        }
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de linea
        return indice;
    }
}

