package ro.alexil.algorithms.slidingwindow.a01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindRepeatedSequences {

    public static Set<String> findRepeatedSequences(String dna, int k) {
        if(dna.length() < k) {
            return Set.of();
        }

        Map<Character, Integer> toInt = Map.of('A', 0, 'C', 1, 'G', 2, 'T', 3);


        var a = 4; // number of characters
        var a_k = 1;

        // get hash for first k length sequence
        var hash = 0;
        for(int i = 0; i < k; i++) {
            hash = hash * a + toInt.get(dna.charAt(i));
            a_k *= 4;
        }

        var seenHashes = new HashSet<Integer>();
        var output = new HashSet<String>();
        seenHashes.add(hash);
        for(int i = 1; i <= dna.length() - k; i++) {
            // remove first character and add new character
            hash = hash * a - toInt.get(dna.charAt(i-1)) * a_k + toInt.get(dna.charAt(i + k -1));
            if(!seenHashes.add(hash)) {
                output.add(dna.substring(i, i + k));
            }
        }
        return output;
    }


    public static void main(String[] args) {
        String dna = "ACGAATTCACG";
        int k = 3;
        System.out.println(findRepeatedSequences(dna, k));

    }
}
