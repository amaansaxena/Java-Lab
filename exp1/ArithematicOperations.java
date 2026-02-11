
public class ArithematicOperations {
    public int n1, n2;

    public int addNums(int a, int b){
        return a+b;
    }

    public int subtractNums(int a, int b){
        return a-b;
    }

    public int multiplyNums(int a, int b){
        return a*b;
    }

    public double divideNums(int a, int b){
        if (b==0){
            System.out.println("error: division by zero is not allowed.");
            return 0.0;
        }
        return (double) a / b;
    }

    public int modulusNums(int a, int b){
        if(b==0){
            System.out.println("error: modulus by zero is not allowed.");
            return 0;
        }
        return a%b;
    }

    /*public static void main(String[] args){
        ArithematicOperations operations = new ArithematicOperations();
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter first number: ");
        operations.n1 = scanner.nextInt();
        System.out.print("enter second number: ");
        operations.n2 = scanner.nextInt();

        System.out.println("Addition: "+ operations.addNums(operations.n1,operations.n2));
        System.out.println("Subtractions: "+ operations.subtractNums(operations.n1,operations.n2));
        System.out.println("Multiplication: "+ operations.multiplyNums(operations.n1,operations.n2));
        System.out.println("Division: "+ operations.divideNums(operations.n1,operations.n2));
        System.out.println("Modulus: "+ operations.addNums(operations.n1,operations.n2));

        scanner.close();

    }*/





}
