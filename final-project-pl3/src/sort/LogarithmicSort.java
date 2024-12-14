package sort;

import sort.SortPerformance;

public class LogarithmicSort {

    public static void mergeSort(int[] array) {
        if (array.length < 2) return;

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            // Increment comparisons
            SortPerformance.incrementComparisons();
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void introSort(int[] array) {
        introsort(array, 0, array.length - 1, 2 * (int) Math.floor(Math.log(array.length) / Math.log(2)));
    }

    private static void introsort(int[] array, int start, int end, int depthLimit) {
        if (end - start < 16) {
            insertionSort(array, start, end);
        } else if (depthLimit == 0) {
            heapSort(array, start, end);
        } else {
            int pivot = partition(array, start, end);
            introsort(array, start, pivot - 1, depthLimit - 1);
            introsort(array, pivot + 1, end, depthLimit - 1);
        }
    }

    private static void insertionSort(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= start) {
                // Increment comparisons
                SortPerformance.incrementComparisons();
                if (array[j] > key) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }
    }

    private static void heapSort(int[] array, int start, int end) {
        int n = end - start + 1;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, start);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(array, start, start + i);
            heapify(array, i, 0, start);
        }
    }

    private static void heapify(int[] array, int n, int i, int start) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            // Increment comparisons
            SortPerformance.incrementComparisons();
            if (array[start + left] > array[start + largest]) {
                largest = left;
            }
        }

        if (right < n) {
            // Increment comparisons
            SortPerformance.incrementComparisons();
            if (array[start + right] > array[start + largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            swap(array, start + i, start + largest);
            heapify(array, n, largest, start);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // Increment comparisons
            SortPerformance.incrementComparisons();
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
