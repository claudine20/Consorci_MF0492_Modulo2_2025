package W4D1Lab2;

// La clase Sedan extiende la clase abstracta Car, lo que significa que hereda sus propiedades
// y debe implementar todos sus métodos abstractos (en este caso, getInfo()).
public class Sedan extends Car {
        /**
         * Constructor de la clase Sedan.
         * Llama al constructor de la clase padre (Car) usando 'super()'.
         *
         * @param vinNumber El número VIN del Sedan.
         * @param make La marca del Sedan.
         * @param model El modelo del Sedan.
         * @param mileage El kilometraje del Sedan.
         */
        public Sedan(String vinNumber, String make, String model, int mileage) {
            super(vinNumber, make, model, mileage); // Llama al constructor de Car
        }

        /**
         * Implementación del método getInfo() de la clase abstracta Car.
         * Devuelve una cadena con todas las propiedades del Sedan en un formato legible.
         *
         * @return Una cadena que describe el Sedan.
         */
        @Override // Indica que este método sobrescribe un método de la clase padre.
        public String getInfo() {
            return "Tipo: Sedan, VIN: " + vinNumber +
                    ", Marca: " + make +
                    ", Modelo: " + model +
                    ", Kilometraje: " + mileage + " millas.";
        }
    }


