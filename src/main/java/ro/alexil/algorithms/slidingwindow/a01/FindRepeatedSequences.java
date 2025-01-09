package ro.alexil.algorithms.slidingwindow.a01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindRepeatedSequences{

    // brut force ... :)
    public static Set<String> findRepeatedSequences(String dna, int k) {

        Map<String, Integer> frequencies = new HashMap<>();
        for(int i = 0; i < dna.length() - k + 1; i++) {
            String sequence = dna.substring(i, i + k);
            System.out.println(sequence);
            frequencies.put(sequence, frequencies.getOrDefault(sequence, 0) + 1) ;
        }
        // Replace this placeholder return statement with your code

        return frequencies.
                entrySet().stream()
                    .filter(e -> e.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        String dna = "abcedsfgtaaabcfgt";
        int k = 3;
        System.out.println(findRepeatedSequences(dna, k));

    }
}
