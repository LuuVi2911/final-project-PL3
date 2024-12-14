package search;

import java.util.Scanner;
import utils.RandomGenerator;

/**
 * This class implements a linear search algorithm and provides
 * an interactive interface for performing the search on a random array.
 */
public class LinearSearch {

    /**
     * Performs a linear search on a randomly generated array.
     * Prompts the user for input and displays whether the target value is found.
     */
    public static void performSearch() {
        Scanner scanner = new Scanner(System.in);

        // Generate a random array using RandomGenerator
        int[] array = RandomGenerator.generateRandomArray(10, 0, 9);

        // Display the generated array to the user
        System.out.println("Generated Array: ");
        RandomGenerator.printArray(array);

        // Prompt the user to input the value to search for
        System.out.println("In the list are values 0, ..., 9; which value would you like to search with linear search?");
        int target = scanner.nextInt();

        // Perform linear search and display the result
        if (linearSearch(array, target)) {
            System.out.println("\nFound"); // Target value found
        } else {
            System.out.println("\nNot found"); // Target value not found
        }
    }

    /**
     * Implements the linear search algorithm.
     * Iterates through the array to find the target value.
     * @param array The array to search in.
     * @param target The value to search for.
     * @return True if the target value is found, false otherwise.
     */
    private static boolean linearSearch(int[] array, int target) {
        for (int value : array) {
            // Check if the current element matches the target
            if (value == target) {
                return true; // Target found
            }
        }
        return false; // Target not found
    }
}
