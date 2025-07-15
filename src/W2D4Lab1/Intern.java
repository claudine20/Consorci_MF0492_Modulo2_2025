package W2D4Lab1;

public class Intern extends Employee{
    // Constante para el límite salarial del interno
    private static final double SALARY_LIMIT = 20000.0;

    // CONSTRUCTOR de la clase Intern
    public Intern(String name, String email, int age, double salary) {
        super(name, email, age, salary);

        // Aplica el metodo para la validación del salario al crear un Intern
        validateSalary(salary);
    }

    // Sobrescribe el setter de salario para incluir la validación
    @Override
    public void setSalary(double salary) {
        validateSalary(salary); // Valida el nuevo salario
        super.setSalary(salary); // Llama al setter de la clase padre si la validación es exitosa
    }

    // Método privado para validar el salario
    private void validateSalary(double salary) {
        if (salary > SALARY_LIMIT) {
            // Lanza una excepción si el salario excede el límite
            throw new IllegalArgumentException("El salario del interno no puede exceder " + SALARY_LIMIT + ".");
        }
    }

    // Método toString para representar el objeto Intern como una cadena
    @Override
    public String toString() {
        return "Interno - " + super.toString(); // Reutiliza el toString de Employee
    }
}

