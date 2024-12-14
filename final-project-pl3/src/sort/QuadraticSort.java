package sort;

import sort.SortPerformance;
import java.util.ArrayList;
import java.util.Collections;

public class QuadraticSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Increment comparisons
                SortPerformance.incrementComparisons();
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void bucketSort(int[] array) {
        int n = array.length;
        if (n <= 0) return;

        int max = array[0], min = array[0];
        for (int i : array) {
            SortPerformance.incrementComparisons();
            if (i > max) max = i;
            SortPerformance.incrementComparisons();
            if (i < min) min = i;
        }

        int bucketCount = (max - min) / n + 1;
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i : array) {
            SortPerformance.incrementComparisons();
            buckets[(i - min) / n].add(i);
        }

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket); // Java's built-in sort
            for (int value : bucket) {
                array[index++] = value;
            }
        }
    }
}
