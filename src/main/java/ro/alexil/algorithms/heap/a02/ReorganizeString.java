package ro.alexil.algorithms.heap.a02;

import ro.alexil.algorithms.utils.Print;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    private static class CharCounter {
        public final char character;
        public final int counter;

        public CharCounter(char character, int counter) {
            this.character = character;
            this.counter = counter;
        }
    }

    public static String reorganizeString(String string1) {
        // create a frequencies hashmap
        Map<Character, Integer> frequencies = new HashMap<>();
        for(int i=0; i<string1.length(); i++) {
            char current = string1.charAt(i);
            frequencies.put(current, frequencies.getOrDefault(current, 0) + 1);
        }

        // create a max heap to extract the elements
        PriorityQueue<CharCounter> maxHeap = new PriorityQueue<>((CharCounter a, CharCounter b) -> b.counter - a.counter);
        for(Map.Entry<Character, Integer> frequency:  frequencies.entrySet()) {
            maxHeap.offer(new CharCounter(frequency.getKey(), frequency.getValue()));
        }

        CharCounter previous = null;
        StringBuilder result = new StringBuilder();
        while(!maxHeap.isEmpty() || previous != null) {

            if(previous != null && maxHeap.isEmpty()) {
                return "";
            }

            CharCounter current = maxHeap.poll();
            result.append(current.character);
            int counter = current.counter - 1;

            if(previous != null) {
                maxHeap.offer(previous);
                previous = null;
            }

            if(counter > 0) {
                previous = new CharCounter(current.character, counter);
            }




        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] inputs = {
            "aaabc",
            "aaa",
            "aabb"
        };

        for(String input : inputs) {
            System.out.println("Input String: " + input);
            System.out.println("Reorganized string: " + reorganizeString(input));
            System.out.println(Print.repeat("-", 100));
        }


    }

}
