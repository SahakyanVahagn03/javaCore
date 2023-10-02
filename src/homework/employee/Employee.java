package homework.employee;

public class Employee {
    private String name;
    private String surName;
    private String employeeId;
    private double salary;
    private String company;
    private String position;




    public Employee(String name, String surName, double salary, String company, String position) {
        this.name = name;
        this.surName = surName;
        this.employeeId = String.valueOf(System.nanoTime());
        this.salary = salary;
        this.company = company;
        this.position = position;
    }
    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
