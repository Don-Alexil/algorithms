package ro.alexil.algorithms.kwaymerge.a02;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindSmallestKNumber {

    public static int kSmallestNumber(List<List<Integer>> lists, int k) {

        PriorityQueue<int[]> smallestHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])) ;

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> current = lists.get(i);
            if(!current.isEmpty()) {
                smallestHeap.offer(new int[] { current.get(0), i, 0 });
            }
        }

        int smallest = 0;
        for(int i=0; i<k; i++) {
            int[] current = smallestHeap.poll();
            if(current == null) {
                break;
            }
            smallest = current[0];
            if(current[2] + 1 < lists.get(current[1]).size()) {
                smallestHeap.offer(new int[] {lists.get(current[1]).get(current[2]+1), current[1], current[2]+1});
            }
        }

        // Replace this placeholder return statement with your code

        return smallest;
    }

    public static void main(String[] args) {
        List<List<Integer>>[] inputs = new List[]{ List.of(
                List.of(1, 4, 5),
                List.of(4, 7, 8),
                List.of(2, 6, 9)
        )};


        int result = kSmallestNumber(inputs[0], 5);
        System.out.println("K smalest number is " + result);

    }
}
