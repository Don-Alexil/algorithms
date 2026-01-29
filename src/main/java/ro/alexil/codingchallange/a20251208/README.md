# Find the Lexicographically Largest String From Box II

## Statement

You are given a string `word`, and an integer `numFriends`, representing the number of friends participating in a game organized by Alice.

The game consists of multiple rounds, and in each round:

1. The string `word` is split into exactly `numFriends` **non-empty substrings**.
2. The split must be **unique**; no previous round has produced the same sequence of splits.
3. All resulting substrings from the split are placed into a box.

When all rounds are over and all possible unique splits have been performed, determine the **lexicographically largest string** among all the substrings in the box.

---

## Lexicographical Order Definition

A string **a** is considered lexicographically larger than a string **b** if:

- At the first position where **a** and **b** differ, the character in **a** comes later in the alphabet than the corresponding character in **b**.
- If **a** is a prefix of **b**, the **longer** string is considered larger.

---

## Constraints

- `1 ≤ word.length ≤ 10^3`
- `word` consists only of lowercase English letters.
- `1 ≤ numFriends ≤ word.length`