package ro.alexil.codingchallange.a20260118;

class Solution {
    public int splitArray(int[] nums, int k) {

        // Replace this placeholder return statement with your code

        return -1;
    }

    public static void main(String[] args) {
        int[][] aNums = {
                {7, 2, 5, 10, 8},
                {1, 2, 3, 4, 5},
                {3, 4, 3, 4, 5, 5, 8, 2},
                {5, 2, 4},
                {1, 6, 2, 6, 8}
        };
        int[] aKs = { 2, 2, 4, 2, 5};

        Solution solution = new Solution();
        for(int i = 0; i < aNums.length; i++) {
            System.out.printf("Solution %d -> %d\n", i, solution.splitArray(aNums[i], aKs[i]));
        }
    }
}