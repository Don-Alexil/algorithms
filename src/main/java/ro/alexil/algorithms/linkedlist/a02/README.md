# Reverse Nodes in Even-Length Groups

## Problem Statement
Given the head of a linked list, the nodes in the list are divided into groups in a sequential manner. 
The length of these groups follows the sequence of natural numbers (1, 2, 3, 4, ...), where each group has a progressively 
increasing number of nodes.

### Group Assignment
- The **1st** node is assigned to the first group.
- The **2nd** and **3rd** nodes are assigned to the second group.
- The **4th**, **5th**, and **6th** nodes are assigned to the third group, and so on.

### Objective
Your task is to reverse the nodes in each group that contains an **even number of nodes** and return the head 
of the modified linked list.

**Note:** The length of the last group may be less than or equal to `1 +` the length of the second to the last group.

## Constraints
- `1 ≤ Number of nodes ≤ 500`
- `0 ≤ LinkedListNode.data ≤ 10^3`

## Example
Given a linked list: `1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10`
- Group 1: [1] - Contains 1 node (odd) → remains as [1]
- Group 2: [2, 3] - Contains 2 nodes (even) → reversed to [3, 2]
- Group 3: [4, 5, 6] - Contains 3 nodes (odd) → remains as [4, 5, 6]
- Group 4: [7, 8, 9, 10] - Contains 4 nodes (even) → reversed to [10, 9, 8, 7]

Modified linked list: `1 → 3 → 2 → 4 → 5 → 6 → 10 → 9 → 8 → 7`

## Approach
1. Traverse the linked list and divide it into groups following the sequence of natural numbers.
2. Check if the length of each group is even.
3. Reverse the nodes in groups with an even number of nodes.
4. Return the modified linked list's head.

## Usage
Implement this logic in a programming language of your choice to reverse nodes in even-length groups of a linked list.

## License
This project is open-source and available under the MIT License.
