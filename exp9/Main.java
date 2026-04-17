import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        TableOperations ops = new TableOperations();
        try (Connection conn = DBUtil.getConnection()) {
            ops.createTables(conn);
            ops.insertInitialRecords(conn);

            System.out.println("\n--- Menu Items Price <= 100 ---");
            ops.selectItemsByPrice(conn);

            System.out.println("\n--- Menu Items in 'Cafe Java' ---");
            ops.selectItemsByRestaurant(conn);

            System.out.println("\n--- Updating Prices <= 100 to 200 ---");
            ops.updatePrices(conn);
            ops.displayResult(conn, "SELECT * FROM MenuItem");

            System.out.println("\n--- Deleting Items starting with 'P' ---");
            ops.deleteItemsStartingWithP(conn);
            ops.displayResult(conn, "SELECT * FROM MenuItem");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
