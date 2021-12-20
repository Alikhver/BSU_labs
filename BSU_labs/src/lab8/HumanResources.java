package lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HumanResources {
    private ArrayList<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee deleteEmployeeById(int id) {
        Employee employee;
        for(int i = 0; i  < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                System.out.println("Employee with id = " + employees.get(i).getId() + " deleted.\n");
                employee = employees.remove(i);
                return employee;
            }
        }
        return null;
    }

    public void printEmployeesAscById() {
        System.out.println("Printing employees in ascending order by id: ");
        employees.sort(Comparator.comparing(Employee::getId));
        for (Employee e : employees) {
            System.out.println(e);
            System.out.println("_______________________________________");
        }
    }

    public void printEmployeesDescById() {
        System.out.println("Printing employees in descending order by id: ");

        employees.sort(Comparator.comparing(Employee::getId));
        Collections.reverse(employees);
        for (Employee e : employees) {
            System.out.println(e);
            System.out.println("_______________________________________");
        }
    }

    public void printEmployeesWithIdGreaterThan(int id) {
        employees.sort(Comparator.comparing(Employee::getId));
        if (id > employees.size() || id < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int left = 0;
        int right = employees.size() - 1;
        int pivot;
        boolean isFound = false;

        while (left <= right) {
            pivot = (right + left) / 2;
            int eId = employees.get(pivot).getId();
            if (eId > id) {
                right = pivot - 1 ;
            } else if (eId < id){
                left = pivot + 1;
            } else {
                func(pivot);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("No element with id = " + id + " found\n");
        }
    }

    public HumanResources(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    private void func(int i) {
        boolean printedAnything = false;
        for (int j = ++i; j < employees.size(); j++) {
            printedAnything = true;
            System.out.println(employees.get(j));
        }
        if (!printedAnything) {
            System.out.println("No elements with id greater than " + employees.get(i).getId() + " found\n");
        }
    }
}
