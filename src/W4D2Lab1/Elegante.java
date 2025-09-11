package W4D2Lab1;

public class Elegante extends Zapato{
    private boolean tieneHebilla;

    public Elegante(String marca, String modelo, String material, int talla, double precio, boolean tieneHebilla) {
        super(marca, modelo, material, talla, precio);
        this.tieneHebilla = tieneHebilla;
    }

    public boolean isTieneHebilla() {
        return tieneHebilla;
    }

    public void setTieneHebilla(boolean tieneHebilla) {
        this.tieneHebilla = tieneHebilla;
    }

    @Override
    public String toString() {
        return super.toString() + " | Hebilla: " + (tieneHebilla?"Sí":"No");
    }
}