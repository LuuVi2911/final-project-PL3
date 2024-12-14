package utils;

import java.util.Random;

public class RandomGenerator {

    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        if (size <= 0 || minValue > maxValue) {
            throw new IllegalArgumentException("Invalid size or range for random array generation.");
        }

        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        return array;
    }

    public static void printArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty.");
        } else {
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
