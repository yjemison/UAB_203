package UAB_203.BonusHW;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataOrganizer {
    private ArrayList<Employee> employees;
    private Map<String, Department> departments;
    
    public DataOrganizer(ArrayList<Employee> employees) {
        this.employees = employees;
        this.departments = new HashMap<>();
        
        // Organizes the employees by department
        for (Employee employee : employees) {
            String deptName = employee.getDepartment();
            if (!departments.containsKey(deptName)) {
                departments.put(deptName, new Department(deptName));
            }
            departments.get(deptName).addEmployee(employee);
        }
    }
        //Methods
    // This will find the lowest-paid employee in each department
    public Map<String, Employee> findLowestPaidByDepartment() {
        Map<String, Employee> lowestPaidMap = new HashMap<>();
        
        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            String deptName = entry.getKey();
            Department dept = entry.getValue();
            lowestPaidMap.put(deptName, dept.getLowestPaidEmployee());
        }
        
        return lowestPaidMap;
    }
    
    // This lists employees with less than 4 years of service
    public ArrayList<Employee> findEmployeesWithLessThanFourYears() {
        ArrayList<Employee> result = new ArrayList<>();
        
        for (Employee employee : employees) {
            if (employee.getYearsOfService() < 4) {
                result.add(employee);
            }
        }
        
        return result;
    }
    
    // Calculates average salary in Marketing department
    public double calculateMarketingAverageSalary() {
        if (departments.containsKey("Marketing")) {
            return departments.get("Marketing").calculateAverageSalary();
        }
        return 0;
    }
    
    // This will find the longest tenured employees
    public ArrayList<Employee> findLongestTenureEmployees() {
        ArrayList<Employee> longestTenure = new ArrayList<>();
        int maxYears = 0;
        
        // Find the maximum years of service
        for (Employee employee : employees) {
            if (employee.getYearsOfService() > maxYears) {
                maxYears = employee.getYearsOfService();
                longestTenure.clear();
                longestTenure.add(employee);
            } else if (employee.getYearsOfService() == maxYears) {
                longestTenure.add(employee);
            }
        }
        
        return longestTenure;
    }
    
    //Counts the number of leads in each department
    public Map<String, Integer> countLeadsByDepartment() {
        Map<String, Integer> leadCountMap = new HashMap<>();
        
        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            String deptName = entry.getKey();
            Department dept = entry.getValue();
            leadCountMap.put(deptName, dept.getLeadCount());
        }
        
        return leadCountMap;
    }
}
