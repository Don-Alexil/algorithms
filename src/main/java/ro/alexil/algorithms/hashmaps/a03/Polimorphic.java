package ro.alexil.algorithms.hashmaps.a03;

import ro.alexil.algorithms.utils.Print;

import java.util.HashMap;
import java.util.Map;

public class Polimorphic {

    public static boolean isIsomorphic(String string1, String string2) {
        if(string1.length() != string2.length()){
            return false;
        }
        // Replace this placeholder return statement with your code
        Map<String, String> correspondence_1_to_2 = new HashMap<>();
        Map<String, String> correspondence_2_to_1 = new HashMap<>();

        for(int i = 0 ; i < string1.length(); i++){
            String c_source = String.valueOf(string1.charAt(i));
            String c_destination = String.valueOf(string2.charAt(i));
            if(correspondence_1_to_2.containsKey(c_source) && !c_destination.equals(correspondence_1_to_2.get(c_source))){
                return false;
            }
            if(correspondence_2_to_1.containsKey(c_destination) && !c_source.equals(correspondence_2_to_1.get(c_destination))){
                return false;
            }
            correspondence_1_to_2.put(c_source, c_destination);
            correspondence_2_to_1.put(c_destination, c_source);
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        String[] A = {"egg", "foo", "paper", "badc", "aaeaa"};
        String[] B = {"all", "bar", "title", "baba", "uuxyy"};
        for (int i = 0; i < A.length; i++) {
            System.out.println((i + 1) + ".\tString 1 = " + A[i]);
            System.out.println("\tString 2 = " + B[i]);
            System.out.println("\n\tIsomorphic String ? " + isIsomorphic(A[i], B[i]));
            System.out.println(Print.repeat("-", 100));
        }
    }

}
