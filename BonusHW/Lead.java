package UAB_203.BonusHW;

public class Lead extends Employee {
    private int teamSize;
    
    // Constructor
    public Lead(String firstName, String lastName, String department, String position, 
                double salary, int yearsOfService, int teamSize) {
        super(firstName, lastName, department, position, salary, yearsOfService, true);
        this.teamSize = teamSize;
    }
    
    public int getTeamSize() {
        return teamSize;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Team Size: " + teamSize;
    }
}