package UAB_203.BonusHW;
import java.util.ArrayList;

public class Department {
    // Attributes
    private String name;
    private ArrayList<Employee> employees;  // this will be the list of employees in the department

    // Constructor
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();  // Initialize with empty ArrayList
    }

    //Methods
    public String getName() {
        return name;

    }
    //This will add an employee to the department list
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    //Gets employees from the department
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    //This will get the number of employees in the department
    public int getEmployeeCount() {
        return employees.size();
    }

    //This will get the number of employees in the department that are leads
    public int getLeadCount() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.isLead()) {
                count++;
            }
        }
        return count;
    }

    //This will get the employee with the lowest salary in the department
    public Employee getLowestPaidEmployee() {
        if (employees.isEmpty()) {
            return null;
        }
        
        Employee lowestPaid = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getSalary() < lowestPaid.getSalary()) {
                lowestPaid = employee;
            }
        }
        return lowestPaid;
    }

    //This will calculate the average salary of employees in the department
    public double calculateAverageSalary() {
        if (employees.isEmpty()) {
            return 0;
        }
        
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / employees.size();
    }

}