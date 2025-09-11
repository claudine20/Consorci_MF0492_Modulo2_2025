package W4D1Lab2;
// La clase Movie extiende la clase abstracta Video.
public class Movie extends Video {
    // Propiedad adicional específica para Movie
    private double rating; // Calificación de la película (ej. 8.5, 9.2)

    /**
     * Constructor de la clase MovieV2.
     * Llama al constructor de la clase padre (VideoV2) y luego inicializa su propia propiedad.
     *
     * @param title El título de la película.
     * @param duration La duración de la película en minutos.
     * @param rating La calificación de la película.
     */
    public Movie(String title, int duration, double rating) {
        super(title, duration); // Llama al constructor de VideoV2
        this.rating = rating;   // Inicializa la propiedad rating
    }

    // Getter para la propiedad rating
    public double getRating() {
        return rating; // Devuelve la calificación de la película
    }

    // Setter para la propiedad rating
    public void setRating(double rating) {
        // Se podría añadir validación, por ejemplo, que la calificación esté entre 0 y 10.
        if (rating >= 0 && rating <= 10) {
            this.rating = rating; // Establece la calificación
        } else {
            System.out.println("La calificación debe estar entre 0 y 10.");
        }
    }

    /**
     * Implementación del método getInfo() de la clase abstracta VideoV2.
     * Devuelve una cadena con todas las propiedades de la película, incluyendo la específica.
     *
     * @return Una cadena que describe la película.
     */
    @Override
    public String getInfo() {
        return "Tipo: Película, Título: " + title +
                ", Duración: " + duration + " min" +
                ", Calificación: " + String.format("%.1f", rating) + "."; // Formatea a un decimal
    }

}
