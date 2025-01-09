package ro.alexil.algorithms.heap.a01;

import ro.alexil.algorithms.utils.Print;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
    public PriorityQueue<Integer> topKHeap;
    public int k;

    // Constructor to initialize heap and add values in it
    public KthLargest(int k, int[] nums) {
        System.out.println("\tInitializing the heap");
        this.k = k;
        topKHeap = new PriorityQueue<>();

        System.out.println("\tk = " + this.k);
        System.out.println("\tHeap: " + topKHeap);

        for (int element : nums) {
            System.out.println("\tAdding element " + element + " to the heap.");
            add(element);
        }
    }

    // Adds element in the heap and return the Kth largest
    public int add(int val) {
        if (topKHeap.size() < k) {
            System.out.println("\n\tSize of the heap is less than k, so we’ll push " + val);
            topKHeap.offer(val);
        } else if (val > topKHeap.peek()) {
            System.out.println("\n\tSize of the heap is equal to k and " + val + " is greater than the top of heap " + topKHeap.peek());
            System.out.println("\tWe will poll the top element from heap and offer the new element.");
            topKHeap.poll();
            topKHeap.offer(val);
        } else {
            System.out.println("\n\tSize of the heap is equal to k and " + val + " is equal to or smaller than the top of heap.");
            System.out.println("\tNo operation will be performed.");
        }

        System.out.println("\tHeap: " + topKHeap);
        return topKHeap.peek();
    }

    // Driver code
    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 10};
        int[] temp = {3, 6, 9, 10};
        System.out.print("Initial stream: ");
        System.out.print(Print.arrayToString(nums));
        System.out.println("\nk: " + 3);
        KthLargest kLargest = new KthLargest(3, nums);
        int[] val = {4, 7, 10, 8, 15};
        for (int i = 0; i < val.length; i++) {
            System.out.println("\tAdding a new number " + val[i] + " to the stream");
            temp = Arrays.copyOf(temp, temp.length + 1);
            temp[temp.length - 1] = val[i];
            System.out.print("\tNumber stream: ");
            System.out.print(Print.arrayToString(temp));
            System.out.println("\tKth largest element in the stream: " + kLargest.add(val[i]));
            System.out.println(Print.repeat("-", 100));
        }
    }
}