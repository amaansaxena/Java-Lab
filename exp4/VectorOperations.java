import java.util.Scanner;

public class VectorOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Vector v1 = getVectorInput(scanner, 1);
            Vector v2 = getVectorInput(scanner, 2);

            System.out.println("\n--- Results ---");
            v1.display("Vector 1");
            v2.display("Vector 2");

            Vector sum = v1.add(v2);
            sum.display("Addition Result");

            Vector diff = v1.subtract(v2);
            diff.display("Subtraction Result");

            double dot = v1.dotProduct(v2);
            System.out.println("Dot Product: " + dot);

        } catch (VectorException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }

    private static Vector getVectorInput(Scanner sc, int index) throws VectorException {
        System.out.print("Enter dimension for Vector " + index + " (2 or 3): ");
        int dim = sc.nextInt();
        
        double[] components = new double[dim];
        System.out.println("Enter " + dim + " components:");
        for (int i = 0; i < dim; i++) {
            components[i] = sc.nextDouble();
        }
        return new Vector(components);
    }
}
