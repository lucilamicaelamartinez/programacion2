import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Enter the operation you wish to perform (+, -, *, /):");
            String operationString = sc.nextLine();

            Operation operation = null;
            for (Operation o : Operation.values()) {
                if (o.getSymbol().equals(operationString)) {
                    operation = o;
                    break;
                }
            }

            if (operation == null) {
                System.out.println("Invalid operation.");
                continue;
            }

            System.out.println("Enter the numbers separated by spaces:");
            String[] numbersString = sc.nextLine().split(" ");

            double[] numbers = new double[numbersString.length];
            try {
                for (int i = 0; i < numbersString.length; i++) {
                    numbers[i] = Double.parseDouble(numbersString[i]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter valid numbers.");
                continue;
            }

            double result = 0;
            switch (operation) {
                case ADDITION:
                    result = Calculator.add(numbers);
                    break;
                case SUBTRACTION:
                    result = Calculator.subtract(numbers);
                    break;
                case MULTIPLICATION:
                    result = Calculator.multiply(numbers);
                    break;
                case DIVISION:
                    result = Calculator.divide(numbers);
                    break;
            }

            System.out.println("The result is: " + result);

            boolean validResponse = false;
            while (!validResponse) {
                System.out.println("Do you wish to perform another operation? (y/n)");
                String response = sc.nextLine();
                if (response.equals("y")) {
                    validResponse = true;
                } else if (response.equals("n")) {
                    validResponse = true;
                    continueLoop = false;
                } else {
                    System.out.println("Invalid response.");
                }
            }
        }
    }
}