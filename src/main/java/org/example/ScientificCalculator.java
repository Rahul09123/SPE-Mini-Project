package org.example;

import java.util.Scanner;

public class ScientificCalculator {
    private Scanner scanner;

    public ScientificCalculator() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getChoice();
            
            if (choice == 5) {
                System.out.println("Exiting calculator. Goodbye!!!");
                break;
            }
            
            processChoice(choice);
            System.out.println();
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("=== Scientific Calculator ===");
        System.out.println("1. Square Root (√x)");
        System.out.println("2. Factorial (x!)");
        System.out.println("3. Natural Logarithm (ln(x))");
        System.out.println("4. Power (x^b)");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    private int getChoice() {
        try {
            int choice = scanner.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                return getChoice();
            }
            return choice;
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the invalid input
            return getChoice();
        }
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                calculateSquareRoot();
                break;
            case 2:
                calculateFactorial();
                break;
            case 3:
                calculateNaturalLogarithm();
                break;
            case 4:
                calculatePower();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void calculateSquareRoot() {
        System.out.print("Enter a number: ");
        try {
            double number = scanner.nextDouble();
            if (number < 0) {
                System.out.println("Error: Cannot calculate square root of a negative number.");
            } else {
                double result = Math.sqrt(number);
                System.out.printf("√%.4f = %.4f%n", number, result);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private void calculateFactorial() {
        System.out.print("Enter a non-negative integer: ");
        try {
            int number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Error: Factorial is not defined for negative numbers.");
            } else if (number > 20) {
                System.out.println("Error: Factorial of numbers greater than 20 may cause overflow.");
            } else {
                long result = factorial(number);
                System.out.printf("%d! = %d%n", number, result);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private void calculateNaturalLogarithm() {
        System.out.print("Enter a positive number: ");
        try {
            double number = scanner.nextDouble();
            if (number <= 0) {
                System.out.println("Error: Natural logarithm is only defined for positive numbers.");
            } else {
                double result = Math.log(number);
                System.out.printf("ln(%.4f) = %.4f%n", number, result);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private void calculatePower() {
        System.out.print("Enter the base (x): ");
        try {
            double base = scanner.nextDouble();
            System.out.print("Enter the exponent (b): ");
            double exponent = scanner.nextDouble();
            
            double result = Math.pow(base, exponent);
            System.out.printf("%.4f^%.4f = %.4f%n", base, exponent, result);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // Clear the invalid input
        }
    }
}
