import java.util.ArrayList;
import java.util.List;

public class Payroll {
    private List<Employee> employees;

    public Payroll() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void processPayroll() {
        System.out.printf("%-10s | %-15s | %-15s | %-10s%n", "ID", "Name", "Designation", "Final CTC");
        System.out.println("------------------------------------------------------------");
        for (Employee emp : employees) {
            System.out.printf("%-10s | %-15s | %-15s | %-10.2f%n", 
                emp.empId, emp.name, emp.designation, emp.calcCTC());
        }
    }
}
