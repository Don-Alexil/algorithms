package ro.alexil.codingchallange.a20251207;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public boolean parseBoolExpr(String expression) {
        Stack<Character> operations = new Stack<>();
        Stack<List<Boolean>> exprElements = new Stack<>();
        List<Boolean> currentElements = new ArrayList<>();
        boolean currentResult = false;
        for(int i=0; i< expression.length(); i++){
            char current = expression.charAt(i);
            if(current == 't' || current == 'f') {
                currentResult = current == 't';
            }
            else if(current == '!' || current == '&' || current == '|') {
                operations.push(current);
            }
            else if(current == '(' || current == ')') {
                if(current == '(') {
                    exprElements.push(new ArrayList<>(currentElements));
                    currentElements = new ArrayList<>();
                }
                else {
                    currentElements.add(currentResult);
                    currentResult = computeResult(operations.pop(), currentElements);
                    currentElements = new ArrayList<>(exprElements.pop());
                }
            }
            else if(current == ',') {
                currentElements.add(currentResult);
            }

        }
        // Replace this placeholder return statement with your code
        return currentResult;
    }

    private boolean computeResult(char operation, List<Boolean> elements) {
        return switch (operation) {
            case '!' -> !elements.getFirst();
            case '&' -> elements.stream().reduce(true, (acc, elem) -> acc && elem);
            case '|' -> elements.stream().reduce(false, (acc, elem) -> acc || elem);
            default -> false;
        };

    }
    public static void main(String[] args) {
        List<String> requests = List.of(
                "|(&(t,t,f))", "&(t,t,t,t)", "&(t,t,t,t)", "!(!(!(!(t))))", "|(&(t,f),!(f),&(t,t))"
        );

        Solution solution = new Solution();
        for(String request : requests) {
            System.out.printf("Result for %s : %b\n", request, solution.parseBoolExpr(request));
            System.out.println("--------------------------------------------------------------");
        }

    }
}
