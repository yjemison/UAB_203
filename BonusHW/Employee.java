package UAB_203.BonusHW;

public class Employee extends Person {
    // Attributes
    private String department;
    private String position;
    private double salary;
    private int yearsOfService;
    private boolean isLead;

    // Constructor
    public Employee(String firstName, String lastName, String department, String position, double salary, int yearsOfService, boolean isLead) {
        super(firstName, lastName);
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.yearsOfService = yearsOfService;
        this.isLead = isLead;
    }
    

    public String getDepartment() {
        return department;
    }
    
    public String getPosition() {
        return position;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public int getYearsOfService() {
        return yearsOfService;
    }
    
    public boolean isLead() {
        return isLead;
    }
    
    // the display method will be used to display the employee's information
    @Override
    public String toString() {
        return super.toString() +
               ", Department: " + department + 
               ", Position: " + position + 
               ", Salary: $" + salary + 
               ", Years of Service: " + yearsOfService + 
               ", Lead: " + (isLead ? "Yes" : "No");
    }
}