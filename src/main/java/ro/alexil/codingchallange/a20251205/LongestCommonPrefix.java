package ro.alexil.codingchallange.a20251205;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }

        String prefix = "";
        int current = 0;
        int minLength = Integer.MAX_VALUE;
        for(String str: strs) {
            if(str.length() < minLength) {
                minLength = str.length();
            }
        }

        while(current < minLength) {
            boolean allMatch = true;
            char currentChar = strs[0].charAt(current);
            for(String string: strs){
                if(string.charAt(current) != currentChar) {
                    allMatch = false;
                    break;
                }
            }
            if(allMatch) {
                prefix += strs[0].charAt(current);
            } else {
                return prefix;
            }
            current++;
        }


        // Replace the following return statement with your code
        return prefix;
    }


    public static void main(String[] args) {
        String[][] testCases = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"},
                {"interspecies", "interstellar", "interstate"},
                {"throne", "dungeon"},
                {"throne", "throne"},
                {"apple", "app"},
                {"a", "b", "c"},
                {"reflower", "flow", "flight"},
                {"preach", "prevent", "prelude", "press"},
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.print(i + 1 + ".\t Input strings: [");
            for (int j = 0; j < testCases[i].length; j++) {
                System.out.print("'" + testCases[i][j] + "'");
                if (j < testCases[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.println("\t Longest common prefix: '" + LongestCommonPrefix.longestCommonPrefix(testCases[i]) + "'");
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
