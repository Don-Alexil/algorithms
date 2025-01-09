package ro.alexil.algorithms.mergeintervals.a02;

import ro.alexil.algorithms.utils.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int i = 0;
        // add non overlapping at the beginning
        while(i < existingIntervals.length && isBefore(existingIntervals[i], newInterval)){
            mergedIntervals.add(existingIntervals[i]);
            i++;
        }

        int[] current = { newInterval[0], newInterval[1] };
        mergedIntervals.add(current);
        // merge overlapping intervals
        while(i < existingIntervals.length) {
            if(isOverlap(existingIntervals[i], current)) {
                current[0] = Math.min(existingIntervals[i][0], current[0]);
                current[1] = Math.max(existingIntervals[i][1], current[1]);
            }
            else {
                current = existingIntervals[i];
                mergedIntervals.add(current);
            }
            i++;
        }
        return mergedIntervals.toArray(new int[][]{});
    }

    private static boolean isOverlap(int[] intervalA, int[] intervalB) {
        return intervalA[0] <= intervalB[1] && intervalB[0] <= intervalA[1];
    }

    private static boolean isBefore(int[] current, int[] next) {
        return current[1] < next[0];
    }

    public static void main(String[] args) {
        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            int[][] result = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println( ".\tInitial interval: " + Arrays.deepToString(existingIntervals[i]));
            System.out.println( ".\tNew interval: " + Arrays.deepToString(new int[][] { newIntervals[i] }));
            System.out.println("\tMerged intervals: " + Arrays.deepToString(result));
            System.out.println(Print.repeat("-", 50));
        }

    }

}
