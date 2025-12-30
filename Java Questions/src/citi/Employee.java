package citi;

public class Employee {
    private String name;
    private int salary;

    public Employee(String string, int salary) {
        name = string;
        this.salary = salary;
    }

    public int getString() {
        return salary;
    }

    public void setString(String string) {
        name = string;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
