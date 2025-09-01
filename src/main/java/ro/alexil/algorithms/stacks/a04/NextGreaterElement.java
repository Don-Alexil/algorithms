package ro.alexil.algorithms.stacks.a04;

import ro.alexil.algorithms.utils.Print;

import java.util.Arrays;
import java.util.Stack;


public class NextGreaterElement {

    private static class Element {
        public int data;
        public int index;

        public Element(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }


    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        Stack<Element> nextGreater = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            int current = arr[i];

            while(!nextGreater.isEmpty() && current > nextGreater.peek().data) {
                Element element = nextGreater.pop();
                result[element.index] = current;
            }

            nextGreater.push(new Element(current, i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] inputs = {
            {5, 21, 4, 9, 6, 3, 2, 1},
            {4, 6, 3, 2, 8, 1, 9, 9, 9},
            {33, 20, 105, 88},
            {12, 5, 44, 56, 46, 78},
            {1, 2, 3, 4, 5},
            {150, 125, 100, 75, 50, 25, 0}
        };

        for(int i = 0; i < inputs.length; i++) {
            System.out.println("Input: " + Print.arrayToString(inputs[i]));
            int[] result = nextGreaterElement(inputs[i]);
            System.out.println("Result: " + Print.arrayToString(result));
            System.out.println(Print.repeat("-", 50));
        }
    }

}
