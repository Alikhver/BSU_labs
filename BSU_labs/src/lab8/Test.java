package lab8;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        HumanResources hr = new HumanResources(new ArrayList<>(Arrays.asList(
                new Employee(4, "Alikhver Dzmitry",
                        123, new GregorianCalendar(2018, 2, 3), 12, 5),
                new Employee(1, "Alec Kotovich",
                        234, new GregorianCalendar(2012, 3, 4), 23, 12),
                new Employee(3, "Slevin Kelevra",
                        345, new GregorianCalendar(2005, 4, 5), 45, 12),
                new Employee(4, "Alikhver Dzmitry",
                        123, new GregorianCalendar(2018, 2, 3), 12, 5),
                new Employee(1, "Alec Kotovich",
                        234, new GregorianCalendar(2012, 3, 4), 23, 12),
                new Employee(3, "Slevin Kelevra",
                        345, new GregorianCalendar(2005, 4, 5), 45, 12),
                new Employee(4, "Alikhver Dzmitry",
                        123, new GregorianCalendar(2018, 2, 3), 12, 5),
                new Employee(1, "Alec Kotovich",
                        234, new GregorianCalendar(2012, 3, 4), 23, 12),
                new Employee(3, "Slevin Kelevra",
                        345, new GregorianCalendar(2005, 4, 5), 45, 12)
        )));

        hr.printEmployeesAscById();

        hr.deleteEmployeeById(5);
//        hr.deleteEmployeeById(In);

        hr.printEmployeesDescById();

        hr.printEmployeesWithIdGreaterThan(1);

    }
}
