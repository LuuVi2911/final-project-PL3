package sort;

import sort.SortPerformance;

/**
 * This class implements O(n*log(n)) sorting algorithms: Merge Sort and Introsort.
 * It includes utility methods to support hybrid sorting approaches.
 * Performance is tracked via SortPerformance.incrementComparisons().
 */
public class LogarithmicSort {

    /**
     * Performs Merge Sort on the given array.
     * @param array The array to be sorted.
     */
    public static void mergeSort(int[] array) {
        if (array.length < 2) return; // Base case: array with 1 or fewer elements is already sorted

        int mid = array.length / 2; // Determine the midpoint
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Split the array into left and right halves
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // Recursively sort the left and right halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(array, left, right);
    }

    /**
     * Merges two sorted arrays into one.
     * @param array The original array to hold the merged result.
     * @param left The sorted left half.
     * @param right The sorted right half.
     */
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge elements from left and right into the original array
        while (i < left.length && j < right.length) {
            SortPerformance.incrementComparisons(); // Track comparisons
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements from left
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements from right
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    /**
     * Performs Introsort on the given array.
     * @param array The array to be sorted.
     */
    public static void introSort(int[] array) {
        // Calculate maximum depth as 2 * log2(n)
        introsort(array, 0, array.length - 1, 2 * (int) Math.floor(Math.log(array.length) / Math.log(2)));
    }

    /**
     * Recursive implementation of Introsort.
     * @param array The array to be sorted.
     * @param start Start index of the array.
     * @param end End index of the array.
     * @param depthLimit Maximum recursion depth allowed.
     */
    private static void introsort(int[] array, int start, int end, int depthLimit) {
        if (end - start < 16) {
            insertionSort(array, start, end); // Use insertion sort for small subarrays
        } else if (depthLimit == 0) {
            heapSort(array, start, end); // Use heapsort if depth limit is reached
        } else {
            int pivot = partition(array, start, end); // Partition the array
            introsort(array, start, pivot - 1, depthLimit - 1); // Sort left partition
            introsort(array, pivot + 1, end, depthLimit - 1); // Sort right partition
        }
    }

    /**
     * Performs Insertion Sort on a subarray.
     * @param array The array to be sorted.
     * @param start Start index of the subarray.
     * @param end End index of the subarray.
     */
    private static void insertionSort(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = array[i];
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= start) {
                SortPerformance.incrementComparisons(); // Track comparisons
                if (array[j] > key) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = key; // Place the key in its correct position
        }
    }

    /**
     * Performs Heap Sort on a subarray.
     * @param array The array to be sorted.
     * @param start Start index of the subarray.
     * @param end End index of the subarray.
     */
    private static void heapSort(int[] array, int start, int end) {
        int n = end - start + 1;

        // Build the heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, start);
        }

        // Extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            swap(array, start, start + i); // Swap root with the last element
            heapify(array, i, 0, start); // Re-heapify the reduced heap
        }
    }

    /**
     * Maintains the heap property for a given subtree.
     * @param array The array representing the heap.
     * @param n Size of the heap.
     * @param i Index of the root of the subtree.
     * @param start Offset for subarray within the heap.
     */
    private static void heapify(int[] array, int n, int i, int start) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child is larger
        if (left < n) {
            SortPerformance.incrementComparisons();
            if (array[start + left] > array[start + largest]) {
                largest = left;
            }
        }

        // Check if right child is larger
        if (right < n) {
            SortPerformance.incrementComparisons();
            if (array[start + right] > array[start + largest]) {
                largest = right;
            }
        }

        // Swap and heapify if root is not largest
        if (largest != i) {
            swap(array, start + i, start + largest);
            heapify(array, n, largest, start);
        }
    }

    /**
     * Partitions the array for quicksort.
     * @param array The array to be partitioned.
     * @param low Start index.
     * @param high End index.
     * @return Index of the pivot element.
     */
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            SortPerformance.incrementComparisons(); // Track comparisons
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps two elements in the array.
     * @param array The array containing the elements.
     * @param i Index of the first element.
     * @param j Index of the second element.
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
