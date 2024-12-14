package utils;

import java.util.Random;

/**
 * Utility class for generating random arrays and printing arrays.
 * Provides methods to create random integer arrays within a specified range and display them.
 */
public class RandomGenerator {

    /**
     * Generates a random integer array.
     * Each element in the array is within the specified range [minValue, maxValue].
     *
     * @param size The size of the array to generate.
     * @param minValue The minimum value (inclusive) for elements in the array.
     * @param maxValue The maximum value (inclusive) for elements in the array.
     * @return A randomly generated integer array.
     * @throws IllegalArgumentException If size is less than or equal to 0 or if minValue is greater than maxValue.
     */
    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        // Validate the size and range
        if (size <= 0 || minValue > maxValue) {
            throw new IllegalArgumentException("Invalid size or range for random array generation.");
        }

        int[] array = new int[size];
        Random random = new Random();

        // Populate the array with random integers in the specified range
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        return array;
    }

    /**
     * Prints the elements of an array in a formatted manner.
     * If the array is empty or null, an appropriate message is displayed.
     *
     * @param array The array to print.
     */
    public static void printArray(int[] array) {
        // Handle empty or null arrays
        if (array == null || array.length == 0) {
            System.out.println("Array is empty.");
        } else {
            // Print the array in a formatted style
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
