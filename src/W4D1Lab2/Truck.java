package W4D1Lab2;
// La clase Truck extiende la clase abstracta Car
public class Truck  extends Car{
    // Propiedad adicional específica para Truck
    private double towingCapacity; // Capacidad de remolque de la camioneta (en libras o kg)

    /**
     * Constructor de la clase TruckV2.
     * Llama al constructor de la clase padre (CarV2) y luego inicializa su propia propiedad.
     *
     * @param vinNumber El número VIN del Truck.
     * @param make La marca del Truck.
     * @param model El modelo del Truck.
     * @param mileage El kilometraje del Truck.
     * @param towingCapacity La capacidad de remolque del Truck.
     */
    public Truck(String vinNumber, String make, String model, int mileage, double towingCapacity) {
        super(vinNumber, make, model, mileage); // Llama al constructor de CarV2
        this.towingCapacity = towingCapacity;   // Inicializa la propiedad towingCapacity
    }

    // Getter para la propiedad towingCapacity
    public double getTowingCapacity() {
        return towingCapacity; // Devuelve la capacidad de remolque
    }

    // Setter para la propiedad towingCapacity
    public void setTowingCapacity(double towingCapacity) {
        // Se podría añadir validación, por ejemplo, que la capacidad no sea negativa.
        if (towingCapacity >= 0) {
            this.towingCapacity = towingCapacity; // Establece la capacidad de remolque
        } else {
            System.out.println("La capacidad de remolque no puede ser negativa.");
        }
    }

    /**
     * Implementación del método getInfo() de la clase abstracta CarV2.
     * Devuelve una cadena con todas las propiedades del Truck, incluyendo la específica.
     *
     * @return Una cadena que describe el Truck.
     */
    @Override
    public String getInfo() {
        return "Tipo: Camioneta, VIN: " + getVinNumber() +
                ", Marca: " + getMake()  +
                ", Modelo: " + getModel() +
                ", Kilometraje: " + getMileage() + " millas" +
                ", Capacidad de Remolque: " + String.format("%.1f", towingCapacity) + " lbs."; // Formatea a un decimal
    }

}
