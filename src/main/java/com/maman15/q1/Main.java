package main.java.com.maman15.q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Run example values
        int exampleM = 1000, exampleN = 10;

        // Create a NumbersPool with default size
        NumbersPool exampleNumPool = new NumbersPool(exampleM);

        // Create an array of PrimeNumbers threads
        PrimeNumbers[] exampleThreads = new PrimeNumbers[exampleN];

        // Start the threads
        for(int i = 0; i < exampleN; i++) {
            exampleThreads[i] = new PrimeNumbers(exampleNumPool);
            exampleThreads[i].start();
        }

        // Print the prime numbers after all threads finish
        System.out.println("These are the prime numbers between 1 to 1000, using 10 threads:");
        exampleNumPool.printPrimeNums();

        // Ask the user for input
        Scanner scan = new Scanner(System.in);

        System.out.print("\nDo you want to enter your own values? (y/n): ");
        String choice = scan.nextLine().toLowerCase();

        if(choice.equals("y")) {
            System.out.print("Enter the number you want to find all the prime numbers until (positive number): ");
            int m = getPositiveNumberInput(scan);

            System.out.print("Enter the number of threads you want to use (positive number): ");
            int n = getPositiveNumberInput(scan);

            NumbersPool userNumPool = new NumbersPool(m);
            PrimeNumbers[] userThreads = new PrimeNumbers[n];

            for(int i = 0; i < n; i++) {
                userThreads[i] = new PrimeNumbers(userNumPool);
                userThreads[i].start();
            }

            userNumPool.printPrimeNums();
        }
    }

    // Helper method to get valid positive number input from the user
    private static int getPositiveNumberInput(Scanner scan) {
        int num;
        do {
            while(!scan.hasNextInt()) {
                System.out.println("Please enter a valid positive number.");
                scan.next(); // consume the invalid input
            }
            num = scan.nextInt();
            if(num <= 0) {
                System.out.println("Please enter a valid positive number.");
            }
        } while(num <= 0);

        return num;
    }
}