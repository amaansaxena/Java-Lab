public class Main {
    public static void main(String[] args) {
        Payroll payrollSystem = new Payroll();

        FullTimeEmployee swe = new FullTimeEmployee(
            "Alice Smith", 
            "ABCDE1234F", 
            "2023-01-15", 
            "SWE", 
            "E001", 
            80000, 
            15000
        );

        FullTimeEmployee hr = new FullTimeEmployee(
            "Bob Johnson", 
            "FGHIJ5678K", 
            "2022-05-20", 
            "HR", 
            "E002", 
            60000, 
            5000
        );

        ContractEmployee contractor = new ContractEmployee(
            "Charlie Brown", 
            "LMNOP9012Q", 
            "2024-02-01", 
            "Consultant", 
            "C001", 
            160, 
            50.0
        );

        Manager manager = new Manager(
            "Diana Prince", 
            "QRSTU3456V", 
            "2021-11-10", 
            "Manager", 
            "M001", 
            120000, 
            25000, 
            5000, 
            3000
        );

        payrollSystem.addEmployee(swe);
        payrollSystem.addEmployee(hr);
        payrollSystem.addEmployee(contractor);
        payrollSystem.addEmployee(manager);

        System.out.println("Final Payroll Report:");
        payrollSystem.processPayroll();
    }
}
