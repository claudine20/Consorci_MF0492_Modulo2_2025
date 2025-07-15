package W3D2Lab2;

import java.util.ArrayList; // Importa la clase ArrayList (aunque no se usa directamente aquí, es común para colecciones)
import java.util.Scanner;   // Importa la clase Scanner (aunque no se usa directamente aquí, es común para entrada)

// Definición de la clase Bicicleta
class Bicicleta {
    // Propiedades (características) de una bicicleta
    private String marca;          // Marca de la bicicleta (ej. "Orbea", "Scott")
    private String modelo;         // Modelo específico de la bicicleta (ej. "Alma H30", "Spark RC")
    private double velocidadMaxima; // Velocidad máxima que puede alcanzar (en km/h)
    private boolean tieneMarchas;  // Indica si la bicicleta tiene marchas (true) o es de piñón fijo (false)
    private int numMarchas;        // Número de marchas, si las tiene

    // Constructor de la clase Bicicleta
    // Este método se llama cuando se crea una nueva instancia de Bicicleta
    public Bicicleta(String marca, String modelo, double velocidadMaxima, boolean tieneMarchas, int numMarchas) {
        this.marca = marca;                 // Asigna la marca recibida al atributo de la instancia
        this.modelo = modelo;               // Asigna el modelo
        this.velocidadMaxima = velocidadMaxima; // Asigna la velocidad máxima
        this.tieneMarchas = tieneMarchas;     // Asigna si tiene marchas
        // Si no tiene marchas, el número de marchas se establece en 0
        if (!tieneMarchas) {
            this.numMarchas = 0;
        } else {
            this.numMarchas = numMarchas;   // Asigna el número de marchas
        }
    }

    // Métodos Getters (para obtener el valor de las propiedades)
    public String getMarca() {
        return marca; // Devuelve la marca de la bicicleta
    }

    public String getModelo() {
        return modelo; // Devuelve el modelo de la bicicleta
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima; // Devuelve la velocidad máxima de la bicicleta
    }

    public boolean getTieneMarchas() {
        return tieneMarchas; // Devuelve si la bicicleta tiene marchas
    }

    public int getNumMarchas() {
        return numMarchas; // Devuelve el número de marchas
    }

    // Métodos Setters (para modificar el valor de las propiedades)
    public void setMarca(String marca) {
        this.marca = marca; // Establece una nueva marca para la bicicleta
    }

    public void setModelo(String modelo) {
        this.modelo = modelo; // Establece un nuevo modelo para la bicicleta
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima; // Establece una nueva velocidad máxima
    }

    public void setTieneMarchas(boolean tieneMarchas) {
        this.tieneMarchas = tieneMarchas; // Establece si tiene marchas
        // Si se cambia a false, el número de marchas debe ser 0
        if (!tieneMarchas) {
            this.numMarchas = 0;
        }
    }

    public void setNumMarchas(int numMarchas) {
        // Solo permite establecer el número de marchas si la bicicleta tiene marchas
        if (this.tieneMarchas) {
            this.numMarchas = numMarchas;
        } else {
            System.out.println("Esta bicicleta no tiene marchas, no se puede establecer el número de marchas.");
        }
    }

    // Métodos de acción de la bicicleta
    public void tocarClaxon() {
        System.out.println(marca + " " + modelo + " hace: ¡Piip piip!"); // Imprime el sonido del claxon
    }

    public void pedalear() {
        System.out.println(marca + " " + modelo + " está pedaleando."); // Imprime que está pedaleando
    }

    public void parar() {
        System.out.println(marca + " " + modelo + " se ha detenido."); // Imprime que se ha detenido
    }

    public void girar(String direccion) {
        System.out.println(marca + " " + modelo + " está girando hacia " + direccion + "."); // Imprime la dirección del giro
    }

    public void cambiarMarchas(int nuevaMarcha) {
        if (this.tieneMarchas) { // Comprueba si la bicicleta tiene marchas
            if (nuevaMarcha > 0 && nuevaMarcha <= this.numMarchas) { // Valida que la marcha sea válida
                System.out.println(marca + " " + modelo + " ha cambiado a la marcha " + nuevaMarcha + ".");
            } else {
                System.out.println("Marcha " + nuevaMarcha + " no válida para esta bicicleta. Tiene " + this.numMarchas + " marchas.");
            }
        } else {
            System.out.println(marca + " " + modelo + " no tiene marchas para cambiar.");
        }
    }

    // Método toString() para una representación legible del objeto
    // Se modifica para mostrar el booleano 'tieneMarchas' como texto
    @Override
    public String toString() {
        String marchasText = tieneMarchas ? "sí incluye cambio de marchas (" + numMarchas + " marchas)" : "no incluye cambio de marchas";
        return "Bicicleta [Marca: " + marca + ", Modelo: " + modelo + ", Velocidad Máxima: " + String.format("%.1f", velocidadMaxima) + " km/h, " + marchasText + "]";
    }
}

