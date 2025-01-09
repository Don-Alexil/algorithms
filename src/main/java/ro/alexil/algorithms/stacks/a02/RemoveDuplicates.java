package ro.alexil.algorithms.stacks.a02;

import java.util.Stack;

public class RemoveDuplicates {

    public static String removeDuplicates(String s) {
        Stack<Character> reverseNonDuplicates = new Stack<>();
        StringBuilder result = new StringBuilder();
        // Replace this placeholder return statement with your code

        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (reverseNonDuplicates.empty() || current != reverseNonDuplicates.peek()) {
                reverseNonDuplicates.push(current);
            } else {
                reverseNonDuplicates.pop();
            }
        }

        while (!reverseNonDuplicates.empty()) {
            result.insert(0, reverseNonDuplicates.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] inputs = {
                "g",
                "ggaabcdeb",
                "abbddaccaaabcd",
                "aabbccdd",
                "aannkwwwkkkwna"
        };

        for(int i=0; i<inputs.length; i++){
            String result = removeDuplicates(inputs[i]);
            System.out.println(i + " Result of '" + inputs[i] + "' is: " + result);
        }
    }
}
