import java.sql.*;

public class TableOperations {

    public void createTables(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS Restaurant (" +
                        "Id INT PRIMARY KEY, Name VARCHAR(100), Address VARCHAR(255))");
            stmt.execute("CREATE TABLE IF NOT EXISTS MenuItem (" +
                        "Id INT PRIMARY KEY, Name VARCHAR(100), Price DOUBLE, ResId INT, " +
                        "FOREIGN KEY (ResId) REFERENCES Restaurant(Id))");
        }
    }

    public void insertInitialRecords(Connection conn) throws SQLException {
        String resSql = "INSERT IGNORE INTO Restaurant (Id, Name, Address) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(resSql)) {
            String[] names = {"Cafe Java", "Burger King", "Pizza Hut", "Sushi Zen", "Taco Bell", "Pasta Bar", "Steak House", "Vegan Bite", "Donut Shop", "Grill It"};
            for (int i = 1; i <= 10; i++) {
                pstmt.setInt(1, i);
                pstmt.setString(2, names[i - 1]);
                pstmt.setString(3, "Street " + i);
                pstmt.executeUpdate();
            }
        }

        String itemSql = "INSERT IGNORE INTO MenuItem (Id, Name, Price, ResId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(itemSql)) {
            String[] items = {"Pasta", "Pizza", "Burger", "Salad", "Soup", "Pancakes", "Sushi", "Tacos", "Steak", "Donut"};
            double[] prices = {80.0, 150.0, 90.0, 60.0, 40.0, 110.0, 200.0, 75.0, 300.0, 30.0};
            for (int i = 1; i <= 10; i++) {
                pstmt.setInt(1, i);
                pstmt.setString(2, items[i - 1]);
                pstmt.setDouble(3, prices[i - 1]);
                pstmt.setInt(4, (i % 10) + 1);
                pstmt.executeUpdate();
            }
        }
    }

    public void selectItemsByPrice(Connection conn) throws SQLException {
        displayResult(conn, "SELECT * FROM MenuItem WHERE Price <= 100");
    }

    public void selectItemsByRestaurant(Connection conn) throws SQLException {
        displayResult(conn, "SELECT m.* FROM MenuItem m JOIN Restaurant r ON m.ResId = r.Id WHERE r.Name = 'Cafe Java'");
    }

    public void updatePrices(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("UPDATE MenuItem SET Price = 200 WHERE Price <= 100");
        }
    }

    public void deleteItemsStartingWithP(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM MenuItem WHERE Name LIKE 'P%'");
        }
    }

    public void displayResult(Connection conn, String query) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            for (int i = 1; i <= cols; i++) System.out.printf("%-15s", meta.getColumnName(i));
            System.out.println("\n" + "-".repeat(cols * 15));
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) System.out.printf("%-15s", rs.getString(i));
                System.out.println();
            }
        }
    }
}