package W3D2Lab1;

// Definición de la clase Ordenador
class Ordenador {
    // Atributos privados de la clase Ordenador
    private String marca;          // Marca del ordenador (ej. "HP", "Dell", "Apple")
    private String modelo;         // Modelo específico del ordenador (ej. "Pavilion", "XPS 13", "MacBook Air")
    private int memoriaRAMGB;      // Cantidad de memoria RAM en Gigabytes (GB)
    private int capacidadDiscoDuroGB; // Capacidad del disco duro en Gigabytes (GB)
    private double precio;         // Precio del ordenador en euros (o la moneda que se desee)

    /**
     * Constructor de la clase Ordenador.
     * Permite crear una nueva instancia de Ordenador inicializando todos sus atributos.
     *
     * @param marca La marca del ordenador.
     * @param modelo El modelo del ordenador.
     * @param memoriaRAMGB La cantidad de memoria RAM en GB.
     * @param capacidadDiscoDuroGB La capacidad del disco duro en GB.
     * @param precio El precio del ordenador.
     */
    public Ordenador(String marca, String modelo, int memoriaRAMGB, int capacidadDiscoDuroGB, double precio) {
        this.marca = marca;                 // Asigna el valor de la marca proporcionado al atributo de la instancia
        this.modelo = modelo;               // Asigna el valor del modelo
        this.memoriaRAMGB = memoriaRAMGB;       // Asigna el valor de la memoria RAM
        this.capacidadDiscoDuroGB = capacidadDiscoDuroGB; // Asigna el valor de la capacidad del disco duro
        this.precio = precio;               // Asigna el valor del precio
    }

    // Métodos Getters: Permiten acceder a los valores de los atributos privados desde fuera de la clase.

    public String getMarca() {
        return marca; // Devuelve la marca del ordenador
    }

    public String getModelo() {
        return modelo; // Devuelve el modelo del ordenador
    }

    public int getMemoriaRAMGB() {
        return memoriaRAMGB; // Devuelve la memoria RAM en GB
    }

    public int getCapacidadDiscoDuroGB() {
        return capacidadDiscoDuroGB; // Devuelve la capacidad del disco duro en GB
    }

    public double getPrecio() {
        return precio; // Devuelve el precio del ordenador
    }

    // Métodos Setters: Permiten modificar los valores de los atributos privados desde fuera de la clase.

    public void setMarca(String marca) {
        this.marca = marca; // Establece una nueva marca para el ordenador
    }

    public void setModelo(String modelo) {
        this.modelo = modelo; // Establece un nuevo modelo para el ordenador
    }

    public void setMemoriaRAMGB(int memoriaRAMGB) {
        // Se podría añadir validación aquí, por ejemplo, que la RAM no sea negativa
        if (memoriaRAMGB > 0) {
            this.memoriaRAMGB = memoriaRAMGB; // Establece una nueva cantidad de memoria RAM
        } else {
            System.out.println("La memoria RAM debe ser un valor positivo.");
        }
    }

    public void setCapacidadDiscoDuroGB(int capacidadDiscoDuroGB) {
        // Se podría añadir validación aquí, por ejemplo, que la capacidad no sea negativa
        if (capacidadDiscoDuroGB > 0) {
            this.capacidadDiscoDuroGB = capacidadDiscoDuroGB; // Establece una nueva capacidad de disco duro
        } else {
            System.out.println("La capacidad del disco duro debe ser un valor positivo.");
        }
    }

    public void setPrecio(double precio) {
        // Se podría añadir validación aquí, por ejemplo, que el precio no sea negativo
        if (precio >= 0) {
            this.precio = precio; // Establece un nuevo precio para el ordenador
        } else {
            System.out.println("El precio no puede ser negativo.");
        }
    }

    /**
     * Sobrescribe el método toString() para proporcionar una representación de cadena legible del objeto Ordenador.
     * Esto es útil para imprimir los detalles del objeto directamente.
     *
     * @return Una cadena que describe todas las características del ordenador.
     */
    @Override
    public String toString() {
        return "Ordenador [Marca: " + marca +
                ", Modelo: " + modelo +
                ", RAM: " + memoriaRAMGB + "GB" +
                ", Disco Duro: " + capacidadDiscoDuroGB + "GB" +
                ", Precio: " + String.format("%.2f", precio) + "€]"; // Formatea el precio a dos decimales
    }
}
