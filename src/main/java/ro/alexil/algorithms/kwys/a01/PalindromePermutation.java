package ro.alexil.algorithms.kwys.a01;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PalindromePermutation {

    public static boolean permutePalindrome(String st) {

        Map<Character, Long> charCountMap = st.chars()
                .mapToObj(c -> (char) c) // Convert int to char
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long oddOccurrences = charCountMap.values()
                .stream()
                .map(i -> i % 2)
                .reduce(0L, Long::sum);
             return oddOccurrences <= 1;
    }

    public static void main(String[] args) {
        var testStrings = List.of("aab", "abcab", "abc", "aaaccc");
        String template = "String %s is a palindrome : %s %n";
        testStrings.forEach(
                s -> System.out.printf(template, s, permutePalindrome(s))
        );
    }
}
