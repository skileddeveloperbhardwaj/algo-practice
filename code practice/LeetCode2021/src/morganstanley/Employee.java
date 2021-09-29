package morganstanley;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Employee {
    private final String name;
    private final Date dateOfJoining;

    public Employee(String n, Date date) {
        name = n;
        dateOfJoining = date;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfJoining() {
        List<Integer> list = new ArrayList<>();
        list.forEach(ele -> System.out.println(ele*ele));
        return dateOfJoining;
    }
}
