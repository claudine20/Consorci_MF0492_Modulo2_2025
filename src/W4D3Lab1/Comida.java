package W4D3Lab1;

/**
 * Clase que representa un producto de comida en el carrito.
 */
public class Comida {
    // Atributos privados de la clase
    private String nombre;
    private String origen;
    private double peso; // En kilogramos
    private double precioPorKg; // Precio por kilogramo

    /**
     * Constructor para crear una nueva instancia de Comida.
     * @param nombre El nombre del producto.
     * @param origen El pais o lugar de origen.
     * @param peso El peso del producto en kg.
     * @param precioPorKg El precio por kilogramo del producto.
     */
    public Comida(String nombre, String origen, double peso, double precioPorKg) {
        this.nombre = nombre;
        this.origen = origen;
        this.peso = peso;
        this.precioPorKg = precioPorKg;
    }

    // Metodos getters para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public double getPeso() {
        return peso;
    }

    public double getPrecioPorKg() {
        return precioPorKg;
    }

    // Metodos setters para modificar los atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPrecioPorKg(double precioPorKg) {
        this.precioPorKg = precioPorKg;
    }

    /**
     * Calcula y retorna el precio total del producto.
     * @return El precio final calculado (peso * precioPorKg).
     */
    public double calcularPrecioFinal() {
        return peso * precioPorKg;
    }

    /**
     * Devuelve una representacion en cadena del objeto Comida.
     * @return Una cadena con todos los detalles del producto.
     */
    @Override
    public String toString() {
        return "Comida [nombre=" + nombre + ", origen=" + origen + ", peso=" + String.format("%.2f", peso) + " kg"
                + ", precio/kg=" + String.format("%.2f", precioPorKg) + "€"
                + ", precio final=" + String.format("%.2f", calcularPrecioFinal()) + "€]";
    }
}
