package sort;

import sort.SortPerformance;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class implements O(n²) sorting algorithms: Bubble Sort and Bucket Sort.
 * Both algorithms are designed to demonstrate quadratic time complexity.
 * Performance is tracked using SortPerformance.incrementComparisons().
 */
public class QuadraticSort {

    /**
     * Performs Bubble Sort on the given array.
     * Bubble Sort is a simple comparison-based algorithm that repeatedly
     * steps through the list, compares adjacent elements, and swaps them
     * if they are in the wrong order.
     *
     * @param array The array to be sorted.
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for adjacent comparisons
            for (int j = 0; j < n - i - 1; j++) {
                // Increment comparisons for performance tracking
                SortPerformance.incrementComparisons();
                if (array[j] > array[j + 1]) {
                    // Swap adjacent elements if out of order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Performs Bucket Sort on the given array.
     * Bucket Sort divides elements into buckets, sorts each bucket,
     * and then concatenates the sorted buckets to form the final sorted array.
     *
     * @param array The array to be sorted.
     */
    public static void bucketSort(int[] array) {
        int n = array.length;
        if (n <= 0) return; // Handle empty array edge case

        // Find the maximum and minimum values in the array
        int max = array[0], min = array[0];
        for (int i : array) {
            // Increment comparisons for performance tracking
            SortPerformance.incrementComparisons();
            if (i > max) max = i;
            SortPerformance.incrementComparisons();
            if (i < min) min = i;
        }

        // Calculate the number of buckets required
        int bucketCount = (max - min) / n + 1;
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>(); // Initialize each bucket
        }

        // Distribute array elements into buckets
        for (int i : array) {
            SortPerformance.incrementComparisons();
            buckets[(i - min) / n].add(i);
        }

        // Sort each bucket and concatenate the results
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket); // Sort each bucket using Java's built-in sort
            for (int value : bucket) {
                array[index++] = value; // Add sorted elements back to the array
            }
        }
    }
}
