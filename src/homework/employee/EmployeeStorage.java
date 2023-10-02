package homework.employee;

public class EmployeeStorage {
    private Employee[] array = new Employee[10];
    private int size;

    private void checkIfNeedToExtend() {
        if (size == array.length) {
            extend();
        }
    }

    public void add(Employee value) {
        checkIfNeedToExtend();
        array[size++] = value;
    }

    private void extend() {
        Employee[] tamp = new Employee[array.length + 10];
        if (size >= 0) System.arraycopy(array, 0, tamp, 0, size);
        array = tamp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + 1 + ") Id{" + array[i].getEmployeeId() + "} |-> "
                    + array[i].getName() + "| " + array[i].getSurName() + "| " + array[i].getCompany() + "| " + array[i].getPosition() + "| " + array[i].getSalary());

        }
        System.out.println();
    }

    public void searchEmployeeById(String employeeId) {
        for (int i = 0; i < size; i++) {
           if(array[i].getEmployeeId().equals(employeeId)){
               System.out.println(i + 1 + ") Id{" + array[i].getEmployeeId() + "} |-> "
                       + array[i].getName() + "| " + array[i].getSurName() + "| " + array[i].getCompany() + "| " + array[i].getPosition() + "| " + array[i].getSalary());
           }
        }
    }

    public void searchEmployeeWithNameOfCompany(String nameOfCompany) {
        for (int i = 0; i < size; i++) {
            if(array[i].getCompany().contains(nameOfCompany)){
                System.out.println(i + 1 + ") Id{" + array[i].getEmployeeId() + "} |-> "
                        + array[i].getName() + "| " + array[i].getSurName() + "| " + array[i].getCompany() + "| " + array[i].getPosition() + "| " + array[i].getSalary());
            }
        }
    }
}
