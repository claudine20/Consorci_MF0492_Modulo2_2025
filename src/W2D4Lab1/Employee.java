package W2D4Lab1;

public class Employee {
    // PROPIEDADES ; Estas propiedades tienen que ser privadas para acceder a ellos a traves de la encapsulación
    private String name;
    private String email;
    private int age;
    private double salary ;




    // CONSTRUCTOR DE LA CLASE Employee
    public Employee(String name, String email, int age, double salary) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.salary = salary;
    }

    // MÉTODOS

    // Accesores (getters)
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

   // Mutadores (setters)
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Método toString para representar el objeto Employee como una cadena
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}




