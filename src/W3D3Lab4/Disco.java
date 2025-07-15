package W3D3Lab4;

// Definición de la clase Disco
class Disco {
    // Atributos privados de la clase Disco
    private String artista;  // Nombre del artista o grupo
    private String titulo;   // Título del álbum o canción
    private int ano;         // Año de lanzamiento del disco
    private double duracionMinutos; // Duración total del disco en minutos

    /**
     * Constructor de la clase Disco.
     * Permite crear una nueva instancia de Disco inicializando todos sus atributos.
     *
     * @param artista El nombre del artista o grupo.
     * @param titulo El título del disco.
     * @param ano El año de lanzamiento.
     * @param duracionMinutos La duración del disco en minutos.
     */
    public Disco(String artista, String titulo, int ano, double duracionMinutos) {
        this.artista = artista;             // Asigna el valor del artista proporcionado
        this.titulo = titulo;               // Asigna el valor del título
        this.ano = ano;                     // Asigna el valor del año
        this.duracionMinutos = duracionMinutos; // Asigna el valor de la duración
    }

    // Métodos Getters: Permiten acceder a los valores de los atributos privados.

    public String getArtista() {
        return artista; // Devuelve el nombre del artista
    }

    public String getTitulo() {
        return titulo; // Devuelve el título del disco
    }

    public int getAno() {
        return ano; // Devuelve el año de lanzamiento
    }

    public double getDuracionMinutos() {
        return duracionMinutos; // Devuelve la duración en minutos
    }

    // Métodos Setters: Permiten modificar los valores de los atributos privados.

    public void setArtista(String artista) {
        this.artista = artista; // Establece un nuevo nombre de artista
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo; // Establece un nuevo título
    }

    public void setAno(int ano) {
        // Se podría añadir validación para el año (ej. que no sea futuro)
        this.ano = ano; // Establece un nuevo año de lanzamiento
    }

    public void setDuracionMinutos(double duracionMinutos) {
        // Se podría añadir validación para la duración (ej. que sea positiva)
        this.duracionMinutos = duracionMinutos; // Establece una nueva duración
    }

    /**
     * Sobrescribe el método toString() para proporcionar una representación de cadena legible del objeto Disco.
     * Esto es útil para imprimir los detalles del objeto directamente.
     *
     * @return Una cadena que describe todas las características del disco.
     */
    @Override
    public String toString() {
        return "Disco [Artista: " + artista +
                ", Título: " + titulo +
                ", Año: " + ano +
                ", Duración: " + String.format("%.1f", duracionMinutos) + " min]"; // Formatea la duración a un decimal
    }
}

