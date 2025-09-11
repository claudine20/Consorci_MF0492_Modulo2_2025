package W4D1Lab2;
// // La clase TvSeriesV2 extiende la clase abstracta Video
public class TvSeries extends Video {
    // Propiedad adicional específica para TvSeries
    private int episodes; // Número de episodios en la serie

    /**
     * Constructor de la clase TvSeriesV2.
     * Llama al constructor de la clase padre (VideoV2) y luego inicializa su propia propiedad.
     *
     * @param title El título de la serie.
     * @param duration La duración total de la serie en minutos.
     * @param episodes El número de episodios de la serie.
     */
    public TvSeries(String title, int duration, int episodes) {
        super(title, duration); // Llama al constructor de VideoV2
        this.episodes = episodes; // Inicializa la propiedad episodes
    }

    // Getter para la propiedad episodes
    public int getEpisodes() {
        return episodes; // Devuelve el número de episodios
    }

    // Setter para la propiedad episodes
    public void setEpisodes(int episodes) {
        // Se podría añadir validación, por ejemplo, que el número de episodios sea positivo.
        if (episodes >= 0) {
            this.episodes = episodes; // Establece el número de episodios
        } else {
            System.out.println("El número de episodios no puede ser negativo.");
        }
    }

    /**
     * Implementación del método getInfo() de la clase abstracta VideoV2.
     * Devuelve una cadena con todas las propiedades de la serie, incluyendo la específica.
     *
     * @return Una cadena que describe la serie de TV.
     */
    @Override
    public String getInfo() {
        return "Tipo: Serie de TV, Título: " + title +
                ", Duración Total: " + duration + " min" +
                ", Episodios: " + episodes + ".";
    }
}
