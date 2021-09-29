package misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeImpl {
    public List<String> getFilteredEmp(List<Employee> list) {
        Stream<Employee> stream = list.stream();
        List<String> l = stream.filter(e ->e.age>20).sorted(new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e2.age-e1.age;
            }
        }).map(e->e.name).collect(Collectors.toList());

        return l;
    }
}

class Employee {
    int id;
    String name;
    int age;
}
