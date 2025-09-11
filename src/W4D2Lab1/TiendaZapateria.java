package W4D2Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TiendaZapateria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double gastoTotal = 0;

        List<Zapato> inventario = new ArrayList<>();

        inventario.add(new Elegante("Clarks", "Oxford", "Cuero", 42, 89.99, false));
        inventario.add(new Elegante("Boss", "Monkstrap", "Cuero", 43, 120.00, true));
        inventario.add(new Casual("Vans", "Classic", "Lona", 41, 60.50));
        inventario.add(new Casual("Levi´s", "Urban", "Sintético", 42, 55.75));
        inventario.add(new Deporte("Nike", "AirMax", "Textil", 44, 140.00));
        inventario.add(new Deporte("Adidas", "Ultraboost", "Malla", 43, 150.00));

        System.out.println("Zapatería - Inventario disponible:\n");

        for(Zapato z: inventario){
            System.out.println(z);
        }

        while(true){
            System.out.println("\n¿Qué modelo deseas comprar? (o escribe 'salir')");
            String modeloDeseado = sc.nextLine();

            if(modeloDeseado.equalsIgnoreCase("salir")) break;

            boolean encontrado = false;
            for(Zapato z: inventario){
                if(z.getModelo().equalsIgnoreCase(modeloDeseado)){
                    gastoTotal += z.getPrecio();
                    System.out.printf("Comprado: %s (%.2f €)\n", z.getModelo(), z.getPrecio());
                    System.out.printf("Gasto acumulado: %.2f €\n", gastoTotal);

                    encontrado=true;
                    break;
                }
            }

            if(!encontrado){
                System.out.println("Modelo no encontrado");
            }
        }

        System.out.printf("\nGasto total final: %.2f €\n", gastoTotal);
        System.out.println("¡Gracias por tu compra! Hasta la próxima.");

        sc.close();
    }
}

