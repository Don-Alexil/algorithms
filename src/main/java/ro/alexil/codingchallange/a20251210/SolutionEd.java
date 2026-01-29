package ro.alexil.codingchallange.a20251210;

import java.math.BigDecimal;
import java.util.*;

public class SolutionEd {

    public static List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();

        int leftToRemove = 0, rightToRemove = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftToRemove++;
            } else if (c == ')') {
                if (leftToRemove > 0) {
                    leftToRemove--;
                } else {
                    rightToRemove++;
                }
            }
        }

        backtrack(s, 0, 0, 0, new StringBuilder(), leftToRemove, rightToRemove, result);

        return new ArrayList<>(result);
    }

    private static void backtrack(String s, int index, int openCount, int closeCount,
                                  StringBuilder path, int leftRemain, int rightRemain,
                                  Set<String> result) {
        if (index == s.length()) {
            if (leftRemain == 0 && rightRemain == 0 && openCount == closeCount) {
                result.add(path.toString());
            }
            return;
        }

        char ch = s.charAt(index);
        int len = path.length();

        if (ch == '(') {
            if (leftRemain > 0) {
                backtrack(s, index + 1, openCount, closeCount, path, leftRemain - 1, rightRemain, result);
            }

            path.append(ch);
            backtrack(s, index + 1, openCount + 1, closeCount, path, leftRemain, rightRemain, result);
            path.setLength(len); // backtrack
        } else if (ch == ')') {
            if (rightRemain > 0) {
                backtrack(s, index + 1, openCount, closeCount, path, leftRemain, rightRemain - 1, result);
            }
            if (closeCount < openCount) {
                path.append(ch);
                backtrack(s, index + 1, openCount, closeCount + 1, path, leftRemain, rightRemain, result);
                path.setLength(len); // backtrack
            }
        } else {
            path.append(ch);
            backtrack(s, index + 1, openCount, closeCount, path, leftRemain, rightRemain, result);
            path.setLength(len); // backtrack
        }
    }

    public static void main(String[] args) {
        String[] testCases = {
                "()())()",
                "(a)())()",
                ")(",
                "(a(b(c)d)",
                "((()())(()"
        };

        for (int i = 0; i < testCases.length; i++) {
            List<String> result = removeInvalidParentheses(testCases[i]);
            System.out.println((i + 1) + ".\tInput: " + testCases[i]);
            System.out.println("\tValid Outputs: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        System.out.println(1 << 2);
    }
}

