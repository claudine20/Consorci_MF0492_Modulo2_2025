package W4D2Lab2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // --- Demostracion de BigDecimal Operations ---
        System.out.println("--- Demostracion de Operaciones con BigDecimal ---");

        // Ejemplo 1: redondear a la centesima
        BigDecimal num1 = new BigDecimal("4.2545");
        double result1 = BigDecimalOperations.roundToHundredth(num1);
        System.out.println("Redondeando " + num1 + " a la centesima mas cercana: " + result1); // Salida: 4.25

        // Ejemplo 2: invertir signo y redondear a la decima
        BigDecimal num2 = new BigDecimal("1.2345");
        double result2 = BigDecimalOperations.reverseSignAndRoundToTenth(num2);
        System.out.println("Invirtiendo signo y redondeando " + num2 + " a la decima mas cercana: " + result2); // Salida: -1.2

        BigDecimal num3 = new BigDecimal("-45.67");
        double result3 = BigDecimalOperations.reverseSignAndRoundToTenth(num3);
        System.out.println("Invirtiendo signo y redondeando " + num3 + " a la decima mas cercana: " + result3); // Salida: 45.7

        // --- Demostracion de IntArrayList y IntVector ---
        System.out.println("\n--- Demostracion de IntArrayList ---");
        IntArrayList list1 = new IntArrayList();
        // Anade 12 elementos para demostrar el redimensionamiento.
        for (int i = 0; i < 12; i++) {
            list1.add(i);
        }
        System.out.print("IntArrayList: ");
        list1.printList();
        System.out.println("Obteniendo el elemento en el indice 5: " + list1.get(5));

        System.out.println("\n--- Demostracion de IntVector ---");
        IntVector list2 = new IntVector();
        // Anade 22 elementos para demostrar el redimensionamiento.
        for (int i = 0; i < 22; i++) {
            list2.add(i);
        }
        System.out.print("IntVector: ");
        list2.printList();
        System.out.println("Obteniendo el elemento en el indice 15: " + list2.get(15));
    }
}
