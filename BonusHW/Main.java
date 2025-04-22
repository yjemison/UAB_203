package UAB_203.BonusHW;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // File path to CSV file
            String filePath = "employee_data.csv";
            
            // Read employee data from CSV
            EmployeeDataReader dataReader = new EmployeeDataReader();
            ArrayList<Employee> employees = dataReader.readEmployeeData(filePath);
            
            // Create data organizer
            DataOrganizer organizer = new DataOrganizer(employees);
            
            // 1) Lowest-paid employee in each department
            System.out.println("1. LOWEST-PAID EMPLOYEE IN EACH DEPARTMENT:");
            Map<String, Employee> lowestPaid = organizer.findLowestPaidByDepartment();
            for (Map.Entry<String, Employee> entry : lowestPaid.entrySet()) {
                System.out.println("Department: " + entry.getKey() + 
                                   ", Employee: " + entry.getValue().getFullName() + 
                                   ", Salary: $" + entry.getValue().getSalary());
            }
            System.out.println();
            
            // 2) Employees with less than 4 years of service
            System.out.println("2. EMPLOYEES WITH LESS THAN 4 YEARS OF SERVICE:");
            ArrayList<Employee> juniorEmployees = organizer.findEmployeesWithLessThanFourYears();
            for (Employee employee : juniorEmployees) {
                System.out.println(employee);
            }
            System.out.println();
            
            // 3) Average salary in Marketing department
            System.out.println("3. AVERAGE SALARY IN MARKETING DEPARTMENT:");
            System.out.printf("Average Salary: $%.2f\n", organizer.calculateMarketingAverageSalary());
            System.out.println();
            
            // 4) Employee(s) with longest tenure
            System.out.println("4. EMPLOYEE(S) WITH LONGEST TENURE:");
            ArrayList<Employee> seniorEmployees = organizer.findLongestTenureEmployees();
            for (Employee employee : seniorEmployees) {
                System.out.println(employee);
            }
            System.out.println();
            
            // 5) Lead count by department
            System.out.println("5. LEAD COUNT BY DEPARTMENT:");
            Map<String, Integer> leadCounts = organizer.countLeadsByDepartment();
            for (Map.Entry<String, Integer> entry : leadCounts.entrySet()) {
                System.out.println("Department: " + entry.getKey() + 
                                   ", Lead Count: " + entry.getValue());
            }
            
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}