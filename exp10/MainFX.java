import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;

public class MainFX extends Application {
    private TableOperations ops = new TableOperations();
    private TextArea displayArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        // Initialize Tables on startup
        try (Connection conn = DBUtil.getConnection()) {
            ops.createTables(conn);
            displayArea.setText("Connected to MySQL. Tables ready.");
        } catch (Exception e) {
            displayArea.setText("Connection Error: " + e.getMessage());
        }

        // Setup MenuBar
        MenuBar menuBar = new MenuBar();

        Menu insertMenu = new Menu("Insert");
        MenuItem insData = new MenuItem("Insert Initial Records");
        insertMenu.getItems().add(insData);

        Menu selectMenu = new Menu("Select");
        MenuItem viewItems = new MenuItem("View All MenuItems");
        selectMenu.getItems().add(viewItems);

        Menu updateMenu = new Menu("Update");
        MenuItem updPrice = new MenuItem("Set Price 200 (if <= 100)");
        updateMenu.getItems().add(updPrice);

        Menu deleteMenu = new Menu("Delete");
        MenuItem delItem = new MenuItem("Delete items starting with 'P'");
        deleteMenu.getItems().add(delItem);

        menuBar.getMenus().addAll(insertMenu, selectMenu, updateMenu, deleteMenu);

        // Menu Actions
        insData.setOnAction(e -> process(() -> ops.insertInitialData(DBUtil.getConnection())));
        viewItems.setOnAction(e -> process(() -> ops.viewAllItems(DBUtil.getConnection())));
        updPrice.setOnAction(e -> process(() -> ops.updatePriceLogic(DBUtil.getConnection())));
        delItem.setOnAction(e -> process(() -> ops.deleteItemsLogic(DBUtil.getConnection())));

        // Layout
        displayArea.setEditable(false);
        displayArea.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 13;");
        VBox root = new VBox(menuBar, displayArea);
        displayArea.setPrefHeight(400);

        Scene scene = new Scene(root, 650, 450);
        primaryStage.setTitle("Restaurant CRUD System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void process(SQLCallable action) {
        try {
            displayArea.setText(action.call());
        } catch (Exception ex) {
            displayArea.setText("Operation Failed: " + ex.getMessage());
        }
    }

    interface SQLCallable { String call() throws Exception; }

    public static void main(String[] args) { launch(args); }
}
