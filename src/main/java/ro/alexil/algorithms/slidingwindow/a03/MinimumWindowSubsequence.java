package ro.alexil.algorithms.slidingwindow.a03;

public class MinimumWindowSubsequence {

    public static String minWindow(String s, String t) {

        // Replace this placeholder return statement with your code
        String shortestSequence = "";
        int endIndex = findEndIndex(s, t);
        int beginIndex;

        while(endIndex >= 0) {
            beginIndex = findBeginIndex(s, t, endIndex);
            if("".equals(shortestSequence) || shortestSequence.length() > endIndex - beginIndex + 1) {
                shortestSequence  = s.substring(beginIndex, endIndex + 1);
            }
            s = s.substring(beginIndex+1);
            endIndex = findEndIndex(s, t);
        }

        return shortestSequence;
    }

    private static  int findEndIndex(String s, String t) {
        int idxDest = 0;

        for(int i =0; i <s.length(); i++ ) {
            if(s.charAt(i) == t.charAt(idxDest)) {
                idxDest++;
            }
            if(idxDest == t.length()) {
                return i;
            }
        }
        return -1;
    }

    private static  int findBeginIndex(String s, String t, int endIndex) {
        int idxDest = t.length() - 1;

        for(int i = endIndex; i >= 0; i--) {
            if(s.charAt(i) == t.charAt(idxDest)) {
                idxDest--;
            }
            if(idxDest == -1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[]  args) {
        String[][] inputs = {
                {"o" , "o"}
        };

        for(String[] example: inputs) {
            String result = minWindow(example[0], example[1]);
            System.out.println("Min window of '" + example[1] + "' in '" + example[0] + "' is: " + result);
        }
    }
}
