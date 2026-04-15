import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CsvService service = new CsvService();
        String fileName = "Students.csv";

        try {
            System.out.println("--- 1. Initializing File ---");
            service.initializeFile();
            service.displayContent(fileName);

            System.out.println("\n--- 2. Adding 3 Rows (marks4/5 = 0) ---");
            service.appendRows(Arrays.asList(
                new Student("103", "Charlie", "ECE", 60, 65, 70, 0, 0, 0),
                new Student("104", "David", "ME", 55, 50, 58, 0, 0, 0),
                new Student("105", "Eve", "CE", 90, 92, 88, 0, 0, 0)
            ));
            service.displayContent(fileName);

            System.out.println("\n--- 3. Updating Marks & Percentages ---");
            service.processFile(true, true, null);
            service.displayContent(fileName);

            System.out.println("\n--- 4. Deleting Student 102 ---");
            service.processFile(false, false, "102");
            service.displayContent(fileName);

            System.out.println("\n--- 5. Triggering Exception Condition ---");
            service.displayContent("non_existent_file.csv");

        } catch (IOException e) {
            System.out.println("\n[!] Caught Expected IOException: " + e.toString());
        }
    }
}