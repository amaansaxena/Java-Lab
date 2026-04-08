public class FullTimeEmployee extends Employee {
    protected double baseSalary;
    protected double bonusOrCommission;

    public FullTimeEmployee(String name, String PANNo, String joiningDate, String designation, String empId, double baseSalary, double bonusOrCommission) {
        super(name, PANNo, joiningDate, designation, empId);
        this.baseSalary = baseSalary;
        this.bonusOrCommission = bonusOrCommission;
    }

    @Override
    public double calcCTC() {
        return baseSalary + bonusOrCommission;
    }
}
