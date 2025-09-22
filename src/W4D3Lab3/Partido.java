package W4D3Lab3;

// Definicion de la clase Partido
public class Partido {
    // Atributos privados para encapsular los datos
    private String nombre;
    private double porcentaje;

    // Constructor para inicializar un objeto Partido
    public Partido(String nombre) {
        this.nombre = nombre;
        // El porcentaje se inicializa en 0 y se establece mas tarde
        this.porcentaje = 0.0;
    }

    // Metodo getter para obtener el nombre del partido
    public String getNombre() {
        return nombre;
    }

    // Metodo setter para establecer el porcentaje de votos
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    // Metodo getter para obtener el porcentaje de votos
    public double getPorcentaje() {
        return porcentaje;
    }
}

