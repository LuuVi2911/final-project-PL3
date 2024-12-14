package sort;

import utils.RandomGenerator;

public class SortPerformance {
    private static long compareCount = 0; // Static for global tracking

    public void analyzePerformance(int n) {
        int[] sizes = new int[10];
        for (int i = 0; i < 10; i++) {
            sizes[i] = n * (i + 1);
        }

        System.out.printf("%-25s", "Algorithm/Data Size");
        for (int size : sizes) {
            System.out.printf("%-10d", size);
        }
        System.out.println();

        // Use existing algorithms from QuadraticSort and LogarithmicSort
        compareAndTime(sizes, "Bubble Sort", QuadraticSort::bubbleSort);
        compareAndTime(sizes, "Bucket Sort", QuadraticSort::bucketSort);
        compareAndTime(sizes, "Merge Sort", LogarithmicSort::mergeSort);
        compareAndTime(sizes, "Introsort", LogarithmicSort::introSort);
    }

    private void compareAndTime(int[] sizes, String algorithmName, SortAlgorithm sortAlgorithm) {
        // Comparisons
        System.out.printf("%-25s", algorithmName + " Comparisons");
        for (int size : sizes) {
            int[] array = RandomGenerator.generateRandomArray(size, 0, 100000);
            resetComparisons();
            sortAlgorithm.sort(array);
            System.out.printf("%-10d", getComparisons());
        }
        System.out.println();
    
        // Time
        System.out.printf("%-25s", algorithmName + " Time (ms)");
        for (int size : sizes) {
            int[] array = RandomGenerator.generateRandomArray(size, 0, 100000);
            long startTime = System.nanoTime();
            sortAlgorithm.sort(array);
            long endTime = System.nanoTime();
            double durationInMilliseconds = (endTime - startTime) / 1_000_000.0;  // Convert to milliseconds with decimals
            System.out.printf("%-10.3f", durationInMilliseconds);  // Use .3f for 3 decimal places
        }
        System.out.println();
    }    
    
    // Static method to increment comparisons
    public static void incrementComparisons() {
        compareCount++;
    }

    // Static method to get current comparison count
    public static long getComparisons() {
        return compareCount;
    }

    // Static method to reset comparison count
    public static void resetComparisons() {
        compareCount = 0;
    }

    @FunctionalInterface
    interface SortAlgorithm {
        void sort(int[] array);
    }
}
