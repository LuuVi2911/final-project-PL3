package search;

import utils.RandomGenerator;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void performSearch() {
        Scanner scanner = new Scanner(System.in);

        // Generate a random array using RandomGenerator
        int[] array = RandomGenerator.generateRandomArray(10, 0, 9);

        // Sort the array before binary search
        Arrays.sort(array);

        // Display the sorted array
        System.out.println("Sorted Array:");
        RandomGenerator.printArray(array);

        System.out.println("In the list are values 0, ..., 9; which value would you like to search with binary search?");
        int target = scanner.nextInt();

        // Perform binary search
        if (binarySearch(array, target)) {
            System.out.println("\nFound");
        } else {
            System.out.println("\nNot found");
        }
    }

    private static boolean binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is at mid
            if (array[mid] == target) {
                return true;
            }

            // If target is greater, ignore the left half
            if (array[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        return false; // Target not found
    }
}
