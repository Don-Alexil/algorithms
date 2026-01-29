package ro.alexil.codingchallange.a20260115;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Integer>> columns = new HashMap<>();
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> boxes = new HashMap<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j <9; j++) {
                char current = board[i][j];
                if(current != '.') {
                    int nums = Character.getNumericValue(current);

                    // check rows
                    if(rows.containsKey(i) && rows.get(i).contains(nums)) {
                        return false;
                    }
                    else {
                        rows.putIfAbsent(i, new ArrayList<>());
                        rows.get(i).add(nums);
                    }

                    // check columns
                    if(columns.containsKey(j) && columns.get(j).contains(nums)) {
                        return false;
                    }
                    else {
                        columns.putIfAbsent(j, new ArrayList<>());
                        columns.get(j).add(nums);
                    }

                    // check boxes
                    int boxIndex = (i/3) * 3 + (j/3);
                    if(boxes.containsKey(boxIndex) && boxes.get(boxIndex).contains(nums)) {
                        return false;
                    }
                    else {
                        boxes.putIfAbsent(boxIndex, new ArrayList<>());
                        boxes.get(boxIndex).add(nums);
                    }
                }
            }
        }
        // Replace this placeholder return statement with your code
        return true;
    }
}