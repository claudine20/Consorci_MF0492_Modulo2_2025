package W2D4Lab1;

// Clase principal para ejecutar el programa

import java.io.FileWriter; // Importa la clase para escribir en archivos
import java.io.IOException; // Importa la clase para manejar excepciones de I/O
import java.io.PrintWriter; // Importa la clase para imprimir datos formateados en un archivo

public class Main {
    public static void main(String[] args) {
        //Employee myEmployee = new Employee("Claudia" , "abcd@yahoo.fr", 30, 35000);
        // Array para almacenar 10 objetos Employee
        Employee[] employees = new Employee[10];

        // Crear 10 objetos Employee (algunos Interns para demostrar la validación)
        try {
            employees[0] = new Employee("Juan Perez", "juan.perez@example.com", 30, 50000.0);
            employees[1] = new Intern("Maria Lopez", "maria.lopez@example.com", 22, 18000.0);
            employees[2] = new Employee("Carlos Garcia", "carlos.garcia@example.com", 35, 60000.0);
            employees[3] = new Intern("Ana Martinez", "ana.martinez@example.com", 21, 19500.0);
            employees[4] = new Employee("Pedro Sanchez", "pedro.sanchez@example.com", 40, 75000.0);
            employees[5] = new Intern("Laura Rodriguez", "laura.rodriguez@example.com", 23, 17000.0);
            employees[6] = new Employee("Sofia Gomez", "sofia.gomez@example.com", 28, 45000.0);
            employees[7] = new Intern("David Fernandez", "david.fernandez@example.com", 20, 19999.99);
            employees[8] = new Employee("Elena Diaz", "elena.diaz@example.com", 33, 55000.0);
            employees[9] = new Intern("Pablo Ruiz", "pablo.ruiz@example.com", 24, 16000.0);

            // Ejemplo de intento de establecer un salario inválido para un Intern
            System.out.println("Intentando establecer un salario inválido para Maria Lopez (Interna)...");
            try {
                ((Intern) employees[1]).setSalary(21000.0); // Esto debería lanzar una excepción
            } catch (IllegalArgumentException e) {
                System.out.println("Error al actualizar salario: " + e.getMessage());
            }

            // Nombre y ubicación del archivo de salida
            String fileName = "src/W2D4Lab1/employees.txt";

            // Escribir las propiedades de los empleados en el archivo
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                System.out.println("\nEscribiendo datos de empleados en " + fileName + "...");
                for (Employee emp : employees) {
                    if (emp != null) { // Asegurarse de que el objeto no sea nulo
                        writer.println(emp.toString());
                        System.out.println("Escrito: " + emp.toString()); // También imprime en consola
                    }
                }
                System.out.println("Datos de empleados escritos exitosamente en " + fileName);
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo " + fileName + ": " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error al crear un empleado/interno: " + e.getMessage());
        }
    }
}
