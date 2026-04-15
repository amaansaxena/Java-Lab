public class Student {
    private String id;
    private String name;
    private String branch;
    private int[] marks;
    private double percentage;

    public Student(String id, String name, String branch, int m1, int m2, int m3, int m4, int m5, double percentage) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.marks = new int[]{m1, m2, m3, m4, m5};
        this.percentage = percentage;
    }

    public static Student fromCsv(String line) {
        String[] parts = line.split(",");
        return new Student(
            parts[0], parts[1], parts[2],
            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), 
            Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), 
            Integer.parseInt(parts[7]), Double.parseDouble(parts[8])
        );
    }

    public String toCsv() {
        return String.format("%s,%s,%s,%d,%d,%d,%d,%d,%.2f", 
            id, name, branch, marks[0], marks[1], marks[2], marks[3], marks[4], percentage);
    }

    public void setMarks(int m4, int m5) {
        this.marks[3] = m4;
        this.marks[4] = m5;
    }

    public void calculatePercentage() {
        int sum = 0;
        for (int m : marks) sum += m;
        this.percentage = sum / 5.0;
    }

    public String getId() { return id; }
}
