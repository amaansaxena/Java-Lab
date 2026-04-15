import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvService {
    private static final String FILE_NAME = "Students.csv";
    private static final String HEADER = "studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage";

    public void initializeFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(HEADER);
            bw.newLine();
            bw.write(new Student("101", "Alice", "CS", 85, 90, 78, 88, 92, 0).toCsv());
            bw.newLine();
            bw.write(new Student("102", "Bob", "IT", 70, 65, 80, 75, 70, 0).toCsv());
            bw.newLine();
        }
    }

    public void appendRows(List<Student> students) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            for (Student s : students) {
                bw.write(s.toCsv());
                bw.newLine();
            }
        }
    }

    public void processFile(boolean updateMarks, boolean updatePercentage, String deleteId) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(FILE_NAME);
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); 
            lines.add(line);

            while ((line = br.readLine()) != null) {
                Student s = Student.fromCsv(line);
                if (deleteId != null && s.getId().equals(deleteId)) continue;
                if (updateMarks) s.setMarks(82, 88);
                if (updatePercentage) s.calculatePercentage();
                lines.add(s.toCsv());
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        }
    }

    public void displayContent(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}