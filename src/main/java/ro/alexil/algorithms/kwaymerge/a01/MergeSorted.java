package ro.alexil.algorithms.kwaymerge.a01;

import java.util.Arrays;

public class MergeSorted {

    // refactor
    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m - 1;
        int end2 = n - 1;
        int end = m + n - 1;
        for(int k = m + n -1; k>=0; k--){
            if(end2 < 0) {
                break;
            }
            if(end1 >= 0 && nums1[end1] >= nums2[end2]) {
                nums1[k] = nums1[end1];
                System.out.println(" Putting " + nums1[end1] + " at position " + end + ". End1 = " + end1);
                end1--;
            } else {
                nums1[k] = nums2[end2];
                System.out.println(" Putting " + nums2[end2] + " at position " + end + ". End2 = " + end2);
                end2--;
            }
        }

        // Replace this placeholder return statement with your code
        return nums1;
    }

    public static void main(String[] args) {
        int[][][] inputs = {
                { {3, 4, 9, 0, 0, 0}, {1, 2, 7} },
                { {1, 1, 1, 0, 0, 0}, {1, 1, 1} },

        };

        for(int i=0; i < inputs.length; i++) {
            int m = inputs[i][0].length;
            int n = inputs[i][1].length;
            int[] result = mergeSorted(inputs[i][0], m-n, inputs[i][1], n);
            System.out.println("Merged array : " + Arrays.deepToString(new int[][]{result}));
        }
    }
}
