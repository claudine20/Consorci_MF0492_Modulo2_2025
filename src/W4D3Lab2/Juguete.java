package W4D3Lab2;

/**
 * Clase que representa un juguete, incluyendo sus propiedades
 * de nombre, precio y dimensiones.
 */
public class Juguete {
    // Atributos de la clase
    private String nombre;
    private double precioBase;
    // El atributo de dimension es un objeto de la clase Dimension
    private Dimension dimension;

    /**
     * Constructor para crear un nuevo juguete.
     * @param nombre El nombre del juguete.
     * @param precioBase El precio sin el costo de envio.
     * @param dimension El objeto Dimension del juguete.
     */
    public Juguete(String nombre, double precioBase, Dimension dimension) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.dimension = dimension;
    }

    /**
     * Calcula el precio de envio basandose en el volumen del juguete.
     * Se aplican diferentes tramos de precio segun el volumen.
     * @return El costo de envio.
     */
    public double getPrecioEnvio() {
        double volumen = dimension.calcularVolumen();
        if (volumen < 0.1) {
            return 5.0; // Envio para volumen pequeno
        } else if (volumen < 0.5) {
            return 10.0; // Envio para volumen mediano
        } else {
            return 25.0; // Envio para volumen grande
        }
    }

    /**
     * Calcula el precio final del juguete sumando el precio base y el de envio.
     * @return El precio total a pagar.
     */
    public double getPrecioFinal() {
        return precioBase + getPrecioEnvio();
    }

    /**
     * Devuelve una cadena con todas las propiedades del juguete en un formato legible.
     * @return Una cadena con todos los detalles del juguete.
     */
    @Override
    public String toString() {
        return "Juguete: " + nombre + "\n" +
                "  - Precio Base: " + String.format("%.2f", precioBase) + "€\n" +
                "  - Dimensiones: " + dimension + " m^3\n" +
                "  - Volumen: " + String.format("%.2f", dimension.calcularVolumen()) + " m^3\n" +
                "  - Precio Envio: " + String.format("%.2f", getPrecioEnvio()) + "€\n" +
                "  - Precio Final: " + String.format("%.2f", getPrecioFinal()) + "€";
    }
}
