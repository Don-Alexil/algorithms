package ro.alexil.algorithms.stacks.a03;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveParentheses {

    /**
     * Given a string s of '(' , ')' and lowercase English characters.
     * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
     * Formally, a parentheses string is valid if and only if:
     * It is the empty string, contains only lowercase characters, or
     * It can be written as AB (A concatenated with B), where A and B are valid strings, or
     * It can be written as (A), where A is a valid string.
     *
     * @param s input string
     * @return a valid parentheses string
     */
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
