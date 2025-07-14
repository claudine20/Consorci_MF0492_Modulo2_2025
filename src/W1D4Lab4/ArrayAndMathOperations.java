package W1D4Lab4;

import java.util.Arrays; // Import the Arrays class for sorting

public class ArrayAndMathOperations {

    /**
     * Task 1: Calculates the difference between the largest and smallest values in an array of integers.
     * The array must have a length of at least 1.
     *
     * @param arr The input array of integers.
     * @return The difference between the largest and smallest values.
     * @throws IllegalArgumentException If the array is null or its length is less than 1.
     */
    public int calculateDifference(int[] arr) {
        // Validate the input array
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Array must not be null and must contain at least one element.");
        }

        // Initialize min and max with the first element of the array
        int minVal = arr[0];
        int maxVal = arr[0];

        // Iterate through the array to find the minimum and maximum values
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i]; // Update minVal if a smaller element is found
            }
            if (arr[i] > maxVal) {
                maxVal = arr[i]; // Update maxVal if a larger element is found
            }
        }

        // Return the difference between the maximum and minimum values
        return maxVal - minVal;
    }

    /**
     * Task 2: Finds the smallest and second smallest elements of a given array and prints them to the console.
     * This method handles arrays with less than two elements by printing appropriate messages.
     *
     * @param arr The input array of integers.
     */
    public void findSmallestAndSecondSmallest(int[] arr) {
        // Check for null array
        if (arr == null) {
            System.out.println("Array is null. Cannot find smallest and second smallest elements.");
            return;
        }

        // Check if the array has at least two elements
        if (arr.length < 2) {
            System.out.println("Array must contain at least two elements to find smallest and second smallest.");
            if (arr.length == 1) {
                System.out.println("Only one element found: " + arr[0]);
            }
            return;
        }

        // Create a copy of the array and sort it to easily find the smallest and second smallest
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr); // Sort the array in ascending order

        // The smallest element is at index 0 after sorting
        int smallest = sortedArr[0];
        // The second smallest element is at index 1 after sorting
        int secondSmallest = sortedArr[1];

        // Print the results to the console
        System.out.println("Smallest element: " + smallest);
        System.out.println("Second smallest element: " + secondSmallest);
    }

    /**
     * Task 3: Calculates the result of the mathematical expression: x^2 + ((4y/5) - x)^2.
     *
     * @param x The value of variable x.
     * @param y The value of variable y.
     * @return The calculated result of the expression.
     */
    public double calculateExpression(double x, double y) {
        // Calculate the term (4y/5)
        double term1 = (4.0 * y) / 5.0;
        // Calculate the term (4y/5 - x)
        double term2 = term1 - x;
        // Calculate the square of x (x^2)
        double xSquared = Math.pow(x, 2);
        // Calculate the square of (4y/5 - x)
        double term2Squared = Math.pow(term2, 2);

        // Return the sum of the two squared terms
        return xSquared + term2Squared;
    }

    public static void main(String[] args) {
        ArrayAndMathOperations calculator = new ArrayAndMathOperations();

        // --- Task 1 Demonstration ---
        System.out.println("--- Task 1: Difference between largest and smallest ---");
        int[] numbers1 = {10, 5, 20, 2, 8};
        try {
            int diff1 = calculator.calculateDifference(numbers1);
            System.out.println("Array: " + Arrays.toString(numbers1) + ", Difference: " + diff1); // Expected: 18 (20 - 2)
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n--- Task 2: Smallest and Second Smallest Elements ---");


        // --- Task 2 Demonstration ---
        int[] data1 = {15, 7, 22, 3, 10, 1};
        System.out.println("Array: " + Arrays.toString(data1));
        calculator.findSmallestAndSecondSmallest(data1); // Expected: Smallest: 1, Second smallest: 3

        int[] data2 = {8, 2, 5, 10};
        System.out.println("\nArray: " + Arrays.toString(data2));
        calculator.findSmallestAndSecondSmallest(data2); // Expected: Smallest: 5, Second smallest: 5


        // --- Task 3 Demonstration ---

        System.out.println("\n--- Task 3: Mathematical Expression Calculation ---");
        // --- Task 3 Demonstration ---
        double x1 = 2.0;
        double y1 = 5.0;
        double result1 = calculator.calculateExpression(x1, y1);
        System.out.println("For x = " + x1 + ", y = " + y1 + ", Result: " + result1);
        // Expected: x^2 + ((4y/5) - x)^2 = 2^2 + ((4*5/5) - 2)^2 = 4 + (4 - 2)^2 = 4 + 4 = 8

        double x3 = 10.0;
        double y3 = 25.0;
        double result3 = calculator.calculateExpression(x3, y3);
        System.out.println("For x = " + x3 + ", y = " + y3 + ", Result: " + result3);
        // Expected: 10^2 + ((4*25/5) - 10)^2 = 100 + (20 - 10)^2 = 100 + 100 = 200
    }
}
