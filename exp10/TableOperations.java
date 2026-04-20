import java.sql.*;

public class TableOperations {

    public void createTables(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS Restaurant (Id INT PRIMARY KEY, Name VARCHAR(100), Address VARCHAR(255))");
            stmt.execute("CREATE TABLE IF NOT EXISTS MenuItem (Id INT PRIMARY KEY, Name VARCHAR(100), Price DOUBLE, ResId INT, FOREIGN KEY (ResId) REFERENCES Restaurant(Id))");
        }
    }

    public String insertInitialData(Connection conn) throws SQLException {
        String resSql = "INSERT IGNORE INTO Restaurant (Id, Name, Address) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(resSql)) {
            String[][] data = {{"1", "Cafe Java", "Street 1"}, {"2", "Burger King", "Street 2"}, {"3", "Pizza Hut", "Street 3"}};
            for (String[] r : data) {
                pstmt.setInt(1, Integer.parseInt(r[0]));
                pstmt.setString(2, r[1]);
                pstmt.setString(3, r[2]);
                pstmt.executeUpdate();
            }
        }
        return "Database Initialized with Restaurant records.";
    }

    public String viewAllItems(Connection conn) throws SQLException {
        return fetchData(conn, "SELECT * FROM MenuItem");
    }

    public String updatePriceLogic(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate("UPDATE MenuItem SET Price = 200 WHERE Price <= 100");
            return rows + " items updated to Price 200.";
        }
    }

    public String deleteItemsLogic(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate("DELETE FROM MenuItem WHERE Name LIKE 'P%'");
            return rows + " items starting with 'P' deleted.";
        }
    }

    private String fetchData(Connection conn, String query) throws SQLException {
        StringBuilder sb = new StringBuilder();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            for (int i = 1; i <= cols; i++) sb.append(String.format("%-15s", meta.getColumnName(i)));
            sb.append("\n").append("-".repeat(cols * 15)).append("\n");
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) sb.append(String.format("%-15s", rs.getString(i)));
                sb.append("\n");
            }
        }
        return sb.length() == 0 ? "No records found." : sb.toString();
    }
}
