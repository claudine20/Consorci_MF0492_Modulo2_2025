package W3D1Lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        ** Instructions
        Pedir al usuario nombre, apellido y edad
I        Imprimir frase con estos 3 datos, del tipo: Te llamas Pepe Luis Gonzalez y tienes 45 años”
        * */

        // Creamos el objeto Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tu nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Escribe tu apellido: ");
        String apellido = sc.nextLine();

        System.out.println("Escribe tu edad: ");
        int edad = sc.nextInt();
        sc.nextLine(); // Para vaciar el buffer

        System.out.println("Te llamas " + nombre + " " + apellido + " y tienes " +  edad + " años");

        sc.close();
    }
}
