package W4D1Lab2;

public abstract class Video {
    // Atributos protegidos: accesibles dentro de la clase y por las clases que la extienden.
    protected String title;    // Título del video
    protected int duration;    // Duración del video en minutos

    /**
     * Constructor de la clase abstracta VideoV2.
     * Este constructor será llamado por los constructores de las clases que extiendan VideoV2.
     *
     * @param title El título del video.
     * @param duration La duración del video en minutos.
     */
    public Video(String title, int duration) {
        this.title = title;       // Inicializa el título
        this.duration = duration; // Inicializa la duración
    }

    // Métodos Getters
    public String getTitle() {
        return title; // Devuelve el título
    }

    public int getDuration() {
        return duration; // Devuelve la duración
    }

    // Métodos Setters
    public void setTitle(String title) {
        this.title = title; // Establece un nuevo título
    }

    public void setDuration(int duration) {
        // Se podría añadir validación, por ejemplo, que la duración sea positiva.
        if (duration >= 0) {
            this.duration = duration; // Establece una nueva duración
        } else {
            System.out.println("La duración no puede ser negativa.");
        }
    }

    /**
     * Método abstracto getInfo().
     * Las clases que extiendan VideoV2 DEBEN implementar este método.
     *
     * @return Una cadena que contiene todas las propiedades del video en un formato legible.
     */
    public abstract String getInfo();
}
