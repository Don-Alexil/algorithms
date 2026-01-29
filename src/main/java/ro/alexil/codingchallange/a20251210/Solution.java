package ro.alexil.codingchallange.a20251210;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution{

    public static List<String> removeInvalidParentheses (String s) {
        String r1 = getSolution(s, '(', ')');


        // Replace this placeholder return statement with your code
        return List.of(r1);
    }
    public static String getSolution(String s, char left, char right) {
        Stack<int[]> toRemove = new Stack<>();
        // solution 1
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(current == left) {
                toRemove.push(new int[] { current, i});
            } else if(current == right) {
                if(toRemove.isEmpty()) {
                    toRemove.push(new int[] { current, i});
                }
                else {
                    toRemove.pop();
                }
            }
        }

        List<Integer> idxToRemove = new ArrayList<>();
        while(!toRemove.isEmpty()) {
            idxToRemove.add(toRemove.pop()[1]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < s.length(); i++) {
            if(!idxToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        List<String> inputs = List.of(
                "()())()", "())()(", "()())()", "))((", "()())()"
        );

        for(String input : inputs) {
            System.out.printf("Solutions of %s -> %s\n", input, Solution.removeInvalidParentheses(input));
            System.out.println("------------------------------------------------");
        }
    }
}