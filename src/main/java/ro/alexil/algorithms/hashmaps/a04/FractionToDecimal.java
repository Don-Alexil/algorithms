package ro.alexil.algorithms.hashmaps.a04;


import java.util.HashMap;
import java.util.Map;

class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        Map<Long, Integer> remainderMap = new HashMap<>();

        if (numerator == 0) {
            return "0";
        }

        if ((numerator < 0) ^ (denominator < 0)) {
            result.append('-');
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long quotient = num / den;
        long remainder = (num % den) * 10;
        result.append(quotient);

        if (remainder == 0) {
            return result.toString();
        } else {
            result.append(".");
            while (remainder != 0) {
                if (remainderMap.containsKey(remainder)) {
                    int beginning = remainderMap.get(remainder);
                    result = new StringBuilder(result.substring(0, beginning) + "(" + result.substring(beginning) + ")");
                    return result.toString();
                } else {
                    remainderMap.put(remainder, result.length());
                    quotient = remainder / den;
                    remainder = (remainder % den) * 10;
                    result.append(quotient);
                }
            }

            return result.toString();
        }
    }

    public static void main(String[] args) {
        int[][] inputs = { { 0, 4 }, { 4, 2 }, { 5, 333 }, { 2, 3 }, { 47, 18 }, { 93, 7 }, { -5, 333 }, { 47, -18 },
                { -4, -2 } };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1 + ".\tInput: fraction_to_decimal(");
            for (int j = 0; j < inputs[i].length - 1; j++) {
                System.out.print(inputs[i][j]);
                System.out.print(", ");
            }
            System.out.println(inputs[i][inputs[i].length - 1] + ")");
            String result = fractionToDecimal(inputs[i][0], inputs[i][1]);
            System.out.println("\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
