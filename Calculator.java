import java.util.Scanner;

public class Calculator {
    public int ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        ArithematicOperations operations = new ArithematicOperations();

        do {
            System.out.println("welcome to the calculator program!");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Modulus");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            calculator.ch = scanner.nextInt();

            if (calculator.ch >= 1 && calculator.ch <= 5) {
                System.out.print("Enter first number: ");
                int n1 = scanner.nextInt();
                System.out.print("Enter second number: ");
                int n2 = scanner.nextInt();

                switch (calculator.ch) {
                    case 1:
                        System.out.println("Result: " + operations.addNums(n1, n2));
                        break;
                    case 2:
                        System.out.println("Result: " + operations.subtractNums(n1, n2));
                        break;
                    case 3:
                        System.out.println("Result: " + operations.multiplyNums(n1, n2));
                        break;
                    case 4:
                        System.out.println("Result: " + operations.divideNums(n1, n2));
                        break;
                    case 5:
                        System.out.println("Result: " + operations.modulusNums(n1, n2));
                        break;
                }
            } else if (calculator.ch != 0) {
                System.out.println("Invalid choice! Please try again.");
            }

        } while (calculator.ch != 0);

        System.out.println("Exiting program.");
        scanner.close();
    }
}