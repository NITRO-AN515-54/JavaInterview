package CoreConcept.Generic;

import java.util.ArrayList;
import java.util.List;


class Employee {
    // employee attributes
}

public class Accountant extends Employee{
    // accountant attributes

    //List<Employee> employees = new ArrayList<Accountant>();
    List<? extends Employee> employes = new ArrayList<Accountant>(); // ✅ Valid
}
