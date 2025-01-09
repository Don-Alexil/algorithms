package ro.alexil.algorithms.stacks.a03;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveParentheses {

    public static String minRemoveParentheses(String s) {
        Stack<int[]> unclosed = new Stack<>();

        for(int i=0; i < s.length(); i++) {
            char current = s.charAt(i);
            if('(' == current || ')' == current) {
                if(unclosed.empty() || !(current == ')' && unclosed.peek()[0] == '(')) {
                    unclosed.push(new int[] { current, i} );
                }
                else {
                    unclosed.pop();
                }
            }

        }

        Set<Integer> indexesToRemove = new HashSet<>();
        while(!unclosed.empty()) {
            indexesToRemove.add(unclosed.pop()[1]);
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(!indexesToRemove.contains(i)){
                result.append(current);
            }
        }
        // Replace this placeholder return statement with your code
        return result.toString();
    }

    public static void main(String[] args) {

        String[] inputs = {
                "(",
                ")(",
                ")",
                "(((a",
                "(((abc)(to)((q)()(",
                "ab)ca(so)(sc(s)(",
                "(((a",
                "a)))"
        };

        for(int i=0; i<inputs.length; i++){
            String result = minRemoveParentheses(inputs[i]);
            System.out.println(i + " Result of '" + inputs[i] + "' is: " + result);
        }

    }
}
