package ro.alexil.algorithms.mergeintervals.a03;

import ro.alexil.algorithms.utils.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {
    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        // Replace this placeholder return statement with your code
        List<int[]> result = new ArrayList<>();
        int currentA = 0;
        int currentB = 0;
        while(currentA < intervalLista.length && currentB < intervalListb.length) {
            int end = Math.min(intervalLista[currentA][1], intervalListb[currentB][1]);
            int start = Math.max(intervalLista[currentA][0], intervalListb[currentB][0]);

            if(start <= end) {
                result.add(new int[] {start, end});
            }

            if(intervalLista[currentA][1] == end) {
                currentA++;
            }
            else {
                currentB++;
            }
        }

        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][][] intervalsA = {
            { {1, 7}}
        };

        int[][][] intervalsB = {
            {{1,2}, {3, 9}, {11, 13} }
        };

        for(int i=0; i<intervalsA.length; i++) {
            System.out.println( ".\tInterval A: " + Arrays.deepToString(intervalsA[i]));
            System.out.println( ".\tInterval B: " + Arrays.deepToString(intervalsB[i]));
            int[][] intersection = intervalsIntersection(intervalsA[i], intervalsB[i]);
            System.out.println(".\tIntersection: " + Arrays.deepToString(intersection));
            System.out.println(Print.repeat("-", 50));
        }

    }
}
