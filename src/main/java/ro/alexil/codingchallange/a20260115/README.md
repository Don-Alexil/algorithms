# Valid Sudoku

## Problem Statement

Given a **9 × 9 Sudoku board**, determine whether it is **valid**.

A Sudoku board is considered valid if **all of the following conditions hold**, considering **only the filled cells**:

- Each **row** contains the digits **1–9** at most once.
- Each **column** contains the digits **1–9** at most once.
- Each of the nine **3 × 3 sub-boxes** contains the digits **1–9** at most once.

You **do not** need to check whether the Sudoku is solvable—only whether the current filled entries obey these rules.

## Notes

- A **partially filled** Sudoku board can be valid even if it is not solvable.
- Empty cells are represented by `.` and should be ignored during validation.

## Constraints

- `board.length == 9`
- `board[i].length == 9`
- `board[i][j]` is a digit (`'1'` to `'9'`) or `'.'`
