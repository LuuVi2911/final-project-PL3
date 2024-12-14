package search;

import java.util.Scanner;
import utils.RandomGenerator;

public class LinearSearch {

    public static void performSearch() {
        Scanner scanner = new Scanner(System.in);

        // Generate random array using RandomGenerator
        int[] array = RandomGenerator.generateRandomArray(10, 0, 9);

        // Display the generated array
        System.out.println("Generated Array: ");
        RandomGenerator.printArray(array);

        System.out.println("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
        int target = scanner.nextInt();

        // Perform linear search
        if (linearSearch(array, target)) {
            System.out.println("\nFound");
        } else {
            System.out.println("\nNot found");
        }
    }

    // Linear search implementation
    private static boolean linearSearch(int[] array, int target) {
        for (int value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}
