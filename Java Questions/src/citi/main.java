package citi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] arrgs){
        Employee e1 = new Employee("Arpit", 50000);
        Employee e2 = new Employee("Pratik", 65000);
        Employee e3 = new Employee("Raju", 40000);
        Employee e4 = new Employee("BabuRao", 12000);

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Integer> filteredEmployee = new ArrayList<>();

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        List<Employee> value = employees.stream().filter(t-> t.getSalary() > 30000).collect(Collectors.toList());
        System.out.println(value);
    }
}
