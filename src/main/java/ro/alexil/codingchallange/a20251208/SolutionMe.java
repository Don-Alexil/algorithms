package ro.alexil.codingchallange.a20251208;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SolutionMe
{

    private static Comparator<String> LEXIBOX = (s1, s2) ->
            (s1.charAt(0) - s2.charAt(0)) != 0 ? s1.charAt(0) - s2.charAt(0) : s1.length() - s2.length();

    public String answerString(String word, int numFriends)
    {
        if(numFriends < 0 || numFriends > word.length()) {
            return "";
        }
        if(numFriends == 1) {
            return word;
        }

        String maxString = "";
        Set<List<String>> combinations = new HashSet<>();
        getCombinations(word, numFriends, new ArrayList<>(), combinations);
        for(List<String> combination : combinations) {

        }
        return maxString;
    }

    private void getCombinations(String word, int remaining, List<String> current, Set<List<String>> results) {
        if(remaining == 1) {
            current.add(word);
            results.add(new ArrayList<>(current));
            current.removeLast();
            return;
        }

        int maxLength = word.length() - remaining + 1;
        for(int len = 1; len <= maxLength; len++) {
            String chunk = word.substring(0, len);
            current.add(chunk);
            getCombinations(word.substring(len), remaining - 1, current, results);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] friends = {2, 4, 2, 3, 3};
        List<String> words = List.of("dbca", "gggg","acbd","zxya", "mnopqr");

        SolutionMe solution = new SolutionMe();
        for(int i=0; i<friends.length; i++) {
            System.out.printf("Result for %s -> %s\n", words.get(i), solution.answerString(words.get(i), friends[i]));
            System.out.println("---------------------------------------------");
        }
    }
}