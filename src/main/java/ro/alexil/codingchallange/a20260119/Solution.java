package ro.alexil.codingchallange.a20260119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int countPairs(List<Integer> nums, int target) {
        nums = new ArrayList<>(nums);
        Collections.sort(nums);
        // Replace this placeholder return statement with your code
        int size = nums.size();
        int counter = 0;
        int left = 0;
        int right = size -1;
        while(left < right) {
            if(nums.get(left) + nums.get(right) < target) {
                counter += right - left;
                left ++ ;
            }
            else {
                right--;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        List<List<Integer>> aNums = List.of(
            List.of(1,3,2,4,5),
            List.of(10, 20, 30, 40),
            List.of(5,1,3,2),
            List.of(20,20,20,20,20,20),
            List.of(-5, -4, -3)
        );
        int[] aKs = { 6, 50, 7, 7, -5};

        for(int i = 0; i < aNums.size(); i++) {
            System.out.printf("Solution %d -> %d\n", i, Solution.countPairs(aNums.get(i), aKs[i]));
        }
    }
}
