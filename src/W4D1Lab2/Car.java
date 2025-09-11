package W4D1Lab2;

// Clase abstracta Car
// Una clase abstracta no puede ser instanciada directamente.
// Sirve como una plantilla para otras clases (clases concretas) que la extenderán.
public abstract class Car {
    // Atributos protegidos: son accesibles dentro de la misma clase y por las clases que la extienden.
    protected String vinNumber; // Número de Identificación del Vehículo (VIN)
    protected String make;      // Marca del coche (ej. "Toyota", "Ford")
    protected String model;     // Modelo del coche (ej. "Camry", "F-150")
    protected int mileage;      // Kilometraje del coche (en millas o kilómetros)

    /**
     * Constructor de la clase abstracta Car.
     * Este constructor será llamado por los constructores de las clases que extiendan Car.
     *
     * @param vinNumber El número VIN del coche.
     * @param make La marca del coche.
     * @param model El modelo del coche.
     * @param mileage El kilometraje del coche.
     */
    public Car(String vinNumber, String make, String model, int mileage) {
        this.vinNumber = vinNumber; // Inicializa el número VIN
        this.make = make;           // Inicializa la marca
        this.model = model;         // Inicializa el modelo
        this.mileage = mileage;     // Inicializa el kilometraje
    }

    // Métodos Getters: Permiten acceder a los valores de los atributos protegidos.
    public String getVinNumber() {
        return vinNumber; // Devuelve el número VIN
    }

    public String getMake() {
        return make; // Devuelve la marca
    }

    public String getModel() {
        return model; // Devuelve el modelo
    }

    public int getMileage() {
        return mileage; // Devuelve el kilometraje
    }

    // Métodos Setters: Permiten modificar los valores de los atributos protegidos.
    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber; // Establece un nuevo número VIN
    }

    public void setMake(String make) {
        this.make = make; // Establece una nueva marca
    }

    public void setModel(String model) {
        this.model = model; // Establece un nuevo modelo
    }

    public void setMileage(int mileage) {
        // Se podría añadir validación, por ejemplo, que el kilometraje no sea negativo.
        if (mileage >= 0) {
            this.mileage = mileage; // Establece un nuevo kilometraje
        } else {
            System.out.println("El kilometraje no puede ser negativo.");
        }
    }

    /**
     * Método abstracto getInfo().
     * Las clases que extiendan Car DEBEN implementar este método.
     * No tiene cuerpo en la clase abstracta.
     *
     * @return Una cadena que contiene todas las propiedades del coche en un formato legible.
     */
    public abstract String getInfo();
}
