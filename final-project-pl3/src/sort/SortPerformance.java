package sort;

import utils.RandomGenerator;

/**
 * This class is responsible for analyzing the performance of sorting algorithms.
 * It tracks and displays the number of comparisons and execution time for different
 * data sizes using various sorting algorithms.
 */
public class SortPerformance {
    private static long compareCount = 0; // Tracks the number of comparisons globally across all sorts

    /**
     * Analyzes the performance of multiple sorting algorithms for varying data sizes.
     * @param n The base size for generating datasets (e.g., n, 2n, ..., 10n).
     */
    public void analyzePerformance(int n) {
        // Generate array sizes (n, 2n, ..., 10n)
        int[] sizes = new int[10];
        for (int i = 0; i < 10; i++) {
            sizes[i] = n * (i + 1);
        }

        // Print header for data size
        System.out.printf("%-25s", "Algorithm/Data Size");
        for (int size : sizes) {
            System.out.printf("%-10d", size);
        }
        System.out.println();

        // Analyze performance for each sorting algorithm
        compareAndTime(sizes, "Bubble Sort", QuadraticSort::bubbleSort);
        compareAndTime(sizes, "Bucket Sort", QuadraticSort::bucketSort);
        compareAndTime(sizes, "Merge Sort", LogarithmicSort::mergeSort);
        compareAndTime(sizes, "Introsort", LogarithmicSort::introSort);
    }

    /**
     * Tracks and displays the number of comparisons and execution time for a given sorting algorithm.
     * @param sizes Array of dataset sizes to test.
     * @param algorithmName Name of the sorting algorithm (e.g., "Bubble Sort").
     * @param sortAlgorithm Sorting algorithm implementation to test.
     */
    private void compareAndTime(int[] sizes, String algorithmName, SortAlgorithm sortAlgorithm) {
        // Print comparison counts for the algorithm
        System.out.printf("%-25s", algorithmName + " Comparisons");
        for (int size : sizes) {
            int[] array = RandomGenerator.generateRandomArray(size, 0, 100000); // Generate a random dataset
            resetComparisons(); // Reset the comparison counter
            sortAlgorithm.sort(array); // Perform the sort
            System.out.printf("%-10d", getComparisons()); // Display the number of comparisons
        }
        System.out.println();

        // Print execution times for the algorithm
        System.out.printf("%-25s", algorithmName + " Time (ms)");
        for (int size : sizes) {
            int[] array = RandomGenerator.generateRandomArray(size, 0, 100000); // Generate a random dataset
            long startTime = System.nanoTime(); // Start the timer
            sortAlgorithm.sort(array); // Perform the sort
            long endTime = System.nanoTime(); // End the timer
            double durationInMilliseconds = (endTime - startTime) / 1_000_000.0; // Convert nanoseconds to milliseconds
            System.out.printf("%-10.3f", durationInMilliseconds); // Display the duration with 3 decimal places
        }
        System.out.println();
    }

    /**
     * Increments the comparison count.
     * This method is used by sorting algorithms to track the number of comparisons made.
     */
    public static void incrementComparisons() {
        compareCount++;
    }

    /**
     * Returns the current comparison count.
     * @return The number of comparisons made so far.
     */
    public static long getComparisons() {
        return compareCount;
    }

    /**
     * Resets the comparison count to zero.
     */
    public static void resetComparisons() {
        compareCount = 0;
    }

    /**
     * Functional interface for sorting algorithms.
     * Allows passing sorting methods as arguments to other methods.
     */
    @FunctionalInterface
    interface SortAlgorithm {
        void sort(int[] array);
    }
}
