# Isomorphic Strings

## Problem Statement

Given two strings, check whether they are **isomorphic** or not. Two strings are isomorphic if a **fixed mapping** exists from the characters of one string to the characters of the other string.

For example, if there are two instances of the character `"a"` in the first string, both of these instances should be converted to the same character in the second string. This converted character should remain consistent across both positions in the second string, due to the fixed mapping between the characters of the two strings.

### Important Notes:

- Two different characters **cannot** map to the same character.
- The order of characters must be preserved.
- Every instance of a character in the first string must map to a specific character in the second string.

## Constraints

- Both strings consist of valid ASCII characters.
- The length of the strings is between `0` and `10^4` (inclusive).
- The length of both strings is the **same**.

## Examples

### Example 1:

Input: s = "egg", t = "add" Output: true Explanation: 'e' maps to 'a' and 'g' maps to 'd'. The mapping is consistent.

### Example 2:

Input: s = "foo", t = "bar" Output: false Explanation: 'f' maps to 'b', but 'o' maps to both 'a' and 'r', which is not allowed.

### Example 3:

Input: s = "paper", t = "title" Output: true Explanation: 'p' maps to 't', 'a' maps to 'i', 'p' (again) maps to 't' (consistent), and so on.


## Steps to Solve

We'll cover the following steps:

1. **Understand the Problem**: Grasp the definition of isomorphic strings and the constraints of the problem.
2. **Figure it Out**: Think about how we can establish and maintain the character mapping between two strings.
3. **Try it Yourself**: Implement a solution to check if two strings are isomorphic.

## Solution Approach

We can solve this problem by iterating over the characters of both strings and keeping track of the mappings between the characters from the first string to the second. If any invalid mapping occurs (e.g., two different characters map to the same character in the second string), we return `false`.

---

Happy coding! 😄
