import search.LinearSearch;
import search.BinarySearch;
import sort.QuadraticSort;
import sort.LogarithmicSort;
import sort.SortPerformance;
import utils.RandomGenerator;
import java.util.Scanner;

/**
 * Main class for the Sorting and Searching Project.
 * Provides a user interface to test various algorithms and analyze performance.
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the menu options
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. O(n²) Sorting");
            System.out.println("4. O(n*log(n)) Sorting");
            System.out.println("5. Sorting Performance");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Performing Linear Search...");
                    LinearSearch.performSearch(); // Perform Linear Search
                    break;

                case 2:
                    System.out.println("Performing Binary Search...");
                    BinarySearch.performSearch(); // Perform Binary Search
                    break;

                case 3:
                    // O(n²) Sorting: Provides a choice between Bubble Sort and Bucket Sort
                    System.out.println("Performing O(n²) Sorting...");
                    System.out.println("Choose Sorting Algorithm: 1. Bubble Sort 2. Bucket Sort");
                    int quadraticSortChoice = scanner.nextInt(); // Read user's choice for sorting algorithm
                    int[] quadraticArray = RandomGenerator.generateRandomArray(10, 0, 100); // Generate random array

                    // Perform sorting based on user's choice
                    if (quadraticSortChoice == 1) {
                        QuadraticSort.bubbleSort(quadraticArray); // Perform Bubble Sort
                        System.out.println("Sorted using Bubble Sort:");
                    } else if (quadraticSortChoice == 2) {
                        QuadraticSort.bucketSort(quadraticArray); // Perform Bucket Sort
                        System.out.println("Sorted using Bucket Sort:");
                    } else {
                        // Handle invalid input
                        System.out.println("Invalid choice for O(n²) Sorting!");
                    }
                    RandomGenerator.printArray(quadraticArray); // Print the sorted array
                    break;

                case 4:
                    // O(n*log(n)) Sorting: Provides a choice between Merge Sort and Introsort
                    System.out.println("Performing O(n*log(n)) Sorting...");
                    System.out.println("Choose Sorting Algorithm: 1. Merge Sort 2. Introsort");
                    int logarithmicSortChoice = scanner.nextInt(); // Read user's choice for sorting algorithm
                    int[] logarithmicArray = RandomGenerator.generateRandomArray(10, 0, 100); // Generate random array

                    // Perform sorting based on user's choice
                    if (logarithmicSortChoice == 1) {
                        LogarithmicSort.mergeSort(logarithmicArray); // Perform Merge Sort
                        System.out.println("Sorted using Merge Sort:");
                    } else if (logarithmicSortChoice == 2) {
                        LogarithmicSort.introSort(logarithmicArray); // Perform Introsort
                        System.out.println("Sorted using Introsort:");
                    } else {
                        // Handle invalid input
                        System.out.println("Invalid choice for O(n*log(n)) Sorting!");
                    }
                    RandomGenerator.printArray(logarithmicArray); // Print the sorted array
                    break;

                case 5:
                    System.out.println("Analyzing Sorting Performance...");
                    System.out.print("Enter the base data size (n): ");
                    int baseSize = scanner.nextInt();
                    SortPerformance performance = new SortPerformance();
                    performance.analyzePerformance(baseSize); // Analyze sorting performance
                    break;

                case 6:
                    System.out.println("Exiting program");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
