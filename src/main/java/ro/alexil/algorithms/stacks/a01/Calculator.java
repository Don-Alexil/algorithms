package ro.alexil.algorithms.stacks.a01;

import java.util.Stack;

public class Calculator {

    public static int calculator(String expression) {

        int result = 0;
        int currentNumber = 0;
        int currentSign = 1;
        Stack<Integer> expressionBuffer = new Stack<>();
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(c - '0' >= 0 && c-'0' <= 9) {
                currentNumber = currentNumber * 10 + (c - '0');
            }
            if(c == '+' || c == '-') {
                result = computeResult(result, currentSign, currentNumber);
                currentNumber = 0;
                currentSign = c == '+' ? 1 : -1;
            }
            if(c == '(' || c == ')') {
                if(c=='(') {
                    expressionBuffer.push(result);
                    expressionBuffer.push(currentSign);
                    result = 0;
                    currentSign = 1;
                }
                else {
                    result = computeResult(result, currentSign, currentNumber);
                    int popSign = expressionBuffer.pop();
                    int popNumber = expressionBuffer.pop();
                    result *= popSign;
                    result += popNumber;
                    currentSign = 1;
                    currentNumber = 0;
                }
            }
        }
        return  computeResult(result, currentSign, currentNumber);
    }

    private static int computeResult(int result, int currentSign, int currentNumber) {
        result += currentSign * currentNumber;
        return result;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "1+1",
                "-1+7",
                "8+9-3",
                "1+(2+3)+(4+6)",
                "1+((2+3)+(4+6)-1)+2",
                "7-(2+3)"
        };

        for(int i=0; i<inputs.length; i++){
            int result = calculator(inputs[i]);
            System.out.println(i + " Result of '" + inputs[i] + "' is: " + result);
        }
    }

}


