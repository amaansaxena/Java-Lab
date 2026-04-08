
public abstract class Employee {
    protected String name;
    protected String PANNo;
    protected String joiningDate;
    protected String designation;
    protected String empId;

    public Employee(String name, String PANNo, String joiningDate, String designation, String empId) {
        this.name = name;
        this.PANNo = PANNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
    }

    public abstract double calcCTC();
}
