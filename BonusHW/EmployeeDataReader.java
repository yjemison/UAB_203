package UAB_203.BonusHW;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class EmployeeDataReader {

    // Method to read an employee's data from the CSV file
    public ArrayList<Employee> readEmployeeData(String file) {
        ArrayList<Employee> employees = new ArrayList<>();
            
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;        
            reader.readLine(); // Skips the header line
                    
            // Read each line of data
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                    
                if (data.length == 7) {
                    String firstName = data[0];
                    String lastName = data[1];
                    String department = data[2];
                    String position = data[3];
                    double salary = Double.parseDouble(data[4]);
                    int yearsOfService = Integer.parseInt(data[5]);
                    boolean isLead = data[6].equalsIgnoreCase("Yes");
                    
                    Employee employee = new Employee(firstName, lastName, department, 
                                                   position, salary, yearsOfService, isLead);
                    employees.add(employee);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
                
        return employees;
    }
}