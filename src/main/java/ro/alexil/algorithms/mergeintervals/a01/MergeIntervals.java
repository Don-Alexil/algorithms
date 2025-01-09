package ro.alexil.algorithms.mergeintervals.a01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] lastInterval = intervals[0];
        mergedIntervals.add(lastInterval);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (isOverlap(lastInterval, current)) {
                lastInterval[1] = Math.max(lastInterval[1], current[1]);
            } else {
                lastInterval = current;
                mergedIntervals.add(lastInterval);
            }

        }
        return mergedIntervals.toArray(new int[][]{});
    }

    private static boolean isOverlap(int[] intervalA, int[] intervalB) {
        return intervalA[1] >= intervalB[0] && intervalB[1] >= intervalA[0];
    }

    public static void main(String[] args) {
        int[][][] allIntervals = {
                {{1, 5}, {3, 7}, {4, 6}},
                {{1, 5}, {4, 6}, {6, 8}, {11, 15}},
                {{3, 7}, {6, 8}, {10, 12}, {11, 15}},
                {{1, 5}},
                {{1, 9}, {3, 8}, {4, 4}},
                {{1, 2}, {3, 4}, {8, 8}},
                {{1, 5}, {1, 3}},
                {{1, 5}, {6, 9}},
                {{0, 0}, {1, 18}, {1, 3}}
        };

        int index = 1;
        for (int[][] intervals : allIntervals) {
            System.out.println(index + ".\tIntervals to merge: " + Arrays.deepToString(intervals));
            int[][] result = mergeIntervals(intervals);
            System.out.println("\tMerged intervals: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            index++;
        }

    }

}
