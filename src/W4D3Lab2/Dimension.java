package W4D3Lab2;
/**
 * Clase que representa las dimensiones de un objeto (ancho, alto, profundidad).
 * Tambien contiene la logica para calcular su volumen.
 */
public class Dimension {
    // Atributos privados para las medidas en metros o centimetros
    private double ancho;
    private double alto;
    private double profundidad;

    /**
     * Constructor para inicializar las dimensiones de un objeto.
     * @param ancho El ancho del objeto.
     * @param alto El alto del objeto.
     * @param profundidad La profundidad del objeto.
     */
    public Dimension(double ancho, double alto, double profundidad) {
        this.ancho = ancho;
        this.alto = alto;
        this.profundidad = profundidad;
    }

    /**
     * Calcula y devuelve el volumen del objeto.
     * Este metodo puede ser usado por cualquier clase que tenga una dimension.
     * @return El volumen del objeto (ancho * alto * profundidad).
     */
    public double calcularVolumen() {
        return ancho * alto * profundidad;
    }

    /**
     * Devuelve una cadena con las dimensiones en un formato legible.
     * @return Una cadena con las dimensiones.
     */
    @Override
    public String toString() {
        return String.format("%.2f", ancho) + "x" + String.format("%.2f", alto) + "x" + String.format("%.2f", profundidad);
    }
}
