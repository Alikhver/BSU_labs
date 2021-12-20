package lab8;

import java.io.Serializable;
import java.util.Calendar;

public class Employee implements Serializable {



    private static int LAST_ID;

    static {
        LAST_ID = 0;
    }

    private final int id;

    private int departmentId;

    private String fullName;

    private double salary;

    private Calendar employmentDate;

    private int premium;

    private int incomeTax;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getId() {
        return id;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Calendar getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Calendar employmentDate) {
        this.employmentDate = employmentDate;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    public Employee(int departmentId, String fullName, double salary, Calendar employmentDate, int premium, int incomeTax) {
        this.departmentId = departmentId;
        this.fullName = fullName;
        this.salary = salary;
        this.employmentDate = employmentDate;
        this.premium = premium;
        this.incomeTax = incomeTax;

        this.id = ++LAST_ID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", employmentDate=" + employmentDate.getTime() +
                ", premium=" + premium +
                ", incomeTax=" + incomeTax +
                '}';
    }
}
