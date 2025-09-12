package W4D1Lab1;

// Definición de la clase Casual
// Esta clase no hereda de ninguna otra.
class Casual {
    // Atributos privados para encapsular los datos.
    private String marca;
    private String modelo;
    private String material;
    private int talla;
    private double precio;

    // Constructor para inicializar un objeto de tipo ZapatoCasual.
    public Casual(String marca, String modelo, String material, int talla, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.material = material;
        this.talla = talla;
        this.precio = precio;
    }

    // Método getter para obtener el modelo del zapato.
    public String getModelo() {
        return modelo;
    }

    // Método getter para obtener el precio del zapato.
    public double getPrecio() {
        return precio;
    }

    // Método para mostrar todas las características del zapato casual.
    public void mostrarCaracteristicas() {
        System.out.println("Categoría: Casual");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Material: " + material);
        System.out.println("Talla: " + talla);
        System.out.printf("Precio: %.2f€\n", precio);
    }
}