package ro.alexil.codingchallange.a20251207;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SolutionEd {

    private char evaluateSubExpr(char op, List<Character> values) {
        if (op == '!')
            return values.get(0) == 't' ? 'f' : 't';

        if (op == '&') {
            for (char value : values) {
                if (value == 'f') return 'f';
            }
            return 't';
        }

        if (op == '|') {
            for (char value : values) {
                if (value == 't') return 't';
            }
            return 'f';
        }

        return 'f';
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == ')') {
                List<Character> values = new ArrayList<>();

                while (st.peek() != '(') {
                    values.add(st.pop());
                }
                st.pop();

                char op = st.pop();

                char result = evaluateSubExpr(op, values);
                st.push(result);
            } else if (c != ',') {
                st.push(c);
            }
        }

        return st.peek() == 't';
    }
}
