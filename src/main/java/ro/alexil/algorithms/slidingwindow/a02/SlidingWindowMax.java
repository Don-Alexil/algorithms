package ro.alexil.algorithms.slidingwindow.a02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMax {

    public static int[] findMaxInWindows(int[] nums, int w) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || w <= 0 || w > nums.length) {
            return new int[]{}; // Return empty result for invalid inputs
        }

        Deque<Integer> deque = new LinkedList<>(); // Stores indices of elements in the current window

        for (int i = 0; i < nums.length; i++) {
            // Remove indices of elements not in the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - w + 1) {
                deque.pollFirst();
            }

            // Remove indices of elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // Add the maximum of the current window to the result
            if (i >= w - 1) { // Start adding results after the first full window
                result.add(nums[deque.peekFirst()]);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int w = 3;

        int[] result = findMaxInWindows(nums, w);
        System.out.println("Maximum values in each window: " + Arrays.deepToString(new int[][]{result}));
    }
}

