package ro.alexil.algorithms.slidingwindow.a05;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static int findLongestSubstring(String str) {
        if(str == null) {
            return 0;
        }
        int start = 0;
        int result = 0;
        Map<Character, Integer> lastIndexes = new HashMap<>();
        for(int idx =0; idx < str.length(); idx++) {
            char current = str.charAt(idx);
            // check if we encountered a repeating character
            if(lastIndexes.containsKey(current) && lastIndexes.get(current) >= start) {
                result = Math.max(idx - start, result);
                start = lastIndexes.get(current) + 1;
            }
            lastIndexes.put(current, idx);
        }
        return Math.max(str.length() - start, result);
    }

    public static void main(String[] args) {
        String[] inputs = {
            "abcdaazxyt"
        };

        for(String s : inputs) {
            int result = findLongestSubstring(s);
            System.out.println("Longest length of substring of '" + s + "' is '" + result);
        }
    }
}
