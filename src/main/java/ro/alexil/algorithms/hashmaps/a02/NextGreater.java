package ro.alexil.algorithms.hashmaps.a02;

import ro.alexil.algorithms.utils.Print;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class NextGreater {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nextGrater = new HashMap<>();

        // iterate over nums2
        for (int current : nums2) {
            // while stack is not empty and current element is greater than the top element of the stack
            while (!stack.empty() && current > stack.peek()) {
                // update the map with the current element as the value for the popped element
                nextGrater.put(stack.pop(), current);
            }
            // push the current element to the stack
            stack.push(current);
        }

        // iterate over remaining elements in the stack, pop them and set their values to -1 in the map
        while (!stack.empty()) {
            nextGrater.put(stack.pop(), -1);
        }

        int[] ans = new int[nums1.length];
        // iterate over nums1 and add the corresponding value from the map to ans
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGrater.get(nums1[i]);
        }

        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        /*
        int[][] A = {
                {2, 4},
                {3, 2, 5},
                {14, 45, 52},
                {1, 3, 2},
                {4, 2},
                {0}
        };
        int[][] B = {
                {1, 2, 3, 4},
                {2, 3, 5, 1},
                {52, 14, 45, 65},
                {1, 3, 2, 4, 5},
                {1, 2, 4, 3},
                {0}
        };
        */
        int[][] A = {
                {1, 3, 2}
        };
        int[][] B = {
                {1, 3, 2, 4, 5}
        };
        int x = 1;
        for (int i = 0; i < A.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tNums 1 = " + Arrays.toString(A[i]));
            System.out.println("\tNums 2 = " + Arrays.toString(B[i]));
            System.out.print("");
            System.out.println("\tThe Next Greater Element Array = " + Arrays.toString(nextGreaterElement(A[i], B[i])));
            System.out.println(Print.repeat("-", 100));
        }
    }
}