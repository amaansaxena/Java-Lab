public class Manager extends FullTimeEmployee {
    private double TA;
    private double eduAllowance;

    public Manager(String name, String PANNo, String joiningDate, String designation, String empId, double baseSalary, double perfBonus, double TA, double eduAllowance) {
        super(name, PANNo, joiningDate, designation, empId, baseSalary, perfBonus);
        this.TA = TA;
        this.eduAllowance = eduAllowance;
    }

    @Override
    public double calcCTC() {
        return baseSalary + bonusOrCommission + TA + eduAllowance;
    }
}
