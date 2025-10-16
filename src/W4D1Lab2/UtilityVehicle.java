package W4D1Lab2;
// La clase UtilityVehicle extiende la clase abstracta Car
public class UtilityVehicle extends Car{
    // Propiedad adicional específica para UtilityVehicle
    private boolean fourWheelDrive; // Indica si el vehículo tiene tracción a las cuatro ruedas

    /**
     * Constructor de la clase UtilityVehicleV2.
     * Llama al constructor de la clase padre (CarV2) y luego inicializa su propia propiedad.
     *
     * @param vinNumber El número VIN del UtilityVehicle.
     * @param make La marca del UtilityVehicle.
     * @param model El modelo del UtilityVehicle.
     * @param mileage El kilometraje del UtilityVehicle.
     * @param fourWheelDrive Si el vehículo tiene tracción a las cuatro ruedas.
     */
    public UtilityVehicle(String vinNumber, String make, String model, int mileage, boolean fourWheelDrive) {
        super(vinNumber, make, model, mileage); // Llama al constructor de CarV2
        this.fourWheelDrive = fourWheelDrive;   // Inicializa la propiedad fourWheelDrive
    }

    // Getter para la propiedad fourWheelDrive
    public boolean isFourWheelDrive() {
        return fourWheelDrive; // Devuelve el estado de la tracción a las cuatro ruedas
    }

    // Setter para la propiedad fourWheelDrive
    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive; // Establece el estado de la tracción a las cuatro ruedas
    }

    /**
     * Implementación del método getInfo() de la clase abstracta CarV2.
     * Devuelve una cadena con todas las propiedades del UtilityVehicle, incluyendo la específica.
     *
     * @return Una cadena que describe el UtilityVehicle.
     */
    @Override
    public String getInfo() {
        return "Tipo: Utility Vehicle, VIN: " + getVinNumber() +
                ", Marca: " + getMake() +
                ", Modelo: " + getModel()+
                ", Kilometraje: " + getMileage() + " millas" +
                ", Tracción 4x4: " + (fourWheelDrive ? "Sí" : "No") + "."; // Muestra "Sí" o "No" para el booleano
    }
}

