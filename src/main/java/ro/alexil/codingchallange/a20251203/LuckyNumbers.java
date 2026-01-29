package ro.alexil.codingchallange.a20251203;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] min = new int[m][2];
        int[][] max = new int[n][2];

        // initialize min and max arrays
        for(int i = 0; i < m; i++) {
            min[i][0]  = Integer.MAX_VALUE;
        }
        for(int i = 0; i < n; i++) {
            max[i][0] = Integer.MIN_VALUE;
        }

        // find min in rows and max in columns
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(matrix[row][col] < min[row][0]) {
                    min[row][0] = matrix[row][col];
                    min[row][1] = col;
                }
                if(matrix[row][col] > max[col][0]) {
                    max[col][0] = matrix[row][col];
                    max[col][1] = row;
                }
            }
        }

        // find lucky numbers
        for (int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(min[row][0] == max[col][0] && min[row][1] == col && max[col][1] == row) {
                    result.add(min[row][0]);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][][] matrix = {
            {{3,7,8}, {9,11,13}, {15,16,17}},
            {{1,2,3},{4,5,6},{7,8,9}}
        };

        for (int[][] ints : matrix) {
            System.out.println("Input Matrix:");
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            List<Integer> luckyNumbers = luckyNumbers(ints);
            System.out.println("Lucky Numbers: " + luckyNumbers);
            System.out.println("--------------------------------------------------");
        }
    }
}
