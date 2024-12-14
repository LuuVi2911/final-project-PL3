package search;

import utils.RandomGenerator;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class implements a binary search algorithm and provides
 * an interactive interface for performing binary search on a random array.
 */
public class BinarySearch {

    /**
     * Performs a binary search on a random, sorted array.
     * Prompts the user for input and displays whether the target value is found.
     */
    public static void performSearch() {
        Scanner scanner = new Scanner(System.in);

        // Generate a random array using RandomGenerator
        int[] array = RandomGenerator.generateRandomArray(10, 0, 9);

        // Sort the array before performing binary search
        Arrays.sort(array);

        // Display the sorted array to the user
        System.out.println("Sorted Array:");
        RandomGenerator.printArray(array);

        // Prompt the user to input the value to search for
        System.out.println("In the list are values 0, ..., 9; which value would you like to search with binary search?");
        int target = scanner.nextInt();

        // Perform binary search and display the result
        if (binarySearch(array, target)) {
            System.out.println("\nFound"); // Target value found
        } else {
            System.out.println("\nNot found"); // Target value not found
        }
    }

    /**
     * Implements the binary search algorithm.
     * @param array The sorted array to search in.
     * @param target The value to search for.
     * @return True if the target value is found, false otherwise.
     */
    private static boolean binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;

        // Perform iterative binary search
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid-point

            // Check if the target is at the mid-point
            if (array[mid] == target) {
                return true; // Target found
            }

            // If the target is greater than the mid-point, search the right half
            if (array[mid] < target) {
                left = mid + 1;
            }
            // If the target is smaller than the mid-point, search the left half
            else {
                right = mid - 1;
            }
        }

        return false; // Target not found
    }
}
