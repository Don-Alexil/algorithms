package ro.alexil.algorithms.slidingwindow.a04;

public class LongestSubstringKReplacements {

    public static int longestSubstringWithReplacements(String s, int k) {
        int maxLength = 0;
        int[] charCount = new int[26]; // Array to store counts of characters
        int left = 0; // Left pointer of the sliding window
        int maxFreq = 0; // Max frequency of a single character in the current window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount[currentChar - 'a']++;
            maxFreq = Math.max(maxFreq, charCount[currentChar - 'a']);

            // Current window size is (right - left + 1)
            // If the number of characters to replace exceeds k, shrink the window
            while ((right - left + 1) - maxFreq > k) {
                charCount[s.charAt(left) - 'a']--;
                left++;
            }

            // Update the maximum length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aabccbb";
        int k = 2;
        System.out.println("Longest substring length: " + longestSubstringWithReplacements(s, k)); // Output: 5

        s = "abbcb";
        k = 1;
        System.out.println("Longest substring length: " + longestSubstringWithReplacements(s, k)); // Output: 4

        s = "abccde";
        k = 1;
        System.out.println("Longest substring length: " + longestSubstringWithReplacements(s, k)); // Output: 3
    }
}
