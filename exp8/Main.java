import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = InventoryManager.getInstance();

        Product laptop = new NewProduct("High-End Laptop");
        inventory.addProduct(laptop);

        LegacyItem oldScanner = new LegacyItem(101, "Vintage Flatbed Scanner");
        Product adaptedScanner = new ProductAdapter(oldScanner);
        inventory.addProduct(adaptedScanner);

        Product smartphone = new NewProduct("Flagship Smartphone");
        inventory.addProduct(smartphone);

        LegacyItem oldPrinter = new LegacyItem(202, "Dot Matrix Printer");
        inventory.addProduct(new ProductAdapter(oldPrinter));

        Iterator<Product> productIterator = inventory.returnInventory();

        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            product.displayDetails();
        }
    }
}
