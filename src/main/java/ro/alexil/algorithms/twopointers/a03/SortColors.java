package ro.alexil.algorithms.twopointers.a03;

import ro.alexil.algorithms.utils.Print;

public class SortColors {

    public static int[] sortColors(int[] colors) {

        // Initialize the start, current, and end pointers
        int start = 0;
        int current = 0;
        int end = colors.length - 1;
        // Iterate through the list until the current pointer exceeds the end pointer
        while (current <= end) {

            if (colors[current] == 0) {

                // If the current element is 0, swap it with the element at the start pointer
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;

                // Move both the start and current pointers one position forward
                current++;
                start++;
            }

            else if (colors[current] == 1) {
                // If the current element is 1, just move the current pointer one position forward
                current++;
            }

            else {

                // If the current element is 2, swap it with the element at the end pointer

                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;

                // Move the end pointer one position backward
                end--;
            }
        }

        return colors;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        // Iterate over the inputs and print the sorted array for each
        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + Print.arrayToString(inputs[i]));

            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Print.arrayToString(sortedColors));

            System.out.println(Print.repeat("-", 100));
        }
    }
}